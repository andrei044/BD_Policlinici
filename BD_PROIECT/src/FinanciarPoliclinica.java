import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.Kernel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class FinanciarPoliclinica extends JPanel {
    private JPanel medicPanel=new JPanel();
    private JPanel locatiePanel=new JPanel();
    private JPanel specializarePanel=new JPanel();
    private JPanel angajatPanel=new JPanel();
    private JPanel mainNorthPanel=new JPanel();
    private JPanel mainCenterPanel=new JPanel();

    private JPanel medicNorthPanel=new JPanel();
    private JPanel locatieNorthPanel=new JPanel();
    private JPanel specializareNorthPanel=new JPanel();
    private JPanel angajatNorthPanel=new JPanel();

    private JPanel medicCenterPanel=new JPanel();
    private JPanel locatieCenterPanel=new JPanel();
    private JPanel specializareCenterPanel=new JPanel();
    private JPanel angajatCenterPanel=new JPanel();

    private JPanel searchFieldsMedic=new JPanel();

    private JPanel medicButtons=new JPanel();
    private CreateUserField numeMedic=new CreateUserField("NumeMedic");
    private CreateUserField prenumeMedic=new CreateUserField("PrenumeMedic");
    private UtilDateModel model1medic = new UtilDateModel();
    private JDatePanelImpl datePanel1medic = new JDatePanelImpl(model1medic);
    private JDatePickerImpl datePicker1medic = new JDatePickerImpl(datePanel1medic);
    private UtilDateModel model2medic = new UtilDateModel();
    private JDatePanelImpl datePanel2medic = new JDatePanelImpl(model2medic);
    private JDatePickerImpl datePicker2medic = new JDatePickerImpl(datePanel2medic);
    private JButton veziMedicButton=new JButton("Vezi");
    private JScrollPane jScrollPaneMedic=new JScrollPane();
    private JPanel medicScrollPaneContent=new JPanel();
    private UtilDateModel model1locatie = new UtilDateModel();
    private JDatePanelImpl datePanel1locatie = new JDatePanelImpl(model1locatie);
    private JDatePickerImpl datePicker1locatie = new JDatePickerImpl(datePanel1locatie);
    private UtilDateModel model2locatie = new UtilDateModel();
    private JDatePanelImpl datePanel2locatie = new JDatePanelImpl(model2locatie);
    private JDatePickerImpl datePicker2locatie = new JDatePickerImpl(datePanel2locatie);
    private JScrollPane jScrollPaneLocatie=new JScrollPane();
    private JPanel locatieScrollPaneContent=new JPanel();
    private JPanel searchFieldsLocatie=new JPanel();
    private JPanel locatieButtons=new JPanel();
    private JButton veziLocatieButton=new JButton("Vezi");

    private JScrollPane jScrollPaneSpecializare=new JScrollPane();
    private JPanel specializareScrollPaneContent=new JPanel();
    private JPanel searchFieldsSpecializare=new JPanel();
    private JPanel specializareButtons=new JPanel();
    private JButton veziSpecializareButton=new JButton("Vezi");
    private CreateUserField denumireSpecializare=new CreateUserField("Denumire:");
    private UtilDateModel model1specializare = new UtilDateModel();
    private JDatePanelImpl datePanel1specializare = new JDatePanelImpl(model1specializare);
    private JDatePickerImpl datePicker1Specializare = new JDatePickerImpl(datePanel1specializare);
    private UtilDateModel model2specializare = new UtilDateModel();
    private JDatePanelImpl datePanel2specializare = new JDatePanelImpl(model2specializare);
    private JDatePickerImpl datePicker2Specializare = new JDatePickerImpl(datePanel2specializare);
    private JScrollPane jScrollPaneAngajat=new JScrollPane();
    private JPanel angajatScrollPaneContent=new JPanel();
    private JPanel searchFieldsAngajat=new JPanel();
    private JPanel angajatButtons=new JPanel();
    private JButton veziAngajatButton=new JButton("Vezi");
    private CreateUserField numeAngajat=new CreateUserField("Nume");
    private CreateUserField prenumeAngajat=new CreateUserField("Prenume");
    private CreateUserField functieAngajat=new CreateUserField("Functie");
    private UtilDateModel model1Angajat = new UtilDateModel();
    private JDatePanelImpl datePanel1Angajat = new JDatePanelImpl(model1Angajat);
    private JDatePickerImpl datePicker1Angajat = new JDatePickerImpl(datePanel1Angajat);
    private UtilDateModel model2Angajat = new UtilDateModel();
    private JDatePanelImpl datePanel2Angajat = new JDatePanelImpl(model2Angajat);
    private JDatePickerImpl datePicker2Angajat= new JDatePickerImpl(datePanel2Angajat);

    private UtilDateModel model1 = new UtilDateModel();
    private JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
    private JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
    private UtilDateModel model2 = new UtilDateModel();
    private JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
    private JDatePickerImpl datePicker2= new JDatePickerImpl(datePanel2);
    private JButton veziButton=new JButton("Vezi VCP");

    public FinanciarPoliclinica() {
        this.setLayout(new BorderLayout());

        mainCenterPanel.setLayout(new GridLayout(2,2));
        this.add(mainNorthPanel,BorderLayout.NORTH);
        this.add(mainCenterPanel,BorderLayout.CENTER);

        mainNorthPanel.add(datePicker1);
        mainNorthPanel.add(datePicker2);
        datePicker1.setMaximumSize(new Dimension(150,25));
        datePicker2.setMaximumSize(new Dimension(150,25));
        mainNorthPanel.add(veziButton);

        mainCenterPanel.add(medicPanel);
        mainCenterPanel.add(locatiePanel);
        mainCenterPanel.add(angajatPanel);
        mainCenterPanel.add(specializarePanel);

        jScrollPaneMedic.setViewportView(medicScrollPaneContent);
        medicScrollPaneContent.setLayout(new BoxLayout(medicScrollPaneContent,BoxLayout.Y_AXIS));
        jScrollPaneMedic.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        medicCenterPanel.setLayout(new BorderLayout());
        medicCenterPanel.add(jScrollPaneMedic,BorderLayout.CENTER);
        medicPanel.setLayout(new BorderLayout());
        medicPanel.add(medicNorthPanel,BorderLayout.NORTH);
        medicPanel.add(medicCenterPanel,BorderLayout.CENTER);
        searchFieldsMedic.setLayout(new GridLayout(1,8));
        searchFieldsMedic.add(new JLabel("ID"));
        searchFieldsMedic.add(new JLabel("NUME"));
        searchFieldsMedic.add(new JLabel("PRENUME"));
        searchFieldsMedic.add(new JLabel("SERVICIU"));
        searchFieldsMedic.add(new JLabel("VENIT"));
        searchFieldsMedic.add(new JLabel("SALARIU_BRUT"));
        searchFieldsMedic.add(new JLabel("SALARIU_NET"));
        searchFieldsMedic.add(new JLabel("PROFIT POLI"));
        medicButtons.add(numeMedic);
        medicButtons.add(prenumeMedic);
        medicButtons.add(datePicker1medic);
        medicButtons.add(datePicker2medic);
        medicButtons.add(veziMedicButton);
        medicButtons.setLayout(new BoxLayout(medicButtons,BoxLayout.X_AXIS));
        medicNorthPanel.setLayout(new BoxLayout(medicNorthPanel,BoxLayout.Y_AXIS));
        medicNorthPanel.add(medicButtons);
        medicNorthPanel.add(searchFieldsMedic);



        jScrollPaneLocatie.setViewportView(locatieScrollPaneContent);
        locatieScrollPaneContent.setLayout(new BoxLayout(locatieScrollPaneContent,BoxLayout.Y_AXIS));
        jScrollPaneLocatie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        locatieCenterPanel.setLayout(new BorderLayout());
        locatieCenterPanel.add(jScrollPaneLocatie,BorderLayout.CENTER);
        locatiePanel.setLayout(new BorderLayout());
        locatiePanel.add(locatieNorthPanel,BorderLayout.NORTH);
        locatiePanel.add(locatieCenterPanel,BorderLayout.CENTER);
        searchFieldsLocatie.setLayout(new GridLayout(1,4));
        searchFieldsLocatie.add(new JLabel("ID"));
        searchFieldsLocatie.add(new JLabel("VENIT"));
        searchFieldsLocatie.add(new JLabel("CHELTUIELI"));
        searchFieldsLocatie.add(new JLabel("PROFIT"));
        locatieButtons.add(veziLocatieButton);
        locatieButtons.add(datePicker1locatie);
        locatieButtons.add(datePicker2locatie);
        locatieNorthPanel.setLayout(new BoxLayout(locatieNorthPanel,BoxLayout.Y_AXIS));
        locatieNorthPanel.add(locatieButtons);
        locatieNorthPanel.add(searchFieldsLocatie);


        jScrollPaneSpecializare.setViewportView(specializareScrollPaneContent);
        specializareScrollPaneContent.setLayout(new BoxLayout(specializareScrollPaneContent,BoxLayout.Y_AXIS));
        jScrollPaneSpecializare.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        specializareCenterPanel.setLayout(new BorderLayout());
        specializareCenterPanel.add(jScrollPaneSpecializare,BorderLayout.CENTER);
        specializarePanel.setLayout(new BorderLayout());
        specializarePanel.add(specializareNorthPanel,BorderLayout.NORTH);
        specializarePanel.add(specializareCenterPanel,BorderLayout.CENTER);
        searchFieldsSpecializare.setLayout(new GridLayout(1,4));
        searchFieldsSpecializare.add(new JLabel("SPECIALIZARE"));
        searchFieldsSpecializare.add(new JLabel("VENIT"));
        searchFieldsSpecializare.add(new JLabel("CHELTUIELI"));
        searchFieldsSpecializare.add(new JLabel("PROFIT"));
        specializareButtons.add(denumireSpecializare);
        specializareButtons.add(datePicker1Specializare);
        specializareButtons.add(datePicker2Specializare);
        specializareButtons.add(veziSpecializareButton);
        specializareNorthPanel.setLayout(new BoxLayout(specializareNorthPanel,BoxLayout.Y_AXIS));
        specializareNorthPanel.add(specializareButtons);
        specializareNorthPanel.add(searchFieldsSpecializare);

        jScrollPaneAngajat.setViewportView(angajatScrollPaneContent);
        angajatScrollPaneContent.setLayout(new BoxLayout(angajatScrollPaneContent,BoxLayout.Y_AXIS));
        jScrollPaneAngajat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        angajatCenterPanel.setLayout(new BorderLayout());
        angajatCenterPanel.add(jScrollPaneAngajat,BorderLayout.CENTER);
        angajatPanel.setLayout(new BorderLayout());
        angajatPanel.add(angajatNorthPanel,BorderLayout.NORTH);
        angajatPanel.add(angajatCenterPanel,BorderLayout.CENTER);
        searchFieldsAngajat.setLayout(new GridLayout(1,6));
        searchFieldsAngajat.add(new JLabel("ID"));
        searchFieldsAngajat.add(new JLabel("NUME"));
        searchFieldsAngajat.add(new JLabel("PRENUME"));
        searchFieldsAngajat.add(new JLabel("FUNCTIE"));
        searchFieldsAngajat.add(new JLabel("BRUT"));
        searchFieldsAngajat.add(new JLabel("NET"));
        angajatButtons.add(numeAngajat);
        angajatButtons.add(prenumeAngajat);
        angajatButtons.add(functieAngajat);
        angajatButtons.add(datePicker1Angajat);
        angajatButtons.add(datePicker2Angajat);
        angajatButtons.add(veziAngajatButton);
        angajatButtons.setLayout(new BoxLayout(angajatButtons,BoxLayout.X_AXIS));
        angajatNorthPanel.setLayout(new BoxLayout(angajatNorthPanel,BoxLayout.Y_AXIS));
        angajatNorthPanel.add(angajatButtons);
        angajatNorthPanel.add(searchFieldsAngajat);

        medicPanel.setBorder(new TitledBorder( new EtchedBorder(), "Profit Medici"));
        angajatPanel.setBorder(new TitledBorder( new EtchedBorder(), "Salarii Angajati"));
        locatiePanel.setBorder(new TitledBorder( new EtchedBorder(), "Profit Unitati"));
        specializarePanel.setBorder(new TitledBorder( new EtchedBorder(), "Profit Specializari"));

    }
    public void addVeziMedicListener(ActionListener actionListener){
        veziMedicButton.addActionListener(actionListener);
    }
    public void addVeziAngajatListener(ActionListener actionListener){
        veziAngajatButton.addActionListener(actionListener);
    }
    public void addVeziUnitateListener(ActionListener actionListener){
        veziLocatieButton.addActionListener(actionListener);
    }
    public void addVeziSpecializareListener(ActionListener actionListener){
        veziSpecializareButton.addActionListener(actionListener);
    }
    public void addVeziTotalListener(ActionListener actionListener){
        veziButton.addActionListener(actionListener);
    }
    public String getDatePicker1Medic(){
        Date date= (Date) datePicker1medic.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDatePicker2Medic(){
        Date date= (Date) datePicker2medic.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDatePicker1Angajat(){
        Date date= (Date) datePicker1Angajat.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDatePicker2Angajat(){
        Date date= (Date) datePicker2Angajat.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDatePicker1Locatie(){
        Date date= (Date) datePicker1locatie.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDatePicker2Locatie(){
        Date date= (Date) datePicker2locatie.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDatePicker1Specializare(){
        Date date= (Date) datePicker1Specializare.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDatePicker2Specializare(){
        Date date= (Date) datePicker2Specializare.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public void resetContentAngajat(){
        while(angajatScrollPaneContent.getComponentCount()>0){
            angajatScrollPaneContent.remove(0);
        }
    }
    public void showResultAngajat(List<FinanciarField> lista) {
        resetContentAngajat();
        for(int i=0;i<lista.size();i++){
            angajatScrollPaneContent.add(lista.get(i));
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void resetContentMedic(){
        while(medicScrollPaneContent.getComponentCount()>0){
            medicScrollPaneContent.remove(0);
        }
    }
    public void showResultMedic(List<FinanciarField> lista) {
        resetContentMedic();
        for(int i=0;i<lista.size();i++){
            medicScrollPaneContent.add(lista.get(i));
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void resetContentLocatie(){
        while(locatieScrollPaneContent.getComponentCount()>0){
            locatieScrollPaneContent.remove(0);
        }
    }
    public void showResultLocatie(List<FinanciarField> lista) {
        resetContentLocatie();
        for(int i=0;i<lista.size();i++){
            locatieScrollPaneContent.add(lista.get(i));
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void resetContentSpecializare(){
        while(specializareScrollPaneContent.getComponentCount()>0){
            specializareScrollPaneContent.remove(0);
        }
    }
    public void showResultSpecializare(List<FinanciarField> lista) {
        resetContentSpecializare();
        for(int i=0;i<lista.size();i++){
            specializareScrollPaneContent.add(lista.get(i));
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public boolean verif(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date1=(Date)datePicker1.getModel().getValue();
        Date date2=(Date)datePicker2.getModel().getValue();
        if(date1==null || date2==null)return false;
        String strDate1 = dateFormat.format(date1);
        String strDate2 = dateFormat.format(date2);

        LocalDate myDate1=LocalDate.parse(strDate1,formatter);
        LocalDate myDate2=LocalDate.parse(strDate2,formatter);

        if(myDate2.isBefore(myDate1))return false;
        return true;
    }
    public boolean verifAngajat(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date1=(Date)datePicker1Angajat.getModel().getValue();
        Date date2=(Date)datePicker2Angajat.getModel().getValue();
        if(date1==null || date2==null)return false;
        String strDate1 = dateFormat.format(date1);
        String strDate2 = dateFormat.format(date2);

        LocalDate myDate1=LocalDate.parse(strDate1,formatter);
        LocalDate myDate2=LocalDate.parse(strDate2,formatter);

        if(myDate2.isBefore(myDate1))return false;
        return true;
    }
    public boolean verifMedic(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date1=(Date)datePicker1medic.getModel().getValue();
        Date date2=(Date)datePicker2medic.getModel().getValue();
        if(date1==null || date2==null)return false;
        String strDate1 = dateFormat.format(date1);
        String strDate2 = dateFormat.format(date2);

        LocalDate myDate1=LocalDate.parse(strDate1,formatter);
        LocalDate myDate2=LocalDate.parse(strDate2,formatter);

        if(myDate2.isBefore(myDate1))return false;
        return true;
    }
    public boolean verifLocatie(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date1=(Date)datePicker1locatie.getModel().getValue();
        Date date2=(Date)datePicker2locatie.getModel().getValue();
        if(date1==null || date2==null)return false;
        String strDate1 = dateFormat.format(date1);
        String strDate2 = dateFormat.format(date2);

        LocalDate myDate1=LocalDate.parse(strDate1,formatter);
        LocalDate myDate2=LocalDate.parse(strDate2,formatter);

        if(myDate2.isBefore(myDate1))return false;
        return true;
    }
    public boolean verifSpecializare(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date1=(Date)datePicker1Specializare.getModel().getValue();
        Date date2=(Date)datePicker2Specializare.getModel().getValue();
        if(date1==null || date2==null)return false;
        String strDate1 = dateFormat.format(date1);
        String strDate2 = dateFormat.format(date2);

        LocalDate myDate1=LocalDate.parse(strDate1,formatter);
        LocalDate myDate2=LocalDate.parse(strDate2,formatter);

        if(myDate2.isBefore(myDate1))return false;
        return true;
    }

    public String getNumeAngajat() {
        return numeAngajat.getText();
    }

    public String getPrenumeAngajat() {
        return prenumeAngajat.getText();
    }

    public String getFunctieAngajat() {
        return functieAngajat.getText();
    }

    public String getNumeMedic() {
        return numeMedic.getText();
    }

    public String getPrenumeMedic() {
        return prenumeMedic.getText();
    }

    public String getDenumireSpecializare() {
        return denumireSpecializare.getText();
    }
    public void reset(){
        numeMedic.setText("");
        prenumeMedic.setText("");
        numeAngajat.setText("");
        prenumeMedic.setText("");
        denumireSpecializare.setText("");
        functieAngajat.setText("");
        resetContentAngajat();
        resetContentLocatie();
        resetContentMedic();
        resetContentSpecializare();
    }
    public String getDatePicker1(){
        Date date= (Date) datePicker1.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDatePicker2(){
        Date date= (Date) datePicker2.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
