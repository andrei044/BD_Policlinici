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

public class ConcediuPanel extends JPanel {
    private UtilDateModel model1 = new UtilDateModel();
    private  ActionListener listener;
    private JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
    private JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
    private UtilDateModel model2 = new UtilDateModel();
    private JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
    private JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
    private JPanel datePickersPanel=new JPanel();
    private JPanel northPanel=new JPanel();

    private JPanel searchFieldsPanel=new JPanel();

    private JPanel centerPanel=new JPanel();
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();
    private JButton adaugaButton=new JButton("Adauga");
    private JButton refreshButton=new JButton("Refresh");
    private int contentSize=0;

    public ConcediuPanel() {
        this.setLayout(new BorderLayout());
        datePickersPanel.setLayout(new BoxLayout(datePickersPanel,BoxLayout.X_AXIS));
        datePickersPanel.add(datePicker1);
        datePickersPanel.add(datePicker2);
        datePickersPanel.add(adaugaButton);
        datePickersPanel.add(refreshButton);

        searchFieldsPanel.setLayout(new GridLayout(1,3));
        searchFieldsPanel.add(new JLabel("ID Angajat"));
        searchFieldsPanel.add(new JLabel("Data"));
        searchFieldsPanel.add(new JLabel("Sterge"));
        searchFieldsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        datePicker1.setMaximumSize(new Dimension(150,25));
        datePicker2.setMaximumSize(new Dimension(150,25));

        northPanel.add(datePickersPanel);
        northPanel.add(searchFieldsPanel);

        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));

        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        jScrollPane.setViewportView(scrollPaneContent);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jScrollPane,BorderLayout.CENTER);

        this.add(northPanel,BorderLayout.NORTH);
        this.add(centerPanel,BorderLayout.CENTER);

    }
    public void addStergeConcediuListener(ActionListener actionListener){
        listener=actionListener;
    }
    public void addAdaugaConcediuListener(ActionListener actionListener){
        adaugaButton.addActionListener(actionListener);
    }
    public void addRefreshListener(ActionListener actionListener){
        refreshButton.addActionListener(actionListener);
    }
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.setContentPane(new ConcediuPanel());
        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void resetContent(){
        while(contentSize>0){
            scrollPaneContent.remove(contentSize-1);
            contentSize--;
        }

    }
    public void showConcediu(List<ConcediuField> lista) {
        resetContent();
        contentSize=lista.size();
        for(int i=0;i<lista.size();i++){
            ConcediuField x=lista.get(i);
            x.addStergeConcediuListener(listener);
            scrollPaneContent.add(x);
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void setDatePickerVisible(boolean b){
        datePicker1.setVisible(b);
        datePicker2.setVisible(b);
        adaugaButton.setVisible(b);
    }

    public boolean verif() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date1=(Date)datePicker1.getModel().getValue();
        Date date2=(Date)datePicker2.getModel().getValue();
        String strDate1 = dateFormat.format(date1);
        String strDate2 = dateFormat.format(date2);

        LocalDate myDate1=LocalDate.parse(strDate1,formatter);
        LocalDate myDate2=LocalDate.parse(strDate2,formatter);
        LocalDate now=LocalDate.now();
        if(myDate1.isBefore(now) || myDate2.isBefore(now))return false;
        if(myDate2.isBefore(myDate1))return false;
        return true;
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
}
