import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class CreeazaRaportPanel extends JPanel {
    ActionListener listener;
    private CardLayout cardLayout=new CardLayout();
    private JPanel cautaPacient=new JPanel();
    private JPanel completeazaAnalize=new JPanel();
    private JPanel completeazaRaport=new JPanel();
    //CreateUserField numePacient=new CreateUserField("Nume:");
    //CreateUserField prenumePacient=new CreateUserField("Prenume:");
    private JButton cautaButton=new JButton("Refresh");
    private JButton veziAziButton=new JButton("Vezi Azi");
    private JPanel cautaNorthPanel=new JPanel();
    private JPanel cautaCenterPanel=new JPanel();

    private JScrollPane jScrollPanePacienti=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();
    private JPanel scrollFieldsPanel=new JPanel();
    private int contentSize=0;

    private CreateUserField wbc=new CreateUserField("WBC");
    private CreateUserField lymph=new CreateUserField("LYMPH");
    private CreateUserField neut=new CreateUserField("NEUT");
    private CreateUserField mono=new CreateUserField("MONO");
    private CreateUserField hct=new CreateUserField("HCT");
    private JButton valideazaButton=new JButton("Valideaza");

    private TextAreaScrollable istoricRaport=new TextAreaScrollable("Istoric Raport:");
    private TextAreaScrollable simptome=new TextAreaScrollable("Simptome:");
    private TextAreaScrollable diagnostic=new TextAreaScrollable("Diagnostic:");
    private TextAreaScrollable recomandari=new TextAreaScrollable("Recomandari:");
    private JButton parafeaza=new JButton("Parafeaza");
    private JButton backParafeaza=new JButton("Inapoi");
    private JButton backAnalize=new JButton("Inapoi");
    private String idProgramare;

    public CreeazaRaportPanel() {
        this.setLayout(cardLayout);
        this.add(cautaPacient,"cautaPacient");
        this.add(completeazaAnalize,"completeazaAnalize");
        this.add(completeazaRaport,"completeazaRaport");
        cautaPacient.setLayout(new BorderLayout());
        cautaPacient.add(cautaNorthPanel,BorderLayout.NORTH);
        cautaPacient.add(cautaCenterPanel,BorderLayout.CENTER);
        cautaNorthPanel.setLayout(new BoxLayout(cautaNorthPanel,BoxLayout.Y_AXIS));
        cautaNorthPanel.add(cautaButton);
        cautaNorthPanel.add(veziAziButton);
        cautaNorthPanel.add(scrollFieldsPanel);
        scrollFieldsPanel.add(new Label("Data programare"));
        scrollFieldsPanel.add(new Label("Nume Pacient"));
        scrollFieldsPanel.add(new Label("Nume Doctor"));
        scrollFieldsPanel.add(new Label("Nume Competenta"));
        scrollFieldsPanel.add(new Label("Ora inceput"));
        scrollFieldsPanel.add(new Label("Ora final"));
        scrollFieldsPanel.add(new Label("Selecteaza"));
        cautaCenterPanel.setLayout(new BorderLayout());
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        jScrollPanePacienti.setViewportView(scrollPaneContent);

        jScrollPanePacienti.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cautaCenterPanel.add(jScrollPanePacienti,BorderLayout.CENTER);
        scrollFieldsPanel.setLayout(new GridLayout(1,7));


        completeazaAnalize.setLayout(new BoxLayout(completeazaAnalize,BoxLayout.Y_AXIS));
        completeazaAnalize.add(wbc);
        completeazaAnalize.add(lymph);
        completeazaAnalize.add(neut);
        completeazaAnalize.add(mono);
        completeazaAnalize.add(hct);
        completeazaAnalize.add(valideazaButton);
        completeazaAnalize.add(backAnalize);

        completeazaRaport.add(istoricRaport);
        completeazaRaport.add(simptome);
        completeazaRaport.add(diagnostic);
        completeazaRaport.add(recomandari);
        completeazaRaport.add(parafeaza);
        completeazaRaport.add(backParafeaza);
        completeazaRaport.setLayout(new BoxLayout(completeazaRaport,BoxLayout.Y_AXIS));
    }

    public void setShowRaport(){
        cardLayout.show(this,"completeazaRaport");
    }
    public void setShowAnalize(){
        cardLayout.show(this,"completeazaAnalize");
    }
    public void setShowPacient(){
        cardLayout.show(this,"cautaPacient");
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.setContentPane(new CreeazaRaportPanel());
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void resetContent(){
        while(contentSize>0){
            scrollPaneContent.remove(contentSize-1);
            contentSize--;
        }
    }

    public void setListeners(ActionListener actionListener){
        for(int i=0;i<contentSize;i++){
            CreeazaRaportScrollField component=(CreeazaRaportScrollField) scrollPaneContent.getComponent(i);
            component.addSelectProgramareListener(actionListener);
        }
    }

    public void addSelectProgramareListener(ActionListener actionListener){
        listener=actionListener;
    }
    public void addCautaProgramareListener(ActionListener actionListener){
        cautaButton.addActionListener(actionListener);
    }

    public void showCautaPacientResult(List<CreeazaRaportField> lista) {
        resetContent();
        contentSize= lista.size();
        for(int i=0;i<lista.size();i++){
            CreeazaRaportField x=lista.get(i);
            scrollPaneContent.add(new CreeazaRaportScrollField(x.getIdProgramare(),x.getData_programare(),x.getPacient(),x.getMedic(),x.getCompetenta(),x.getProgramare_start(),x.getProgramare_stop(),
                    x.getId_raport(),x.getId_analize()));
        }
        setListeners(listener);
        this.setVisible(false);
        this.setVisible(true);
    }
    public boolean verifParafeaza(){
        if(istoricRaport.getText().length()>300)return false;
        if(simptome.getText().length()>300)return false;
        if(diagnostic.getText().length()>300)return false;
        if(recomandari.getText().length()>300)return false;
        return true;
    }
    public Raport getRaport(){
        return new Raport(istoricRaport.getText(),simptome.getText(),diagnostic.getText(),recomandari.getText());
    }
    public void setIdProgramare(String idProgramare){
        this.idProgramare=idProgramare;
    }

    public String getIdProgramare() {
        return idProgramare;
    }
    public void addParafeazaListener(ActionListener actionListener){
        parafeaza.addActionListener(actionListener);
    }

    public void addBackParafeazaListener(ActionListener actionListener){
        backParafeaza.addActionListener(actionListener);
        backAnalize.addActionListener(actionListener);
    }
    public void resetParafeaza(){
        istoricRaport.reset();
        simptome.reset();
        diagnostic.reset();
        recomandari.reset();
    }

    public void setRaportEditable(boolean b) {
        istoricRaport.setEditable(b);
        simptome.setEditable(b);
        diagnostic.setEditable(b);
        recomandari.setEditable(b);
        if(b)parafeaza.setVisible(true);
        else parafeaza.setVisible(false);
    }

    public void showRaport(Raport raportDetails) {
        istoricRaport.setText(raportDetails.getIstoricRaport());
        simptome.setText(raportDetails.getSimptome());
        diagnostic.setText(raportDetails.getDiagnostic());
        recomandari.setText(raportDetails.getRecomandari());
    }
    public void reset(){
        resetContent();
        resetParafeaza();
        setShowPacient();
        resetAnalize();
    }
    public void resetAnalize(){
        wbc.reset();
        lymph.reset();
        neut.reset();
        mono.reset();
        hct.reset();
    }
    public void setAnalizeEditable(boolean b){
        wbc.setEditable(b);
        lymph.setEditable(b);
        neut.setEditable(b);
        mono.setEditable(b);
        hct.setEditable(b);
        valideazaButton.setVisible(b);
    }

    public void showAnalize(Analize analizeDetails) {
        wbc.setText(analizeDetails.getWbc());
        lymph.setText(analizeDetails.getLymph());
        neut.setText(analizeDetails.getNeut());
        mono.setText(analizeDetails.getMono());
        hct.setText(analizeDetails.getHct());
    }
    public boolean verifAnalize(){
        if(wbc.getText().matches(".*[a-z].*") || wbc.getText().matches(".*[A-Z].*"))return false;
        if(lymph.getText().matches(".*[a-z].*") || lymph.getText().matches(".*[A-Z].*"))return false;
        if(neut.getText().matches(".*[a-z].*") || neut.getText().matches(".*[A-Z].*"))return false;
        if(mono.getText().matches(".*[a-z].*") || mono.getText().matches(".*[A-Z].*"))return false;
        if(hct.getText().matches(".*[a-z].*") || hct.getText().matches(".*[A-Z].*"))return false;
        return true;
    }

    public Analize getAnalize() {
        return new Analize(wbc.getText(),lymph.getText(),neut.getText(),mono.getText(),hct.getText());
    }
    public void addValideazaListener(ActionListener actionListener){
        valideazaButton.addActionListener(actionListener);
    }
    public void addVeziAziListener(ActionListener actionListener){
        veziAziButton.addActionListener(actionListener);
    }
}
