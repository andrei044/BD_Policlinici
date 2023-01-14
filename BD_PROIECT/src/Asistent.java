public class Asistent extends Angajat{
    private String tip;
    private String grad;

    public Asistent(String username, String password, String nume, String prenume, String CNP, String adresa, String tel, String email, String IBAN, String functie, String dataAngajare,String salariuBrut,String newgrad,String newtip) {
        super(username, password, nume, prenume, CNP, adresa, tel, email, IBAN, functie, dataAngajare,salariuBrut, 1);
        tip=newtip;
        grad=newgrad;
    }
    public Asistent(Angajat angajat){
        super(angajat.getUsername(), angajat.getPassword(), angajat.getNume(), angajat.getPrenume(), angajat.getCNP(), angajat.getAdresa(), angajat.getTel(), angajat.getEmail(), angajat.getIBAN(), angajat.getFunctie(), angajat.getDataAngajare(),angajat.getSalariuBrut(), 1);
        this.setProgram(angajat.getProgramGeneric());
        this.setNrContract(angajat.getNrContract());
        this.setId_user(angajat.getId_user());
    }

    public Asistent() {
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getTip() {
        return tip;
    }

    public String getGrad() {
        return grad;
    }

    @Override
    public String toString() {
        return "Asistent{" +
                "nume='" + this.getNume() + '\'' +
                ", prenume='" + this.getPrenume() + '\'' +
                ", CNP='" + this.getCNP() + '\'' +
                ", adresa='" + this.getAdresa() + '\'' +
                ", tel='" + this.getTel() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", IBAN='" + this.getIBAN() + '\'' +
                ", functie='" + this.getFunctie() + '\'' +
                ", dataAngajare='" + this.getDataAngajare() + '\'' +
                ", nrContract='" + this.getNrContract() + '\'' +
                ", " + this.getProgramGeneric().toString() + '\'' +
                "tip='" + tip + '\'' +
                ", grad='" + grad + '\'' +
                '}';
    }
}
