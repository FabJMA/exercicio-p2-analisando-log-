package log.analisador.arquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import log.analisador.log.RegexLog;

public class ManipulacaoArquivo{

    public void manipulaLog(RegexLog regex, String nome){
        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("access.log"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nome));
            String linha;
            String resultado;
            while((linha = arquivo.readLine())!= null){
                switch (nome){
                    case "Analise/recursosGrandes.txt":
                        resultado = regex.buscaRecursoGrande(linha);
                        break;
                    case "Analise/naoRespondidosNovembro.txt":
                        resultado = regex.naoRespondidosNov(linha);
                        break;
                    case "Analise/sistemasOperacionais.txt":
                        resultado = regex.porcRequisicaoSO(linha);
                        break;
                    default:
                        resultado = null;
                        System.out.println("Houve algum erro.");
                        break;
                    
            }
            if (resultado != null){
                escritor.write(resultado);
                escritor.newLine();
                }     
            }

            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
    
    public long mediaRequisicoes(RegexLog regex){
        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("access.log"));
            String linha;
            long resultado;
            long soma = 0;
            int contadora = 0;
            while((linha = arquivo.readLine())!= null){
                resultado = regex.buscaTamanhoRequisicao(linha);
                if (resultado!=0){
                    soma+=resultado;
                    contadora++;

                }
                
            }
            if(contadora!=0){
                return soma/contadora;
            }
     
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return 0;

    }
    
}
