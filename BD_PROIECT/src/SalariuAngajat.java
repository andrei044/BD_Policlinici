import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class SalariuAngajat extends JPanel {
    private UtilDateModel model1 = new UtilDateModel();
    private JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
    private JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
    private UtilDateModel model2 = new UtilDateModel();
    private JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
    private JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);

    private JPanel searchFieldsAngajat=new JPanel();
    private JPanel searchFieldsMedic=new JPanel();

    private JPanel northPanel=new JPanel();
    private JPanel centerPanel=new JPanel();

    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();

    private JPanel buttonsPanel=new JPanel();
    private JButton veziButton=new JButton("Vezi");
    public SalariuAngajat() {
        searchFieldsAngajat.setLayout(new GridLayout(1,6));
        searchFieldsAngajat.add(new JLabel("ID"));
        searchFieldsAngajat.add(new JLabel("NUME"));
        searchFieldsAngajat.add(new JLabel("PRENUME"));
        searchFieldsAngajat.add(new JLabel("FUNCTIE"));
        searchFieldsAngajat.add(new JLabel("BRUT"));
        searchFieldsAngajat.add(new JLabel("NET"));
        searchFieldsMedic.setLayout(new GridLayout(1,8));
        searchFieldsMedic.add(new JLabel("ID"));
        searchFieldsMedic.add(new JLabel("NUME"));
        searchFieldsMedic.add(new JLabel("PRENUME"));
        searchFieldsMedic.add(new JLabel("SERVICIU"));
        searchFieldsMedic.add(new JLabel("VENIT"));
        searchFieldsMedic.add(new JLabel("BRUT"));
        searchFieldsMedic.add(new JLabel("NET"));
        searchFieldsMedic.add(new JLabel("DATA"));
        datePicker1.setMaximumSize(new Dimension(150,25));
        datePicker2.setMaximumSize(new Dimension(150,25));datePicker1.setPreferredSize(new Dimension(150,25));
        datePicker2.setPreferredSize(new Dimension(150,25));
        //buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.X_AXIS));
        buttonsPanel.add(datePicker1);
        buttonsPanel.add(datePicker2);
        buttonsPanel.add(veziButton);


        jScrollPane.setViewportView(scrollPaneContent);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));
        northPanel.add(buttonsPanel);
        //northPanel.add(searchFieldsAngajat);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jScrollPane,BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(northPanel,BorderLayout.NORTH);
        this.add(centerPanel,BorderLayout.CENTER);

    }
    public void resetContent(){
        while(scrollPaneContent.getComponentCount()>0){
            scrollPaneContent.remove(0);
        }
    }
    public void showResult(List<SalariuAngajatField> lista) {
        resetContent();
        for(int i=0;i<lista.size();i++){
            scrollPaneContent.add(lista.get(i));
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
    public void addVeziSalariuListener(ActionListener actionListener){
        veziButton.addActionListener(actionListener);
    }
    public String getDatePicker1() {
        Date date= (Date) datePicker1.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public String getDatePicker2() {
        Date date= (Date) datePicker2.getModel().getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public void showForMedic(){
        northPanel.remove(searchFieldsAngajat);
        northPanel.add(searchFieldsMedic);
        this.setVisible(false);
        this.setVisible(true);
    }
    public void showForAngajat(){
        northPanel.remove(searchFieldsMedic);
        northPanel.add(searchFieldsAngajat);

        this.setVisible(false);
        this.setVisible(true);
    }
}
