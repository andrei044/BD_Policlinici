import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    ImageIconScalable logo=new ImageIconScalable("resources/logo0.png");
    JLabel logoLabel=new JLabel();
    JPanel textFields=new JPanel();
    JButton submitButton=new JButton("Submit");
    TextFieldWithPlaceHolder usernameTextField=new TextFieldWithPlaceHolder("");
    PasswordFieldWithPlaceHolder passwordTextField=new PasswordFieldWithPlaceHolder("");
    SpringLayout springLayout=new SpringLayout();

    public LoginPanel() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(new Color(223,239,244,255));
        //logo.scaleImage(300,300);
        logoLabel.setIcon(logo);
        this.add(logoLabel);
        this.add(textFields);
        textFields.setBackground(new Color(223,239,244,255));
        this.add(submitButton);
        textFields.add(usernameTextField);
        textFields.add(passwordTextField);

        usernameTextField.setPlaceholder("username");
        passwordTextField.setPlaceholder("password");
        usernameTextField.setPreferredSize(new Dimension(170,25));
        passwordTextField.setPreferredSize(new Dimension(170,25));
        usernameTextField.setMaximumSize(new Dimension(170,25));
        passwordTextField.setMaximumSize(new Dimension(170,25));
        //this.setBorder(BorderFactory.createLineBorder(Color.green));
        textFields.setLayout(new BoxLayout(textFields,BoxLayout.Y_AXIS));

        usernameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFields.setAlignmentX(Component.CENTER_ALIGNMENT);
        //textFields.setBorder(BorderFactory.createLineBorder(Color.green));
        //logoLabel.setBorder(BorderFactory.createLineBorder(Color.green));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//        springLayout.putConstraint(SpringLayout.WEST,logoLabel,200,SpringLayout.WEST,this);
//        springLayout.putConstraint(SpringLayout.NORTH,logoLabel,100,SpringLayout.NORTH,this);
//
//        springLayout.putConstraint(SpringLayout.NORTH,textFields,20,SpringLayout.SOUTH,logoLabel);
//        springLayout.putConstraint(SpringLayout.WEST,textFields,0,SpringLayout.WEST,logoLabel);
//
//        springLayout.putConstraint(SpringLayout.NORTH,submitButton,20,SpringLayout.SOUTH,textFields);
//        springLayout.putConstraint(SpringLayout.WEST,submitButton,0,SpringLayout.WEST,textFields);

    }

    public void addSubmitListener(ActionListener actionListener){
        submitButton.addActionListener(actionListener);
    }

    public String getUsername(){
        return usernameTextField.getText();
    }
    public String getPassword(){
        return passwordTextField.getText();
    }

    public void displayLoginFail(){
        JOptionPane.showMessageDialog(this,
                "Wrong username/password",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE);
    }

    public void clearUsername(){
        usernameTextField.setText("");
    }

    public void clearPassword(){
        passwordTextField.setText("");
    }

    public void reset(){
        this.clearUsername();
        this.clearPassword();
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.setPreferredSize(new Dimension(1000,800));
        LoginPanel loginPanel=new LoginPanel();
        jFrame.setContentPane(loginPanel);

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
