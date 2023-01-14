public class Serviciu {
    private String denumire;
    private String idMedic;
    private String numeMedic;
    private String idServiciu;
    private String pret;
    private String durata;

    public Serviciu(String idServiciu, String denumire, String numeMedic ,String durata) {
        this.denumire = denumire;
        this.numeMedic = numeMedic;
        this.idServiciu = idServiciu;
        this.durata=durata;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getIdMedic() {
        return idMedic;
    }

    public String getNumeMedic() {
        return numeMedic;
    }

    public String getIdSpecializare() {
        return idServiciu;
    }

    public String getPret() {
        return pret;
    }

    public String getDurata() {
        return durata;
    }
}
