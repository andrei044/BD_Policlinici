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
public class ProgramSpecificPanel extends JPanel {
    private SchedulerPanel schedulerPanel=new SchedulerPanel();
    private JPanel northPanelData=new JPanel();
    private JPanel centerPanelData=new JPanel();
    private UtilDateModel model = new UtilDateModel();
    private JDatePanelImpl datePanel = new JDatePanelImpl(model);
    private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
    JButton veziProgramPeDataButton=new JButton("Vezi program");
    JButton confirmaButton=new JButton("Confirma");
    JComboBox unitatiComboBox=new JComboBox();

    public ProgramSpecificPanel() {
        this.setLayout(new BorderLayout());
        northPanelData.setLayout(new BoxLayout(northPanelData,BoxLayout.X_AXIS));
        centerPanelData.setLayout(new BoxLayout(centerPanelData,BoxLayout.Y_AXIS));
        northPanelData.add(datePicker);
        northPanelData.add(veziProgramPeDataButton);
        northPanelData.add(unitatiComboBox);
        centerPanelData.add(schedulerPanel);
        centerPanelData.add(confirmaButton);
        this.add(northPanelData,BorderLayout.NORTH);
        this.add(centerPanelData,BorderLayout.CENTER);
    }
    public SchedulerPanel getSchedulerPanel(){
        return schedulerPanel;
    }
    public void addConfirmProgramareListener(ActionListener actionListener){
        confirmaButton.addActionListener(actionListener);
    }
    public void addVeziProgramPeDataListener(ActionListener actionListener){
        veziProgramPeDataButton.addActionListener(actionListener);
    }
    public String getDataProgramare(){
        Date date= (Date) datePicker.getModel().getValue();
        if(date==null)return null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public void setUnitati(List<String>list){
        DefaultComboBoxModel<String> comboBoxModel_unitati = new DefaultComboBoxModel<>(list.toArray(new String[0]) );
        unitatiComboBox.setModel(comboBoxModel_unitati);
    }

    public String getIdUnitate() {
        return unitatiComboBox.getSelectedItem().toString();
    }
}
