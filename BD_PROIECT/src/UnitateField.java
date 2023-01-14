import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UnitateField extends JPanel {
    private JLabel id=new JLabel();
    private JLabel denumire=new JLabel();
    private JLabel adresa=new JLabel();
    private JButton select=new JButton("Select");
    //private ProgramGeneric programGeneric;
    public UnitateField(String id, String denumire,String adresa) {
        this.id.setText(id);
        this.denumire.setText(denumire);
        this.adresa.setText(adresa);
        this.setLayout(new GridLayout(1,4));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id);
        this.add(this.denumire);
        this.add(this.adresa);
        this.add(this.select);

    }
    public String getId() {
        return id.getText();
    }

    public void addSelectListener(ActionListener actionListener) {
        select.addActionListener(actionListener);
    }
}
