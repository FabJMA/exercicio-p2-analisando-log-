package log.analisador.interacao;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scan = new Scanner(System.in);

    public int exibeMenu() {
        int opcao = -1;
        System.out.println("\u001B[34m===== EXTRAÇÃO DE LOGS =====");
        System.out.println("1 - Recursos Grandes Respondidos\n"
                         + "2 - Não Respondidos\n"
                         + "3 - % de requisições por SO\n"
                         + "4 - Média das requisições POST\n"
                         + "0 - Sair");  
        System.out.print("Digite a opção que deseja: \u001B[0m");
        
            try {
                opcao = scan.nextInt();
                System.out.println("");
            } catch (InputMismatchException e) {
                scan.nextLine(); 
            }
        
        return opcao;
	}
}