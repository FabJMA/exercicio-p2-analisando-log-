package log.analisador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import log.analisador.arquivo.ManipulacaoArquivo;
import log.analisador.interacao.Menu;


public class Main {
    public static void main(String[] args) {
        ManipulacaoArquivo manipulacao = new ManipulacaoArquivo();
        Path path = Paths.get("Analise");
        Menu menu = new Menu();

        try {
            Files.createDirectories(path);
            System.out.println("Pasta 'Analise' criada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao criar a pasta: " + e.getMessage());
        }
        int opcao = -1;
        while(opcao!=0){
            opcao = menu.exibeMenu();
            switch (opcao) {
                    case 1:
                        manipulacao.manipulaLog("Analise/recursosGrandes.txt");
                        break;
                    case 2:
                        manipulacao.manipulaLog("Analise/naoRespondidosNovembro.txt");
                        break;
                    case 3:
                        manipulacao.manipulaLog("Analise/sistemasOperacionais.txt");
                        break;
                    case 4:
                        System.out.println("A média é: " + manipulacao.mediaRequisicoes());
                        break;
                    case 0:
                        System.out.println("Saindo do menu...\n");
                        break;
                    default:
                        System.out.println("Digite um número válido!\n");
                        break;
                }
            }
    }
}
 