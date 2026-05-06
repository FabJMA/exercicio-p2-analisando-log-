package log.analisador.interacao;

import java.util.Scanner;

public class Menu {

    public int exibeMenu(){
    	int opcao = -1;
    	
        System.out.println("\u001B[34m"
        				 + "1 - Recursos Grandes Respondidos\n"
        				 + "2 - Não Respondidos\n"
        				 + "3 - % de requisições por SO\n"
        				 + "4 - Média das requisições POST\n"
        				 + "0 - Sair\u001B[0m");
        System.out.println("Digite a opção que deseja: ");
        
        Scanner scan = new Scanner(System.in);
        opcao = scan.nextInt();

		while (opcao != 0) {
			switch (opcao) {
				case 1:
					manipulaLog("Analise/recursosGrandes.txt");
					break;
				case 2:
					manipulaLog("Analise/naoRespondidosNovembro.txt");
					break;
				case 3:
					manipulaLog("Analise/sistemasOperacionais.txt");
					break;
				case 4:
					manipulaLog();
					break;
				default:
					System.out.println("Digite um número válido!\n");
					break;

			}
			System.out.println("Digite a opção que deseja: ");
			opcao = scan.nextInt();
		}
        
        return opcao;

    }

}


