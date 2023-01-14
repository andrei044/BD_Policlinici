import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConcediuField extends JPanel {
    private String zi_concediu;
    private String id_angajat;
    JButton stergeButton=new JButton("Sterge");

    public ConcediuField(String id_angajat,String zi_concediu) {
        this.id_angajat=id_angajat;
        this.zi_concediu = zi_concediu;

        this.setLayout(new GridLayout(1,3));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));

        this.add(new JLabel(id_angajat));
        this.add(new JLabel(zi_concediu));
        this.add(stergeButton);
        stergeButton.setVisible(false);
    }
    public void addStergeConcediuListener(ActionListener actionListener){
        stergeButton.addActionListener(actionListener);
    }

}
