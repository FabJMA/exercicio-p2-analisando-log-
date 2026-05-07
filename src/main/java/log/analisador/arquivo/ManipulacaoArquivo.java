package log.analisador.arquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import log.analisador.log.RegexLog;

public class ManipulacaoArquivo{

    RegexLog regex = new RegexLog();

    public void manipulaLog(String nome){
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
    public void calculoPorcentagem() {
        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("Analise/sistemasOperacionais.txt"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter("Analise/sistemasOperacionais.txt"));
            String linha;
            int contGeral = 0;
            int[] contadoras = new int [6];
            while((linha = arquivo.readLine())!= null){
                String[] partes = linha.split(" ");
            if (partes[0] == "Windows") {
                contadoras[0]++;
            }
            else if (partes[0] == "Ubuntu") {
                contadoras[1]++;
            }
            else if (partes[0] == "Fedora") {
                contadoras[2]++;
            }
            else if (partes[0] == "Mobile" || partes[0] == "Android") {
                contadoras[3]++;
            }
            else if (partes[0] == "Macintosh") {
                contadoras[4]++;
            }
            else if (partes[0] == "Linux" || partes[0] == "X11") {
                contadoras[5]++;
            }
            contGeral++;    
                
            }
            String[] sistOp = {"Windows", "Ubuntu", "Fedora", "Mobile", "Macintosh", "Linux"};
            float[] porcento = {contadoras[0]/contGeral, contadoras[1]/contGeral, contadoras[2]/contGeral, contadoras[3]/contGeral, contadoras[4]/contGeral, contadoras[5]/contGeral};
            for(int i = 0; i < 6; i++){
                escritor.write(sistOp[i] + " " + porcento[i]);
                escritor.newLine();
            }
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public long mediaRequisicoes(){
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
