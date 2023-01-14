import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProgramarePanel extends JPanel {
    private int contentSize=0;
    private String durata;
    private int contentSizeServicii=0;
    private ActionListener listener;
    private ActionListener listenerServicii;
    private JScrollPane jScrollPane=new JScrollPane();
    private JScrollPane jScrollPaneServicii=new JScrollPane();
    private JPanel content=new JPanel();
    private JPanel contentServicii=new JPanel();
    private JPanel searchFieldsPanel=new JPanel();
    private JPanel searchFieldsPanelServicii=new JPanel();
    private JPanel contentFieldsPanel=new JPanel();
    private JPanel contentFieldsPanelServicii=new JPanel();
    private JPanel northPanel=new JPanel();
    private JPanel northPanelServicii=new JPanel();
    private TextFieldWithPlaceHolder numePacient=new TextFieldWithPlaceHolder();
    private TextFieldWithPlaceHolder prenumePacient=new TextFieldWithPlaceHolder();
    private TextFieldWithPlaceHolder denumireServiciu=new TextFieldWithPlaceHolder();
    private JButton searchButton=new JButton("Cauta");
    private JButton searchButtonServicii=new JButton("Cauta");
    JPanel cautaPacientPanel=new JPanel();
    JPanel cautaServiciuPanel=new JPanel();
    JPanel cautaDataPanel=new JPanel();
    CardLayout cardLayout=new CardLayout();

    JPanel mainCardPanel=new JPanel();

    JButton backButton=new JButton("Inapoi");

    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
    JPanel northPanelData=new JPanel();
    JPanel centerPanelData=new JPanel();
    JButton veziProgramPeDataButton=new JButton("Vezi program");
    JButton confirmaProgramareButton=new JButton("Confirma");
    JButton backToServicii=new JButton("Back");
    JLabel durataServiciu=new JLabel();
    JButton backToPacienti=new JButton("Back");
    SchedulerPanel schedulerPanel=new SchedulerPanel();
    private String id_serviciu;
    private String id_pacient;

    public ProgramarePanel() {
        cautaPacientPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));

        cautaServiciuPanel.setLayout(new BorderLayout());
        northPanelServicii.setLayout(new BoxLayout(northPanelServicii,BoxLayout.Y_AXIS));


        //setup search fields
        numePacient.setPlaceholder("Nume");
        prenumePacient.setPlaceholder("Prenume");
        numePacient.setPreferredSize(new Dimension(100,25));
        numePacient.setMaximumSize(new Dimension(100,25));
        prenumePacient.setPreferredSize(new Dimension(100,25));
        prenumePacient.setMaximumSize(new Dimension(100,25));
        searchFieldsPanel.add(new JLabel("Nume Pacient:"));
        searchFieldsPanel.add(numePacient);
        searchFieldsPanel.add(new JLabel("Prenume Pacient:"));
        searchFieldsPanel.add(prenumePacient);
        searchFieldsPanel.add(searchButton);
        northPanel.add(searchFieldsPanel);

        //setup search fields Servicii
        denumireServiciu.setPlaceholder("Serviciu");
        denumireServiciu.setPreferredSize(new Dimension(100,25));
        denumireServiciu.setMaximumSize(new Dimension(100,25));
        searchFieldsPanelServicii.add(new JLabel("Denumire Serviciu:"));
        searchFieldsPanelServicii.add(denumireServiciu);
        searchFieldsPanelServicii.add(searchButtonServicii);
        northPanelServicii.add(searchFieldsPanelServicii);

        //setup contentFields
        contentFieldsPanel.setLayout(new GridLayout(1,4));
        contentFieldsPanel.add(new JLabel("             ID"));
        contentFieldsPanel.add(new JLabel("Nume"));
        contentFieldsPanel.add(new JLabel("Prenume"));
        contentFieldsPanel.add(new JLabel("Selecteaza"));
        contentFieldsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        northPanel.add(contentFieldsPanel);

        cautaPacientPanel.add(northPanel,BorderLayout.NORTH);

        //setup contentFieldServicii
        contentFieldsPanelServicii.setLayout(new GridLayout(1,4));
        contentFieldsPanelServicii.add(new JLabel("             ID"));
        contentFieldsPanelServicii.add(new JLabel("Denumire"));
        contentFieldsPanelServicii.add(new JLabel("Nume Medic"));
        contentFieldsPanelServicii.add(new JLabel("Selecteaza"));
        contentFieldsPanelServicii.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        northPanelServicii.add(contentFieldsPanelServicii);

        cautaServiciuPanel.add(northPanelServicii,BorderLayout.NORTH);

        //setup scrollPane
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cautaPacientPanel.add(jScrollPane,BorderLayout.CENTER);
        jScrollPane.setViewportView(content);

        //setup scrollPaneServicii
        jScrollPaneServicii.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cautaServiciuPanel.add(jScrollPaneServicii,BorderLayout.CENTER);
        cautaServiciuPanel.add(backToPacienti,BorderLayout.SOUTH);
        jScrollPaneServicii.setViewportView(contentServicii);

        //setup cautaDataPanel
        cautaDataPanel.setLayout(new BorderLayout());
        northPanelData.setLayout(new BoxLayout(northPanelData,BoxLayout.X_AXIS));
        centerPanelData.setLayout(new BoxLayout(centerPanelData,BoxLayout.Y_AXIS));
        northPanelData.add(durataServiciu);
        northPanelData.add(datePicker);
        northPanelData.add(veziProgramPeDataButton);
        centerPanelData.add(schedulerPanel);
        centerPanelData.add(confirmaProgramareButton);
        centerPanelData.add(backToServicii);
        cautaDataPanel.add(northPanelData,BorderLayout.NORTH);
        cautaDataPanel.add(centerPanelData,BorderLayout.CENTER);


        //setup cardPanel
        mainCardPanel.setLayout(cardLayout);
        mainCardPanel.add(cautaPacientPanel,"cautaPanel");
        mainCardPanel.add(cautaServiciuPanel,"cautaServiciuPanel");
        mainCardPanel.add(cautaDataPanel,"cautaDataPanel");
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        contentServicii.setLayout(new BoxLayout(contentServicii,BoxLayout.Y_AXIS));
        this.add(mainCardPanel);
        this.add(backButton);
        backButton.setVisible(false);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.setContentPane(new ProgramarePanel());
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public void resetContent(){
        while(contentSize>0){
            content.remove(contentSize-1);
            contentSize--;
        }
    }
    public void setDurataServiciu(String durata){
        durataServiciu.setText("Timp recomandat serviciu:"+durata);
        this.durata=durata;
    }
    public void resetContentServicii(){
        while(contentSizeServicii>0){
            contentServicii.remove(contentSizeServicii-1);
            contentSizeServicii--;
        }
    }
    public void reset(){
        numePacient.setText("");
        prenumePacient.setText("");
        denumireServiciu.setText("");
        resetSchedulerPanel();
        resetContent();
        resetContentServicii();
        setShowPacienti();
    }


    public void showCautaPacientResult(List<User> lista) {
        resetContent();
        contentSize= lista.size();
        for(int i=0;i<lista.size();i++){
            User user=lista.get(i);
            ProgramarePacientScrollField programarePacientScrollField=new ProgramarePacientScrollField(user.getNume(),user.getPrenume(),user.getId_user());
            content.add(programarePacientScrollField);
        }
        setListeners(listener);
        this.setVisible(false);
        this.setVisible(true);
    }

    public void showCautaServiciutResult(List<Serviciu> lista) {
        resetContentServicii();
        contentSizeServicii= lista.size();
        for(int i=0;i<lista.size();i++){
            Serviciu serviciu=lista.get(i);
            ProgramareServiciuScrollField programareServiciuScrollField=new ProgramareServiciuScrollField(serviciu.getIdSpecializare(),serviciu.getDenumire(),serviciu.getNumeMedic(),serviciu.getDurata());
            contentServicii.add(programareServiciuScrollField);
        }
        setListenersServicii(listenerServicii);
        this.setVisible(false);
        this.setVisible(true);
    }

    private void setListenersServicii(ActionListener listenerServicii) {
        for(int i=0;i<contentSizeServicii;i++){
            ProgramareServiciuScrollField component=(ProgramareServiciuScrollField) contentServicii.getComponent(i);
            component.addSelectServiciuListener(listenerServicii);
        }
    }

    public void setListeners(ActionListener actionListener) {
        for(int i=0;i<contentSize;i++){
            ProgramarePacientScrollField component=(ProgramarePacientScrollField) content.getComponent(i);
            component.addSelectPacientListener(actionListener);
        }
    }
    public void addSelectPacientListener(ActionListener actionListener){
        listener=actionListener;
    }

    public void addSelectServiciuListener(ActionListener actionListener){
        listenerServicii=actionListener;
    }
    public void addCautaPacientListener(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void addCautaServiciuListener(ActionListener actionListener) {
        searchButtonServicii.addActionListener(actionListener);
    }

    public String getNumePacient() {
        return numePacient.getText();
    }

    public String getPrenumePacient() {
        return prenumePacient.getText();
    }
    public String getDenumireServiciu(){
        return denumireServiciu.getText();
    }
    public void nextCard(){
        cardLayout.next(mainCardPanel);
    }
    public String getDataProgramare(){
        Date date= (Date) datePicker.getModel().getValue();
        if(date==null)return null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public String getDurataRecomandata(){
        return this.durata;
    }
    public void setId_serviciu(String id_specializare) {
        this.id_serviciu = id_specializare;
    }
    public void setId_pacient(String newIdPacient){
        this.id_pacient=newIdPacient;
    }

    public String getId_serviciu() {
        return id_serviciu;
    }
    public String getId_pacient() {
        return id_pacient;
    }
    public void addVeziProgramPeDataListener(ActionListener actionListener){
        veziProgramPeDataButton.addActionListener(actionListener);
    }
    public void resetSchedulerPanel(){
        schedulerPanel.reset();
    }
    public void addBackToServiciiListener(ActionListener actionListener){
        backToServicii.addActionListener(actionListener);
    }

    public void setShowServicii() {
        cardLayout.show(mainCardPanel,"cautaServiciuPanel");
    }
    public SchedulerPanel getSchedulerPanel(){
        return schedulerPanel;
    }
    public void addConfirmProgramareListener(ActionListener actionListener){
        confirmaProgramareButton.addActionListener(actionListener);
    }

    public void setShowPacienti() {
        cardLayout.show(mainCardPanel,"cautaPanel");
    }
    public void addBackToPacientiListener(ActionListener actionListener){
        backToPacienti.addActionListener(actionListener);
    }
}
