package log.analisador;
import log.analisador.arquivo.ManipulacaoArquivo;
import log.analisador.interacao.Menu;


public class Main {
    public static void main(String[] args) {
        ManipulacaoArquivo manipulacao = new ManipulacaoArquivo("Analise");
        Menu menu = new Menu();
        int opcao = -1;
        while(opcao!=0){
            opcao = menu.exibeMenu();
            switch (opcao) {
                    case 1:
                        manipulacao.manipulaLog("recursosGrandes.txt",1);
                        System.out.println("\u001B[32mArquivo 'recursosGrandes.txt' foi gerado com sucesso!\n\u001B[0m");
                        break;
                    case 2:
                        manipulacao.manipulaLog("naoRespondidosNovembro.txt",2 );
                        System.out.println("\u001B[32mArquivo 'naoRespondidosNovembro.txt' foi gerado com sucesso!\n\u001B[0m");
                        break;
                    case 3:
                        manipulacao.manipulaLog("temp.txt",3);
                        manipulacao.calculoPorcentagem();
                        System.out.println("\u001B[32mArquivo 'sistemasOperacionais.txt' foi gerado com sucesso!\n\u001B[0m");
                        break;
                    case 4:
                        System.out.println("\u001B[36mA média é: " + manipulacao.mediaRequisicoes() + "\n\u001B[0m");
                        break;
                    case 0:
                        System.out.println("\u001B[35mSaindo do menu...\n\u001B[0m");
                        break;
                    default:
                        System.out.println("\u001B[33mDigite um número válido!\n\u001B[0m");
                        break;
                }
            }
    }
}
 