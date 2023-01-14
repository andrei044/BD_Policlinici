import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class UIPanel extends JPanel {

    private CardLayout cardLayout=new CardLayout();
    private JTabbedPane tabbedPane=new JTabbedPane();

    private CardLayout createUserLayout=new CardLayout();

    private JPanel createUserPanelCard=new JPanel();
    private CreateProgramPanel createProgramPanel=new CreateProgramPanel();
    private CreateUserPanel createUserCard=new CreateUserPanel("admin");
    private ShowUserPanel showUserCard=new ShowUserPanel();

    private CautaAngajatPanel cautaAngajatCard=new CautaAngajatPanel();
    private FinanciarPoliclinica profitPoliclinicaCard=new FinanciarPoliclinica();
    private SalariuAngajat salariuAngajatCard=new SalariuAngajat();
    private ProgramarePanel programareCard=new ProgramarePanel();
    private EmiteFacturaPanel emiteFacturaCard=new EmiteFacturaPanel();
    private CreeazaRaportPanel raportCard=new CreeazaRaportPanel();
    private DeleteUserPanel deleteUserCard=new DeleteUserPanel();
    private LogoutPanel logoutCard=new LogoutPanel();
    private StergeProgramarePanel stergeProgramarePane=new StergeProgramarePanel();
    private CabinetePanel cabinetePanel=new CabinetePanel();
    public UIPanel() {
        createUserPanelCard.setLayout(createUserLayout);
        createUserPanelCard.add(createUserCard,"createUserCard");
        createUserPanelCard.add(createProgramPanel,"createProgramPanel");


        this.setLayout(cardLayout);
        this.add(tabbedPane);
        //this.add(createUserCard);
        this.add(createUserPanelCard);
        this.add(showUserCard);
        this.add(cautaAngajatCard);
        this.add(profitPoliclinicaCard);
        this.add(salariuAngajatCard);
        this.add(programareCard);
        this.add(emiteFacturaCard);
        this.add(raportCard);
        this.add(deleteUserCard);
        this.add(stergeProgramarePane);
        this.add(cabinetePanel);
        this.add(logoutCard);
        tabbedPane.addTab("Date Utilizator",showUserCard);
        tabbedPane.addTab("Creeaza Utilizator",createUserPanelCard);
        tabbedPane.addTab("Cauta Angajat",cautaAngajatCard);
        tabbedPane.addTab("Profit Policlinica",profitPoliclinicaCard);
        //tabbedPane.addTab("Salariu Angajat",salariuAngajatCard);
        tabbedPane.addTab("Programare",programareCard);
        tabbedPane.addTab("Emite Factura",emiteFacturaCard);
        tabbedPane.addTab("Raport",raportCard);
        tabbedPane.addTab("Logout",logoutCard);
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        UIPanel interfataUtilizator=new UIPanel();
        jFrame.setPreferredSize(new Dimension(1000,800));
        jFrame.setContentPane(interfataUtilizator);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showForMedic(){
        tabbedPane.removeAll();
        tabbedPane.addTab("Date Utilizator",showUserCard);

        tabbedPane.addTab("Raport",raportCard);
        tabbedPane.addTab("Logout",logoutCard);tabbedPane.addTab("Salariu Angajat",salariuAngajatCard);
        this.setVisible(false);
        this.setVisible(true);
//        createUserCard.setVisible(false);
//        showUserCard.setVisible(true);
//        cautaAngajatCard.setVisible(false);
//        profitPoliclinicaCard.setVisible(false);
//        profitAngajatCard.setVisible(true);
//        programareCard.setVisible(false);
//        emiteFacturaCard.setVisible(false);
//        raportCard.setVisible(false);
//        veziRaportCard.setVisible(true);
    }
    public void showForRecep(){
        tabbedPane.removeAll();
        tabbedPane.addTab("Creeaza Utilizator",createUserPanelCard);
        tabbedPane.addTab("Date Utilizator",showUserCard);

        tabbedPane.addTab("Programare",programareCard);
        tabbedPane.addTab("Emite Factura",emiteFacturaCard);
        tabbedPane.addTab("Logout",logoutCard);tabbedPane.addTab("Salariu Angajat",salariuAngajatCard);tabbedPane.addTab("Sterge Programare",stergeProgramarePane);
        tabbedPane.addTab("Cabinete",cabinetePanel);
        createUserCard.loggedAsRecep();
        this.setVisible(false);
        this.setVisible(true);
//        createUserCard.setVisible(true);
//        showUserCard.setVisible(true);
//        cautaAngajatCard.setVisible(false);
//        profitPoliclinicaCard.setVisible(false);
//        profitAngajatCard.setVisible(true);
//        programareCard.setVisible(true);
//        emiteFacturaCard.setVisible(true);
//        raportCard.setVisible(false);
//        veziRaportCard.setVisible(false);
    }
    public void showForFinanciar(){
        tabbedPane.removeAll();
        tabbedPane.addTab("Date Utilizator",showUserCard);
        tabbedPane.addTab("Profit Policlinica",profitPoliclinicaCard);

        tabbedPane.addTab("Logout",logoutCard);tabbedPane.addTab("Salariu Angajat",salariuAngajatCard);
        this.setVisible(false);
        this.setVisible(true);
//        createUserCard.setVisible(false);
//        showUserCard.setVisible(true);
//        cautaAngajatCard.setVisible(false);
//        profitPoliclinicaCard.setVisible(true);
//        profitAngajatCard.setVisible(true);
//        programareCard.setVisible(false);
//        emiteFacturaCard.setVisible(false);
//        raportCard.setVisible(false);
//        veziRaportCard.setVisible(false);
    }
    public void showForHR(){
        tabbedPane.removeAll();
        tabbedPane.addTab("Creeaza Utilizator",createUserPanelCard);
        tabbedPane.addTab("Date Utilizator",showUserCard);
        tabbedPane.addTab("Cauta Angajat",cautaAngajatCard);

        tabbedPane.addTab("Logout",logoutCard);tabbedPane.addTab("Salariu Angajat",salariuAngajatCard);
        createUserCard.loggedAsAdmin();
        this.setVisible(false);
        this.setVisible(true);
//        createUserCard.setVisible(true);
//        showUserCard.setVisible(true);
//        cautaAngajatCard.setVisible(true);
//        profitPoliclinicaCard.setVisible(false);
//        profitAngajatCard.setVisible(false);
//        programareCard.setVisible(false);
//        emiteFacturaCard.setVisible(false);
//        raportCard.setVisible(false);
//        veziRaportCard.setVisible(false);
    }
    public void showForAsistent(){
        tabbedPane.removeAll();
        tabbedPane.addTab("Date Utilizator",showUserCard);
        tabbedPane.addTab("Creeaza Raport",raportCard);

        tabbedPane.addTab("Logout",logoutCard);tabbedPane.addTab("Salariu Angajat",salariuAngajatCard);
        this.setVisible(false);
        this.setVisible(true);
    }
    public void showForAdmin(){
        tabbedPane.removeAll();
        tabbedPane.addTab("Date Utilizator",showUserCard);
        tabbedPane.addTab("Creeaza Utilizator",createUserPanelCard);
        tabbedPane.addTab("Cauta Angajat",cautaAngajatCard);
        tabbedPane.addTab("Profit Policlinica",profitPoliclinicaCard);

        tabbedPane.addTab("Programare",programareCard);
        tabbedPane.addTab("Emite Factura",emiteFacturaCard);
        tabbedPane.addTab("Creeaza Raport",raportCard);
        tabbedPane.addTab("Sterge User",deleteUserCard);

        tabbedPane.addTab("Logout",logoutCard);tabbedPane.addTab("Salariu Angajat",salariuAngajatCard);tabbedPane.addTab("Sterge Programare",stergeProgramarePane);
        tabbedPane.addTab("Cabinete",cabinetePanel);
        createUserCard.loggedAsSuperAdmin();
        this.setVisible(false);
        this.setVisible(true);
    }

    public ShowUserPanel getShowUserCard() {
        return showUserCard;
    }

    public JPanel getCreateUserPanelCard() {
        return createUserPanelCard;
    }

    public void login(Angajat angajat){


    }

    public void addLogoutListener(ActionListener actionListener) {
        logoutCard.addLogoutListener(actionListener);
    }

    public void addComboBoxCreateUserListener(ActionListener actionListener){
        createUserCard.addComboBoxCreateUserListener(actionListener);
    }

    public String getFunctieCreateUser() {
        return createUserCard.getFunctie();
    }

    public void displayCreateUserForMedic() {
        createUserCard.displayForMedic();
    }

    public void displayCreateUserForAsistent() {
        createUserCard.displayForAsistent();
    }

    public void displayCreateUserForRest() {
        createUserCard.displayForAngajat();
    }


    public void addAddSpecializareCreateUserListener(ActionListener actionListener) {
        createUserCard.addAddSpecializareCreateUserListener(actionListener);
    }

    public void addRemoveSpecializareCreateUserListener(ActionListener actionListener) {
        createUserCard.addRemoveSpecializareCreateUserListener(actionListener);
    }

    public void addSpecializareCreateUser() {
        createUserCard.addSpecializare();
    }

    public void removeSpecializareCreateUser() {
        createUserCard.removeSpecializare();
    }

    public void addNextCreateUserListener(ActionListener actionListener) {
        createUserCard.addNextCreateUserListener(actionListener);
    }

    public void nextCreateUser() {
        createUserLayout.next(createUserPanelCard);
    }

    public void addBackCreateUserListener(ActionListener actionListener) {
        createProgramPanel.addBackCreateUserListener(actionListener);
    }

    public void backCreateUser() {
        createUserLayout.next(createUserPanelCard);
    }

    public void addSubmitCreateUserListener(ActionListener actionListener) {
        createProgramPanel.addSubmitCreateUserListener(actionListener);
    }
    public void createUser() {
        if(createUserCard.getFunctie().equals("Financiar") || createUserCard.getFunctie().equals("Resurse Umane") || createUserCard.getFunctie().equals("Receptioner")){
            Angajat angajat=createUserCard.getAngajat();
            angajat.setProgram(createProgramPanel.getProgramGeneric());
            System.out.println(angajat.toString());
        }else if(createUserCard.getFunctie().equals("Medic")){
            Medic medic=createUserCard.getMedic();
            medic.setProgram(createProgramPanel.getProgramGeneric());
            System.out.println(medic.toString());
        }
        else if(createUserCard.getFunctie().equals("Asistent")){
            Asistent asistent=createUserCard.getAsistent();
            asistent.setProgram(createProgramPanel.getProgramGeneric());
            System.out.println(asistent.toString());
        }
        //createUserCard.reset();
        //createProgramPanel.reset();
    }

    public void displayCreateUserForPacient() {
        createUserCard.displayForPacient();
    }

    public Medic getMedicCreateUser() {
        Medic medic=createUserCard.getMedic();
        medic.setProgram(createProgramPanel.getProgramGeneric());
        return medic;
    }

    public Asistent getAsistentCreateUser() {
        Asistent asistent=createUserCard.getAsistent();
        asistent.setProgram(createProgramPanel.getProgramGeneric());
        return asistent;
    }

    public User getPacientCreateUser() {
        return createUserCard.getPacient();
    }

    public Angajat getAngajatCreateUser() {
        Angajat angajat=createUserCard.getAngajat();
        angajat.setProgram(createProgramPanel.getProgramGeneric());
        return angajat;
    }

    public void resetCreateUser() {
        createUserCard.reset();
        createProgramPanel.reset();
    }

    public void addCautaAngajatListener(ActionListener actionListener) {
        cautaAngajatCard.addCautaAngajatListener(actionListener);
    }

    public String getCautaAngajatNume() {
        return cautaAngajatCard.getCautaAngajatNume();
    }

    public String getCautaAngajatPrenume() {
        return cautaAngajatCard.getCautaAngajatPrenume();
    }

    public void showCautaAngajatResult(List<Angajat> lista) {
        cautaAngajatCard.showCautaAngajatResult(lista);
    }

    public void addVeziAngajatListener(ActionListener actionListener) {
        cautaAngajatCard.addVeziAngajatListener(actionListener);
    }

    public CautaAngajatPanel getCautaAngajatCard() {
        return cautaAngajatCard;
    }

    public ProgramarePanel getProgramareCard() {
        return programareCard;
    }

    public CreeazaRaportPanel getRaportCard() {
        return raportCard;
    }

    public EmiteFacturaPanel getEmiteFacturaCard() {
        return emiteFacturaCard;
    }

    public void showForSuperadmin() {

        tabbedPane.removeAll();
        tabbedPane.addTab("Date Utilizator",showUserCard);
        tabbedPane.addTab("Creeaza Utilizator",createUserPanelCard);
        tabbedPane.addTab("Cauta Angajat",cautaAngajatCard);
        tabbedPane.addTab("Profit Policlinica",profitPoliclinicaCard);
        tabbedPane.addTab("Salariu Angajat",salariuAngajatCard);
        tabbedPane.addTab("Programare",programareCard);
        tabbedPane.addTab("Emite Factura",emiteFacturaCard);
        tabbedPane.addTab("Creeaza Raport",raportCard);
        tabbedPane.addTab("Logout",logoutCard);
        createUserCard.loggedAsAdmin();

    }

    public CreateUserPanel getCreateUserCard() {
        return createUserCard;
    }

    public CreateProgramPanel getCreateProgramPanel() {
        return createProgramPanel;
    }
    public SalariuAngajat getSalariuAngajatCard() {
        return salariuAngajatCard;
    }

    public FinanciarPoliclinica getProfitPoliclinicaCard() {
        return profitPoliclinicaCard;
    }

    public DeleteUserPanel getDeleteUserCard() {
        return deleteUserCard;
    }
    public void reset(){
        //tabbedPane.setSelectedIndex(9);
        //tabbedPane.setSelectedIndex(10);
        //tabbedPane.setSelectedIndex(0);
        tabbedPane.setSelectedComponent(salariuAngajatCard);
        tabbedPane.setSelectedComponent(stergeProgramarePane);
        tabbedPane.setSelectedComponent(cabinetePanel);
        tabbedPane.setSelectedComponent(showUserCard);
    }

    public StergeProgramarePanel getStergeProgramarePane() {
        return stergeProgramarePane;
    }
}