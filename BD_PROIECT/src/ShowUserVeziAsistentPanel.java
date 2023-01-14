import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShowUserVeziAsistentPanel extends JPanel {
    String[] tipAsistentComboBoxString={"","generalist","laborator","radiologie"};
    String[] gradAsistentComboBoxString={"","secundar","principal"};
    DefaultComboBoxModel<String> comboBoxModel_tip_asistent = new DefaultComboBoxModel<>( tipAsistentComboBoxString );
    DefaultComboBoxModel<String> comboBoxModel_grad_asistent = new DefaultComboBoxModel<>( gradAsistentComboBoxString );

    JComboBox tipAsistentComboBox=new JComboBox(comboBoxModel_tip_asistent);
    JComboBox gradAsistentComboBox=new JComboBox(comboBoxModel_grad_asistent);
    JPanel tipPanel=new JPanel();
    JPanel gradPanel=new JPanel();
    JButton modificaButton=new JButton("Modifica");
    public ShowUserVeziAsistentPanel() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        tipAsistentComboBox.setPreferredSize(new Dimension(100,25));
        tipAsistentComboBox.setMaximumSize(new Dimension(100,25));
        gradAsistentComboBox.setPreferredSize(new Dimension(100,25));
        gradAsistentComboBox.setMaximumSize(new Dimension(100,25));
        tipPanel.add(new JLabel("Tip:"));
        tipPanel.add(tipAsistentComboBox);
        tipPanel.setLayout(new BoxLayout(tipPanel,BoxLayout.X_AXIS));
        gradPanel.add(new JLabel("Grad:"));
        gradPanel.add(gradAsistentComboBox);
        gradPanel.setLayout(new BoxLayout(gradPanel,BoxLayout.X_AXIS));
        this.add(tipPanel);
        this.add(gradPanel);
        this.add(modificaButton);
    }

    public void setAll(String tip, String grad){
        tipAsistentComboBox.setSelectedItem(tip);
        gradAsistentComboBox.setSelectedItem(grad);
    }
    public Asistent getAsistent(){
        Asistent asistent=new Asistent();
        asistent.setTip(tipAsistentComboBox.getSelectedItem().toString());
        asistent.setGrad(gradAsistentComboBox.getSelectedItem().toString());
        return asistent;
    }
    public void addModificaListener(ActionListener actionListener){
        modificaButton.addActionListener(actionListener);
    }
}
