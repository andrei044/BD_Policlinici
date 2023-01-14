import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProgramareField extends JPanel{
    private JLabel start=new JLabel();
    private JLabel stop=new JLabel();
    private JLabel id=new JLabel();
    private JLabel data=new JLabel();
    private JLabel numePacient=new JLabel();
    private JLabel serviciu=new JLabel();
    private JButton sterge=new JButton("Sterge");

    public ProgramareField(String toString, String toString1, String toString2, String toString3, String toString4, String toString5) {
        this.id.setText(toString);
        this.data.setText(toString1);
        this.start.setText(toString2);
        this.stop.setText(toString3);
        this.numePacient.setText(toString4);
        this.serviciu.setText(toString5);
        this.setLayout(new GridLayout(1,7));
        this.add(id);
        this.add(data);
        this.add(start);
        this.add(stop);
        this.add(numePacient);
        this.add(serviciu);
        this.add(sterge);
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
    }
    public String getId(){
        return id.getText();
    }

    public void addStergeListener(ActionListener actionListener) {
        sterge.addActionListener(actionListener);
    }
}
