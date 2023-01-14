import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class AppView2 extends JFrame {
    JPanel content=new JPanel();
    LoginPanel loginPanel=new LoginPanel();
    UIPanel uiPanel=new UIPanel();

    CardLayout cardLayout=new CardLayout();
    public AppView2() throws HeadlessException {
        content.add(loginPanel);
        content.add(uiPanel);
        content.setLayout(cardLayout);
        this.setTitle("POLICLINICA");
        this.setPreferredSize(new Dimension(1650,800));
        this.pack();
        this.setContentPane(content);
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getUsername(){
        return loginPanel.getUsername();
    }
    public String getPassword(){
        return loginPanel.getPassword();
    }

    public void login(Angajat angajat){
        cardLayout.next(content);
        uiPanel.login(angajat);
    }
    public void logout(){
        cardLayout.next(content);
        loginPanel.reset();
    }
    public void next(){
        cardLayout.next(content);
    }
    public void displayLoginFail(){
        loginPanel.displayLoginFail();
    }

    public void resetLogin(){
        loginPanel.reset();
    }
    public void addSubmitListener(ActionListener actionListener){
        loginPanel.addSubmitListener(actionListener);
    }
    public void addLogoutListener(ActionListener actionListener){
        uiPanel.addLogoutListener(actionListener);
    }
    public void addComboBoxCreateUserListener(ActionListener actionListener){
        uiPanel.addComboBoxCreateUserListener(actionListener);
    }
    public String getFunctieCreateUser(){
        return uiPanel.getFunctieCreateUser();
    }

    public void displayCreateUserForMedic() {
        uiPanel.displayCreateUserForMedic();
    }

    public void displayCreateUserForAsistent() {
        uiPanel.displayCreateUserForAsistent();
    }

    public void displayCreateUserForRest() {
        uiPanel.displayCreateUserForRest();
    }

    public void addAddSpecializareCreateUserListener(ActionListener actionListener) {
        uiPanel.addAddSpecializareCreateUserListener(actionListener);
    }

    public void addRemoveSpecializareCreateUserListener(ActionListener actionListener) {
        uiPanel.addRemoveSpecializareCreateUserListener(actionListener);
    }

    public void addSpecializareCreateUser() {
        uiPanel.addSpecializareCreateUser();
    }

    public void removeSpecializareCreateUser() {
        uiPanel.removeSpecializareCreateUser();
    }

    public void addNextCreateUserListener(ActionListener actionListener) {
        uiPanel.addNextCreateUserListener(actionListener);
    }

    public void nextCreateUser() {
        uiPanel.nextCreateUser();
    }

    public void addBackCreateUserListener(ActionListener actionListener) {
        uiPanel.addBackCreateUserListener(actionListener);
    }

    public void backCreateUser() {
        uiPanel.backCreateUser();
    }

    public void addSubmitCreateUserListener(ActionListener actionListener) {
        uiPanel.addSubmitCreateUserListener(actionListener);
    }

    public void createUser() {
        uiPanel.createUser();
    }

    public void displayCreateUserForPacient() {
        uiPanel.displayCreateUserForPacient();
    }

    public Medic getMedicCreateUser() {
        return uiPanel.getMedicCreateUser();
    }

    public Asistent getAsistentCreateUser() {
        return uiPanel.getAsistentCreateUser();
    }

    public User getPacientCreateUser() {
        return uiPanel.getPacientCreateUser();
    }

    public Angajat getAngajatCreateUser() {
        return uiPanel.getAngajatCreateUser();
    }

    public void resetCreateUser() {
        uiPanel.resetCreateUser();
    }

    public void addCautaAngajatListener(ActionListener actionListener) {
        uiPanel.addCautaAngajatListener(actionListener);
    }

    public String getCautaAngajatNume() {
        return uiPanel.getCautaAngajatNume();
    }

    public String getCautaAngajatPrenume() {
        return uiPanel.getCautaAngajatPrenume();
    }

    public void showCautaAngajatResult(List<Angajat> lista) {
        uiPanel.showCautaAngajatResult(lista);
    }

    public void addVeziAngajatListener(ActionListener actionListener) {
        uiPanel.addVeziAngajatListener(actionListener);
    }

    public UIPanel getUiPanel() {
        return uiPanel;
    }
}
