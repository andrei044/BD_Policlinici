import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProgramarePacientScrollField extends JPanel {
    private JLabel nume=new JLabel();
    private JLabel prenume=new JLabel();
    private JLabel idPacient=new JLabel();
    private JButton selectButton=new JButton("Selecteaza");

    public ProgramarePacientScrollField(String newnume, String newprenume, String newidPacient) {
        this.setLayout(new GridLayout(1,4));
        this.add(idPacient);
        this.add(nume);
        this.add(prenume);
        this.add(selectButton);

        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));

        idPacient.setPreferredSize(new Dimension(100,25));
        idPacient.setMaximumSize(new Dimension(100,25));
        nume.setPreferredSize(new Dimension(100,25));
        nume.setMaximumSize(new Dimension(100,25));
        prenume.setPreferredSize(new Dimension(100,25));
        prenume.setMaximumSize(new Dimension(100,25));
        selectButton.setPreferredSize(new Dimension(100,25));
        selectButton.setMaximumSize(new Dimension(100,25));

        nume.setText(newnume);
        prenume.setText(newprenume);
        idPacient.setText(newidPacient);
    }

    public void addSelectPacientListener(ActionListener actionListener) {
        selectButton.addActionListener(actionListener);
    }

    public String getIdPacient(){
        return idPacient.getText();
    }
}
