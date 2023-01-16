import java.util.Arrays;
import java.util.List;

public class Specializare {
    private String denumire;
    private String grad;
    private int nrCompetente=0;
    private String[] competenta=new String[5];
    private String[] durata=new String[5];
    private String[] pret=new String [5];

    public Specializare(String newdenumire, String newgrad,String competenta0,String durata0,String competenta1,String durata1,String competenta2,String durata2,String competenta3,String durata3,String competenta4,String durata4) {
        competenta[0]=competenta0;
        competenta[1]=competenta1;
        competenta[2]=competenta2;
        competenta[3]=competenta3;
        competenta[4]=competenta4;
        durata[0]=durata0;
        durata[1]=durata1;
        durata[2]=durata2;
        durata[3]=durata3;
        durata[4]=durata4;
        grad=newgrad;
        nrCompetente=5;
        denumire=newdenumire;
    }
    public Specializare(String newdenumire,String newgrad,String competenta0,String durata0,String competenta1,String durata1,String competenta2,String durata2,String competenta3,String durata3) {
        competenta[0]=competenta0;
        competenta[1]=competenta1;
        competenta[2]=competenta2;
        competenta[3]=competenta3;
        durata[0]=durata0;
        durata[1]=durata1;
        durata[2]=durata2;
        durata[3]=durata3;
        grad=newgrad;
        nrCompetente=4;
        denumire=newdenumire;
    }
    public Specializare(String newdenumire,String newgrad,String competenta0,String durata0,String competenta1,String durata1,String competenta2,String durata2) {
        competenta[0]=competenta0;
        competenta[1]=competenta1;
        competenta[2]=competenta2;
        durata[0]=durata0;
        durata[1]=durata1;
        durata[2]=durata2;
        grad=newgrad;
        nrCompetente=3;
        denumire=newdenumire;
    }
    public Specializare(String newdenumire,String newgrad,String competenta0,String durata0,String competenta1,String durata1) {
        competenta[0]=competenta0;
        competenta[1]=competenta1;
        durata[0]=durata0;
        durata[1]=durata1;
        grad=newgrad;
        nrCompetente=2;
        denumire=newdenumire;
    }
    public void addPretServiciu(int i,String newPret){
        pret[i]=newPret;
    }
    public Specializare(String newdenumire,String newgrad,String competenta0,String durata0) {
        competenta[0]=competenta0;
        durata[0]=durata0;
        grad=newgrad;
        nrCompetente=1;
        denumire=newdenumire;
    }
    public void addCompetenta(String denumire,String durata,String pret){
        competenta[nrCompetente]=denumire;
        this.durata[nrCompetente]=durata;
        this.pret[nrCompetente]=pret;
        nrCompetente++;
    }

    public Specializare(String newdenumire,String newgrad) {
        grad=newgrad;
        nrCompetente=0;
        denumire=newdenumire;
    }

    public void setNrCompetente(int nrCompetente) {
        this.nrCompetente = nrCompetente;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getGrad() {
        return grad;
    }

    public int getNrCompetente() {
        return nrCompetente;
    }

    public String getCompetenta(int i) {
        return competenta[i];
    }
    public String getDurata(int i){return durata[i];}

    @Override
    public String toString() {
        return "Specializare{" +
                "denumire='" + denumire + '\'' +
                ", grad='" + grad + '\'' +
                ", nrCompetente=" + nrCompetente +
                ", competenta=" + Arrays.toString(competenta) +
                ", durata=" + Arrays.toString(durata) +
                ", pret=" + Arrays.toString(pret) +
                '}';
    }

    public String getPret(int i) {
        return this.pret[i];
    }

    public void setPret(List<CompetentaField> listCompetente) {
        for(int i=0;i<listCompetente.size();i++){
            this.pret[i]=listCompetente.get(i).getPret();
        }
    }
}
