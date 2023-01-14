public class Raport {
    private String istoricRaport;
    private String simptome;
    private String diagnostic;
    private String recomandari;
    private String idRaport;

    public Raport(String istoricRaport, String simptome, String diagnostic, String recomandari) {
        this.istoricRaport = istoricRaport;
        this.simptome = simptome;
        this.diagnostic = diagnostic;
        this.recomandari = recomandari;
    }

    public String getIstoricRaport() {
        return istoricRaport;
    }

    public String getSimptome() {
        return simptome;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getRecomandari() {
        return recomandari;
    }

    @Override
    public String toString() {
        return "Raport{" +
                "istoricRaport='" + istoricRaport + '\'' +
                ", simptome='" + simptome + '\'' +
                ", diagnostic='" + diagnostic + '\'' +
                ", recomandari='" + recomandari + '\'' +
                ", idRaport='" + idRaport + '\'' +
                '}';
    }
}
