public class Angajat extends User{
    private String IBAN;
    private String functie;
    private String dataAngajare;
    private String nrContract;
    private String salariuBrut;

    private ProgramGeneric programGeneric;

    public Angajat(String id_user, String nume, String prenume, String CNP, String adresa, String tel, String email, String IBAN, String functie, String dataAngajare, String nrContract) {
        super(id_user, nume, prenume, CNP, adresa, tel, email);
        this.IBAN = IBAN;
        this.functie = functie;
        this.dataAngajare = dataAngajare;
        this.nrContract = nrContract;
    }
    public Angajat(String username,String password,String nume, String prenume, String CNP, String adresa, String tel, String email, String IBAN, String functie, String dataAngajare,String salariuBrut,int x) {
        super(nume, prenume, CNP, adresa, tel, email);
        this.setPassword(password);
        this.setUsername(username);
        this.IBAN = IBAN;
        this.functie = functie;
        this.dataAngajare = dataAngajare;
        this.salariuBrut=salariuBrut;
    }

    public Angajat() {
    }

    public void setProgram(ProgramGeneric program) {
        programGeneric = program;
    }

    public String getOraStart(int index){
        return programGeneric.getOraStart(index);
    }
    public String getOraFinal(int index){
        return programGeneric.getOraFinal(index);
    }
    public String getUnitate(int index){
        return programGeneric.getUnitate(index);
    }

    public Angajat(String id_user) {
        super(id_user);
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getFunctie() {
        return functie;
    }

    public String getDataAngajare() {
        return dataAngajare;
    }

    public String getNrContract() {
        return nrContract;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public void setDataAngajare(String dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public void setNrContract(String nrContract) {
        this.nrContract = nrContract;
    }

    public ProgramGeneric getProgramGeneric() {
        return programGeneric;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "username='" + this.getUsername() + '\'' +
                "password='" + this.getPassword() + '\'' +
                "nume='" + this.getNume() + '\'' +
                ", prenume='" + this.getPrenume() + '\'' +
                ", CNP='" + this.getCNP() + '\'' +
                ", adresa='" + this.getAdresa() + '\'' +
                ", tel='" + this.getTel() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", functie='" + functie + '\'' +
                ", dataAngajare='" + dataAngajare + '\'' +
                ", nrContract='" + nrContract + '\'' +
                ", " + programGeneric.toString() + '\'' +
                '}';
    }

    public String getSalariuBrut() {
        return salariuBrut;
    }

    public void setSalariuBrut(String salariuBrut) {
        this.salariuBrut = salariuBrut;
    }
}
