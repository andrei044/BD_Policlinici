import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class RepartizarePanel extends JPanel {
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();
    private JButton backButton=new JButton("Inapoi");
    private JPanel fields=new JPanel();
    public RepartizarePanel() {
        this.setLayout(new BorderLayout());
        this.add(jScrollPane,BorderLayout.CENTER);
        jScrollPane.setViewportView(scrollPaneContent);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        this.add(backButton,BorderLayout.SOUTH);
        fields.add(new JLabel("ID UNITATE"));
        fields.add(new JLabel("ID CABINET"));
        fields.add(new JLabel("ID MEDIC"));
        fields.add(new JLabel("TIMP START"));
        fields.add(new JLabel("TIMP STOP"));
        fields.setLayout(new GridLayout(1,5));
        this.add(fields,BorderLayout.NORTH);
    }
    public void resetContent(){
        while(scrollPaneContent.getComponentCount()>0){
            scrollPaneContent.remove(0);
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void showResult(List<RepartizareField> lista) {
        resetContent();
        for(int i=0;i<lista.size();i++){
            scrollPaneContent.add(lista.get(i));
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void addBackListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }
}
