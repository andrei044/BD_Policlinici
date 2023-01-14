import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserField extends JPanel {
    private JLabel id=new JLabel();
    private JLabel nume=new JLabel();
    private JLabel prenume=new JLabel();
    private JLabel status=new JLabel();
    private JButton delete=new JButton("Sterge");

    public UserField(String id, String nume,String prenume,String status) {
        this.id.setText(id);
        this.nume.setText(nume);
        this.prenume.setText(prenume);
        this.status.setText(status);
        this.setLayout(new GridLayout(1,5));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id);
        this.add(this.nume);
        this.add(this.prenume);
        this.add(this.status);
        this.add(this.delete);
    }
    public void addDeleteListener(ActionListener actionListener){
        delete.addActionListener(actionListener);
    }
    public String getId(){
        return this.id.getText();
    }
}
