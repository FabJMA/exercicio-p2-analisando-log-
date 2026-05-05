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
    

    public String porcRequisicaoSO(String linha) {
    	//linha = "42.236.10.125 - - [19/Dec/2020:15:23:10 +0100] \"GET / HTTP/1.1\" 200 10479 \"http://baidu.com/\" \"Mozilla/5.0 (Linux; U; Android 8.1.0; zh-CN; EML-AL00 Build/HUAWEIEML-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 baidu.sogo.uc.UCBrowser/11.9.4.974 UWS/2.13.1.48 Mobile Safari/537.36 AliApp(DingTalk/4.5.11) com.alibaba.android.rimet/10487439 Channel/227200 language/zh-CN\" \"-\"\r\n";
    	
    	Pattern pattern = Pattern.compile(".*?\\- \\- \\[[0-9]{2}/[A-Z]{1}[a-z]{2}/(2020).*?\".*?\" .*?\".*?\" .*?\\(([A-Z|iP]{1,2}[a-z]{1,20}).*?");
    	//Pattern pattern = Pattern.compile(".*?\\- \\- \\[[0-9]{2}/[A-Z]{1}[a-z]{2}/2020.*?\".*?\" .*?\".*?\" \\(([A-Z]{1}[a-z]{1,10});((.*?)Android) ((.*?)Mobile)");
      	Matcher matcher = pattern.matcher(linha);
    	
    	if (matcher.find()) {
    		String d = matcher.group(1);
    		String sistOp = matcher.group(2);
    		String mobile = "Mobile";
    		
    		return d + " " + sistOp;
    		
    		/*
    		if (android == "Android" || mobile == "Mobile") {
    			return sistOp;
    		}
    		*/
    	}
    	
    	return null;

    
    public long buscaTamanhoRequisicao(String linha){
        Matcher matcher = pattern4.matcher(linha);

        if(matcher.find()){

            return Long.parseLong(matcher.group(1));
            
        }
        return 0;

    }

    }
