import javax.swing.*;
import java.awt.*;

public class ServiciuField extends JPanel {
    private JLabel id_serviciu=new JLabel();
    private JLabel denumire=new JLabel();
    private JLabel numeMedic=new JLabel();
    private JCheckBox checkBox=new JCheckBox();

    public ServiciuField(String id_serviciu,String denumire,String numeMedic) {
        this.id_serviciu.setText(id_serviciu);
        this.denumire.setText(denumire);
        this.numeMedic.setText(numeMedic);

        this.setLayout(new GridLayout(1,4));
        this.setPreferredSize(new Dimension(500,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id_serviciu);
        this.add(this.denumire);
        this.add(this.numeMedic);
        this.add(this.checkBox);
    }

    public String getId_serviciu() {
        return id_serviciu.getText();
    }

    public boolean isCheckBox() {
        return checkBox.isSelected();
    }

    @Override
    public String toString() {
        return "ServiciuField{" +
                "id_serviciu=" + id_serviciu.getText() +
                ", denumire=" + denumire.getText() +
                ", numeMedic=" + numeMedic.getText() +
                ", checkBox=" + checkBox.isSelected() +
                '}';
    }
}
