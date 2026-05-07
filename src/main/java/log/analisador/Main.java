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
                        break;
                    case 2:
                        manipulacao.manipulaLog("naoRespondidosNovembro.txt",2 );
                        break;
                    case 3:
                        manipulacao.manipulaLog("temp.txt",3);
                        manipulacao.calculoPorcentagem();

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
 