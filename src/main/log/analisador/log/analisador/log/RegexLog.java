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

}
