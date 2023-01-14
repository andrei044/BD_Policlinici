public class CreeazaRaportField {
    private String idProgramare;
    private String pacient;
    private String medic;
    private String competenta;
    private String idMedic;
    private String data_programare;
    private String programare_start;
    private String programare_stop;
    private String id_raport;
    private String id_analize;

    public CreeazaRaportField(String idProgramare, String pacient, String medic, String competenta,String idMedic,String data_programare,String programare_start,String programare_stop,String id_raport,String id_analize) {
        this.idProgramare = idProgramare;
        this.pacient = pacient;
        this.medic = medic;
        this.competenta = competenta;
        this.idMedic=idMedic;
        this.data_programare=data_programare;
        this.programare_start=programare_start;
        this.programare_stop=programare_stop;
        this.id_raport=id_raport;
        this.id_analize=id_analize;
    }

    public String getIdProgramare() {
        return idProgramare;
    }

    public String getPacient() {
        return pacient;
    }

    public String getMedic() {
        return medic;
    }

    public String getCompetenta() {
        return competenta;
    }

    public String getIdMedic() {
        return idMedic;
    }

    public String getData_programare() {
        return data_programare;
    }

    public String getProgramare_start() {
        return programare_start;
    }

    public String getProgramare_stop() {
        return programare_stop;
    }

    public String getId_raport() {
        return id_raport;
    }

    public String getId_analize() {
        return id_analize;
    }
}
