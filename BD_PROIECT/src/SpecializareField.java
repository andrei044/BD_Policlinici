import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SpecializareField extends JPanel {
    private TextFieldWithPlaceHolder specializare=new TextFieldWithPlaceHolder();
    private String[] gradMedicComboBoxString={"grad","specialist","primar"};
    private DefaultComboBoxModel<String> comboBoxModel_grad_medic = new DefaultComboBoxModel<>( gradMedicComboBoxString );
    private JComboBox gradMedicComboBox=new JComboBox();
    //private TextFieldWithPlaceHolder[] competenta=new TextFieldWithPlaceHolder[5];
    private JButton addCompetentaButton=new JButton("Adauga Competenta");
    private JButton removeCompetentaButton=new JButton("Sterge Competenta");
    private JPanel addRemoveCompetenta=new JPanel();
    private int nrCompetente=0;
    private boolean show_user=false;

    //private List<TextFieldWithPlaceHolder>listCompetente=new ArrayList<>();
    private List<CompetentaField>listCompetente=new ArrayList<>();
//    public SpecializareField(int x) {
//        this.add(specializare);
//        this.add(gradMedicComboBox);
//        specializare.setPreferredSize(new Dimension(100,25));
//        specializare.setMaximumSize(new Dimension(10000,25));
//        gradMedicComboBox.setPreferredSize(new Dimension(100,25));
//        gradMedicComboBox.setMaximumSize(new Dimension(10000,25));
//        gradMedicComboBox.setModel(comboBoxModel_grad_medic);
//        specializare.setPlaceholder("Specializare "+x);
//        for(int i=0;i<5;i++){
//            competenta[i]=new TextFieldWithPlaceHolder();
//            competenta[i].setPlaceholder("competenta "+i);
//            competenta[i].setPreferredSize(new Dimension(100,25));
//            competenta[i].setMaximumSize(new Dimension(10000,25));
//        }
//        addRemoveCompetenta.add(addCompetentaButton);
//        addRemoveCompetenta.add(removeCompetentaButton);
//        addRemoveCompetenta.setLayout(new BoxLayout(addRemoveCompetenta,BoxLayout.X_AXIS));
//        this.add(addRemoveCompetenta);
//        this.add(competenta[0]);
//        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
//        this.setBorder(BorderFactory.createLineBorder(Color.cyan));
//    }
    public SpecializareField(int nr){
        this.add(specializare);
        this.add(gradMedicComboBox);
        specializare.setPreferredSize(new Dimension(500,25));
        specializare.setMaximumSize(new Dimension(10000,25));
        gradMedicComboBox.setPreferredSize(new Dimension(500,25));
        gradMedicComboBox.setMaximumSize(new Dimension(10000,25));
        gradMedicComboBox.setModel(comboBoxModel_grad_medic);
        specializare.setPlaceholder("Specializare "+nr);
        addRemoveCompetenta.add(addCompetentaButton);
        addRemoveCompetenta.add(removeCompetentaButton);
        addRemoveCompetenta.setLayout(new BoxLayout(addRemoveCompetenta,BoxLayout.X_AXIS));
        this.add(addRemoveCompetenta);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.cyan));

    }
