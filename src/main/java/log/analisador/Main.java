package log.analisador;

import log.analisador.arquivo.ManipulacaoArquivo;
import log.analisador.log.RegexLog;

public class Main {
    public static void main(String[] args) {
        //ManipulacaoArquivo teste = new ManipulacaoArquivo();
        //teste.manipulaLog();
        RegexLog teste = new RegexLog();
        String resultado = teste.buscaRecursoGrande("54.36.148.92 - - [19/Dec/2020:14:16:44 +0100] \"GET /index.php?option=com_phocagallery&view=category&id=2%3Awinterfotos&Itemid=53 HTTP/1.1\" 200 30662 \"-\" \"Mozilla/5.0 (compatible; AhrefsBot/7.0; +http://ahrefs.com/robot/)\" \"-\"\r\n" + //
                        "");
        System.out.println(resultado);


    }
}
