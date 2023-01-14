import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class EmiteFacturaPanel extends JPanel {
    private JButton refreshButton=new JButton("Refresh");
    private ActionListener listener;
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();
    private JPanel northPanel=new JPanel();
    private JPanel centerPanel=new JPanel();
    private JPanel searchFields=new JPanel();
    private int contentSize=0;

    public EmiteFacturaPanel() {
        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));
        searchFields.setLayout(new GridLayout(1,8));
        searchFields.add(new JLabel("Data"));
        searchFields.add(new JLabel("Ora Start"));
        searchFields.add(new JLabel("Ora Final"));
        searchFields.add(new JLabel("Nume Pacient"));
        searchFields.add(new JLabel("Nume Medic"));
        searchFields.add(new JLabel("Nume Serviciu"));
        searchFields.add(new JLabel("Pret"));
        searchFields.add(new JLabel("Selecteaza"));


        northPanel.add(refreshButton);
        northPanel.add(searchFields);
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        jScrollPane.setViewportView(scrollPaneContent);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jScrollPane,BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(northPanel,BorderLayout.NORTH);
        this.add(centerPanel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.setContentPane(new EmiteFacturaPanel());
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
    public void showIstoricForFactura(List<EmiteFacturaField>lista) {
        resetContent();
        contentSize= lista.size();
        for(int i=0;i<lista.size();i++){
            EmiteFacturaField x=lista.get(i);
            x.addSelecteazaListener(listener);
            scrollPaneContent.add(x);
        }
        this.setVisible(false);
        this.setVisible(true);
    }
    public void addSelectListener(ActionListener actionListener){
        listener=actionListener;
    }
    public void addRefreshListener(ActionListener actionListener){
        refreshButton.addActionListener(actionListener);
    }
    public void reset(){
        resetContent();
    }
}
