import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmiteFacturaField extends JPanel {
    private String data_programare;
    private String programare_start;
    private String programare_stop;
    private String pacient;
    private String medic;
    private String serviciu;
    private String pret;
    private String id_istoric;
    private String id_raport;
    private String id_analize;
    private String data_factura;
    private JButton selectButton=new JButton("Selecteaza");

    public EmiteFacturaField(String data_programare, String programare_start, String programare_stop, String pacient, String medic, String serviciu, String pret, String id_istoric, String id_raport, String id_analize,String data_factura) {
        this.data_programare = data_programare;
        this.programare_start = programare_start;
        this.programare_stop = programare_stop;
        this.pacient = pacient;
        this.medic = medic;
        this.serviciu = serviciu;
        this.pret = pret;
        this.id_istoric = id_istoric;
        this.id_raport = id_raport;
        this.id_analize = id_analize;
        this.data_factura=data_factura;
        this.setLayout(new GridLayout(1,8));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(new JLabel(data_programare));
        this.add(new JLabel(programare_start));
        this.add(new JLabel(programare_stop));
        this.add(new JLabel(pacient));
        this.add(new JLabel(medic));
        this.add(new JLabel(serviciu));
        this.add(new JLabel(pret));
        this.add(selectButton);
        if(data_factura.equals("null")){
            this.setBackground(Color.RED);
        }else{
            selectButton.setVisible(false);
        }
        if(id_raport.equals("null") || id_analize.equals("null")){
            this.setBackground(Color.GRAY);
            selectButton.setVisible(false);
        }
    }

    public void addSelecteazaListener(ActionListener actionListener) {
        selectButton.addActionListener(actionListener);
    }

    @Override
    public String toString() {
        return "EmiteFacturaField{" +
                "data_programare='" + data_programare + '\'' +
                ", programare_start='" + programare_start + '\'' +
                ", programare_stop='" + programare_stop + '\'' +
                ", pacient='" + pacient + '\'' +
                ", medic='" + medic + '\'' +
                ", serviciu='" + serviciu + '\'' +
                ", pret='" + pret + '\'' +
                ", id_istoric='" + id_istoric + '\'' +
                ", id_raport='" + id_raport + '\'' +
                ", id_analize='" + id_analize + '\'' +
                ", data_factura='" + data_factura + '\'' +
                ", selectButton=" + selectButton +
                '}';
    }

    public String getData_programare() {
        return data_programare;
    }

    public String getProgramare_start() {
        return programare_start;
    }

    public String getProgramare_stop() {
        return programare_stop;
    }

    public String getPacient() {
        return pacient;
    }

    public String getMedic() {
        return medic;
    }

    public String getServiciu() {
        return serviciu;
    }

    public String getPret() {
        return pret;
    }

    public String getId_istoric() {
        return id_istoric;
    }

    public String getId_raport() {
        return id_raport;
    }

    public String getId_analize() {
        return id_analize;
    }

    public String getData_factura() {
        return data_factura;
    }
    public void setCompleted(){
        this.setBackground(Color.white);
        selectButton.setVisible(false);
    }
}
