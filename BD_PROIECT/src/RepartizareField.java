import javax.swing.*;
import java.awt.*;

public class RepartizareField extends JPanel {
    private JLabel id_unitate=new JLabel();
    private JLabel id_cabinet=new JLabel();
    private JLabel id_medic=new JLabel();
    private JLabel timp_start=new JLabel();
    private JLabel timp_stop=new JLabel();
    private String id_servicii;
    private boolean tip=false;

    public RepartizareField(String id_unitate,String id_cabinet,String id_medic,String timp_start,String timp_stop) {
        this.id_unitate.setText(id_unitate);
        this.id_cabinet.setText(id_cabinet);
        this.id_medic.setText(id_medic);
        this.timp_start.setText(timp_start);
        this.timp_stop.setText(timp_stop);
        this.setLayout(new GridLayout(1,5));
        this.setPreferredSize(new Dimension(500,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(this.id_unitate);
        this.add(this.id_cabinet);
        this.add(this.id_medic);
        this.add(this.timp_start);
        this.add(this.timp_stop);
        tip=true;
    }

    public RepartizareField(String id_servicii) {
        this.id_servicii=id_servicii;
        tip=false;
    }

    public boolean isTip() {
        return tip;
    }

    public String getServiciu() {
        return id_servicii;
    }
}
