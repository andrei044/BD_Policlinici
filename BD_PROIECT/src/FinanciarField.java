import javax.swing.*;
import java.awt.*;

public class FinanciarField extends JPanel {
    private JLabel id=new JLabel();
    private JLabel nume=new JLabel();
    private JLabel prenume=new JLabel();
    private JLabel functie=new JLabel();
    private JLabel brut=new JLabel();
    private JLabel net=new JLabel();
    private JLabel serviciu=new JLabel();
    private JLabel venit=new JLabel();
    private JLabel profit=new JLabel();
    private JLabel specializare=new JLabel();
    private JLabel cheltuieli=new JLabel();

    public FinanciarField(String id,String nume,String prenume,String functie,String brut,String net) {
        this.id.setText(id);
        this.nume.setText(nume);
        this.prenume.setText(prenume);
        this.functie.setText(functie);
        this.brut.setText(brut);
        this.net.setText(net);
        this.setLayout(new GridLayout(1,6));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id);
        this.add(this.nume);
        this.add(this.prenume);
        this.add(this.functie);
        this.add(this.brut);
        this.add(this.net);
    }

    public FinanciarField(String id, String nume, String prenume, String serviciu, String venit, String brut, String net, String profit) {
        this.id.setText(id);
        this.nume.setText(nume);
        this.prenume.setText(prenume);
        this.serviciu.setText(serviciu);
        this.venit.setText(venit);
        this.brut.setText(brut);
        this.net.setText(net);
        this.profit.setText(profit);
        this.setLayout(new GridLayout(1,8));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id);
        this.add(this.nume);
        this.add(this.prenume);
        this.add(this.serviciu);
        this.add(this.venit);
        this.add(this.brut);
        this.add(this.net);
        this.add(this.profit);

    }

    public FinanciarField(String toString, String toString1, String toString2, String toString3) {
        this.specializare.setText(toString);
        this.venit.setText(toString1);
        this.brut.setText(toString2);
        this.profit.setText(toString3);
        this.setLayout(new GridLayout(1,4));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.specializare);
        this.add(this.venit);
        this.add(this.brut);
        this.add(this.profit);
    }

    public FinanciarField(String toString, String toString1, String toString2) {
        this.venit.setText(toString);
        this.cheltuieli.setText(toString1);
        this.profit.setText(toString2);
    }

    public FinanciarField(String toString, String toString1, String toString2, String toString3, int i) {
        this.id.setText(toString);
        this.venit.setText(toString1);
        this.cheltuieli.setText(toString2);
        this.profit.setText(toString3);
        this.setLayout(new GridLayout(1,4));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id);
        this.add(this.venit);
        this.add(this.cheltuieli);
        this.add(this.profit);
    }

    public String getVenit() {
        return venit.getText();
    }

    public String getProfit() {
        return profit.getText();
    }

    public String getCheltuieli() {
        return cheltuieli.getText();
    }
}
