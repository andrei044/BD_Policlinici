import javax.swing.*;
import java.awt.*;

public class CreateUserFieldPassword extends JPanel {
    JLabel label=new JLabel();
    PasswordFieldWithPlaceHolder text=new PasswordFieldWithPlaceHolder();
    public CreateUserFieldPassword(String type) {
        label.setText(type+": ");
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(label);
        this.add(text);
        text.setPreferredSize(new Dimension(100,25));
        text.setMaximumSize(new Dimension(10000,25));
        text.setPlaceholder(type);
    }
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        CreateUserField createUserField=new CreateUserField("Nume utilizator");
        jFrame.add(createUserField);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getText(){
        return text.getText();
    }

    public void reset() {
        text.setText("");
    }
}
