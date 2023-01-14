import javax.swing.*;
import java.awt.event.ActionListener;

public class LogoutPanel extends JPanel {
    private static JButton logoutButton=new JButton("Log out");
    public LogoutPanel() {
        this.add(logoutButton);
    }

    public void addLogoutListener(ActionListener actionListener) {
        logoutButton.addActionListener(actionListener);
    }
}
