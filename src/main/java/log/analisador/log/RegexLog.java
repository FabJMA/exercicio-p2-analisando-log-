package log.analisador.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLog {
    Pattern pattern1 = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}).*?\".*?\" ([0-9]{3}) ([0-9]+)");
    Pattern pattern2 = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3} \\- \\- \\[[0-9]{2}/(Dec/2020).*?\".*?\" ([0-9]{3}) [0-9]+ (\"http[^\"]+\")");
    Pattern pattern3 = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3} \\- \\- \\[[0-9]{2}/[A-Z]{1}[a-z]{2}/2021.*?\".*?\" .*?\".*?\" .*?\\(([A-Z|iP]{1,2}[a-z|11]{1,20}).*?");
    Pattern pattern4 = Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3} \\- \\- \\[[0-9]{2}/[A-Z]{1}[a-z]{2}/2021.*?\"POST.*?\" [0-9]{3} ([0-9]+)");
    
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
    

    public String porcRequisicaoSO(String linha) {
    	
      	Matcher matcher = pattern3.matcher(linha);
//         int contGeral = 0, contWindows = 0, contLinux = 0, contMobile = 0, contFedora = 0, contUbuntu = 0, contMacintosh = 0;

    	
    	if (matcher.find()) {
    		String sistOp = matcher.group(1);

    		
/*     		if (sistOp == "Windows") {
                contWindows++;
            }
            else if (sistOp == "Ubuntu") {
                contUbuntu++;
            }
            else if (sistOp == "Fedora") {
                contFedora++;
            }
            else if (sistOp == "Mobile" || sistOp == "Android") {
                contMobile++;
            }
            else if (sistOp == "Macintosh") {
                contMacintosh++;
            }
            else if (sistOp == "Linux" || sistOp == "X11") {
                contLinux++;
            }*/
           return sistOp + " 1";
            
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