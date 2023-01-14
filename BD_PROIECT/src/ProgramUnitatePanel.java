import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.List;

public class ProgramUnitatePanel extends JPanel {
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel scrollPaneContent=new JPanel();
    private JPanel fields=new JPanel();
    private int contentSize=0;
    public ProgramUnitatePanel() {
        this.setLayout(new BorderLayout());
        setFields();
        this.add(fields,BorderLayout.NORTH);

        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportView(scrollPaneContent);
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));

        this.add(jScrollPane,BorderLayout.CENTER);

    }
    private void setFields(){
        fields.setLayout(new GridLayout(1,15));
        fields.add(new JLabel("ID"));
        fields.add(new JLabel("Luni_start"));
        fields.add(new JLabel("Luni_stop"));
        fields.add(new JLabel("Marti_start"));
        fields.add(new JLabel("Marti_stop"));
        fields.add(new JLabel("Miercuri_start"));
        fields.add(new JLabel("Miercuri_stop"));
        fields.add(new JLabel("Joi_start"));
        fields.add(new JLabel("Joi_stop"));
        fields.add(new JLabel("Vineri_start"));
        fields.add(new JLabel("Vineri_stop"));
        fields.add(new JLabel("Sambata_start"));
        fields.add(new JLabel("Sambata_stop"));
        fields.add(new JLabel("Duminica_start"));
        fields.add(new JLabel("Duminica_stop"));
    }
    public void setContent(List<ProgramGeneric>list){
        resetContent();
        contentSize=list.size();
        while(!list.isEmpty()){
            scrollPaneContent.add(list.get(0));
            list.remove(0);
        }
        this.setVisible(false);
        this.setVisible(true);

    }
    public void resetContent(){
        while(contentSize>0){
            scrollPaneContent.remove(contentSize-1);
            contentSize--;
        }
    }

    public boolean verif(String unitate, int zi, String start, String stop) {
        for(int i=0;i<scrollPaneContent.getComponentCount();i++){
            if(((ProgramGeneric)scrollPaneContent.getComponent(i)).getId_unitate().equals(unitate)){
                if(((ProgramGeneric)scrollPaneContent.getComponent(i)).verif(zi,start,stop)){
                    return true;
                }else return false;
            }
        }
        return false;
    }
}
