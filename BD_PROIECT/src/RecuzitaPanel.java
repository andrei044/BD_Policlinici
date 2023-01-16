import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class RecuzitaPanel extends JPanel {
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();
    private JPanel northPanel=new JPanel();
    private JPanel centerPanel=new JPanel();
    private JPanel fields=new JPanel();
    private JPanel buttons=new JPanel();
    private JButton veziButton=new JButton("Vezi");
    private JButton adaugaCabinet=new JButton("Adauga Cabinet");
    private JButton backButton=new JButton("inapoi");
    private ActionListener listener;
    private ActionListener listener2;

    public RecuzitaPanel() {
        this.setLayout(new BorderLayout());
        this.add(jScrollPane,BorderLayout.CENTER);
        jScrollPane.setViewportView(scrollPaneContent);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        this.add(backButton,BorderLayout.SOUTH);
        fields.add(new JLabel("ID Serv"));
        fields.add(new JLabel("Denumire Serv"));
        fields.add(new JLabel("Nume Medic"));
        fields.add(new JLabel("Recuzita"));
        fields.add(new JLabel("Sterge"));
        fields.add(new JLabel("Select"));
        fields.setLayout(new GridLayout(1,6));
        this.add(fields,BorderLayout.NORTH);
    }

    public void resetContent(){
        while(scrollPaneContent.getComponentCount()>0){
            scrollPaneContent.remove(0);
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void showResult(List<RecuzitaField> lista) {
        resetContent();
        for(int i=0;i<lista.size();i++){
            scrollPaneContent.add(lista.get(i));
            lista.get(i).addDeleteListener(listener);
            lista.get(i).addSelectListener(listener2);
        }
        this.setVisible(false);
        this.setVisible(true);
    }

    public void addBackListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }
    public void addSelectListener(ActionListener actionListener){
        listener2=actionListener;
    }
    public void addDeleteListener(ActionListener actionListener){
        listener=actionListener;
    }
}
