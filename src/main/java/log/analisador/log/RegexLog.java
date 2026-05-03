package log.analisador.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLog {
    
    public String buscaRecursoGrande(String linha) {
        Pattern pattern = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}) \\[.*?\\] \"[^\"]*\" ([0-9]{3}) ([0-9]+)");
        Matcher matcher = pattern.matcher(linha);

        if (matcher.find()) {
            String ip = matcher.group(1);
            int status = Integer.parseInt(matcher.group(2));
            long tamanho = Long.parseLong(matcher.group(3));

            if (status >= 200 && status <= 299 && tamanho > 2000) {
                return status + " " + tamanho + " " + ip;
            }
        }
        return null;
    }
    
    public String naoRespondidosNov(String linha) {    	
    	
    	//linha = "157.48.153.185 - - [19/Dec/2020:14:08:08 +0100] \"GET /favicon.ico HTTP/1.1\" 404 217 \"http://www.almhuette-raith.at/apache-log/access.log\" \"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36\" \"-\"\r\n";
    	
    	Pattern pattern = Pattern.compile(".*?\\- \\- \\[[0-9]{2}/(Dec/2020).*?\".*?\" ([0-9]{3}) [0-9]+ (\"http[^\"]+\")");

    	
    	//Pattern pattern = Pattern.compile(".*?\\- \\- \\[[0-9]{2}/(Dec/2020):[0-9]{2}:[0-9]{2}:[0-9]{2} \\+[0-9]{4}\\] \".?\" ([0-9]{3}) .?\n(\"http(.+)\")");
    	Matcher matcher = pattern.matcher(linha);
    	
    	if (matcher.find()) {
    		String data = matcher.group(1);
    		int status = Integer.parseInt(matcher.group(2));
    		String respostaHTTP = matcher.group(3);
    		
    		if (status >= 400 && status <= 499) {
    			return status + " " + respostaHTTP + " " + data;
    		}
    	}
    	return null;
    }

}
