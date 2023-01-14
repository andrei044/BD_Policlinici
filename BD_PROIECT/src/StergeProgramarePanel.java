import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class StergeProgramarePanel extends JPanel {
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();
    private JPanel northPanel=new JPanel();
    private JPanel centerPanel=new JPanel();
    private JPanel fields=new JPanel();
    private JPanel buttons=new JPanel();
    private UtilDateModel model1 = new UtilDateModel();
    private JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
    private JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
    private UtilDateModel model2 = new UtilDateModel();
    private JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
    private JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
    private JButton veziButton=new JButton("VEZI");
    private ActionListener listener;

    public StergeProgramarePanel() {


        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jScrollPane);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportView(scrollPaneContent);
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        fields.setLayout(new GridLayout(1,7));
        fields.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fields.add(new JLabel("ID"));
        fields.add(new JLabel("DATA"));
        fields.add(new JLabel("START"));
        fields.add(new JLabel("STOP"));
        fields.add(new JLabel("NUME PACIENT"));
        fields.add(new JLabel("SERVICIU"));
        fields.add(new JLabel("STERGE"));
        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));
        northPanel.add(buttons);
        northPanel.add(fields);


        buttons.add(datePicker1);
        buttons.add(datePicker2);
        datePicker1.setMaximumSize(new Dimension(150,25));
        datePicker2.setMaximumSize(new Dimension(150,25));
        datePicker1.setPreferredSize(new Dimension(150,25));
        datePicker2.setPreferredSize(new Dimension(150,25));
        buttons.add(veziButton);
        this.setLayout(new BorderLayout());
        this.add(northPanel,BorderLayout.NORTH);
        this.add(centerPanel,BorderLayout.CENTER);
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
    public void addStergeListener(ActionListener actionListener){
        listener=actionListener;
    }
    public void addVeziListener(ActionListener actionListener){
        veziButton.addActionListener(actionListener);
    }
    public void resetContent(){
        while(scrollPaneContent.getComponentCount()>0){
            scrollPaneContent.remove(0);
        }
    }
    public void showResult(List<ProgramareField> lista) {
        resetContent();
        for(int i=0;i<lista.size();i++){
            scrollPaneContent.add(lista.get(i));
            lista.get(i).addStergeListener(listener);
        }
        this.setVisible(false);
        this.setVisible(true);
    }
}
