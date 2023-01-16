import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CabinetePanel extends JPanel {
    private JButton cabinete=new JButton("Cabinete");
    private JButton recuzita=new JButton("Recuzita");
    private JButton repartizare=new JButton("Repartizare");
    private CardLayout cardLayout=new CardLayout();
    private JPanel menu=new JPanel();
    private AdaugaStergeCabinete adaugaStergeCabinete=new AdaugaStergeCabinete();
    private RecuzitaPanel recuzitaPanel=new RecuzitaPanel();
    private RepartizarePanel repartizarePanel=new RepartizarePanel();
    public CabinetePanel() {
        this.setLayout(cardLayout);
        menu.add(cabinete);
        menu.add(recuzita);
        menu.add(repartizare);

        this.add(menu,"menu");
        this.add(adaugaStergeCabinete,"adaugaStergeCabinete");
        this.add(recuzitaPanel,"recuzitaPanel");
        this.add(repartizarePanel,"repartizarePanel");
    }

    public AdaugaStergeCabinete getAdaugaStergeCabinete() {
        return adaugaStergeCabinete;
    }

    public void showCabinete() {
        cardLayout.show(this,"adaugaStergeCabinete");
    }

    public void addCabineteListener(ActionListener actionListener) {
        cabinete.addActionListener(actionListener);
    }

    public void backCabinete() {
        cardLayout.show(this,"menu");
    }
    public void addRepartizareListener(ActionListener actionListener){
        repartizare.addActionListener(actionListener);
    }
    public RepartizarePanel getRepartizarePanel() {
        return repartizarePanel;
    }
    public void showRepartizare() {
        cardLayout.show(this,"repartizarePanel");
    }
    public void addRecuzitaListener(ActionListener actionListener){
        recuzita.addActionListener(actionListener);
    }

    public void showRecuzita() {
        cardLayout.show(this,"recuzitaPanel");
    }

    public RecuzitaPanel getRecuzitaPanel() {
        return recuzitaPanel;
    }
}
