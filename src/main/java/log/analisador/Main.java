package log.analisador;

import log.analisador.log.RegexLog;

public class Main {
    public static void main(String[] args) {
    	RegexLog t = new RegexLog();
    	
    	int i = 0;
    	String linha = "42.236.10.125 - - [19/Dec/2020:15:23:10 +0100] \"GET / HTTP/1.1\" 200 10479 \"http://baidu.com/\" \"Mozilla/5.0 (Linux; U; Android 8.1.0; zh-CN; EML-AL00 Build/HUAWEIEML-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 baidu.sogo.uc.UCBrowser/11.9.4.974 UWS/2.13.1.48 Mobile Safari/537.36 AliApp(DingTalk/4.5.11) com.alibaba.android.rimet/10487439 Channel/227200 language/zh-CN\" \"-\"\r\n";
    	String linha2 = "45.138.145.106 - - [20/Dec/2020:05:23:42 +0100] \"POST /index.php?option=com_contact&view=contact&id=1 HTTP/1.1\" 303 5 \"-\" \"Mozilla/5.0(Android8.1.0;Mobile;rv:80.0)Gecko/80.0Firefox/80.0\" \"-\"";
    	String linha3 = "176.222.58.254 - - [20/Dec/2020:00:04:04 +0100] \"POST /index.php?option=com_contact&view=contact&id=1 HTTP/1.1\" 200 188 \"-\" \"Mozilla/5.0(iPhone;CPUiPhoneOS12_4likeMacOSX)AppleWebKit/605.1.15(KHTML,likeGecko)Version/12.1.2Mobile/15E148Safari/604.1\" \"-\"";
    	String linha4 = "45.132.207.154 - - [20/Dec/2020:01:33:21 +0100] \"POST /index.php?option=com_contact&view=contact&id=1 HTTP/1.1\" 200 188 \"-\" \"Mozilla/5.0(WindowsNT6.1;WOW64)AppleWebKit/537.36(KHTML,likeGecko)Chrome/84.0.4147.105YaBrowser/20.8.1.83Yowser/2.5Safari/537.36\" \"-\"";

    	
    	
    	String resultado = t.porcRequisicaoSO(linha);
    	System.out.println(resultado);
    	String resultado1 = t.porcRequisicaoSO(linha2);
    	System.out.println(resultado1);
    	String resultado3 = t.porcRequisicaoSO(linha3);
    	System.out.println(resultado3);
    	String resultado4 = t.porcRequisicaoSO(linha4);
    	System.out.println(resultado4);

        
    	
    	
    	/*
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
		*/

    }
}
