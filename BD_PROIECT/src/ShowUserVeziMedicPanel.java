import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class ShowUserVeziMedicPanel extends JPanel {
    private String[] titluMedicComboBoxString={"","doctorand","doctor"};
    private String[] postMedicComboBoxString={"","preparator","asistent","lector","conferentiar","profesor"};
    private DefaultComboBoxModel<String> comboBoxModel_titlu_medic = new DefaultComboBoxModel<>( titluMedicComboBoxString );
    private DefaultComboBoxModel<String> comboBoxModel_post_medic = new DefaultComboBoxModel<>( postMedicComboBoxString );
    private int nr_specializari=0;
    private SpecializareField[] specializareField=new SpecializareField[3];

    private JButton modificaButton=new JButton("Modifica");
    JPanel specializariPanel=new JPanel();
    JPanel titluPanel=new JPanel();
    JPanel postPanel=new JPanel();

    JComboBox titluMedicComboBox=new JComboBox(comboBoxModel_titlu_medic);
    JComboBox postMedicComboBox=new JComboBox(comboBoxModel_post_medic);

    JButton addSpecializareButton=new JButton("Adauga Specializare");
    JButton removeSpecializareButton=new JButton("Sterge Specializare");
    CreateUserField parafa=new CreateUserField("Parafa");
    JPanel buttons=new JPanel();
    List<SpecializareField>specializareFieldList=new ArrayList<>();

    public ShowUserVeziMedicPanel() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        titluPanel.add(new JLabel("Titlu:"));
        titluPanel.add(titluMedicComboBox);
        titluMedicComboBox.setMaximumSize(new Dimension(1000,25));
        titluPanel.setLayout(new BoxLayout(titluPanel,BoxLayout.X_AXIS));

        postPanel.add(new JLabel("Post:"));
        postPanel.add(postMedicComboBox);
        postMedicComboBox.setMaximumSize(new Dimension(1000,25));
        postPanel.setLayout(new BoxLayout(postPanel,BoxLayout.X_AXIS));

        buttons.add(addSpecializareButton);
        buttons.add(removeSpecializareButton);
        buttons.add(modificaButton);
        specializareField[0]=new SpecializareField(0);
        specializareField[1]=new SpecializareField(1);
        specializareField[2]=new SpecializareField(2);
        //specializariPanel.add(specializareField[0]);
        //specializariPanel.add(specializareField[1]);
        //specializariPanel.add(specializareField[2]);

        this.add(titluPanel);
        this.add(postPanel);
        this.add(parafa);
        this.add(specializariPanel);
        this.add(buttons);
        //modificaButton.setVisible(false);
        addSpecializareButton.setVisible(false);
        removeSpecializareButton.setVisible(false);

    }
    public void addSpecializare(Specializare specializare){
        if(nr_specializari<3){
            specializariPanel.add(specializareField[nr_specializari],nr_specializari);
            if(specializare!=null){
                specializareField[nr_specializari].setNrCompetente(0);
                specializareField[nr_specializari].setSpecializare(specializare);
            }
            nr_specializari++;
        }
        this.setVisible(false);
        this.setVisible(true);
    }

    public void addSpecializareField(){
        if(nr_specializari<3){
            specializariPanel.add(specializareField[nr_specializari],nr_specializari);
            nr_specializari++;
        }
        this.setVisible(false);
        this.setVisible(true);
    }

    public void removeSpecializare(){
        if(nr_specializari>1){
            specializariPanel.remove(specializareField[nr_specializari-1]);
            nr_specializari--;
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void setAll(Medic medic){
        //this.reset();
//        parafa.setText(medic.getParafa());
//        titluMedicComboBox.setSelectedItem(medic.getTitlu());
//        postMedicComboBox.setSelectedItem(medic.getPost());
//        nr_specializari= medic.getNrSpecializari();
//        for(int i=0;i<medic.getNrSpecializari();i++)
//        {
//            specializareField[i].setSpecializare(medic.getSpecializare(i));
//            specializariPanel.add(specializareField[i]);
//        }
        parafa.setText(medic.getParafa());
        parafa.setEditable(false);
        titluMedicComboBox.setSelectedItem(medic.getTitlu());
        titluMedicComboBox.setEditable(false);
        postMedicComboBox.setSelectedItem(medic.getPost());
        postMedicComboBox.setEditable(false);
        nr_specializari=medic.getNrSpecializari();
        for(int i=0;i<medic.getNrSpecializari();i++){
            SpecializareField x=new SpecializareField(i);
            x.setSpecializare(medic.getSpecializare(i));
            x.setEditable(false);
            specializareFieldList.add(x);
            specializariPanel.add(x);
        }
    }

    public void reset() {
        titluMedicComboBox.setSelectedIndex(0);
        postMedicComboBox.setSelectedIndex(0);
        parafa.setText("");
        while(nr_specializari>0){
            specializariPanel.remove(0);
            specializareFieldList.remove(0);
            nr_specializari--;
        }

    }
    public void addAddCompetentaListener(ActionListener actionListener){
        specializareField[0].addAddCompetentaListener(actionListener);
        specializareField[1].addAddCompetentaListener(actionListener);
        specializareField[2].addAddCompetentaListener(actionListener);
    }

    public void addRemoveCompetentaListener(ActionListener actionListener) {
        specializareField[0].addRemoveCompetentaListener(actionListener);
        specializareField[1].addRemoveCompetentaListener(actionListener);
        specializareField[2].addRemoveCompetentaListener(actionListener);
    }
    public void addAddSpecializareListener(ActionListener actionListener){
        addSpecializareButton.addActionListener(actionListener);
    }
    public void addRemoveSpecializareListener(ActionListener actionListener){
        removeSpecializareButton.addActionListener(actionListener);
    }
    public void addModificaButtonListener(ActionListener actionListener){
        modificaButton.addActionListener(actionListener);
    }

    public Medic getMedic(){
        Medic medic=new Medic();
        medic.setParafa(parafa.getText());
        medic.setTitlu(titluMedicComboBox.getSelectedItem().toString());
        medic.setPost(postMedicComboBox.getSelectedItem().toString());
        for(int i=0;i<specializareFieldList.size();i++){
            medic.addSpecializare(specializareFieldList.get(i).getSpecializare());
        }
        medic.setNrSpecializari(nr_specializari);
        return medic;
    }
}
