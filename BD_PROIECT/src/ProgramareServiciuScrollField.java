import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProgramareServiciuScrollField extends JPanel {
    private JLabel idSpecializare=new JLabel();
    private JLabel denumire=new JLabel();
    private JLabel medic=new JLabel();
    private JLabel durataServiciu=new JLabel();
    private JButton selectButton=new JButton("Selecteaza");

    public ProgramareServiciuScrollField(String newId, String newDenumire, String newMedic,String durata) {
        this.setLayout(new GridLayout(1,4));
        this.add(idSpecializare);
        this.add(denumire);
        this.add(medic);
        this.add(selectButton);
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));

        idSpecializare.setPreferredSize(new Dimension(100,25));
        idSpecializare.setMaximumSize(new Dimension(100,25));
        denumire.setPreferredSize(new Dimension(100,25));
        denumire.setMaximumSize(new Dimension(100,25));
        medic.setPreferredSize(new Dimension(100,25));
        medic.setMaximumSize(new Dimension(100,25));
        selectButton.setPreferredSize(new Dimension(100,25));
        selectButton.setMaximumSize(new Dimension(100,25));

        idSpecializare.setText(newId);
        denumire.setText(newDenumire);
        medic.setText(newMedic);
        durataServiciu.setText(durata);
    }
    public void addSelectServiciuListener(ActionListener actionListener){
        selectButton.addActionListener(actionListener);
    }
    public String getIdServiciu(){
        return idSpecializare.getText();
    }
    public String getDurataServiciu(){return durataServiciu.getText();}
}
