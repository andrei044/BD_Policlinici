import javax.swing.*;
import java.awt.*;

public class SalariuAngajatField extends JPanel {
    private JLabel idLabel=new JLabel();
    private JLabel numeLabel=new JLabel();
    private JLabel prenumeLabel=new JLabel();
    private JLabel functieLabel=new JLabel();
    private JLabel brutLabel=new JLabel();
    private JLabel netLabel=new JLabel();
    private JLabel serviciuLabel=new JLabel();
    private JLabel dataLabel=new JLabel();
    private JLabel venitLabel=new JLabel();
    private String id;
    private String nume;
    private String prenume;
    private String functie;
    private String brut;
    private String net;
    private String serviciu;
    private String data;
    private String venit;

    public SalariuAngajatField(String id, String nume, String prenume, String functie, String brut, String net) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
        this.brut = brut;
        this.net = net;
        idLabel.setText(id);
        numeLabel.setText(nume);
        prenumeLabel.setText(prenume);
        functieLabel.setText(functie);
        brutLabel.setText(brut);
        netLabel.setText(net);
        this.setLayout(new GridLayout(1,6));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(idLabel);
        this.add(numeLabel);
        this.add(prenumeLabel);
        this.add(functieLabel);
        this.add(brutLabel);
        this.add(netLabel);
    }

    public SalariuAngajatField(String id, String nume, String prenume, String serviciu, String venit, String brut, String net, String data) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.brut = brut;
        this.net = net;
        this.serviciu = serviciu;
        this.data = data;
        this.venit = venit;
        idLabel.setText(id);
        numeLabel.setText(nume);
        prenumeLabel.setText(prenume);
        brutLabel.setText(brut);
        netLabel.setText(net);
        serviciuLabel.setText(serviciu);
        venitLabel.setText(venit);
        dataLabel.setText(data);
        this.setLayout(new GridLayout(1,8));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(idLabel);
        this.add(numeLabel);
        this.add(prenumeLabel);
        this.add(serviciuLabel);
        this.add(brutLabel);
        this.add(netLabel);
        this.add(venitLabel);
        this.add(dataLabel);
    }
}
