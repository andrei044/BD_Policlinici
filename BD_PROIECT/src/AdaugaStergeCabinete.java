import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdaugaStergeCabinete extends JPanel {
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
    private JLabel cabinetePanel=new JLabel();
    private JPanel serviciiPanel=new JPanel();
    JComboBox unitatiComboBox=new JComboBox();
    private JPanel serviciinorthPanel=new JPanel();
    private JPanel serviciicenterPanel=new JPanel();
    private JButton serviciibackButton=new JButton("Inapoi");
    private JPanel serviciiFields=new JPanel();
    private CardLayout cardLayout=new CardLayout();
    private JPanel serviciiButtons=new JPanel();
    private JButton confirmButton=new JButton("Confirma");
    private JButton serviciiVeziButton=new JButton("Vezi");
    private JScrollPane serviciiJScrollPane=new JScrollPane();
    private JPanel serviciiScrollPaneContent=new JPanel();

    public AdaugaStergeCabinete() {
        this.setLayout(cardLayout);
        this.add(cabinetePanel,"cabinetePanel");
        this.add(serviciiPanel,"serviciiPanel");
        cabinetePanel.setLayout(new BorderLayout());
        cabinetePanel.add(northPanel,BorderLayout.NORTH);
        cabinetePanel.add(centerPanel,BorderLayout.CENTER);
        cabinetePanel.add(backButton,BorderLayout.SOUTH);

        serviciiPanel.setLayout(new BorderLayout());
        serviciiPanel.add(serviciinorthPanel,BorderLayout.NORTH);
        serviciiPanel.add(serviciicenterPanel,BorderLayout.CENTER);
        serviciiPanel.add(serviciibackButton,BorderLayout.SOUTH);

        fields.add(new JLabel("ID UNITATE"));
        fields.add(new JLabel("ID CABINET"));
        fields.add(new JLabel("DENUMIRE SERV"));
        fields.add(new JLabel("NUME MEDIC"));
        fields.add(new JLabel("STERGE"));

        serviciiFields.add(new JLabel("ID Serv"));
        serviciiFields.add(new JLabel("Denumire"));
        serviciiFields.add(new JLabel("Nume Medic"));
        serviciiFields.add(new JLabel("CheckBox"));

        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));
        fields.setLayout(new GridLayout(1,5));
        northPanel.add(buttons);
        northPanel.add(fields);
        buttons.add(veziButton);
        buttons.add(adaugaCabinet);
        jScrollPane.setViewportView(scrollPaneContent);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneContent.setLayout(new BoxLayout(scrollPaneContent,BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(jScrollPane,BorderLayout.CENTER);


        serviciinorthPanel.setLayout(new BoxLayout(serviciinorthPanel,BoxLayout.Y_AXIS));
        serviciiFields.setLayout(new GridLayout(1,5));
        serviciinorthPanel.add(serviciiButtons);
        serviciinorthPanel.add(serviciiFields);
        serviciiButtons.add(unitatiComboBox);
        serviciiButtons.add(serviciiVeziButton);
        serviciiButtons.add(confirmButton);
        serviciiJScrollPane.setViewportView(serviciiScrollPaneContent);
        serviciiJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        serviciiScrollPaneContent.setLayout(new BoxLayout(serviciiScrollPaneContent,BoxLayout.Y_AXIS));
        serviciicenterPanel.setLayout(new BorderLayout());
        serviciicenterPanel.add(serviciiJScrollPane,BorderLayout.CENTER);

    }

    public void resetContent(){
        while(scrollPaneContent.getComponentCount()>0){
            scrollPaneContent.remove(0);
        }
        cabinetePanel.setVisible(false);
        cabinetePanel.setVisible(true);
    }
    public void showResult(List<CabinetField>lista) {
        resetContent();
        for(int i=0;i<lista.size();i++){
            scrollPaneContent.add(lista.get(i));
            lista.get(i).addDeleteListener(listener);
        }
        cabinetePanel.setVisible(false);
        cabinetePanel.setVisible(true);
    }

    public void resetContentServicii(){
        while(serviciiScrollPaneContent.getComponentCount()>0){
            serviciiScrollPaneContent.remove(0);
        }
        serviciiPanel.setVisible(false);
        serviciiPanel.setVisible(true);
    }
    public void showResultServicii(List<ServiciuField>lista) {
        resetContentServicii();
        for(int i=0;i<lista.size();i++){
            serviciiScrollPaneContent.add(lista.get(i));
        }
        serviciiPanel.setVisible(false);
        serviciiPanel.setVisible(true);
    }
    public void addStergeCabinetListener(ActionListener actionListener){
        listener=actionListener;
    }
    public void addVeziButton(ActionListener actionListener){
        veziButton.addActionListener(actionListener);
    }
    public void addBackCabineteListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }
    public void setUnitati(List<String>list){
        DefaultComboBoxModel<String> comboBoxModel_unitati = new DefaultComboBoxModel<>(list.toArray(new String[0]) );
        unitatiComboBox.setModel(comboBoxModel_unitati);
    }
    public void addAdaugaCabinetListener(ActionListener actionListener){
        adaugaCabinet.addActionListener(actionListener);
    }
    public void showAdaugaCabinet() {
        cardLayout.show(this,"serviciiPanel");
    }
    public void showCabinete(){cardLayout.show(this,"cabinetePanel");}

    public String getUnitatiComboBox() {
        return unitatiComboBox.getSelectedItem().toString();
    }

    public void addVeziServiciiButton(ActionListener actionListener) {
        serviciiVeziButton.addActionListener(actionListener);
    }
    public void addConfirmButtonListener(ActionListener actionListener){
        confirmButton.addActionListener(actionListener);
    }

    public List<ServiciuField> getList() {
        List<ServiciuField> list=new ArrayList<>();
        for(int i=0;i<serviciiScrollPaneContent.getComponentCount();i++){
            ServiciuField x=(ServiciuField) serviciiScrollPaneContent.getComponent(i);
            if(x.isCheckBox()){
                list.add(x);
            }
        }
        return list;
    }
    public void addBackServiciiButton(ActionListener actionListener){
        serviciibackButton.addActionListener(actionListener);
    }
}
