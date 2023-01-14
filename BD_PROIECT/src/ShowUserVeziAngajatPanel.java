import javax.swing.*;
import java.awt.event.ActionListener;

public class ShowUserVeziAngajatPanel extends JPanel {
    CreateUserField nume=new CreateUserField("Nume");
    CreateUserField prenume=new CreateUserField("Prenume");
    CreateUserField adresa=new CreateUserField("Adresa");
    CreateUserField CNP=new CreateUserField("CNP");
    CreateUserField tel=new CreateUserField("tel");
    CreateUserField email=new CreateUserField("email");
    CreateUserField IBAN=new CreateUserField("IBAN");
    CreateUserField nrContract=new CreateUserField("Nr contract");
    CreateUserField dataAngajare=new CreateUserField("Data angajare");
    CreateUserField functie=new CreateUserField("Functie");
    CreateUserField id=new CreateUserField("ID");
    JButton modificaButton=new JButton("Modifica");
    public ShowUserVeziAngajatPanel() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(nume);
        this.add(prenume);
        this.add(adresa);
        this.add(CNP);
        this.add(tel);
        this.add(email);
        this.add(IBAN);
        this.add(nrContract);
        nrContract.setEditable(false);
        this.add(dataAngajare);
        dataAngajare.setEditable(false);
        this.add(functie);
        functie.setEditable(false);
        this.add(id);
        id.setEditable(false);
        this.add(modificaButton);
    }
    public void setAll(Angajat angajat){
        nume.setText(angajat.getNume());
        prenume.setText(angajat.getPrenume());
        adresa.setText(angajat.getAdresa());
        CNP.setText(angajat.getCNP());
        tel.setText(angajat.getTel());
        email.setText(angajat.getEmail());
        IBAN.setText(angajat.getIBAN());
        nrContract.setText(angajat.getNrContract());
        dataAngajare.setText(angajat.getDataAngajare());
        functie.setText(angajat.getFunctie());
        id.setText(angajat.getId_user());
    }
    public void addModificaListener(ActionListener actionListener){
        modificaButton.addActionListener(actionListener);
    }
    public Angajat getAngajat(){
        Angajat angajat=new Angajat(id.getText(),nume.getText(),prenume.getText(),CNP.getText(),adresa.getText(),tel.getText(),email.getText(),IBAN.getText(),functie.getText(),dataAngajare.getText(),nrContract.getText());
        return angajat;
    }

    public String getIdAngajat() {
        return id.getText();
    }
}
