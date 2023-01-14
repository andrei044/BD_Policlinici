import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppController {
    private App app;
    private AppView appView;

    private String id_user;

    public AppController(App app, AppView appView) {
        this.app = app;
        this.appView = appView;
        app.init("root","root");
        appView.addSubmitListener(new submitListener());
        appView.addModifyUserDataListener(new modifyUserDataListener());
        appView.addLogoutListener(new logoutListener());
        appView.addTipCreateUser(new tipCreateUserListener());
        appView.addCreateNewUserListener(new createNewUserListener());
    }

    class submitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String username= appView.getUsername();
            String password= appView.getPassword();
//            //if(app.login(username,password)){
//                id_user=app.getLoginID(username,password);
//                System.out.println("ID:"+id_user);
////                String nume=app.getUserDataByID(id_user,"nume");
////                String prenume=app.getUserDataByID(id_user,"prenume");
////                String CNP=app.getUserDataByID(id_user,"CNP");
////                String email=app.getUserDataByID(id_user,"email");
////                String adresa=app.getUserDataByID(id_user,"adresa");
////                String tel=app.getUserDataByID(id_user,"tel");
////                ResultSet rez=app.getUserDataByID(id_user);
////                String nume,prenume,CNP,adresa,tel,email;
////                nume=prenume=CNP=adresa=tel=email="";
////                try{
////                    rez.next();
////                    Object object;
////                    object=rez.getObject(2);
////                    nume=object.toString();
////                    object=rez.getObject(3);
////                    prenume=object.toString();
////                    object=rez.getObject(4);
////                    CNP=object.toString();
////                    object=rez.getObject(5);
////                    adresa=object.toString();
////                    object=rez.getObject(6);
////                    tel=object.toString();
////                    object=rez.getObject(7);
////                    email=object.toString();
////                }
////                catch(SQLException ex){
////                    System.err.println("SQLException: "+ex);
////                }
//
//                //appView.showDateUser(id_user,nume,prenume,CNP,adresa,tel,email);
//                System.out.println("Login succes!");
//            }
//
//            else{
//                appView.clearUsername();
//                appView.clearPassword();
//                appView.displayLoginFail();
//            }
        }
    }
    class modifyUserDataListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView.modifyUserDataConfirmation()){
                String nume=appView.getNumeFromTextField();
                String prenume=appView.getPrenumeFromTextField();
                String CNP= appView.getCNPFromTextField();
                String adresa= appView.getAdresaFromTextField();
                String email= appView.getEmailFromTextField();
                String tel= appView.getTelFromTextField();
                app.updateUserDataByID(id_user,nume,prenume,CNP,adresa,tel,email);
            }
        }
    }
    class logoutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            id_user=null;
            appView.logout();
            System.out.println("Logout succes!");
        }
    }

    class tipCreateUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String tip=appView.getTipCreateUser();
            System.out.println(tip);
            if(tip.equals("Pacient") || tip.equals("")){
                appView.displayForPacient();
            }else if(tip.equals("Medic")){
                appView.displayForMedic();
            }else if(tip.equals("Asistent")){
                appView.displayForAsistent();
            }else
                appView.displayForRest();
        }
    }

    class createNewUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView.createNewUserConfirmation()){
                String tip=appView.getTipCreateUser();
                String username=appView.getUsernameCreateNewUser();
                String password=appView.getPasswordCreateNewUser();
                String nume=appView.getNumeCreateNewUser();
                String prenume=appView.getPrenumeCreateNewUser();
                String CNP=appView.getCNPCreateNewUser();
                String email=appView.getEmailCreateNewUser();
                String adresa=appView.getAdresaCreateNewUser();
                String tel=appView.getTelCreateNewUser();
//                String new_id_user=app.insertUser(username,password,nume,prenume,CNP,adresa,tel,email);
//                app.insertLogin(new_id_user,username,password);
//                if(tip.equals("Pacient")){
//                    app.insertPacient(new_id_user);
//                }else{
//                    String IBAN=appView.getIBANCreateNewUser();
//                    String salariu=appView.getSalariuCreateNewUser();
//                    app.insertAngajat(new_id_user,IBAN,tip,salariu);
//                    if(tip.equals("Asistent")){
//                        String tip_asistent=appView.getTipAsistentCreateNewUser();
//                        String grad_asistent=appView.getGradAsistentCreateNewUser();
//                        app.insertAsistent(new_id_user,tip_asistent,grad_asistent);
//                    }else if(tip.equals("Medic")){
//                        String grad_medic=appView.getGradMedicCreateNewUser();
//                        String parafa=appView.getParafaCreateNewUser();
//                        String titlu=appView.getTitluMedicCreateNewUser();
//                        String post=appView.getPostMedicCreateNewUser();
//                        app.insertMedic(new_id_user,grad_medic,parafa,titlu,post);
//                    }
//                }
//                appView.createUserReset();
            }
        }
    }
}
