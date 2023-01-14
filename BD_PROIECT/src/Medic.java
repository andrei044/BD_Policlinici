import java.util.Arrays;

public class Medic extends Angajat{
    private String titlu;
    private String post;
    private String parafa;
    int nrSpecializari=0;//era 1
    Specializare[] specializare=new Specializare[3];

    public Medic(String username, String password, String nume, String prenume, String CNP, String adresa, String tel, String email, String IBAN, String functie, String dataAngajare, String newtitlu,String newpost,String newparafa,Specializare specializare0) {
        super(username, password, nume, prenume, CNP, adresa, tel, email, IBAN, functie, dataAngajare,"", 1);
        titlu=newtitlu;
        post=newpost;
        parafa=newparafa;
        specializare[0]=specializare0;
        nrSpecializari=1;
    }

    public Medic(String username, String password, String nume, String prenume, String CNP, String adresa, String tel, String email, String IBAN, String functie, String dataAngajare, String newtitlu, String newpost, String newparafa, Specializare specializare0, Specializare specializare1) {
        super(username, password, nume, prenume, CNP, adresa, tel, email, IBAN, functie, dataAngajare,"", 1);
        titlu=newtitlu;
        post=newpost;
        specializare[0]=specializare0;
        specializare[1]=specializare1;
        nrSpecializari=2;
        parafa=newparafa;
    }

    public void setParafa(String parafa) {
        this.parafa = parafa;
    }
    public Medic(Angajat angajat){
        super(angajat.getUsername(), angajat.getPassword(), angajat.getNume(), angajat.getPrenume(), angajat.getCNP(), angajat.getAdresa(), angajat.getTel(), angajat.getEmail(), angajat.getIBAN(), angajat.getFunctie(), angajat.getDataAngajare(),"", 1);
        this.setProgram(angajat.getProgramGeneric());
        this.setNrContract(angajat.getNrContract());
        this.setId_user(angajat.getId_user());
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }
    public void addSpecializare(Specializare specializare1){
        specializare[nrSpecializari]=specializare1;
        nrSpecializari++;
    }
    public void setPost(String post) {
        this.post = post;
    }

    public void setNrSpecializari(int nrSpecializari) {
        this.nrSpecializari = nrSpecializari;
    }

    public void setSpecializare(Specializare[] specializare) {
        this.specializare = specializare;
    }

    public Medic(String username, String password, String nume, String prenume, String CNP, String adresa, String tel, String email, String IBAN, String functie, String dataAngajare, String newtitlu, String newpost, String newparafa, Specializare specializare0, Specializare specializare1, Specializare specializare2) {
        super(username, password, nume, prenume, CNP, adresa, tel, email, IBAN, functie, dataAngajare,"", 1);
        titlu=newtitlu;
        post=newpost;
        parafa=newparafa;
        specializare[0]=specializare0;
        specializare[1]=specializare1;
        specializare[2]=specializare2;
        nrSpecializari=3;
    }

    public void set1Specializare(Specializare specializare1){
        specializare[0]=specializare1;
    }
    public void set2Specializare(Specializare specializare1,Specializare specializare2){
        specializare[0]=specializare1;
        specializare[1]=specializare2;
        nrSpecializari=2;
    }
    public void set3Specializare(Specializare specializare1,Specializare specializare2,Specializare specializare3){
        specializare[0]=specializare1;
        specializare[1]=specializare2;
        specializare[2]=specializare3;
        nrSpecializari=3;
    }

    public Medic() {
    }

    public Specializare getSpecializare(int index){
        return specializare[index];
    }

    @Override
    public String toString() {
        return "Medic{" +
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
                //", " + this.getProgramGeneric().toString() + '\'' +
                "titlu='" + titlu + '\'' +
                ", post='" + post + '\'' +
                ", nrSpecializari=" + nrSpecializari +
                ", parafa=" + parafa +
                ", specializare=" + Arrays.toString(specializare) +
                '}';
    }

    public String getTitlu() {
        return titlu;
    }

    public String getPost() {
        return post;
    }

    public String getParafa() {
        return parafa;
    }

    public int getNrSpecializari() {
        return nrSpecializari;
    }
}
