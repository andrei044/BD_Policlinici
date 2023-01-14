import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextAreaScrollable extends JPanel {
    JTextArea display = new JTextArea ( 7, 58 );
    JScrollPane scroll = new JScrollPane ( display );

    public TextAreaScrollable(String continut) {
        display.setBorder ( new TitledBorder( new EtchedBorder(), continut ) );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        this.add ( scroll );
    }

    public static void main (String[] args )
    {
        JFrame frame = new JFrame ();
        frame.add ( new TextAreaScrollable("Raport:") );
        frame.pack ();
        frame.setLocationRelativeTo ( null );
        frame.setVisible ( true );
    }
    public String getText(){
        return display.getText();
    }
    public void reset(){
        display.setText("");
    }
    public void setEditable(boolean b){
        display.setEditable(b);
    }
    public void setText(String text){
        display.setText(text);
    }
}
