package log.analisador.log.analisador.log;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ManipulacaoLog {
	
	public void salvarArquivo (int opcao) {
		String nomeArquivoSerSalvo = "";
		
		switch (opcao) {
			case 1:
				nomeArquivoSerSalvo = "recursosGrandes.txt";
			case 2: 
				nomeArquivoSerSalvo = "naoRespondidosNovembro.txt";
			case 3: 
				nomeArquivoSerSalvo = "sistemasOperacionais.txt";
			default:
				break;
		}
		
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivoSerSalvo));
		} catch (Exception e) {
			
		}
	}
}
