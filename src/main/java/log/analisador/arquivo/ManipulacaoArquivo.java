package log.analisador.arquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import log.analisador.log.RegexLog;

public class ManipulacaoArquivo{
    
    public void manipulaLog(){
        RegexLog regex = new RegexLog();
        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("access.log"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter("Analise/recursosGrandes.txt"));
            String linha;
            String resultado;
            while((linha = arquivo.readLine())!= null){
                resultado = regex.buscaRecursoGrande(linha);
                if (resultado != null){
                escritor.write(resultado);
                escritor.newLine();
                }
                
                
                
            }

            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
    


}
