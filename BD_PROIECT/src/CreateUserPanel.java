import com.raven.swing.TimePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateUserPanel extends JPanel {

    TextFieldWithPlaceHolder usernameTextField=new TextFieldWithPlaceHolder("");
    PasswordFieldWithPlaceHolder passwordTextField=new PasswordFieldWithPlaceHolder("");
    TextFieldWithPlaceHolder numeTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder prenumeTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder adresaTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder CNPTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder telTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder emailTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder IBANTextField=new TextFieldWithPlaceHolder();

    //TextFieldWithPlaceHolder salariu_brutTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder parafa_medicTextField=new TextFieldWithPlaceHolder();
    String[] receptionerComboBoxString={"Pacient"};
    String[] adminComboBoxString={"Pacient","Medic","Asistent","Resurse Umane","Financiar","Receptioner"};
    String[] superadminComboBoxString={"Pacient","Medic","Asistent","Resurse Umane","Financiar","Receptioner","Admin"};
    String[] tipAsistentComboBoxString={"","generalist","laborator","radiologie"};
    String[] gradAsistentComboBoxString={"","secundar","principal"};
    String[] titluMedicComboBoxString={"","doctorand","doctor"};
    String[] postMedicComboBoxString={"","preparator","asistent","lector","conferentiar","profesor"};
    DefaultComboBoxModel<String> comboBoxModel_receptioner = new DefaultComboBoxModel<>( receptionerComboBoxString );
    DefaultComboBoxModel<String> comboBoxModel_admin = new DefaultComboBoxModel<>( adminComboBoxString );
    DefaultComboBoxModel<String> comboBoxModel_superadmin = new DefaultComboBoxModel<>( superadminComboBoxString );
    DefaultComboBoxModel<String> comboBoxModel_tip_asistent = new DefaultComboBoxModel<>( tipAsistentComboBoxString );
    DefaultComboBoxModel<String> comboBoxModel_grad_asistent = new DefaultComboBoxModel<>( gradAsistentComboBoxString );
    DefaultComboBoxModel<String> comboBoxModel_titlu_medic = new DefaultComboBoxModel<>( titluMedicComboBoxString );
    DefaultComboBoxModel<String> comboBoxModel_post_medic = new DefaultComboBoxModel<>( postMedicComboBoxString );
    JComboBox tipUserComboBox=new JComboBox();
    JComboBox tipAsistentComboBox=new JComboBox();
    JComboBox gradAsistentComboBox=new JComboBox();
    JComboBox titluMedicComboBox=new JComboBox();
    JComboBox postMedicComboBox=new JComboBox();
    JButton addSpecializareButton=new JButton("Adauga specializare");
    JButton removeSpecializareButton=new JButton("Sterge specializare");

    CreateUserField usernameField=new CreateUserField("Username");
    CreateUserFieldPassword passwordField=new CreateUserFieldPassword("Password");
    CreateUserField numeField=new CreateUserField("Nume");
    CreateUserField prenumeField=new CreateUserField("Prenume");
    CreateUserField adresaField=new CreateUserField("Adresa");
    CreateUserField CNPField=new CreateUserField("CNP");
    CreateUserField telField=new CreateUserField("Tel");
    CreateUserField emailField=new CreateUserField("Email");
    CreateUserField IBANField=new CreateUserField("IBAN");
    CreateUserField parafaField=new CreateUserField("Parafa");
    CreateUserField salariuBrutField=new CreateUserField("Salariu Brut");

    JButton nextButton=new JButton("Urmatorul");
    JPanel titluMedicPanel=new JPanel();
    JPanel postMedicPanel=new JPanel();
    JPanel tipAsistentPanel=new JPanel();
    JPanel gradAsistentPanel=new JPanel();
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
    JPanel dataAngajarePanel=new JPanel();
    JPanel addRemoveSpecializare=new JPanel();

    String instanceUser="";
    JPanel specializariPanel=new JPanel();
    List<SpecializareField>specializareFieldList=new ArrayList<>();
    private int nr_specializari=0;
    ActionListener addCompetentaListener;
    ActionListener removeCompetentaListener;

    public CreateUserPanel(String tip) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(usernameField);
        this.add(passwordField);
        this.add(numeField);
        this.add(prenumeField);
        this.add(CNPField);
        this.add(adresaField);
        this.add(emailField);
        this.add(telField);

        dataAngajarePanel.setLayout(new BoxLayout(dataAngajarePanel,BoxLayout.X_AXIS));
        dataAngajarePanel.add(new JLabel("Data Angajare:"));
        dataAngajarePanel.add(datePicker);

        this.add(dataAngajarePanel);
        this.add(IBANField);
        this.add(tipUserComboBox);
        if(tip.equals("admin")){
            tipUserComboBox.setModel(comboBoxModel_admin);
        }

        else{
            tipUserComboBox.setModel(comboBoxModel_receptioner);
            this.remove(dataAngajarePanel);
            this.remove(IBANField);
        }


        tipUserComboBox.setPreferredSize(new Dimension(100,25));
        tipUserComboBox.setMaximumSize(new Dimension(10000,25));
        titluMedicPanel.add(new JLabel("Titlu:"));
        titluMedicPanel.add(titluMedicComboBox);
        titluMedicComboBox.setModel(comboBoxModel_titlu_medic);
        titluMedicComboBox.setPreferredSize(new Dimension(100,25));
        titluMedicComboBox.setMaximumSize(new Dimension(10000,25));
        titluMedicPanel.setLayout(new BoxLayout(titluMedicPanel,BoxLayout.X_AXIS));

        postMedicPanel.add(new JLabel("Post:"));
        postMedicPanel.add(postMedicComboBox);
        postMedicComboBox.setModel(comboBoxModel_post_medic);
        postMedicComboBox.setPreferredSize(new Dimension(100,25));
        postMedicComboBox.setMaximumSize(new Dimension(10000,25));
        postMedicPanel.setLayout(new BoxLayout(postMedicPanel,BoxLayout.X_AXIS));

        tipAsistentPanel.add(new JLabel("Tip:"));
        tipAsistentPanel.add(tipAsistentComboBox);
        tipAsistentComboBox.setModel(comboBoxModel_tip_asistent);
        tipAsistentComboBox.setPreferredSize(new Dimension(100,25));
        tipAsistentComboBox.setMaximumSize(new Dimension(10000,25));
        tipAsistentPanel.setLayout(new BoxLayout(tipAsistentPanel,BoxLayout.X_AXIS));

        gradAsistentPanel.add(new JLabel("Grad:"));
        gradAsistentPanel.add(gradAsistentComboBox);
        gradAsistentComboBox.setModel(comboBoxModel_grad_asistent);
        gradAsistentComboBox.setPreferredSize(new Dimension(100,25));
        gradAsistentComboBox.setMaximumSize(new Dimension(10000,25));
        gradAsistentPanel.setLayout(new BoxLayout(gradAsistentPanel,BoxLayout.X_AXIS));
        this.add(nextButton);

        addRemoveSpecializare.add(addSpecializareButton);
        addRemoveSpecializare.add(removeSpecializareButton);
        addRemoveSpecializare.setLayout(new BoxLayout(addRemoveSpecializare,BoxLayout.X_AXIS));
    }

    public void reset(){
        usernameField.reset();
        passwordField.reset();
        numeField.reset();
        prenumeField.reset();
        CNPField.reset();
        adresaField.reset();
        emailField.reset();
        telField.reset();
        IBANField.reset();
        salariuBrutField.reset();
        tipUserComboBox.setSelectedIndex(0);
        while(!specializareFieldList.isEmpty()){
            specializareFieldList.remove(0);
            specializariPanel.remove(0);
        }
        nr_specializari=0;
        titluMedicComboBox.setSelectedIndex(0);
        postMedicComboBox.setSelectedIndex(0);
        parafaField.reset();
        tipAsistentComboBox.setSelectedIndex(0);
        gradAsistentComboBox.setSelectedIndex(0);
        displayForPacient();
        //model.reset
    }

    public void addSpecializare(){
        if(nr_specializari<3){
            SpecializareField specializareField1=new SpecializareField(nr_specializari);
            specializareField1.addAddCompetentaListener(addCompetentaListener);
            specializareField1.addRemoveCompetentaListener(removeCompetentaListener);
            specializareFieldList.add(specializareField1);
            specializariPanel.add(specializareField1);
            nr_specializari++;
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    public void removeSpecializare(){
        if(nr_specializari>0){
            nr_specializari--;
            specializariPanel.remove(specializareFieldList.get(nr_specializari));
            specializareFieldList.remove(nr_specializari);
            this.setVisible(false);
            this.setVisible(true);
        }
    }
    public void addAdaugaCompetentaListener(ActionListener actionListener){
        addCompetentaListener=actionListener;
    }
    public void addRemoveCompetentaListener(ActionListener actionListener){
        removeCompetentaListener=actionListener;
    }

    public void displayForAngajat(){
        this.removeAll();
        this.add(tipUserComboBox);
        this.add(usernameField);
        this.add(passwordField);
        this.add(numeField);
        this.add(prenumeField);
        this.add(CNPField);
        this.add(adresaField);
        this.add(emailField);
        this.add(telField);
        this.add(dataAngajarePanel);
        this.add(IBANField);
        this.add(salariuBrutField);
        this.add(nextButton);
    }
    public void displayForPacient(){
        this.removeAll();
        this.add(tipUserComboBox);
        this.add(numeField);
        this.add(prenumeField);
        this.add(CNPField);
        this.add(adresaField);
        this.add(emailField);
        this.add(telField);
        this.add(nextButton);
        this.setVisible(false);
        this.setVisible(true);
    }
    public void displayForAsistent(){
        this.removeAll();
        this.add(tipUserComboBox);
        this.add(usernameField);
        this.add(passwordField);
        this.add(numeField);
        this.add(prenumeField);
        this.add(CNPField);
        this.add(adresaField);
        this.add(emailField);
        this.add(telField);
        this.add(dataAngajarePanel);
        this.add(IBANField);
        this.add(salariuBrutField);
        this.add(gradAsistentPanel);
        this.add(tipAsistentPanel);
        this.add(nextButton);
        this.setVisible(false);
        this.setVisible(true);
    }
    public void displayForMedic(){
        this.removeAll();
        this.add(tipUserComboBox);
        this.add(usernameField);
        this.add(passwordField);
        this.add(numeField);
        this.add(prenumeField);
        this.add(CNPField);
        this.add(adresaField);
        this.add(emailField);
        this.add(telField);
        this.add(dataAngajarePanel);
        this.add(IBANField);
        this.add(parafaField);
        this.add(titluMedicPanel);
        this.add(postMedicPanel);
        this.add(addRemoveSpecializare);
        this.add(specializariPanel);
        this.add(nextButton);
        this.setVisible(false);
        this.setVisible(true);
    }
    public void loggedAsRecep(){
        instanceUser="Receptioner";
        tipUserComboBox.setModel(comboBoxModel_receptioner);
        displayForPacient();
    }
    public void loggedAsAdmin(){
        instanceUser="Admin";
        tipUserComboBox.setModel(comboBoxModel_admin);
        displayForPacient();
    }
    public void loggedAsSuperAdmin(){
        instanceUser="Admin";
        tipUserComboBox.setModel(comboBoxModel_superadmin);
        displayForPacient();
    }
    public String getUsername() {
        return usernameTextField.getText();
    }

    public String getPassword() {
        return passwordTextField.getText();
    }

    public String getNume() {
        return numeTextField.getText();
    }

    public String getPrenume() {
        return prenumeTextField.getText();
    }

    public String getAdresa() {
        return adresaTextField.getText();
    }

    public String getCNP() {
        return CNPTextField.getText();
    }

    public String getTel() {
        return telTextField.getText();
    }

    public String getEmail() {
        return emailTextField.getText();
    }

    public String getIBAN() {
        return IBANTextField.getText();
    }

    public String getFunctie(){
        return tipUserComboBox.getSelectedItem().toString();
    }

    public String getTitluMedic(){
        return titluMedicComboBox.getSelectedItem().toString();
    }
    public String getPostMedic(){
        return postMedicComboBox.getSelectedItem().toString();
    }
    public String getTipAsistent(){
        return tipAsistentComboBox.getSelectedItem().toString();
    }
    public String getGradAsistent(){
        return gradAsistentComboBox.getSelectedItem().toString();
    }
    public String getDataAngajare(){
        Date date= (Date) datePicker.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(date==null)return null;
        String strDate = dateFormat.format(date);
        System.out.println(strDate);
        return strDate;
    }

    public void addComboBoxCreateUserListener(ActionListener actionListener){
        tipUserComboBox.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.add(new CreateUserPanel("admin"));
        //TimePicker timePicker=new TimePicker();
        //jFrame.add(timePicker);
        //add datepicker
//        JPanel jPanel=new JPanel();
//        UtilDateModel model = new UtilDateModel();
//        JDatePanelImpl datePanel = new JDatePanelImpl(model);
//        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
//        jPanel.add(datePicker);
//        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Medic getMedic(){
        Medic medic;
        if(nr_specializari==1) medic=new Medic(usernameField.getText(),passwordField.getText(),numeField.getText(),prenumeField.getText(),CNPField.getText(),adresaField.getText(),telField.getText(),emailField.getText(),IBANField.getText(),getFunctie(),getDataAngajare(),getTitluMedic(),getPostMedic(),getParafa(),specializareFieldList.get(0).getSpecializare());
        else if(nr_specializari==2)medic=new Medic(usernameField.getText(),passwordField.getText(),numeField.getText(),prenumeField.getText(),CNPField.getText(),adresaField.getText(),telField.getText(),emailField.getText(),IBANField.getText(),getFunctie(),getDataAngajare(),getTitluMedic(),getPostMedic(),getParafa(),specializareFieldList.get(0).getSpecializare(),specializareFieldList.get(1).getSpecializare());
        else medic=new Medic(usernameField.getText(),passwordField.getText(),numeField.getText(),prenumeField.getText(),CNPField.getText(),adresaField.getText(),telField.getText(),emailField.getText(),IBANField.getText(),getFunctie(),getDataAngajare(),getTitluMedic(),getPostMedic(),getParafa(),specializareFieldList.get(0).getSpecializare(),specializareFieldList.get(1).getSpecializare(),specializareFieldList.get(2).getSpecializare());
        return medic;
    }

    private String getParafa() {
        return parafaField.getText();
    }

    public Asistent getAsistent(){
        Asistent asistent=new Asistent(usernameField.getText(),passwordField.getText(),numeField.getText(),prenumeField.getText(),CNPField.getText(),adresaField.getText(),telField.getText(),emailField.getText(),IBANField.getText(),getFunctie(),getDataAngajare(),salariuBrutField.getText(),getGradAsistent(),getTipAsistent());
        return asistent;
    }
    public Angajat getAngajat(){
        Angajat angajat=new Angajat(usernameField.getText(),passwordField.getText(),numeField.getText(),prenumeField.getText(),CNPField.getText(),adresaField.getText(),telField.getText(),emailField.getText(),IBANField.getText(),getFunctie(),getDataAngajare(),salariuBrutField.getText(),10);
        return angajat;
    }

    public void addAddSpecializareCreateUserListener(ActionListener actionListener) {
        addSpecializareButton.addActionListener(actionListener);
    }

    public void addRemoveSpecializareCreateUserListener(ActionListener actionListener) {
        removeSpecializareButton.addActionListener(actionListener);
    }

    public void addNextCreateUserListener(ActionListener actionListener) {
        nextButton.addActionListener(actionListener);
    }

    public User getPacient() {
        User user=new User(numeField.getText(),prenumeField.getText(),CNPField.getText(),adresaField.getText(),telField.getText(),emailField.getText());
        user.setUsername(usernameField.getText());
        user.setPassword(passwordField.getText());
        return user;
    }
    public boolean verif(){
        if(numeField.getText().equals("") || numeField.getText().length()>30)return false;
        if(prenumeField.getText().equals("")||prenumeField.getText().length()>30)return false;
        if(CNPField.getText().equals("")||CNPField.getText().length()!=13|| CNPField.getText().matches(".*[a-z].*"))return false;
        if(adresaField.getText().equals("")||adresaField.getText().length()>70)return false;
        if(emailField.getText().equals("") || emailField.getText().length()>30)return false;
        if(telField.getText().equals("")|| telField.getText().matches(".*[a-z].*") || telField.getText().length()>12)return false;
        if(!getFunctie().equals("Pacient")){
            if(getDataAngajare()==null)return false;
            if(IBANField.getText().equals("") || IBANField.getText().length()!=34)return false;
            if(!getFunctie().equals("Medic") && (salariuBrutField.getText().matches(".*[a-z].*") || salariuBrutField.getText().equals("")))return false;
            if(getFunctie().equals("Medic")){
                if(nr_specializari==0)return false;
                for(int i=0;i<specializareFieldList.size();i++){
                    if(!specializareFieldList.get(i).verif())return false;
                }
                if(parafaField.getText().equals(""))return false;
            }else if(getFunctie().equals("Asistent")){
                if(getGradAsistent().equals(""))return false;
                if(getTipAsistent().equals(""))return false;
            }
        }
        return true;
    }
}
