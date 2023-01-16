import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RecuzitaField extends JPanel {
    private JLabel id_serviciu=new JLabel();
    private JLabel denumire=new JLabel();
    private JLabel numeMedic=new JLabel();
    private JLabel recuzita=new JLabel();
    private JButton sterge=new JButton("sterge");
    private JButton selecteaza=new JButton("select");
    private String id_recuzita;

    public RecuzitaField(String id_serviciu,String denumire,String numeMedic,String recuzita,String id_recuzita) {
        this.id_serviciu.setText(id_serviciu);
        this.denumire.setText(denumire);
        this.numeMedic.setText(numeMedic);
        this.recuzita.setText(recuzita);
        this.id_recuzita=id_recuzita;
        this.setLayout(new GridLayout(1,6));
        this.setPreferredSize(new Dimension(500,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id_serviciu);
        this.add(this.denumire);
        this.add(this.numeMedic);
        this.add(this.recuzita);
        this.add(this.sterge);
        this.add(this.selecteaza);
    }
    public String getId_recuzita(){
        return id_recuzita;
    }

    public void addDeleteListener(ActionListener actionListener) {
        sterge.addActionListener(actionListener);
    }
    public void addSelectListener(ActionListener actionListener){
        selecteaza.addActionListener(actionListener);
    }

    public String getIdServiciu() {
        return id_serviciu.getText();
    }

}
