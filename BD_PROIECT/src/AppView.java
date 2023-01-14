import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AppView extends JFrame {
    JButton submitButton=new JButton("Submit");
    JButton createNewUserButton=new JButton("Creeaza user");
    JButton addSpecializareButton=new JButton("Adauga Specializare");
    JButton deleteSpecializareButton=new JButton("Sterge Specializare");
    JButton[] addCompetentaButton=new JButton[3];
    JButton[] deleteCompetentaButton=new JButton[3];
    TextFieldWithPlaceHolder usernameTextField=new TextFieldWithPlaceHolder("");
    PasswordFieldWithPlaceHolder passwordTextField=new PasswordFieldWithPlaceHolder("");

    ImageIconScalable logo=new ImageIconScalable("resources/logo.jpg");
    JLabel logoLabel=new JLabel();
    JPanel login=new JPanel();
    JPanel create_new_user=new JPanel();
    JPanel date_user=new JPanel();
    JPanel content=new JPanel();
    JPanel interfata_user=new JPanel();
    JPanel interfata_user_cards=new JPanel();
    JLabel numeLabel=new JLabel("Nume:");
    JLabel prenumeLabel=new JLabel("Prenume:");
    JLabel adresaLabel=new JLabel("Adresa:");
    JLabel CNPLabel=new JLabel("CNP:");
    JLabel telLabel=new JLabel("Tel:");
    JLabel emailLabel=new JLabel("Email:");
    JLabel gradAsistentLabel=new JLabel("Grad asistent:");
    JLabel tipAsistentLabel=new JLabel("Tip asistent:");
    JLabel gradMedicLabel=new JLabel("Grad medic:");
    JLabel parafaLabel=new JLabel("Parafa medic:");
    JLabel postLabel=new JLabel("Post didactic:");
    JLabel titluLabel=new JLabel("Titlu stiintific:");
    JLabel IBANLabel=new JLabel("IBAN:");
    JLabel salariu_brutLabel=new JLabel("Salariu brut:");
    TextField numeTextField=new TextField();
    TextField prenumeTextField=new TextField();
    TextField adresaTextField=new TextField();
    TextField CNPTextField=new TextField();
    TextField telTextField=new TextField();
    TextField emailTextField=new TextField();

    TextFieldWithPlaceHolder create_new_user_usernameTextField=new TextFieldWithPlaceHolder("");
    PasswordFieldWithPlaceHolder create_new_user_passwordTextField=new PasswordFieldWithPlaceHolder("");
    TextFieldWithPlaceHolder create_new_user_numeTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder create_new_user_prenumeTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder create_new_user_adresaTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder create_new_user_CNPTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder create_new_user_telTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder create_new_user_emailTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder create_new_user_IBANTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder create_new_user_salariu_brutTextField=new TextFieldWithPlaceHolder();
    TextFieldWithPlaceHolder create_new_user_parafa_medicTextField=new TextFieldWithPlaceHolder();
    int nr_specializari=1;
    int[] nr_competente=new int[3];
    TextFieldWithPlaceHolder[] create_new_user_specializareTextField= new TextFieldWithPlaceHolder[3];
    TextFieldWithPlaceHolder[] create_new_user_competentaTextField= new TextFieldWithPlaceHolder[9];

    JButton modifyUserDataButton=new JButton("Modifica Date");
    JButton logoutButton=new JButton("Logout");
    String[] receptionerComboBox_String={"","Pacient"};
    String[] adminComboBox_String={"","Pacient","Medic","Asistent","Resurse Umane","Financiar","Receptioner"};
    String[] tip_asistent={"","generalist","laborator","radiologie"};
    String[] grad_asistent={"","secundar","principal"};
    String[] grad_medic={"","specialist","primar"};
    String[] titlu_medic={"","doctorand","doctor"};
    String[] post_medic={"","preparator","asistent","lector","conferentiar","profesor"};
    DefaultComboBoxModel<String> comboBoxModel_receptioner = new DefaultComboBoxModel<>( receptionerComboBox_String );
    DefaultComboBoxModel<String> comboBoxModel_admin = new DefaultComboBoxModel<>( adminComboBox_String );
    DefaultComboBoxModel<String> comboBoxModel_tip_asistent = new DefaultComboBoxModel<>( tip_asistent );
    DefaultComboBoxModel<String> comboBoxModel_grad_asistent = new DefaultComboBoxModel<>( grad_asistent );
    DefaultComboBoxModel<String> comboBoxModel_grad_medic = new DefaultComboBoxModel<>( grad_medic );
    DefaultComboBoxModel<String> comboBoxModel_titlu_medic = new DefaultComboBoxModel<>( titlu_medic );
    DefaultComboBoxModel<String> comboBoxModel_post_medic = new DefaultComboBoxModel<>( post_medic );

    JComboBox create_new_user_list=new JComboBox();
    JComboBox create_new_user_tip_asistent_list=new JComboBox();
    JComboBox create_new_user_grad_asistent_list=new JComboBox();
    JComboBox create_new_user_grad_medic_list=new JComboBox();
    JComboBox create_new_user_titlu_medic_list=new JComboBox();
    JComboBox create_new_user_post_medic_list=new JComboBox();
    JTabbedPane tabbedPane=new JTabbedPane();
    public AppView() throws HeadlessException {
        this.setPreferredSize(new Dimension(500,800));
        nr_competente[0]=1;
        for(int i=1;i<3;i++)nr_competente[i]=0;
        for(int i=0;i<3;i++)addCompetentaButton[i]=new JButton("Adauga Competenta");
        for(int i=0;i<3;i++)addCompetentaButton[i]=new JButton("Sterge Competenta");
        for(int i=0;i<3;i++){
            create_new_user_specializareTextField[i]=new TextFieldWithPlaceHolder();
            create_new_user_specializareTextField[i].setPlaceholder("Specializare "+i);
        }
        for(int i=0;i<9;i++){
            create_new_user_competentaTextField[i]=new TextFieldWithPlaceHolder();
            create_new_user_competentaTextField[i].setPlaceholder("Competenta "+(i%3));
        }

        JPanel textFields=new JPanel();

        logo.scaleImage(100,100);
        logoLabel.setIcon(logo);
        login.add(logoLabel);
        login.add(textFields);
        textFields.add(usernameTextField);
        textFields.add(passwordTextField);
        textFields.setLayout(new BoxLayout(textFields,BoxLayout.Y_AXIS));

        usernameTextField.setPlaceholder("username");
        passwordTextField.setPlaceholder("password");
        usernameTextField.setPreferredSize(new Dimension(100,25));
        passwordTextField.setPreferredSize(new Dimension(100,25));
        login.add(submitButton);

        date_user.add(numeLabel);
        date_user.add(numeTextField);
        date_user.add(prenumeLabel);
        date_user.add(prenumeTextField);
        date_user.add(CNPLabel);
        date_user.add(CNPTextField);
        date_user.add(emailLabel);
        date_user.add(emailTextField);
        date_user.add(adresaLabel);
        date_user.add(adresaTextField);
        date_user.add(telLabel);
        date_user.add(telTextField);
        date_user.add(new JLabel());
        date_user.add(modifyUserDataButton);
        //date_user.add(logoutButton);

        numeTextField.setPreferredSize(new Dimension(100,25));
        prenumeTextField.setPreferredSize(new Dimension(100,25));
        CNPTextField.setPreferredSize(new Dimension(100,25));
        emailTextField.setPreferredSize(new Dimension(100,25));
        adresaTextField.setPreferredSize(new Dimension(100,25));
        telTextField.setPreferredSize(new Dimension(100,25));
        date_user.setLayout(new GridLayout(7,2));


        initCreateNewUser();

        content.setLayout(new CardLayout());
        content.add(login,"login");
        content.add(interfata_user,"interfata_user");
        interfata_user_cards.setLayout(new CardLayout());
        interfata_user_cards.add(date_user,"date_user");
        interfata_user_cards.add(create_new_user,"create_new_user");
        interfata_user.add(tabbedPane);
        interfata_user.add(interfata_user_cards);
        interfata_user.add(logoutButton);
        interfata_user.setLayout(new BoxLayout(interfata_user,BoxLayout.Y_AXIS));

        tabbedPane.addTab("Date User",date_user);
        tabbedPane.addTab("Create User",create_new_user);




        //CardLayout cardLayout= (CardLayout) content.getLayout();
        //cardLayout.show(content,"date_user");
        this.setContentPane(content);
        this.pack();
        this.setTitle("Policlinica");


        //remove this
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public String getUsername(){
        return usernameTextField.getText();
    }
    public String getPassword(){
        return passwordTextField.getText();
    }
    public void addSubmitListener(ActionListener actionListener){
        submitButton.addActionListener(actionListener);
    }

    public void addModifyUserDataListener(ActionListener actionListener){
        modifyUserDataButton.addActionListener(actionListener);
    }
    public void addLogoutListener(ActionListener actionListener){
        logoutButton.addActionListener(actionListener);
    }
    public void addTipCreateUser(ActionListener actionListener){
        create_new_user_list.addActionListener(actionListener);
    }
    public void addCreateNewUserListener(ActionListener actionListener){
        createNewUserButton.addActionListener(actionListener);
    }
    public void clearUsername(){
        usernameTextField.setText("");
    }
    public void clearPassword(){
        passwordTextField.setText("");
    }
    public void displayLoginFail(){
        JOptionPane.showMessageDialog(this,
                "Wrong username/password",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE);
    }

    public void showDateUser(String id_user,String nume,String prenume,String CNP,String adresa,String tel,String email){
        CardLayout cardLayout= (CardLayout) content.getLayout();
        cardLayout.show(content,"interfata_user");


        //System.out.println(id_user);
        numeTextField.setText(nume);
        prenumeTextField.setText(prenume);
        CNPTextField.setText(CNP);
        adresaTextField.setText(adresa);
        telTextField.setText(tel);
        emailTextField.setText(email);
        //cardLayout.next(content);
    }

    public String getNumeFromTextField(){
        return numeTextField.getText();
    }

    public String getPrenumeFromTextField(){
        return prenumeTextField.getText();
    }

    public String getCNPFromTextField(){
        return CNPTextField.getText();
    }

    public String getAdresaFromTextField(){
        return adresaTextField.getText();
    }

    public String getTelFromTextField(){
        return telTextField.getText();
    }

    public String getEmailFromTextField(){
        return emailTextField.getText();
    }

    public boolean modifyUserDataConfirmation(){
        int rez=JOptionPane.showConfirmDialog(
                this,
                "Suntenti sigur/a ca vreti sa va modificati datele?",
                "Modificare Date",
                JOptionPane.YES_NO_OPTION);
        if(rez==0)
            return true;
        return false;
    }

    public void logout(){
        CardLayout cardLayout= (CardLayout) content.getLayout();
        cardLayout.show(content,"login");
        usernameTextField.setText("");
        passwordTextField.setText("");
        tabbedPane.setSelectedComponent(date_user);
        createUserReset();
    }

    private void initCreateNewUser(){
        JLabel create_new_user_usernameLabel=new JLabel("Username:");
        JLabel create_new_user_passwordLabel=new JLabel("Password:");
        JLabel create_new_user_numeLabel=new JLabel("Nume:");
        JLabel create_new_user_prenumeLabel=new JLabel("Prenume:");
        JLabel create_new_user_adresaLabel=new JLabel("Adresa:");
        JLabel create_new_user_CNPLabel=new JLabel("CNP:");
        JLabel create_new_user_telLabel=new JLabel("Tel:");
        JLabel create_new_user_emailLabel=new JLabel("Email:");
        create_new_user_usernameTextField.setPlaceholder("Username");
        create_new_user_passwordTextField.setPlaceholder("Parola");
        create_new_user_numeTextField.setPlaceholder("ex: Popescu");
        create_new_user_prenumeTextField.setPlaceholder("ex: Gigel");
        create_new_user_adresaTextField.setPlaceholder("ex: Str Lalelelor Nr 40");
        create_new_user_emailTextField.setPlaceholder("ex: myemail@youremail.com");
        create_new_user_telTextField.setPlaceholder("ex: +05544223311");
        create_new_user_CNPTextField.setPlaceholder("ex: 0998877665544");
        create_new_user.add(create_new_user_usernameLabel);
        create_new_user.add(create_new_user_usernameTextField);
        create_new_user.add(create_new_user_passwordLabel);
        create_new_user.add(create_new_user_passwordTextField);
        create_new_user.add(create_new_user_numeLabel);
        create_new_user.add(create_new_user_numeTextField);
        create_new_user.add(create_new_user_prenumeLabel);
        create_new_user.add(create_new_user_prenumeTextField);
        create_new_user.add(create_new_user_CNPLabel);
        create_new_user.add(create_new_user_CNPTextField);
        create_new_user.add(create_new_user_emailLabel);
        create_new_user.add(create_new_user_emailTextField);
        create_new_user.add(create_new_user_adresaLabel);
        create_new_user.add(create_new_user_adresaTextField);
        create_new_user.add(create_new_user_telLabel);
        create_new_user.add(create_new_user_telTextField);
        create_new_user.add(new JLabel("Tip cont:"));
        create_new_user.add(create_new_user_list);
        create_new_user.add(IBANLabel);
        create_new_user.add(create_new_user_IBANTextField);
        create_new_user.add(salariu_brutLabel);
        create_new_user.add(create_new_user_salariu_brutTextField);
        create_new_user.add(tipAsistentLabel);
        create_new_user.add(create_new_user_tip_asistent_list);
        create_new_user.add(gradAsistentLabel);
        create_new_user.add(create_new_user_grad_asistent_list);
        create_new_user.add(gradMedicLabel);
        create_new_user.add(create_new_user_grad_medic_list);
        create_new_user.add(parafaLabel);
        create_new_user.add(create_new_user_parafa_medicTextField);
        create_new_user.add(titluLabel);
        create_new_user.add(create_new_user_titlu_medic_list);
        create_new_user.add(postLabel);
        create_new_user.add(create_new_user_post_medic_list);
        create_new_user.add(createNewUserButton);
        create_new_user.add(new JLabel());
        //add specializare competenta

        create_new_user_tip_asistent_list.setModel(comboBoxModel_tip_asistent);
        create_new_user_list.setModel(comboBoxModel_admin);
        create_new_user_grad_asistent_list.setModel(comboBoxModel_grad_asistent);
        create_new_user_grad_medic_list.setModel(comboBoxModel_grad_medic);
        create_new_user_titlu_medic_list.setModel(comboBoxModel_titlu_medic);
        create_new_user_post_medic_list.setModel(comboBoxModel_post_medic);

        //hide specials
        IBANLabel.setVisible(false);
        create_new_user_IBANTextField.setVisible(false);
        salariu_brutLabel.setVisible(false);
        create_new_user_salariu_brutTextField.setVisible(false);
        tipAsistentLabel.setVisible(false);
        create_new_user_tip_asistent_list.setVisible(false);
        gradAsistentLabel.setVisible(false);
        create_new_user_grad_asistent_list.setVisible(false);
        gradMedicLabel.setVisible(false);
        create_new_user_grad_medic_list.setVisible(false);
        parafaLabel.setVisible(false);
        create_new_user_parafa_medicTextField.setVisible(false);
        titluLabel.setVisible(false);
        create_new_user_titlu_medic_list.setVisible(false);
        postLabel.setVisible(false);
        create_new_user_post_medic_list.setVisible(false);

        create_new_user.setLayout(new GridLayout(20,2));
    }

    public String getTipCreateUser(){
        return create_new_user_list.getSelectedItem().toString();
    }

    public void displayForPacient(){
        IBANLabel.setVisible(false);
        create_new_user_IBANTextField.setVisible(false);
        salariu_brutLabel.setVisible(false);
        create_new_user_salariu_brutTextField.setVisible(false);
        tipAsistentLabel.setVisible(false);
        create_new_user_tip_asistent_list.setVisible(false);
        gradAsistentLabel.setVisible(false);
        create_new_user_grad_asistent_list.setVisible(false);
        gradMedicLabel.setVisible(false);
        create_new_user_grad_medic_list.setVisible(false);
        parafaLabel.setVisible(false);
        create_new_user_parafa_medicTextField.setVisible(false);
        titluLabel.setVisible(false);
        create_new_user_titlu_medic_list.setVisible(false);
        postLabel.setVisible(false);
        create_new_user_post_medic_list.setVisible(false);

    }
    public void displayForMedic(){
        IBANLabel.setVisible(true);
        create_new_user_IBANTextField.setVisible(true);
        salariu_brutLabel.setVisible(true);
        create_new_user_salariu_brutTextField.setVisible(true);
        tipAsistentLabel.setVisible(false);
        create_new_user_tip_asistent_list.setVisible(false);
        gradAsistentLabel.setVisible(false);
        create_new_user_grad_asistent_list.setVisible(false);
        gradMedicLabel.setVisible(true);
        create_new_user_grad_medic_list.setVisible(true);
        parafaLabel.setVisible(true);
        create_new_user_parafa_medicTextField.setVisible(true);
        titluLabel.setVisible(true);
        create_new_user_titlu_medic_list.setVisible(true);
        postLabel.setVisible(true);
        create_new_user_post_medic_list.setVisible(true);
    }

    public void displayForAsistent(){
        IBANLabel.setVisible(true);
        create_new_user_IBANTextField.setVisible(true);
        salariu_brutLabel.setVisible(true);
        create_new_user_salariu_brutTextField.setVisible(true);
        tipAsistentLabel.setVisible(true);
        create_new_user_tip_asistent_list.setVisible(true);
        gradAsistentLabel.setVisible(true);
        create_new_user_grad_asistent_list.setVisible(true);
        gradMedicLabel.setVisible(false);
        create_new_user_grad_medic_list.setVisible(false);
        parafaLabel.setVisible(false);
        create_new_user_parafa_medicTextField.setVisible(false);
        titluLabel.setVisible(false);
        create_new_user_titlu_medic_list.setVisible(false);
        postLabel.setVisible(false);
        create_new_user_post_medic_list.setVisible(false);
    }
    public void displayForRest(){
        IBANLabel.setVisible(true);
        create_new_user_IBANTextField.setVisible(true);
        salariu_brutLabel.setVisible(true);
        create_new_user_salariu_brutTextField.setVisible(true);
        tipAsistentLabel.setVisible(false);
        create_new_user_tip_asistent_list.setVisible(false);
        gradAsistentLabel.setVisible(false);
        create_new_user_grad_asistent_list.setVisible(false);
        gradMedicLabel.setVisible(false);
        create_new_user_grad_medic_list.setVisible(false);
        parafaLabel.setVisible(false);
        create_new_user_parafa_medicTextField.setVisible(false);
        titluLabel.setVisible(false);
        create_new_user_titlu_medic_list.setVisible(false);
        postLabel.setVisible(false);
        create_new_user_post_medic_list.setVisible(false);
    }
    public void hideCreateNewUser(){
        create_new_user.setVisible(false);
    }
    public void showCreateNewUser(){
        create_new_user.setVisible(true);
    }
    public void createUserReset(){
        create_new_user_usernameTextField.setText("");
        create_new_user_passwordTextField.setText("");
        create_new_user_numeTextField.setText("");
        create_new_user_prenumeTextField.setText("");
        create_new_user_CNPTextField.setText("");
        create_new_user_emailTextField.setText("");
        create_new_user_adresaTextField.setText("");
        create_new_user_telTextField.setText("");
        create_new_user_list.setSelectedIndex(0);
        create_new_user_IBANTextField.setText("");
        create_new_user_salariu_brutTextField.setText("");
        create_new_user_tip_asistent_list.setSelectedIndex(0);
        create_new_user_grad_asistent_list.setSelectedIndex(0);
        create_new_user_grad_medic_list.setSelectedIndex(0);
        create_new_user_parafa_medicTextField.setText("");
        create_new_user_titlu_medic_list.setSelectedIndex(0);
        create_new_user_post_medic_list.setSelectedIndex(0);
    }

    public String getUsernameCreateNewUser(){
        return create_new_user_usernameTextField.getText();
    }
    public String getPasswordCreateNewUser(){
        return create_new_user_passwordTextField.getText();
    }
    public String getNumeCreateNewUser(){
        return create_new_user_numeTextField.getText();
    }
    public String getPrenumeCreateNewUser(){
        return create_new_user_prenumeTextField.getText();
    }
    public String getCNPCreateNewUser(){
        return create_new_user_CNPTextField.getText();
    }
    public String getEmailCreateNewUser(){
        return create_new_user_emailTextField.getText();
    }
    public String getAdresaCreateNewUser(){
        return create_new_user_adresaTextField.getText();
    }
    public String getTelCreateNewUser(){
        return create_new_user_telTextField.getText();
    }
    public String getIBANCreateNewUser(){
        return create_new_user_IBANTextField.getText();
    }
    public String getSalariuCreateNewUser(){
        return create_new_user_salariu_brutTextField.getText();
    }
    public String getTipAsistentCreateNewUser(){
        return create_new_user_tip_asistent_list.getSelectedItem().toString();
    }
    public String getGradAsistentCreateNewUser(){
        return create_new_user_grad_asistent_list.getSelectedItem().toString();
    }
    public String getGradMedicCreateNewUser(){
        return create_new_user_grad_medic_list.getSelectedItem().toString();
    }
    public String getParafaCreateNewUser(){
        return create_new_user_parafa_medicTextField.getText();
    }
    public String getTitluMedicCreateNewUser(){
        return create_new_user_titlu_medic_list.getSelectedItem().toString();
    }
    public String getPostMedicCreateNewUser(){
        return create_new_user_post_medic_list.getSelectedItem().toString();
    }
    public boolean createNewUserConfirmation(){
        int rez=JOptionPane.showConfirmDialog(
                this,
                "Suntenti sigur/a ca vreti sa creati user nou?",
                "Creeare User",
                JOptionPane.YES_NO_OPTION);
        if(rez==0)
            return true;
        return false;
    }
}
