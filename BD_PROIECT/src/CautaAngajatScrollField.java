import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CautaAngajatScrollField extends JPanel{
    JLabel nume=new JLabel();
    JLabel prenume=new JLabel();
    JLabel idAngajat=new JLabel();
    JButton veziButton=new JButton("Vezi");

    public CautaAngajatScrollField(String newnume, String newprenume, String newidAngajat) {
        this.setLayout(new GridLayout(1,4));
        this.add(idAngajat);
        this.add(nume);
        this.add(prenume);
        this.add(veziButton);

        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));

        idAngajat.setPreferredSize(new Dimension(100,25));
        idAngajat.setMaximumSize(new Dimension(100,25));
        nume.setPreferredSize(new Dimension(100,25));
        nume.setMaximumSize(new Dimension(100,25));
        prenume.setPreferredSize(new Dimension(100,25));
        prenume.setMaximumSize(new Dimension(100,25));
        veziButton.setPreferredSize(new Dimension(100,25));
        veziButton.setMaximumSize(new Dimension(100,25));

        nume.setText(newnume);
        prenume.setText(newprenume);
        idAngajat.setText(newidAngajat);
    }

    public void addVeziAngajatListener(ActionListener actionListener) {
        veziButton.addActionListener(actionListener);
    }

    public String getIdAngajat(){
        return idAngajat.getText();
    }
}
