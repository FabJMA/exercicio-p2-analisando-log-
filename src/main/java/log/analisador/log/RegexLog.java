package log.analisador.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLog {
    Pattern pattern1 = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}).*?\".*?\" ([0-9]{3}) ([0-9]+)");
    Pattern pattern2 = Pattern.compile(".*?\\- \\- \\[[0-9]{2}/(Dec/2020).*?\".*?\" ([0-9]{3}) [0-9]+ (\"http[^\"]+\")");
    Pattern pattern4 = Pattern.compile(".*?\\- \\- \\[[0-9]{2}/[A-Z]{1}[a-z]{2}/2021.*?\"POST.*?\" [0-9]{3} ([0-9]+)");
    
    public String buscaRecursoGrande(String linha) {
        Matcher matcher = pattern1.matcher(linha);


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

    	Matcher matcher = pattern2.matcher(linha);
    	
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
    
    
    public long buscaTamanhoRequisicao(String linha){
        Matcher matcher = pattern4.matcher(linha);

        if(matcher.find()){

            return Long.parseLong(matcher.group(1));
            
        }
        return 0;

    }

}
