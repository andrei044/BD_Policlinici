import javax.swing.*;
import java.awt.*;

public class VeziAngajatPanel extends JPanel {
    CardLayout cardLayout=new CardLayout();
    JTabbedPane tabbedPane=new JTabbedPane();
    ShowUserVeziAngajatPanel showUserVeziAngajatPanel=new ShowUserVeziAngajatPanel();
    CreateProgramPanel createProgramPanel=new CreateProgramPanel(1);
    ShowUserVeziMedicPanel showUserVeziMedicPanel=new ShowUserVeziMedicPanel();
    ShowUserVeziAsistentPanel showUserVeziAsistentPanel=new ShowUserVeziAsistentPanel();
    ConcediuPanel concediuPanel=new ConcediuPanel();
    ProgramSpecificPanel programSpecific=new ProgramSpecificPanel();
    String functie;

    public VeziAngajatPanel() {
        this.setLayout(cardLayout);
        this.add(tabbedPane);
        this.add(showUserVeziAngajatPanel);
        this.add(createProgramPanel);
        this.add(showUserVeziMedicPanel);
        this.add(showUserVeziAsistentPanel);
        this.add(concediuPanel);
        this.add(programSpecific);
        tabbedPane.addTab("Detalii Angajat",showUserVeziAngajatPanel);
        tabbedPane.addTab("Program Generic",createProgramPanel);
        tabbedPane.addTab("Detalii Medic",showUserVeziMedicPanel);
        tabbedPane.addTab("Detalii Asistent",showUserVeziAsistentPanel);
        tabbedPane.addTab("Concediu",concediuPanel);
        tabbedPane.addTab("Program Specific",programSpecific);
    }

    public ShowUserVeziMedicPanel getShowUserVeziMedicPanel() {
        return showUserVeziMedicPanel;
    }

    public ShowUserVeziAsistentPanel getShowUserVeziAsistentPanel() {
        return showUserVeziAsistentPanel;
    }

    public void showForAngajat(){
        tabbedPane.remove(showUserVeziMedicPanel);
        tabbedPane.remove(showUserVeziAsistentPanel);
        tabbedPane.remove(programSpecific);
        tabbedPane.setSelectedIndex(0);

        this.setVisible(false);
        this.setVisible(true);
        functie="Angajat";
    }
    public void showForMedic(){
        tabbedPane.addTab("Detalii Medic",showUserVeziMedicPanel);
        tabbedPane.addTab("Program Specific",programSpecific);
        tabbedPane.remove(showUserVeziAsistentPanel);
        tabbedPane.setSelectedIndex(0);

        this.setVisible(false);
        this.setVisible(true);
        functie="Medic";
    }
    public void showForAsistent(){
        tabbedPane.addTab("Detalii Asistent",showUserVeziAsistentPanel);
        //tabbedPane.addTab("Program Specific",programSpecific);
        tabbedPane.remove(showUserVeziMedicPanel);
        tabbedPane.setSelectedIndex(0);

        this.setVisible(false);
        this.setVisible(true);
        functie="Asistent";
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.setContentPane(new VeziAngajatPanel());
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public ShowUserVeziAngajatPanel getShowUserVeziAngajatPanel() {
        return showUserVeziAngajatPanel;
    }

    public CreateProgramPanel getCreateProgramPanel() {
        return createProgramPanel;
    }

    public Angajat getAngajat(){
        Angajat angajat=showUserVeziAngajatPanel.getAngajat();
        if(functie.equals("Angajat"))
            return angajat;
        else if(functie.equals("Medic")){
            Medic medic=new Medic(angajat);
            Medic medic1=showUserVeziMedicPanel.getMedic();
            medic.setParafa(medic1.getParafa());
            medic.setTitlu(medic1.getTitlu());
            medic.setPost(medic1.getPost());
            for(int i=0;i<medic1.getNrSpecializari();i++){
                medic.addSpecializare(medic1.getSpecializare(i));
            }
            System.out.println(medic);
            return medic;
        }else{
            Asistent asistent=new Asistent(angajat);
            Asistent asistent1=showUserVeziAsistentPanel.getAsistent();
            asistent.setGrad(asistent1.getGrad());
            asistent.setTip(asistent1.getTip());
            return asistent;
        }
    }

    public ConcediuPanel getConcediuPanel() {
        return concediuPanel;
    }

    public ProgramSpecificPanel getProgramSpecific() {
        return programSpecific;
    }

    public void reset(){
        tabbedPane.setSelectedIndex(0);
    }
}
