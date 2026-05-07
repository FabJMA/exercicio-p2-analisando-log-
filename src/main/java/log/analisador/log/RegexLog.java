package log.analisador.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLog {
    private Pattern patternOpcao1 = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}).*?\".*?\" ([0-9]{3}) ([0-9]+)");
    
    private Pattern patternOpcao2 = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3} \\- \\- \\[[0-9]{2}/(Nov/2021).*?\".*?\" ([0-9]{3}) [0-9]+ (\"http[^\"]+\")");
    //private Pattern pattern2 = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3} \\- \\- \\[[0-9]{2}/(Nov/2021).*?\".*?\" ([0-9]{3}) [0-9]+ \"([^\"]+)\"");
    
    private Pattern patternOpcao3 = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3} \\- \\- \\[[0-9]{2}/[A-Z]{1}[a-z]{2}/2021.*?\".*?\" .*?\".*?\" .*?\\(([A-Z|iP]{1,2}[a-z|11]{1,20}).*?");
    
    private Pattern patternOpcao4 = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3} \\- \\- \\[[0-9]{2}/[A-Z]{1}[a-z]{2}/2021.*?\"POST.*?\" ([0-9]{3}) ([0-9]+)");
    
    public String buscaRecursoGrande(String linha) {
        Matcher matcher = patternOpcao1.matcher(linha);

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

    	Matcher matcher = patternOpcao2.matcher(linha);
    	
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
    

    public String porcRequisicaoSO(String linha) {
    	
      	Matcher matcher = patternOpcao3.matcher(linha);

    	if (matcher.find()) {
    		String sistOp = matcher.group(1);
           return sistOp;
            
    	}
    	
    	return null;
    }

    public long buscaTamanhoRequisicao(String linha) {
        Matcher matcher = patternOpcao4.matcher(linha);

        if (matcher.find()) {
            int status = Integer.parseInt(matcher.group(1));
            long tamanho = Long.parseLong(matcher.group(2));
        
        
            if (status >= 200 && status <= 299) {
                return tamanho; 
            }
        }
    
         return 0; 
    }

    
}