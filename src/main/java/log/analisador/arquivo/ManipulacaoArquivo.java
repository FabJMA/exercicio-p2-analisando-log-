package log.analisador.arquivo;
import log.analisador.log.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import log.analisador.log.RegexLog;

public class ManipulacaoArquivo{
    
    public void manipulaLog(){
        RegexLog regex = new RegexLog();
        Path path = Paths.get("Analise");

        try {
            Files.createDirectories(path);
            System.out.println("Pasta 'Analise' criada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao criar a pasta: " + e.getMessage());
        }
        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("access.log"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter("recursosGrandes.txt"));
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
