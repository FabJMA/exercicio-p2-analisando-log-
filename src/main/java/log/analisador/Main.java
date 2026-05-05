package log.analisador;

import log.analisador.log.RegexLog;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import log.analisador.arquivo.ManipulacaoArquivo;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("Analise");

        try {
            Files.createDirectories(path);
            System.out.println("Pasta 'Analise' criada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao criar a pasta: " + e.getMessage());
        }

        ManipulacaoArquivo teste = new ManipulacaoArquivo();
       teste.manipulaLog();
       long media = teste.testeOpcao4();
       System.out.println(media);
        teste.manipulaLog();
		

    }
}
