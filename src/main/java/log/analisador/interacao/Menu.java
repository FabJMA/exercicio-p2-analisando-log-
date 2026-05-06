package log.analisador.interacao;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public int exibeMenu() {
        int opcao = -1;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\u001B[34m"
                         + "1 - Recursos Grandes Respondidos\n"
                         + "2 - Não Respondidos\n"
                         + "3 - % de requisições por SO\n"
                         + "4 - Média das requisições POST\n"
                         + "0 - Sair\u001B[0m");  
            try {
                opcao = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine(); 
            }
        
        return opcao;
	}
}