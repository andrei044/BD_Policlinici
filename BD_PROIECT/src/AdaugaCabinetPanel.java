import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class AdaugaCabinetPanel extends JPanel {
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();
    private JPanel northPanel=new JPanel();
    private JPanel centerPanel=new JPanel();
    private JPanel fields=new JPanel();
    private JPanel buttons=new JPanel();
    private JButton veziButton=new JButton("VEZI");
    private ActionListener listener;

    public void resetContent(){
        while(scrollPaneContent.getComponentCount()>0){
            scrollPaneContent.remove(0);
        }
    }
    public void showResult(List<UnitateField> lista) {
        resetContent();
        for(int i=0;i<lista.size();i++){
            scrollPaneContent.add(lista.get(i));
            lista.get(i).addSelectListener(listener);
        }
        this.setVisible(false);
        this.setVisible(true);
    }
}
