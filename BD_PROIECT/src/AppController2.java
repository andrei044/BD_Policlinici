import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppController2 {
    AppView2 appView2;
    App app;

    public AppController2(AppView2 appView2, App app) {
        this.appView2 = appView2;
        this.app = app;
        app.init("root","root");
        appView2.addSubmitListener(new SubmitListener());
        appView2.addLogoutListener(new LogoutListener());
        appView2.addComboBoxCreateUserListener(new ComboBoxCreateUserListener());
        appView2.getUiPanel().getCreateUserCard().addAdaugaCompetentaListener(new AddCompetentaListener());
        appView2.getUiPanel().getCreateUserCard().addRemoveCompetentaListener(new RemoveCompetentaListener());
        appView2.addAddSpecializareCreateUserListener(new AddSpecializareCreateUserListener());
        appView2.addRemoveSpecializareCreateUserListener(new RemoveSpecializareCreateUserListener());
        appView2.addNextCreateUserListener(new NextCreateUserListener());
        appView2.addBackCreateUserListener(new BackCreateUserListener());
        appView2.addSubmitCreateUserListener(new SubmitCreateUserListener());
        appView2.addCautaAngajatListener(new CautaAngajatListener());
        appView2.addVeziAngajatListener(new VeziAngajatListener());
        appView2.getUiPanel().getCautaAngajatCard().addCautaAngajatBackListener(new CautaAngajatBackListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziMedicPanel().addAddCompetentaListener(new AddCompetentaListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziMedicPanel().addRemoveCompetentaListener(new RemoveCompetentaListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziMedicPanel().addAddSpecializareListener(new AddSpecializareListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziMedicPanel().addRemoveSpecializareListener(new RemoveSpecializareListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziAngajatPanel().addModificaListener(new ModificaAngajatCautaAngajatListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziMedicPanel().addModificaButtonListener(new ModificaMedicCautaAngajatListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziAsistentPanel().addModificaListener(new ModificaAsistentCautaAngajatListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getCreateProgramPanel().addModificaListener(new ModificaProgramCautaAngajatListener());
        appView2.getUiPanel().getProgramareCard().addCautaPacientListener(new CautaPacientListener());
        appView2.getUiPanel().getProgramareCard().addSelectPacientListener(new SelectPacientListener());
        appView2.getUiPanel().getProgramareCard().addCautaServiciuListener(new CautaServiciuListener());
        appView2.getUiPanel().getProgramareCard().addSelectServiciuListener(new SelectServiciuListener());
        appView2.getUiPanel().getProgramareCard().addVeziProgramPeDataListener(new VeziProgramPeDataListener());
        appView2.getUiPanel().getProgramareCard().addBackToServiciiListener(new BackToServiciiListener());
        appView2.getUiPanel().getProgramareCard().getSchedulerPanel().addClickInsideSchedulerListener(new ClickInsideScheduler());
        appView2.getUiPanel().getProgramareCard().addConfirmProgramareListener(new ConfirmProgramareListener());
        appView2.getUiPanel().getProgramareCard().addBackToPacientiListener(new BackToPacientiListener());
        appView2.getUiPanel().getRaportCard().addCautaProgramareListener(new CautaProgramareListener());
        appView2.getUiPanel().getRaportCard().addSelectProgramareListener(new SelectProgramareListener());
        appView2.getUiPanel().getRaportCard().addParafeazaListener(new ParafeazaListener());
        appView2.getUiPanel().getRaportCard().addBackParafeazaListener(new BackParafeazaListener());
        appView2.getUiPanel().getRaportCard().addValideazaListener(new ValideazaListener());
        appView2.getUiPanel().getRaportCard().addVeziAziListener(new VeziProgramariAziListener());
        appView2.getUiPanel().getEmiteFacturaCard().addSelectListener(new SelectEmiteFacturaListener());
        appView2.getUiPanel().getEmiteFacturaCard().addRefreshListener(new RefreshEmiteFacturaListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getConcediuPanel().addRefreshListener(new RefreshConcediuListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getConcediuPanel().addAdaugaConcediuListener(new AdaugaConcediuListener());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().addVeziProgramPeDataListener(new VeziProgramSpecific());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().addClickInsideSchedulerListener(new ClickInsideSchedulerProgramSpecific());
        appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().addConfirmProgramareListener(new ConfirmProgramSpecificListener());
        appView2.getUiPanel().getSalariuAngajatCard().addVeziSalariuListener(new VeziSalariuListener());
        appView2.getUiPanel().getProfitPoliclinicaCard().addVeziAngajatListener(new VeziAngajatFinanciarListener());
        appView2.getUiPanel().getProfitPoliclinicaCard().addVeziMedicListener(new VeziMedicFinanciarListener());
        appView2.getUiPanel().getProfitPoliclinicaCard().addVeziUnitateListener(new VeziLocatieFinanciarListener());
        appView2.getUiPanel().getProfitPoliclinicaCard().addVeziSpecializareListener(new VeziSpecializareFinanciarListener());
        appView2.getUiPanel().getProfitPoliclinicaCard().addVeziTotalListener(new VeziTotalFinanciarListener());
        appView2.getUiPanel().getDeleteUserCard().addVeziDeleteUserListener(new VeziDeleteListener());
        appView2.getUiPanel().getDeleteUserCard().addDeleteUserListener(new DeleteListener());
        appView2.getUiPanel().getStergeProgramarePane().addStergeListener(new StergeProgramareListener());
        appView2.getUiPanel().getStergeProgramarePane().addVeziListener(new VeziProgramareListener());
    }
    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username= appView2.getUsername();
            String password= appView2.getPassword();
            String id_user=app.login(username,password);
            if(id_user!=null){
                Angajat angajat=app.getUserDataByID(id_user);
                appView2.getUiPanel().getCreateUserCard().reset();
                appView2.getUiPanel().getShowUserCard().setAll(angajat);
                if(app.checkForAdmin()==null){
                    if(angajat.getFunctie().equals("Medic"))
                        appView2.getUiPanel().showForMedic();
                    else if(angajat.getFunctie().equals("Receptioner")){
                        appView2.getUiPanel().showForRecep();
                    }
                    else if(angajat.getFunctie().equals("Resurse Umane"))
                        appView2.getUiPanel().showForHR();
                    else if(angajat.getFunctie().equals("Financiar"))
                        appView2.getUiPanel().showForFinanciar();
                    else if(angajat.getFunctie().equals("Asistent"))
                        appView2.getUiPanel().showForAsistent();
                }else{
                    if(app.checkForAdmin().equals("Superadmin")){
                        appView2.getUiPanel().showForAdmin();
                    }else{
                        appView2.getUiPanel().showForSuperadmin();
                    }
                }
                if(app.getCurrentUserFunctie().equals("Medic"))appView2.getUiPanel().getSalariuAngajatCard().showForMedic();
                else appView2.getUiPanel().getSalariuAngajatCard().showForAngajat();
                //appView2.login(angajat);
                appView2.next();
                System.out.println("Login succes!");
                appView2.getUiPanel().getProgramareCard().reset();
                appView2.getUiPanel().getRaportCard().reset();
                appView2.getUiPanel().getEmiteFacturaCard().reset();
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().reset();
                appView2.getUiPanel().getCautaAngajatCard().reset();
                appView2.getUiPanel().getSalariuAngajatCard().resetContent();
                appView2.getUiPanel().getProfitPoliclinicaCard().reset();
                appView2.getUiPanel().reset();
            }
            else{
                appView2.resetLogin();
                appView2.displayLoginFail();
            }
        }
    }
    class LogoutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            appView2.logout();
            System.out.println("Logout succes!");
            appView2.getUiPanel().getProgramareCard().reset();
            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().reset();
        }
    }
    class ComboBoxCreateUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String tip=appView2.getUiPanel().getCreateUserCard().getFunctie();
            //System.out.println(tip);
            if(tip.equals("Medic")){
                appView2.getUiPanel().getCreateUserCard().displayForMedic();
            }else if(tip.equals("Asistent")){
                appView2.getUiPanel().getCreateUserCard().displayForAsistent();
            }else if(tip.equals("Pacient"))
                appView2.getUiPanel().getCreateUserCard().displayForPacient();
            else
                appView2.displayCreateUserForRest();
        }
    }
    class AddSpecializareCreateUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            appView2.addSpecializareCreateUser();
        }
    }
    class RemoveSpecializareCreateUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            appView2.removeSpecializareCreateUser();
        }
    }

    class NextCreateUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String tip=appView2.getFunctieCreateUser();
            if(appView2.getUiPanel().getCreateUserCard().verif()){
                if(tip.equals("Pacient")){
                    if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Sunteti sigur/a ca vreti sa introduceti pacientul?", "Introduce User", JOptionPane.YES_NO_OPTION)==0){
                        System.out.println(appView2.getPacientCreateUser().toString());
                        app.insertPacient(appView2.getPacientCreateUser());
                        appView2.resetCreateUser();
                        JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                                "Pacient introdus cu succes.",
                                "Introduce User",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                }else {
                    appView2.nextCreateUser();
                    appView2.getUiPanel().getCreateProgramPanel().getProgramUnitatePanel().setContent(app.getAllProgramUnitate());
                }
            }else{
                JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                        "Date introduse gresit",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    class BackCreateUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            appView2.backCreateUser();
        }
    }
    class SubmitCreateUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView2.getUiPanel().getCreateProgramPanel().verif()){
                if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Sunteti sigur/a ca vreti sa introduceti utilizatorul?", "Introduce User", JOptionPane.YES_NO_OPTION)==0){
                    String tip=appView2.getFunctieCreateUser();
                    appView2.createUser();
                    appView2.getUiPanel().nextCreateUser();
                    System.out.println("OK");
                    if(tip.equals("Medic")){
                        System.out.println(appView2.getMedicCreateUser().toString());
                        app.insertMedic(appView2.getMedicCreateUser());
                    }else if(tip.equals("Asistent")){
                        System.out.println(appView2.getAsistentCreateUser().toString());
                        app.insertAsistent(appView2.getAsistentCreateUser());
                    }else{
                        System.out.println(appView2.getAngajatCreateUser().toString());
                        app.insertAngajat(appView2.getAngajatCreateUser());
                    }
                    appView2.resetCreateUser();
                    JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                            "Angajat introdus cu succes.",
                            "Introduce User",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                        "Date introduse gresit",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class CautaAngajatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String nume=appView2.getCautaAngajatNume();
            String prenume=appView2.getCautaAngajatPrenume();
            List<Angajat> lista=app.getCautaAngajatList(nume,prenume);

            appView2.showCautaAngajatResult(lista);
        }
    }
    class VeziAngajatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jButton=(JButton) e.getSource();
            CautaAngajatScrollField jPanel=(CautaAngajatScrollField) jButton.getParent();
            String id_apasat=jPanel.getIdAngajat();
            Angajat angajat=app.getVeziDetaliiAngajat(id_apasat);
            if(angajat instanceof Medic){

                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().showForMedic();
                System.out.println((Medic)angajat);
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().setUnitati(app.getUnitati());
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziMedicPanel().reset();
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziMedicPanel().setAll((Medic) angajat);
            }else if(angajat instanceof Asistent){

                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().showForAsistent();
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziAsistentPanel().setAll(((Asistent) angajat).getTip(),((Asistent) angajat).getGrad());
            }else{
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().showForAngajat();
            }

            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziAngajatPanel().setAll(angajat);
            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getCreateProgramPanel().setProgramGeneric(angajat.getProgramGeneric());
            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getConcediuPanel().resetContent();
            appView2.getUiPanel().getCautaAngajatCard().nextCard();
        }
    }
    class CautaAngajatBackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            appView2.getUiPanel().getCautaAngajatCard().nextCard();
            appView2.getUiPanel().getCautaAngajatCard().hideBackButton();
            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().reset();
        }
    }
    class AddCompetentaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SpecializareField specializareField= (SpecializareField) ((Component)e.getSource()).getParent().getParent();
            specializareField.addCompetenta();

        }
    }
    class RemoveCompetentaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SpecializareField specializareField=(SpecializareField) ((Component)e.getSource()).getParent().getParent();
            specializareField.removeCompetenta();
        }
    }
    class AddSpecializareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ShowUserVeziMedicPanel showUserVeziMedicPanel= (ShowUserVeziMedicPanel) ((Component)e.getSource()).getParent().getParent();

            showUserVeziMedicPanel.addSpecializareField();
        }
    }
    class RemoveSpecializareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ShowUserVeziMedicPanel showUserVeziMedicPanel= (ShowUserVeziMedicPanel) ((Component)e.getSource()).getParent().getParent();
            showUserVeziMedicPanel.removeSpecializare();
        }
    }
    class ModificaAngajatCautaAngajatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Angajat angajat=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getAngajat();
            app.updateUser(angajat);
            app.updateAngajat(angajat);
        }
    }
    class ModificaAsistentCautaAngajatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Asistent asistent= (Asistent) appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getAngajat();
            app.updateAsistent(asistent);
        }
    }
    class ModificaMedicCautaAngajatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Medic medic= (Medic) appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getAngajat();
            for(int i=0;i<medic.getNrSpecializari();i++){
                for(int j=0;j<medic.getSpecializare(i).getNrCompetente();j++){
                    System.out.println(medic.getSpecializare(i).getCompetenta(j)+" "+medic.getSpecializare(i).getPret(j)+" "+medic.getSpecializare(i).getDurata(j));
                }
                System.out.println();
            }
            app.updateMedic(medic);
        }
    }
    class ModificaProgramCautaAngajatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Angajat angajat=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getAngajat();
            ProgramGeneric programGeneric=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getCreateProgramPanel().getProgramGeneric();
            app.updateProgram(angajat.getId_user(),programGeneric);
        }
    }

    class CautaPacientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String nume=appView2.getUiPanel().getProgramareCard().getNumePacient();
            String prenume=appView2.getUiPanel().getProgramareCard().getPrenumePacient();

            List<User> lista=app.getCautaPacientList(nume,prenume);

            appView2.getUiPanel().getProgramareCard().showCautaPacientResult(lista);
        }
    }

    class SelectPacientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jButton=(JButton) e.getSource();
            ProgramarePacientScrollField jPanel=(ProgramarePacientScrollField) jButton.getParent();
            String id_apasat=jPanel.getIdPacient();
            appView2.getUiPanel().getProgramareCard().nextCard();
            appView2.getUiPanel().getProgramareCard().setId_pacient(jPanel.getIdPacient());
        }
    }

    class CautaServiciuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String denumire=appView2.getUiPanel().getProgramareCard().getDenumireServiciu();
            List<Serviciu>lista=app.getCautaServiciuList(denumire);
            appView2.getUiPanel().getProgramareCard().showCautaServiciutResult(lista);
        }
    }

    class SelectServiciuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jButton=(JButton) e.getSource();
            ProgramareServiciuScrollField jpanel= (ProgramareServiciuScrollField) jButton.getParent();
            appView2.getUiPanel().getProgramareCard().nextCard();
            appView2.getUiPanel().getProgramareCard().setId_serviciu(jpanel.getIdServiciu());
            appView2.getUiPanel().getProgramareCard().resetSchedulerPanel();
            System.out.println(jpanel.getDurataServiciu());
            appView2.getUiPanel().getProgramareCard().setDurataServiciu(jpanel.getDurataServiciu());
        }
    }

    class VeziProgramPeDataListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String data_programare=appView2.getUiPanel().getProgramareCard().getDataProgramare();
            LocalDate now = LocalDate.now();
            LocalDate myDate=LocalDate.parse(data_programare);
            if(myDate.isBefore(now)){
                JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                        "Data este din trecut",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
            else{
                String idServiciu = appView2.getUiPanel().getProgramareCard().getId_serviciu();
                IntervalOre intervalOre = app.getProgramPeData(idServiciu, data_programare);
                List<ProgramSpecific> programSpecificList = app.getProgramSpecific(idServiciu, data_programare);
                Concediu concediu = app.getConcediuPeData(idServiciu, data_programare);
                List<Programare> programareList = app.getProgramariPeData(idServiciu, data_programare);
//            System.out.println(intervalOre.toString());
//            System.out.println(programSpecificList);
//            System.out.println(concediu);
//            System.out.println(programareList);
                appView2.getUiPanel().getProgramareCard().getSchedulerPanel().reset();
                appView2.getUiPanel().getProgramareCard().getSchedulerPanel().set(intervalOre.getOraStart(), intervalOre.getOraStop(), programSpecificList, programareList, concediu);
            }
        }
    }
    class BackToServiciiListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            appView2.getUiPanel().getProgramareCard().setShowServicii();
        }
    }

    class ClickInsideScheduler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SchedulerPanelButton schedulerPanelButton=(SchedulerPanelButton)e.getSource();
            appView2.getUiPanel().getProgramareCard().getSchedulerPanel().buttonClicked(schedulerPanelButton);
        }
    }
    class ConfirmProgramareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Suntenti sigur/a ca vreti sa creati o programare noua?", "Programare", JOptionPane.YES_NO_OPTION)==0){
                if(appView2.getUiPanel().getProgramareCard().getDataProgramare()!=null && appView2.getUiPanel().getProgramareCard().getSchedulerPanel().verif()){
                    if(appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getMinutes().equals(appView2.getUiPanel().getProgramareCard().getDurataRecomandata())){
                        if(app.insertProgramare(appView2.getUiPanel().getProgramareCard().getId_pacient(),
                                appView2.getUiPanel().getProgramareCard().getId_serviciu(),
                                app.getCurrentUserId(),
                                appView2.getUiPanel().getProgramareCard().getDataProgramare(),
                                appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getOreButoane().getOraStart(),
                                appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getOreButoane().getOraStop()))
                        {
                            JOptionPane.showMessageDialog((Component) e.getSource(),
                                    "Introdus cu succes.",
                                    "Programare",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog((Component) e.getSource(),
                                    "Eroare la introducere in BD",
                                    "Eroare",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        //System.out.println("OK"+appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getOreButoane().toString()+appView2.getUiPanel().getProgramareCard().getId_serviciu());
                        appView2.getUiPanel().getProgramareCard().getSchedulerPanel().reset();
                    }else{
                        if(JOptionPane.showConfirmDialog((Component) e.getSource(),
                                "Timp ales:"+appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getMinutes()+"\n"+appView2.getUiPanel().getProgramareCard().getDurataRecomandata()+
                                        "\nInterval ales diferit de cel recomandat. Confirmati programarea?"
                                , "Programare", JOptionPane.YES_NO_OPTION)==0){
                            if(app.insertProgramare(appView2.getUiPanel().getProgramareCard().getId_pacient(),
                                    appView2.getUiPanel().getProgramareCard().getId_serviciu(),
                                    app.getCurrentUserId(),
                                    appView2.getUiPanel().getProgramareCard().getDataProgramare(),
                                    appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getOreButoane().getOraStart(),
                                    appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getOreButoane().getOraStop()))
                            {
                                JOptionPane.showMessageDialog((Component) e.getSource(),
                                        "Introdus cu succes.",
                                        "Programare",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog((Component) e.getSource(),
                                        "Eroare la introducere in BD",
                                        "Eroare",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            //System.out.println("OK"+appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getOreButoane().toString()+appView2.getUiPanel().getProgramareCard().getId_serviciu());
                            appView2.getUiPanel().getProgramareCard().getSchedulerPanel().reset();
                        }
                    }


                }
                else{
                    JOptionPane.showMessageDialog((Component) e.getSource(),
                            "Ati intordus gresit intervalul sau nu ati selectat data",
                            "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                    appView2.getUiPanel().getProgramareCard().getSchedulerPanel().reset();
                }
            }
        }
    }

    class BackToPacientiListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            appView2.getUiPanel().getProgramareCard().setShowPacienti();
        }
    }
    class CautaProgramareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(app.getCurrentUserFunctie().equals("Asistent") || app.getCurrentUserFunctie().equals("Admin")){
                List<CreeazaRaportField>list=app.getCautaProgramareAsistent();
                appView2.getUiPanel().getRaportCard().showCautaPacientResult(list);
            }
            else{
                List<CreeazaRaportField>list=app.getCautaProgramareMedic();
                //System.out.println(list);
                appView2.getUiPanel().getRaportCard().showCautaPacientResult(list);
            }
        }
    }

    class SelectProgramareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(app.getCurrentUserFunctie());
            if(app.getCurrentUserFunctie().equals("Asistent")){
                CreeazaRaportScrollField x=(CreeazaRaportScrollField)(((Component)e.getSource()).getParent());
                appView2.getUiPanel().getRaportCard().setShowAnalize();
                if(x.getId_analize().equals("null")){
                    appView2.getUiPanel().getRaportCard().resetAnalize();
                    appView2.getUiPanel().getRaportCard().setAnalizeEditable(true);
                    appView2.getUiPanel().getRaportCard().setIdProgramare(((CreeazaRaportScrollField)((Component)e.getSource()).getParent()).getId_programare());
                }else{
                    appView2.getUiPanel().getRaportCard().setAnalizeEditable(false);
                    appView2.getUiPanel().getRaportCard().showAnalize(app.getAnalizeDetails(x.getId_analize()));
                }
            }
            else{
                CreeazaRaportScrollField x=(CreeazaRaportScrollField)(((Component)e.getSource()).getParent());
                appView2.getUiPanel().getRaportCard().setShowRaport();
                if(x.getId_raport().equals("null")){
                    appView2.getUiPanel().getRaportCard().resetParafeaza();
                    appView2.getUiPanel().getRaportCard().setRaportEditable(true);
                    appView2.getUiPanel().getRaportCard().setIdProgramare(((CreeazaRaportScrollField)((Component)e.getSource()).getParent()).getId_programare());
                }else{
                    appView2.getUiPanel().getRaportCard().setRaportEditable(false);
                    appView2.getUiPanel().getRaportCard().showRaport(app.getRaportDetails(x.getId_raport()));
                }

            }

        }
    }

    class ParafeazaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Suntenti sigur/a ca vreti sa parafati raportul?", "Raport", JOptionPane.YES_NO_OPTION)==0){
                if(appView2.getUiPanel().getRaportCard().verifParafeaza()){
                    Raport raport=appView2.getUiPanel().getRaportCard().getRaport();
                    String id_programare=appView2.getUiPanel().getRaportCard().getIdProgramare();
                    //System.out.println(raport+" "+id_programare);
                    app.parafeazaRaport(raport,id_programare);
                    JOptionPane.showMessageDialog((Component) e.getSource(),
                            "Parafat cu succes.",
                            "Raport",
                            JOptionPane.INFORMATION_MESSAGE);
                    appView2.getUiPanel().getRaportCard().resetParafeaza();
                    appView2.getUiPanel().getRaportCard().setShowPacient();
                    appView2.getUiPanel().getRaportCard().resetContent();
                }else{
                    JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                            "Numar de caractere depasit.",
                            "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    class BackParafeazaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            appView2.getUiPanel().getRaportCard().setShowPacient();
            appView2.getUiPanel().getRaportCard().resetContent();
        }
    }
    class ValideazaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Suntenti sigur/a ca vreti sa validati raportul?", "Raport Analize", JOptionPane.YES_NO_OPTION)==0){
                if(appView2.getUiPanel().getRaportCard().verifAnalize()){
                    Analize analize=appView2.getUiPanel().getRaportCard().getAnalize();
                    String id_programare=appView2.getUiPanel().getRaportCard().getIdProgramare();
                    app.valideazaAnalize(analize,id_programare,app.getCurrentUserId());
                    JOptionPane.showMessageDialog((Component) e.getSource(),
                            "Validat cu Succes.",
                            "Raport Analize",
                            JOptionPane.INFORMATION_MESSAGE);
                    appView2.getUiPanel().getRaportCard().resetAnalize();
                    appView2.getUiPanel().getRaportCard().setShowPacient();
                    appView2.getUiPanel().getRaportCard().resetContent();
                }else{
                    JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                            "Date introduse gresit.",
                            "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    class VeziProgramariAziListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(app.getCurrentUserFunctie().equals("Asistent") || app.getCurrentUserFunctie().equals("Admin")){
                List<CreeazaRaportField>list=app.getProgramariAziAsistent();
                appView2.getUiPanel().getRaportCard().showCautaPacientResult(list);
            }
            else{
                List<CreeazaRaportField>list=app.getProgramariAziMedic();
                System.out.println(list);
                appView2.getUiPanel().getRaportCard().showCautaPacientResult(list);
            }
        }
    }
    class RefreshEmiteFacturaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            List<EmiteFacturaField>list=app.getIstoricForFactura();
            //System.out.println(list);
            appView2.getUiPanel().getEmiteFacturaCard().showIstoricForFactura(list);
        }
    }
    class SelectEmiteFacturaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Suntenti sigur/a ca vreti sa generati factura?", "Generare Factura", JOptionPane.YES_NO_OPTION)==0){
                EmiteFacturaField emiteFacturaField= (EmiteFacturaField) ((Component)e.getSource()).getParent();
                String data_curenta=LocalDateTime.now().toString().substring(0,10)+" "+LocalDateTime.now().toString().substring(11,19);
                if(app.generareFactura(emiteFacturaField.getId_istoric(),app.getCurrentUserId(),data_curenta)){
                    emiteFacturaField.setCompleted();
                    JOptionPane.showMessageDialog((Component) e.getSource(),
                            "Factura generata cu Succes.\nData:"+data_curenta+"\nID:"+emiteFacturaField.getId_istoric()+"\nNume Receptioner:"+
                                    app.getCurrentUserNume()+"\nNume Pacient: "+emiteFacturaField.getPacient()+"\nServiciu: "+emiteFacturaField.getServiciu()+"\n\nTOTAL: $"+emiteFacturaField.getPret(),
                            "Generare Factura",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                            "Eroare baza de date.",
                            "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }
    class RefreshConcediuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String id_angajat=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziAngajatPanel().getIdAngajat();
            List<ConcediuField>list=app.getConcedii(id_angajat);
            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getConcediuPanel().showConcediu(list);
        }
    }
    class AdaugaConcediuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Suntenti sigur/a ca vreti sa generati factura?", "Generare Factura", JOptionPane.YES_NO_OPTION)==0){
                String data_start=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getConcediuPanel().getDatePicker1();
                String data_stop=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getConcediuPanel().getDatePicker2();
                String id_angajat=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getShowUserVeziAngajatPanel().getIdAngajat();
                if(appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getConcediuPanel().verif() && app.verifConcediu(id_angajat,data_start,data_stop)){
                    System.out.println(id_angajat+" "+data_start+" "+data_stop);
                    app.insertConcediu(id_angajat,data_start,data_stop);
                }else{
                    JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                            "Eroare introducere date",
                            "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    class VeziProgramSpecific implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String data_programare=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getDataProgramare();
            String id_unitate=appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getIdUnitate();
            LocalDate now = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate myDate=LocalDate.parse(data_programare,formatter);
            if(myDate.isBefore(now) || id_unitate.equals("")){
                JOptionPane.showMessageDialog(((Component) e.getSource()).getParent().getParent(),
                        "Date introduse gresit",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
            else{
                String idAngajat = appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getAngajat().getId_user();
                String idServiciu=app.getFirstIdServiciu(idAngajat);
                IntervalOre intervalOre = app.getProgramPeData(idServiciu, data_programare);
                List<ProgramSpecific> programSpecificList = app.getProgramSpecific(idServiciu, data_programare);
                Concediu concediu = app.getConcediuPeData(idServiciu, data_programare);
                IntervalOre intervalOreUnitate=app.getProgramUnitatePeData(id_unitate,data_programare);
                //List<Programare> programareList = app.getProgramariPeData(idServiciu, data_programare);
//            System.out.println(intervalOre.toString());
//            System.out.println(programSpecificList);
//            System.out.println(concediu);
//            System.out.println(programareList);
                System.out.println(intervalOreUnitate);
                programSpecificList.add(new ProgramSpecific(intervalOre.getOraStart(),intervalOre.getOraStop()));
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().reset();
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().setProgramSpecific(intervalOreUnitate.getOraStart(),intervalOreUnitate.getOraStop(),programSpecificList, concediu);
            }
        }
    }

    class ConfirmProgramSpecificListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Suntenti sigur/a ca vreti sa adaugati un nou program specific?", "Program Specific", JOptionPane.YES_NO_OPTION)==0){
                if(appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getDataProgramare()!=null && appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().verif()){
                    System.out.println(appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().getOreButoane().getOraStart()+" "+
                            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().getOreButoane().getOraStop());
                    if(app.insertProgramSpecific(appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getAngajat().getId_user(),
                            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getDataProgramare(),
                            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().getOreButoane().getOraStart(),
                            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().getOreButoane().getOraStop(),
                            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getIdUnitate()))
                    {
                        JOptionPane.showMessageDialog((Component) e.getSource(),
                                "Introdus cu succes.",
                                "Programare",
                                JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog((Component) e.getSource(),
                                "Eroare la introducere in BD",
                                "Eroare",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    //System.out.println("OK"+appView2.getUiPanel().getProgramareCard().getSchedulerPanel().getOreButoane().toString()+appView2.getUiPanel().getProgramareCard().getId_serviciu());
                    appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().reset();

                }
                else{
                    JOptionPane.showMessageDialog((Component) e.getSource(),
                            "Ati intordus gresit intervalul sau nu ati selectat data",
                            "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                    appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().reset();
                }
            }
        }
    }
    class ClickInsideSchedulerProgramSpecific implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SchedulerPanelButton schedulerPanelButton=(SchedulerPanelButton)e.getSource();
            appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().buttonClicked(schedulerPanelButton);
        }
    }

    class VeziSalariuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView2.getUiPanel().getSalariuAngajatCard().verif()){
                appView2.getUiPanel().getSalariuAngajatCard().showResult(app.getSalariuCurrentAngajat(appView2.getUiPanel().getSalariuAngajatCard().getDatePicker1(),appView2.getUiPanel().getSalariuAngajatCard().getDatePicker2()));

            }else{
                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Ati intordus gresit intervalul sau nu ati selectat data",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
                appView2.getUiPanel().getCautaAngajatCard().getVeziAngajatPanel().getProgramSpecific().getSchedulerPanel().reset();
            }
        }
    }
    class VeziMedicFinanciarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView2.getUiPanel().getProfitPoliclinicaCard().verifMedic()){
                List<FinanciarField>list=app.getFinanciarMedic(
                        appView2.getUiPanel().getProfitPoliclinicaCard().getNumeMedic(),
                        appView2.getUiPanel().getProfitPoliclinicaCard().getPrenumeMedic(),
                        appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker1Medic(),
                        appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker2Medic()
                );
                appView2.getUiPanel().getProfitPoliclinicaCard().showResultMedic(list);
            }else{
                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Ati intordus gresit intervalul",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class VeziAngajatFinanciarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView2.getUiPanel().getProfitPoliclinicaCard().verifAngajat()){
                appView2.getUiPanel().getProfitPoliclinicaCard().showResultAngajat(app.getFinanciarAngajat(
                        appView2.getUiPanel().getProfitPoliclinicaCard().getNumeAngajat(),
                        appView2.getUiPanel().getProfitPoliclinicaCard().getPrenumeAngajat(),
                        appView2.getUiPanel().getProfitPoliclinicaCard().getFunctieAngajat(),
                        appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker1Angajat(),
                        appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker2Angajat()));
            }else{
                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Ati intordus gresit intervalul",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class VeziLocatieFinanciarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView2.getUiPanel().getProfitPoliclinicaCard().verifLocatie()){

                        appView2.getUiPanel().getProfitPoliclinicaCard().showResultLocatie(
                        app.getFinanciarUnitate(
                                appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker1Locatie(),
                                appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker2Locatie()
                        ));
            }else{
                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Ati intordus gresit intervalul",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class VeziSpecializareFinanciarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView2.getUiPanel().getProfitPoliclinicaCard().verifSpecializare()){
                appView2.getUiPanel().getProfitPoliclinicaCard().showResultSpecializare(
                        app.getFinanciarSpecializare(
                                appView2.getUiPanel().getProfitPoliclinicaCard().getDenumireSpecializare(),
                                appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker1Specializare(),
                                appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker2Specializare()
                        )
                );
            }else{
                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Ati intordus gresit intervalul",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class VeziTotalFinanciarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView2.getUiPanel().getProfitPoliclinicaCard().verif()){
                String data_start=appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker1();
                String data_stop=appView2.getUiPanel().getProfitPoliclinicaCard().getDatePicker2();
                FinanciarField x=app.getFinanciarTotal(data_start,data_stop);

                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "DATA INTEROGARE:"+LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"\nDATA START:"+data_start+"\nDATA STOP:"+data_stop+"\nVENITURI:"+x.getVenit()+"\nCHELTUIELI:"+x.getCheltuieli()+"\nPROFIT:"+x.getProfit(),
                        "STATUS",
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Ati intordus gresit intervalul",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class VeziDeleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String nume=appView2.getUiPanel().getDeleteUserCard().getNume();
            String prenume=appView2.getUiPanel().getDeleteUserCard().getPrenume();
            List<UserField>list=app.getDeleteUserList(nume,prenume);
            appView2.getUiPanel().getDeleteUserCard().showResult(list);
        }
    }
    class DeleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog((Component) e.getSource(), "Suntenti sigur/a ca vreti sa stergeti?", "sterge", JOptionPane.YES_NO_OPTION)==0){
                JButton jButton=(JButton) e.getSource();
                UserField userField=(UserField) jButton.getParent();
                app.deleteUser(userField.getId());
            }

        }
    }
    class VeziProgramareListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(appView2.getUiPanel().getStergeProgramarePane().verif()){
                appView2.getUiPanel().getStergeProgramarePane().showResult(
                        app.getStergeProgramare(
                                appView2.getUiPanel().getStergeProgramarePane().getDatePicker1(),
                                appView2.getUiPanel().getStergeProgramarePane().getDatePicker2()
                        )
                );
            }else{
                JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Ati intordus gresit intervalul",
                        "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class StergeProgramareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jButton= (JButton) e.getSource();
            ProgramareField programareField= (ProgramareField) jButton.getParent();
            app.deleteProgramare(programareField.getId());
            appView2.getUiPanel().getStergeProgramarePane().resetContent();
            JOptionPane.showMessageDialog(appView2,
                    "Sters cu succes.",
                    "STATUS",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
//    class SelectUnitateListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            appView2.getCabinetePanel().getAdaugaStergeCabinete().next();
//        }
//    }
//    class StergeCabinetListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton jButton= (JButton) e.getSource();
//            CabinetField cabinetField=(CabinetField)jButton.getParent();
//            app.stergeCabinet(cabinetField.getId());
//            appView2.getCabinetePanel().getAdaugaStergeCabinete().getCabinete().resetContent();
//        }
//    }
//    class AdaugaCabinetTabListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            appView2.getCabinetePanel().getAdaugaStergeCabinete().next();
//        }
//    }
//    class
}
