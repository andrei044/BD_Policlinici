import javax.swing.*;
import java.awt.*;

public class DayOfWeekField extends JPanel {

    JPanel textFields=new JPanel();
    JLabel label=new JLabel();
    TextFieldWithPlaceHolder startTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder stopTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder unitateTextField=new TextFieldWithPlaceHolder();
    public DayOfWeekField(String day) {
        label.setText(day);
        textFields.add(startTextField);
        textFields.add(stopTextField);
        textFields.add(unitateTextField);
        textFields.setLayout(new BoxLayout(textFields,BoxLayout.X_AXIS));
        startTextField.setPlaceholder("Ora start HH:MM, 0-23");
        startTextField.setPreferredSize(new Dimension(100,25));
        startTextField.setMaximumSize(new Dimension(10000,25));
        stopTextField.setPlaceholder("Ora stop HH:MM, 0-23");
        stopTextField.setPreferredSize(new Dimension(100,25));
        stopTextField.setMaximumSize(new Dimension(10000,25));
        unitateTextField.setPlaceholder("ID unitate");
        unitateTextField.setPreferredSize(new Dimension(100,25));
        unitateTextField.setMaximumSize(new Dimension(10000,25));
//        startTextField.setPreferredSize(new Dimension(100,25));
//        startTextField.setMaximumSize(new Dimension(100,25));
//        startTextField.setMinimumSize(new Dimension(100,25));
//        stopTextField.setPreferredSize(new Dimension(100,25));
//        stopTextField.setMaximumSize(new Dimension(100,25));
//        stopTextField.setMinimumSize(new Dimension(100,25));
//        unitateTextField.setPreferredSize(new Dimension(100,25));
//        unitateTextField.setMaximumSize(new Dimension(100,25));
//        unitateTextField.setMinimumSize(new Dimension(100,25));
        //this.setMaximumSize(new Dimension(300,50));
        //this.setPreferredSize(new Dimension(300,50));
        //this.setMinimumSize(new Dimension(300,50));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label);
        this.add(textFields);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        label.setBorder(BorderFactory.createLineBorder(Color.green));
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        DayOfWeekField dayOfWeekField=new DayOfWeekField("Luni:");
        jFrame.add(dayOfWeekField);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getStart(){
        return startTextField.getText();
    }
    public String getStop(){
        return stopTextField.getText();
    }
    public String getUnitate(){
        return unitateTextField.getText();
    }

    public void setStart(String start){
        startTextField.setText(start);
    }
    public void setStop(String stop){
        stopTextField.setText(stop);
    }
    public void setUnitate(String unitate){
        unitateTextField.setText(unitate);
    }
    public void reset(){
        startTextField.setText("");
        stopTextField.setText("");
        unitateTextField.setText("");
    }
}