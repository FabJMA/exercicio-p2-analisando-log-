public class ManipulacaoLog {
    private String ip;
    private String data;
    private String recurso;
    private int codigo;
    private long tamanhoObjeto;
    private String sistemaOperacional;
    private String userAgent;

    public ManipulacaoLog(String ip, String data, String recurso, int codigo, int tamanhoObjeto, String sistemaOperacional, String userAgent){
        this.ip = ip;
        this.data = data;
        this.recurso = recurso;
        this.codigo = codigo;
        this.tamanhoObjeto = tamanhoObjeto;
        this.sistemaOperacional = sistemaOperacional;
        this.userAgent = userAgent;
    }
    
    public String getIp() {
        return ip;
    }

    public String getData() {
        return data;
    }

    public String getRecurso() {
        return recurso;
    }

    public int getCodigo() {
        return codigo;
    }

    public long getTamanhoObjeto() {
        return tamanhoObjeto;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public String getUserAgent() {
        return userAgent;
    }


}
