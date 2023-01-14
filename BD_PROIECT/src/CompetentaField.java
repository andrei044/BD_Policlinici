import javax.swing.*;

public class CompetentaField extends JPanel {
    private TextFieldWithPlaceHolder denumire=new TextFieldWithPlaceHolder();
    private TextFieldWithPlaceHolder durata_serviciu=new TextFieldWithPlaceHolder();
    private TextFieldWithPlaceHolder pret=new TextFieldWithPlaceHolder();

    public CompetentaField(int nr) {
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(new JLabel("Denumire:"));
        this.add(denumire);
        this.add(new JLabel("Durata Serviciu:"));
        this.add(durata_serviciu);
        denumire.setPlaceholder("competenta"+nr);
        durata_serviciu.setPlaceholder("Durata Serviciu(Minute)");
    }

    public String getText() {
        return denumire.getText();
    }
    public void showPret(){
        pret.setPlaceholder("Pret");
        this.add(new JLabel("Pret:"));
        this.add(pret);
        pret.setVisible(true);
    }

    public String getDurata() {
        return durata_serviciu.getText();
    }
    public String getPret(){return pret.getText();}
    public void setText(String denumire,String durata,String pret){
        this.denumire.setText(denumire);
        this.durata_serviciu.setText(durata);
        this.pret.setText(pret);
    }
    public void setEditable(boolean b){
        denumire.setEditable(b);
    }
}
