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
        System.out.println("Digie a opção que deseja: ");
        
        Scanner scan = new Scanner(System.in);
        opcao = scan.nextInt();

		switch (opcao) {
			//oi teste
			case 1:
				manipulaLog("Analise/recursosGrandes.txt");
			case 2:
				manipulaLog("Analise/naoRespondidosNovembro.txt");
			case 3:
				manipulaLog("Analise/sistemasOperacionais.txt");
			case 4:
				manipulaLog();
			case 0:
				System.out.println("Encerrando programa...\n");
			default:
				System.out.println("Digite um número válido!\n");

		}
        
        while (opcao == 1) {
        	try {
        		
        	} catch (Exception e) {
        		System.out.println("Digite um número válido!\n");
        	}
        }
        return opcao;

    }

}


