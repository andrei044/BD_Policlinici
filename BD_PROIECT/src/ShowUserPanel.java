import javax.swing.*;
import java.awt.*;

public class ShowUserPanel extends JPanel {
    JLabel numeLabel=new JLabel("Nume:");
    JLabel showNumeLabel=new JLabel();
    JLabel prenumeLabel=new JLabel("Prenume:");
    JLabel showPrenumeLabel=new JLabel();
    JLabel adresaLabel=new JLabel("Adresa:");
    JLabel showAdresaLabel=new JLabel();
    JLabel CNPLabel=new JLabel("CNP:");
    JLabel showCNPLabel=new JLabel();
    JLabel telLabel=new JLabel("Tel:");
    JLabel showTelLabel=new JLabel();
    JLabel emailLabel=new JLabel("Email:");
    JLabel showEmailLabel=new JLabel();
    JLabel IBANLabel=new JLabel("IBAN: ");
    JLabel showIBANLabel=new JLabel();
    JLabel nrContractLabel=new JLabel("Nr contract:");
    JLabel showNrContractLabel=new JLabel();
    JLabel dataAngajareLabel=new JLabel("Data angajarii:");
    JLabel showDataAngajareLabel=new JLabel();

    public ShowUserPanel() {
        this.add(numeLabel);
        this.add(prenumeLabel);
        this.add(adresaLabel);
        this.add(CNPLabel);
        this.add(telLabel);
        this.add(emailLabel);
        this.add(IBANLabel);
        this.add(nrContractLabel);
        this.add(dataAngajareLabel);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        numeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        prenumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        adresaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        CNPLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        telLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        IBANLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nrContractLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataAngajareLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        ShowUserPanel x=new ShowUserPanel();
        jFrame.setPreferredSize(new Dimension(1000,800));
        jFrame.setContentPane(x);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setAll(Angajat angajat){
        numeLabel.setText("Nume:"+angajat.getNume());
        prenumeLabel.setText("Prenume:"+angajat.getPrenume());
        adresaLabel.setText("Adresa:"+angajat.getAdresa());
        CNPLabel.setText("CNP:"+angajat.getCNP());
        telLabel.setText("Tel:"+angajat.getTel());
        emailLabel.setText("Email:"+angajat.getEmail());
        IBANLabel.setText("IBAN:"+angajat.getIBAN());
        nrContractLabel.setText("Nr contract:"+angajat.getNrContract());
        dataAngajareLabel.setText("Data angajarii:"+angajat.getDataAngajare());
    }
    public void resetAll(){
        numeLabel.setText("Nume:");
        prenumeLabel.setText("Prenume:");
        adresaLabel.setText("Adresa:");
        CNPLabel.setText("CNP:");
        telLabel.setText("Tel:");
        emailLabel.setText("Email:");
        IBANLabel.setText("IBAN:");
        nrContractLabel.setText("Nr contract:");
        dataAngajareLabel.setText("Data angajarii:");
    }
}
