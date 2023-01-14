import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteUserPanel extends JPanel {
    private JScrollPane jScrollPane=new JScrollPane();
    private JPanel northPanel=new JPanel();
    private JPanel centerPanel=new JPanel();
    private CreateUserField nume=new CreateUserField("Nume");
    private CreateUserField prenume=new CreateUserField("Prenume");
    private JButton veziButton=new JButton("Vezi");
    private JPanel searchFields=new JPanel();
    private JPanel buttons=new JPanel();
    private JPanel scrollPaneContent=new JPanel();
    private ActionListener actionListener;

    public DeleteUserPanel() {
        this.setLayout(new BorderLayout());
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(northPanel,BorderLayout.NORTH);

        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));
        searchFields.setLayout(new GridLayout(1,5));
        searchFields.add(new JLabel("iD"));
        searchFields.add(new JLabel("NUME"));
        searchFields.add(new JLabel("PRENUME"));
        searchFields.add(new JLabel("STATUS"));
        searchFields.add(new JLabel("sterge"));
        buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));
        buttons.add(nume);
        buttons.add(prenume);
        buttons.add(veziButton);
        northPanel.add(buttons);
        northPanel.add(searchFields);

        centerPanel.setLayout(new BorderLayout());
        jScrollPane.setViewportView(scrollPaneContent);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        centerPanel.add(jScrollPane,BorderLayout.CENTER);
    }
    public void resetContent(){
        while(scrollPaneContent.getComponentCount()>0){
            scrollPaneContent.remove(0);
        }
    }
    public void showResult(List<UserField> lista) {
        resetContent();
        for(int i=0;i<lista.size();i++){
            lista.get(i).addDeleteListener(actionListener);
            scrollPaneContent.add(lista.get(i));
        }
        this.setVisible(false);
        this.setVisible(true);
    }

    public void addDeleteUserListener(ActionListener listener){
        actionListener=listener;
    }
    public void addVeziDeleteUserListener(ActionListener actionListener){
        veziButton.addActionListener(actionListener);
    }
    public String getNume(){
        return nume.getText();
    }
    public String getPrenume(){
        return prenume.getText();
    }
}
