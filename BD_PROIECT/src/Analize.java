public class Analize {
    private String wbc;
    private String lymph;
    private String neut;
    private String mono;
    private String hct;

    public Analize(String wbc, String lymph, String neut, String mono, String hct) {
        this.wbc = wbc;
        this.lymph = lymph;
        this.neut = neut;
        this.mono = mono;
        this.hct = hct;
    }

    public String getWbc() {
        return wbc;
    }

    public String getLymph() {
        return lymph;
    }

    public String getNeut() {
        return neut;
    }

    public String getMono() {
        return mono;
    }

    public String getHct() {
        return hct;
    }
}
