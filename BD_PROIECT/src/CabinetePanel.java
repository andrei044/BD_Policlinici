import javax.swing.*;

public class CabinetePanel extends JPanel {
    private JButton cabinete=new JButton("Cabinete");
    private JButton recuzita=new JButton("Recuzita");
    private JButton repartizare=new JButton("Repartizare");

    public CabinetePanel() {
        this.add(cabinete);
        this.add(recuzita);
        this.add(repartizare);
    }
}
