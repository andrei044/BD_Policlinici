import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class CautaAngajatPanel extends JPanel {
    private int contentSize=0;
    private ActionListener veziAngajatListener;
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel content=new JPanel();
    private JPanel informatii_angajat=new JPanel();
    private JPanel searchFieldsPanel=new JPanel();
    private JPanel contentFieldsPanel=new JPanel();
    private JPanel northPanel=new JPanel();
    private TextFieldWithPlaceHolder numeAngajat=new TextFieldWithPlaceHolder();
    private TextFieldWithPlaceHolder prenumeAngajat=new TextFieldWithPlaceHolder();
    private JButton searchButton=new JButton("Cauta");

    VeziAngajatPanel veziAngajatPanel=new VeziAngajatPanel();
    JPanel cautaPanel=new JPanel();
    CardLayout cardLayout=new CardLayout();

    JPanel cardPanel=new JPanel();

    JButton backButton=new JButton("Inapoi");

    public CautaAngajatPanel() {
        cautaPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));

        //setup search fields
        numeAngajat.setPlaceholder("Nume");
        prenumeAngajat.setPlaceholder("Prenume");
        numeAngajat.setPreferredSize(new Dimension(100,25));
        numeAngajat.setMaximumSize(new Dimension(100,25));
        prenumeAngajat.setPreferredSize(new Dimension(100,25));
        prenumeAngajat.setMaximumSize(new Dimension(100,25));
        searchFieldsPanel.add(new JLabel("Nume:"));
        searchFieldsPanel.add(numeAngajat);
        searchFieldsPanel.add(new JLabel("Prenume:"));
        searchFieldsPanel.add(prenumeAngajat);
        searchFieldsPanel.add(searchButton);
        northPanel.add(searchFieldsPanel);

        //setup contentFields
        contentFieldsPanel.setLayout(new GridLayout(1,4));
        contentFieldsPanel.add(new JLabel("             ID"));
        contentFieldsPanel.add(new JLabel("Nume"));
        contentFieldsPanel.add(new JLabel("Prenume"));
        contentFieldsPanel.add(new JLabel("Vezi"));
        contentFieldsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        northPanel.add(contentFieldsPanel);

        cautaPanel.add(northPanel,BorderLayout.NORTH);

        //setup scrollPane
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cautaPanel.add(jScrollPane,BorderLayout.CENTER);
        jScrollPane.setViewportView(content);

        //setup cardPanel
        cardPanel.setLayout(cardLayout);
        cardPanel.add(cautaPanel,"cautaPanel");
        cardPanel.add(veziAngajatPanel,"veziAngajatPanel");
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        this.add(cardPanel);
        this.add(backButton);
        backButton.setVisible(false);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));



        //setup content
        //content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        //this.setLayout(cardLayout);
        //this.add(cautaPanel,"cautaPanel");
        //this.add(veziAngajatPanel,"veziAngajatPanel");
    }
    public void nextCard(){
        cardLayout.next(cardPanel);
        backButton.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        CautaAngajatPanel cautaAngajatPanel=new CautaAngajatPanel();
        jFrame.setPreferredSize(new Dimension(1000,800));
        jFrame.setContentPane(cautaAngajatPanel);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addCautaAngajatListener(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public String getCautaAngajatNume() {
        return numeAngajat.getText();
    }

    public String getCautaAngajatPrenume() {
        return prenumeAngajat.getText();
    }

    public void resetContent(){
        while(contentSize>0){
            content.remove(contentSize-1);
            contentSize--;
        }
    }
    public void showCautaAngajatResult(List<Angajat> lista) {
        resetContent();
        contentSize= lista.size();
        for(int i=0;i<lista.size();i++){
            Angajat angajat=lista.get(i);
            CautaAngajatScrollField cautaAngajatScrollField=new CautaAngajatScrollField(angajat.getNume(),angajat.getPrenume(),angajat.getId_user());
            content.add(cautaAngajatScrollField);
        }
        addVeziAngajatListener(veziAngajatListener);
        this.setVisible(false);
        this.setVisible(true);
    }

    public void addVeziAngajatListener(ActionListener actionListener) {
        veziAngajatListener=actionListener;
        for(int i=0;i<contentSize;i++){
            CautaAngajatScrollField component=(CautaAngajatScrollField) content.getComponent(i);
            component.addVeziAngajatListener(actionListener);
        }
    }

    public VeziAngajatPanel getVeziAngajatPanel() {
        return veziAngajatPanel;
    }

    public void addCautaAngajatBackListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
    public void hideBackButton(){
        backButton.setVisible(false);
    }

    public void reset() {
        veziAngajatPanel.reset();
        cardLayout.show(cardPanel,"cautaPanel");
        resetContent();
    }
}
