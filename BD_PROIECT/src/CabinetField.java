import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CabinetField extends JPanel {
    private JLabel id_cabinet=new JLabel();
    private JLabel id=new JLabel();
    private JLabel serviciu=new JLabel();
    private JLabel numeMedic=new JLabel();
    private JButton delete=new JButton("Delete");
    //private ProgramGeneric programGeneric;
    public CabinetField(String id,String id_cabinet, String serviciu,String nume_medic) {
        this.id.setText(id);
        this.id_cabinet.setText(id_cabinet);
        this.serviciu.setText(serviciu);
        this.numeMedic.setText(nume_medic);
        this.setLayout(new GridLayout(1,5));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id);
        this.add(this.id_cabinet);
        this.add(this.serviciu);
        this.add(this.numeMedic);
        this.add(this.delete);

    }
    public String getId() {
        return id_cabinet.getText();
    }

    public void addDeleteListener(ActionListener actionListener) {
        delete.addActionListener(actionListener);
    }
}
