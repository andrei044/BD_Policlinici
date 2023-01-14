import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreeazaRaportScrollField extends JPanel {
    JLabel dataProgramare=new JLabel();
    JLabel programareStart=new JLabel();
    JLabel programareStop=new JLabel();
    JLabel numePacient=new JLabel();
    JLabel numeMedic=new JLabel();
    JLabel numeCompetenta=new JLabel();
    JButton selectButton=new JButton("Selecteaza");
    private String id_raport;
    private String id_analize;
    private String id_programare;
    public CreeazaRaportScrollField(String id_programare,String data_programare,String pacient,String medic,String competenta,String programare_start,String programare_stop,String id_raport,String id_analize) {
        this.setLayout(new GridLayout(1,7));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(dataProgramare);
        this.add(numePacient);
        this.add(numeMedic);
        this.add(numeCompetenta);
        this.add(programareStart);
        this.add(programareStop);
        this.add(selectButton);
        this.id_programare=id_programare;
        dataProgramare.setText(data_programare);
        numePacient.setText(pacient);
        numeMedic.setText(medic);
        numeCompetenta.setText(competenta);
        programareStart.setText(programare_start);
        programareStop.setText(programare_stop);
        dataProgramare.setPreferredSize(new Dimension(100,25));
        numePacient.setPreferredSize(new Dimension(100,25));
        numeMedic.setPreferredSize(new Dimension(100,25));
        numeCompetenta.setPreferredSize(new Dimension(100,25));
        selectButton.setPreferredSize(new Dimension(100,25));
        programareStart.setPreferredSize(new Dimension(100,25));
        programareStop.setPreferredSize(new Dimension(100,25));

        dataProgramare.setMaximumSize(new Dimension(100,25));
        numePacient.setMaximumSize(new Dimension(100,25));
        numeMedic.setMaximumSize(new Dimension(100,25));
        numeCompetenta.setMaximumSize(new Dimension(100,25));
        selectButton.setMaximumSize(new Dimension(100,25));
        programareStart.setMaximumSize(new Dimension(100,25));
        programareStop.setMaximumSize(new Dimension(100,25));
        this.id_raport=id_raport;
        this.id_analize=id_analize;
        if(id_raport.equals("null") && id_analize.equals("null")){
            this.setBackground(Color.red);
        }else if(!id_raport.equals("null") && id_analize.equals("null")){
            this.setBackground(Color.yellow);
        }if(id_raport.equals("null") && !id_analize.equals("null")){
            this.setBackground(Color.orange);
        }
    }
    public void addSelectProgramareListener(ActionListener actionListener){
        selectButton.addActionListener(actionListener);
    }

    public String getId_programare() {
        return id_programare;
    }

    public String getId_raport() {
        return id_raport;
    }

    public String getId_analize() {
        return id_analize;
    }
}
