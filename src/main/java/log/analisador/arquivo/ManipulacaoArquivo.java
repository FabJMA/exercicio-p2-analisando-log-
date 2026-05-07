package log.analisador.arquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import log.analisador.log.RegexLog;

public class ManipulacaoArquivo{

    private String pasta;
    private RegexLog regex = new RegexLog();

    public ManipulacaoArquivo(String pasta) {
        this.pasta = pasta;
        File pastaVazia = new File(pasta);
        if (!pastaVazia.exists()) {
            if (pastaVazia.mkdirs()) {
                System.out.println("\u001B[32mPasta '" + pasta + "Criada.\u001B[30m");
            }
        }
    }

    public void manipulaLog(String nomeArquivo, int tipoOperacao) {
       File caminhoCompleto = new File (this.pasta, nomeArquivo);

        try (BufferedReader arquivo = new BufferedReader(new FileReader("access.log"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoCompleto))) {
            
            String linha;
            while ((linha = arquivo.readLine()) != null) {
                String resultado;
            
                switch (tipoOperacao) {
                    case 1: 
                        resultado = regex.buscaRecursoGrande(linha);
                        break;
                    case 2: 
                        resultado = regex.naoRespondidosNov(linha);
                        break;
                    case 3: 
                        resultado = regex.porcRequisicaoSO(linha);
                        break;
                    default:
                        System.out.println("Operação inválida!");
                        return; 
                }

                if (resultado != null) {
                    escritor.write(resultado);
                    escritor.newLine();
                }
            }
            
        } catch (Exception e) {
            System.out.println("\u001B[31m Erro ao manipular o log: " + e.getMessage() + "\u001B[0m");
        }
    }
    
    public void calculoPorcentagem() {
        File arquivoTemp = new File(this.pasta, "temp.txt");
        File arquivoFinal = new File(this.pasta, "sistemasOperacionais.txt");

        
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoTemp));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoFinal))) {
            
            String linha;
            int contGeral = 0;
            int[] contadoras = new int[6];

            while ((linha = leitor.readLine()) != null) {

                if (linha.equals("Windows")) {
                    contadoras[0]++;
                } else if (linha.equals("Ubuntu")) {
                    contadoras[1]++;
                } else if (linha.equals("Fedora")) {
                    contadoras[2]++;
                } else if (linha.equals("Mobile") || linha.equals("Android")) {
                    contadoras[3]++; 
                } else if (linha.equals("Macintosh")) {
                    contadoras[4]++;
                } else {
                    contadoras[5]++; 
                }
    
                contGeral++;
            }

            if (contGeral != 0) {
                String[] sistOp = {"Windows", "Ubuntu", "Fedora", "Mobile", "Macintosh", "Linux, outros"};
                for (int i = 0; i < sistOp.length; i++) {
                    float porcento = ((float) contadoras[i] / contGeral) * 100;
                    escritor.write(sistOp[i] + " " + String.format("%.5f", porcento));
                    escritor.newLine();
                }
            }
            
        } catch (Exception e) {
            System.err.println("\u001B[31mErro no cálculo: " + e.getMessage() + "\u001B[0m");
        } finally {
            arquivoTemp.delete(); 
        }
    }

    public long mediaRequisicoes() {
        try (BufferedReader arquivo = new BufferedReader(new FileReader("access.log"))) {
            String linha;
            long resultado;
            long soma = 0;
            int contadora = 0;

            while ((linha = arquivo.readLine()) != null) {
                resultado = regex.buscaTamanhoRequisicao(linha);
                if (resultado != 0) {
                    soma += resultado;
                    contadora++;
                }
            }
            if (contadora!=0){
                return (soma / contadora);

            }
            
        } catch (Exception e) {
            System.err.println("\u001B[31mErro na média: " + e.getMessage() + "\u001B[0m");
        }
        return 0;
    }
    
}
