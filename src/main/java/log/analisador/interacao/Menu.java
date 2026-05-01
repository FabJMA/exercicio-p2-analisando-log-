package log.analisador.interacao;

import java.util.Scanner;

public class Menu {

    public int exibeMenu(){
    	int opcao = -1;
    	
        System.out.println("1 - Recursos Grandes Respondidos\n"
        				 + "2 - Não Respondidos\n"
        				 + "3 - % de requisições por SO\n"
        				 + "4 - Média das requisições POST\n"
        				 + "0 - Sair");
        System.out.println("Digie a opção que deseja: ");
        
        Scanner scan = new Scanner(System.in);
        opcao = scan.nextInt();
        
        while (opcao == 1) {
        	try {
        		
        	} catch (Exception e) {
        		System.out.println("Digie um número válido!\n");
        	}
        }
        return opcao;
    }

}