//    public void addCompetenta(){
//        if(nrCompetente<5){
//            this.add(competenta[nrCompetente]);
//            nrCompetente++;
//            //System.out.println(nrCompetente);
//        }
//        this.setVisible(false);
//        this.setVisible(true);
//    }
//    public void removeCompetenta(){
//        if(nrCompetente>0){
//            this.remove(competenta[nrCompetente-1]);
//            competenta[nrCompetente-1].setText("");
//            nrCompetente--;
//        }
//        this.setVisible(false);
//        this.setVisible(true);
//    }
    public void addCompetenta(){
        if(nrCompetente<5){
            //TextFieldWithPlaceHolder competenta=new TextFieldWithPlaceHolder();
            //competenta.setPlaceholder("Competenta "+nrCompetente);
            CompetentaField competenta=new CompetentaField(nrCompetente);
            listCompetente.add(competenta);
            this.add(competenta);
            nrCompetente++;
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    public void removeCompetenta(){
        if(nrCompetente>0){
            nrCompetente--;
            this.remove(listCompetente.get(nrCompetente));
            listCompetente.remove(nrCompetente);
            this.setVisible(false);
            this.setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        SpecializareField specializareField=new SpecializareField(0);
        jFrame.add(specializareField);
        specializareField.addCompetenta();
        specializareField.removeCompetenta();
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addAddCompetentaListener(ActionListener actionListener) {
        addCompetentaButton.addActionListener(actionListener);
    }

    public void addRemoveCompetentaListener(ActionListener actionListener) {
        removeCompetentaButton.addActionListener(actionListener);
    }

    public void setNrCompetente(int nrCompetente) {
        this.nrCompetente = nrCompetente;
    }

    public void reset() {
        removeCompetenta();
        removeCompetenta();
        removeCompetenta();
        removeCompetenta();
        specializare.setText("");
        gradMedicComboBox.setSelectedIndex(0);
    }
    public String getGrad(){
        return gradMedicComboBox.getSelectedItem().toString();
    }
    public String getDenumire(){
        return specializare.getText();
    }
    public Specializare getSpecializare(){
        Specializare specializare;
        if(nrCompetente==1) specializare=new Specializare(getDenumire(),getGrad(),listCompetente.get(0).getText(),listCompetente.get(0).getDurata());
        else if(nrCompetente==2)specializare=new Specializare(getDenumire(),getGrad(),listCompetente.get(0).getText(),listCompetente.get(0).getDurata(),listCompetente.get(1).getText(),listCompetente.get(1).getDurata());
        else if(nrCompetente==3)specializare=new Specializare(getDenumire(),getGrad(),listCompetente.get(0).getText(),listCompetente.get(0).getDurata(),listCompetente.get(1).getText(),listCompetente.get(1).getDurata(),listCompetente.get(2).getText(),listCompetente.get(2).getDurata());
        else if(nrCompetente==4)specializare=new Specializare(getDenumire(),getGrad(),listCompetente.get(0).getText(),listCompetente.get(0).getDurata(),listCompetente.get(1).getText(),listCompetente.get(1).getDurata(),listCompetente.get(2).getText(),listCompetente.get(2).getDurata(),listCompetente.get(3).getText(),listCompetente.get(3).getDurata());
        else specializare=new Specializare(getDenumire(),getGrad(),listCompetente.get(0).getText(),listCompetente.get(0).getDurata(),listCompetente.get(1).getText(),listCompetente.get(1).getDurata(),listCompetente.get(2).getText(),listCompetente.get(2).getDurata(),listCompetente.get(3).getText(),listCompetente.get(3).getDurata(),listCompetente.get(4).getText(),listCompetente.get(4).getDurata());
        if(show_user){
            specializare.setPret(listCompetente);
        }
        return specializare;
    }

    public SpecializareField() {
    }

    public void setSpecializare(Specializare s){
        specializare.setText(s.getDenumire());
        gradMedicComboBox.setSelectedItem(s.getGrad());
        for(int i=0;i<s.getNrCompetente();i++){
            this.addCompetenta();
            listCompetente.get(i).setText(s.getCompetenta(i),s.getDurata(i),s.getPret(i));
            listCompetente.get(i).showPret();
            show_user=true;
        }
    }
    public void setEditable(boolean b){
        specializare.setEditable(b);
        gradMedicComboBox.setEditable(b);
        addRemoveCompetenta.setVisible(false);
        for(int i=0;i<listCompetente.size();i++){
            listCompetente.get(i).setEditable(b);
        }
    }
    public String getNrCompetente() {
        return String.valueOf(nrCompetente);
    }
    public boolean verif(){
        if(specializare.getText().equals(""))return false;
        if(getGrad().equals("grad"))return false;
        if(nrCompetente==0)return false;
        for(int i=0;i<listCompetente.size();i++){
            if(listCompetente.get(i).getText().equals(""))return false;
            if(listCompetente.get(i).getDurata().equals(""))return false;
        }
        return true;
    }

    public void addCompetentePret() {
        for(int i=0;i< listCompetente.size();i++){

        }
    }
}
