import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class PasswordFieldWithPlaceHolder extends JPasswordField {

    private String placeholder;

    public PasswordFieldWithPlaceHolder() {
    }

    public PasswordFieldWithPlaceHolder(String text) {
        super(text);
    }

    public PasswordFieldWithPlaceHolder(int columns) {
        super(columns);
    }

    public PasswordFieldWithPlaceHolder(String text, int columns) {
        super(text, columns);
    }

    public PasswordFieldWithPlaceHolder(Document doc, String txt, int columns) {
        super(doc, txt, columns);
    }

    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
                .getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }
}
