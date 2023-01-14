import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {
    private String URL;
    //"jdbc:mysql://localhost/policlinica"
    private Connection connection;

    public App(String URL) {
        this.URL = URL;
    }

    private String loggedUserId;

    public void init(String username,String password){
        try {	// Load driver class
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " +e);
        }


        connection=null;
        try {
            connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Succesful Connection");
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
            System.exit(1);
        }
    }

    private void closeConnection(){
        try{
            connection.close();
        }catch(SQLException ex){
            System.err.println("Exception during connection close: " + ex);
        }
    }

    public String login(String username,String password){
        String query="CALL login(\'"+username+"\',\'"+password+"\');";
        try{
            Statement stmt= connection.createStatement();
            ResultSet rst=stmt.executeQuery(query);
            rst.next();
            loggedUserId=rst.getObject(1).toString();
            return rst.getObject(1).toString();
        } catch (SQLException ex){
            System.err.println("SQLException: "+ex);
            return null;
        }
    }
    public String checkForAdmin(){
        String query="select * from admin where id_admin=\'"+loggedUserId+"\';";
        try{
            Statement stmt= connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            if(resultSet.next()){
                String query1="select * from superadmin where id_superadmin=\'"+loggedUserId+"\';";
                Statement stmt1= connection.createStatement();
                ResultSet resultSet1=stmt1.executeQuery(query);
                if(resultSet1.next())return "Superadmin";
                else return "admin";
            }else return null;
        }catch (SQLException ex){
            System.err.println("SQLExceptionCheckForAdmin: "+ex);
            return null;
        }
    }

    public String getLoginID(String username, String password) {
        //String query="select * from login where username=\'"+username+"\' and password=\'"+password+'\''+";";
        String query="CALL login(\'"+username+"\',\'"+password+"\');";
        //System.out.println(query);
        try{
            Statement stmt= connection.createStatement();
            ResultSet rst=stmt.executeQuery(query);
            rst.next();
            Object object=rst.getObject(1);
            String rez=object.toString();
            return rez;
        }
        catch (SQLException ex){
            System.err.println("SQLException: "+ex);
            return null;
        }
    }

    public Angajat getUserDataByID(String id_user){
        String query="select * from date_user where id_user="+id_user+";";
        Angajat angajat=new Angajat(id_user);
        try{
            Statement stmt= connection.createStatement();
            ResultSet rst=stmt.executeQuery(query);
            rst.next();
            angajat.setNume(rst.getObject(2).toString());
            angajat.setPrenume(rst.getObject(3).toString());
            angajat.setCNP(rst.getObject(4).toString());
            angajat.setAdresa(rst.getObject(5).toString());
            angajat.setTel(rst.getObject(6).toString());
            angajat.setEmail(rst.getObject(7).toString());
        }
        catch (SQLException ex){
            System.err.println("SQLException: "+ex);
            return null;
        }
        query="select * from angajat where id_angajat="+id_user+";";
        try{
            Statement stmt= connection.createStatement();
            ResultSet rst=stmt.executeQuery(query);
            rst.next();
            angajat.setIBAN(rst.getObject(2).toString());
            angajat.setFunctie(rst.getObject(3).toString());
            angajat.setDataAngajare(rst.getObject(4).toString());
            angajat.setNrContract(rst.getObject(5).toString());
            return angajat;
        }
        catch (SQLException ex){
            System.err.println("SQLException: "+ex);
            return null;
        }
    }

    public void updateUserDataByID(String id_user,String nume,String prenume,String CNP,String adresa,String tel,String email){
        String query="update date_user set nume=\'"+nume+"\', prenume=\'"+prenume+"\', CNP=\'"+CNP+"\', adresa=\'"+adresa+"\', tel=\'"+tel+"\', email=\'"+email+"\' where id_user=\'"+id_user+"\';";
        System.out.println(query);
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Operation success!");
        }
        catch (SQLException ex){
            System.err.println("SQLException: "+ex);
        }
    }



    public String insertUser(User user){
        String query="insert into date_user(nume,prenume,CNP,adresa,tel,email) values (\'"+user.getNume()+"\',\'"+user.getPrenume()+"\',\'"+user.getCNP()+"\',\'"+user.getAdresa()+"\',\'"+user.getTel()+"\',\'"+user.getEmail()+"\');";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionInsertuSER: "+exception);
        }
        query="select id_user from date_user where CNP=\'"+user.getCNP()+"\' and nume=\'"+user.getNume()+"\' and prenume=\'"+user.getPrenume()+"\' and adresa=\'"+user.getAdresa()
                +"\' and tel=\'"+user.getTel()+"\' and email=\'"+user.getEmail()+"\' order by id_user DESC;";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            resultSet.next();
            Object object=resultSet.getObject(1);
            String rez=object.toString();
            if(!user.getUsername().equals("") && !user.getPassword().equals("")){
                insertLogin(rez,user.getUsername(),user.getPassword());
            }
            return rez;
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionInsertUser: "+exception);
        }
        return null;
    }
    public void updateUser(User user){
        String query="update date_user set nume=\'"+user.getNume()+"\', prenume=\'"+user.getPrenume()+"\', CNP=\'"+user.getCNP()+"\', adresa=\'"+user.getAdresa()+"\', tel=\'"+user.getTel()+"\', email=\'"+user.getEmail()+"\' where id_user=\'"+ user.getId_user()+"\';";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionUpdateUser: "+exception);
        }
    }

    public void updateAngajat(Angajat angajat){
        String query="update angajat set IBAN=\'"+angajat.getIBAN()+"\', data_angajare=\'"+angajat.getDataAngajare()+"\' where id_angajat=\'"+angajat.getId_user()+"\';";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionUpdateAngajat: "+exception);
        }
    }

    public void updateAsistent(Asistent asistent){
        String query="update asistent set grad=\'"+asistent.getGrad()+"\', tip=\'"+asistent.getTip()+"\' where id_asistent=\'"+asistent.getId_user()+"\';";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionUpdateAsistent: "+exception);
        }
    }

    public void updateMedic(Medic medic){
        /*String query="update medic set parafa=\'"+medic.getParafa()+"\', titlu_stiintific=\'"+medic.getTitlu()+"\', post_didactic=\'"+medic.getPost()+"\' where id_medic=\'"+medic.getId_user()+"\';";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionUpdateMedic1: "+exception);
        }
        //sterg specializari vechi
        query="select id_specializare from specializare where id_medic=\'"+medic.getId_user()+"\';";
        try{
            Statement statement=connection.createStatement();
            ResultSet rez=statement.executeQuery(query);
            while(rez.next()){
                String id_specializare=rez.getObject(1).toString();
                String query2="select id_competenta from competenta where id_specializare=\'"+id_specializare+"\';";
                try{
                    Statement statement1=connection.createStatement();
                    ResultSet rez1=statement1.executeQuery(query2);
                    while(rez1.next()){
                        String id_competenta=rez1.getObject(1).toString();
                        String query3="delete from serviciu_medical where id_serviciu=\'"+id_competenta+"\';";
                        try{
                            Statement statement2=connection.createStatement();
                            statement2.executeUpdate(query3);
                        }catch (SQLException exception){
                            System.err.println("SQLExceptionUpdateMedic3: "+exception);
                        }
                        query3="delete from competenta where id_competenta=\'"+id_competenta+"\';";
                        try{
                            Statement statement2=connection.createStatement();
                            statement2.executeUpdate(query3);
                        }catch (SQLException exception){
                            System.err.println("SQLExceptionUpdateMedic3: "+exception);
                        }
                    }
                    String query4="delete from specializare where id_specializare=\'"+id_specializare+"\';";
                    try{
                        Statement statement2=connection.createStatement();
                        statement2.executeUpdate(query4);
                    }catch (SQLException exception){
                        System.err.println("SQLExceptionUpdateMedic4: "+exception);
                    }
                }catch (SQLException exception){
                    System.err.println("SqlExceptionUpdateMedic2: "+exception);
                }
            }
        }
        catch(SQLException exception){
            System.err.println("SqlExceptionMedic2: "+exception);
        }
        //adaug specializari noi
        for(int i=0;i<medic.getNrSpecializari();i++){
            String id_specializare=insertSpecializare(medic.getId_user(),medic.getSpecializare(i).getGrad(),medic.getSpecializare(i).getDenumire());
            for(int j=0;j<medic.getSpecializare(i).getNrCompetente();j++){
                String id_competenta=insertCompetenta(id_specializare,medic.getSpecializare(i).getCompetenta(j));
                insertServiciu(id_competenta,medic.getSpecializare(i).getDenumire());
            }
        }*/
        String query="select id_specializare from specializare where id_medic=\'"+medic.getId_user()+"\';";
        int index_spec=0;
        int index_comp;
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String id_specializare=resultSet.getObject(1).toString();
                index_comp=0;
                String query_comp="select id_competenta from competenta where id_specializare=\'"+id_specializare+"\';";
                try{
                    Statement statement1=connection.createStatement();
                    ResultSet resultSet_comp=statement1.executeQuery(query_comp);
                    while(resultSet_comp.next()){
                        String id_comp=resultSet_comp.getObject(1).toString();
                        System.out.println(medic.getSpecializare(index_spec).getPret(index_comp)+" "+medic.getSpecializare(index_spec).getDurata(index_comp)+" "+id_comp);
                        String query_serv="update serviciu_medical set pret=\'"+medic.getSpecializare(index_spec).getPret(index_comp)+"\', durata=\'"+medic.getSpecializare(index_spec).getDurata(index_comp)+"\' where id_serviciu=\'"+id_comp+"\';";
                        try{
                            Statement statement2=connection.createStatement();
                            statement2.executeUpdate(query_serv);
                        }catch (SQLException exception){
                            System.err.println("SQLExceptionUpdateMedicServ: "+exception);
                        }
                        index_comp++;
                    }

                }catch (SQLException exception){
                    System.err.println("SQLExceptionUpdateMedicComp: "+exception);
                }
                index_spec++;
            }
        }catch (SQLException exception){
            System.err.println("SQLExceptionUpdateMedic: "+exception);
        }
    }
    public void updateProgram(String id_user,ProgramGeneric programGeneric){
        String query="update program_angajat_generic set mon_start=\'"+programGeneric.getOraStart(0)+
                "\', mon_stop=\'"+programGeneric.getOraFinal(0)+
                "\', mon_id_unitate=\'"+programGeneric.getUnitate(0)+
                "\', tues_start=\'"+programGeneric.getOraStart(1)+
                "\', tues_stop=\'"+programGeneric.getOraFinal(1)+
                "\', tues_id_unitate=\'"+programGeneric.getUnitate(1)+
                "\', wed_start=\'"+programGeneric.getOraStart(2)+
                "\', wed_stop=\'"+programGeneric.getOraFinal(2)+
                "\', wed_id_unitate=\'"+programGeneric.getUnitate(2)+
                "\', thurs_start=\'"+programGeneric.getOraStart(3)+
                "\', thurs_stop=\'"+programGeneric.getOraFinal(3)+
                "\', thurs_id_unitate=\'"+programGeneric.getUnitate(3)+
                "\', fri_start=\'"+programGeneric.getOraStart(4)+
                "\', fri_stop=\'"+programGeneric.getOraFinal(4)+
                "\', fri_id_unitate=\'"+programGeneric.getUnitate(4)+
                "\', sat_start=\'"+programGeneric.getOraStart(5)+
                "\', sat_stop=\'"+programGeneric.getOraFinal(5)+
                "\', sat_id_unitate=\'"+programGeneric.getUnitate(5)+
                "\', sun_start=\'"+programGeneric.getOraStart(6)+
                "\', sun_stop=\'"+programGeneric.getOraFinal(6)+
                "\', sun_id_unitate=\'"+programGeneric.getUnitate(6)+"\' where id_angajat=\'"+id_user+"\';";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException exception){
            System.err.println("SqlExceptionUpdateProgram: "+exception);
        }
    }

    public void insertLogin(String id_user,String username,String password){
        String query="insert into login(id_user,username,password) values (\'"+id_user+"\',\'"+username+"\',\'"+password+"\');";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionInsertLogin: "+exception);
        }
    }
    public void insertPacient(User user){
        String newId_user=insertUser(user);
        user.setId_user(newId_user);
        String query="insert into pacient(id_pacient) values (\'"+user.getId_user()+"\');";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionInsertPacient: "+exception);
        }
    }
    public void insertAngajat(Angajat angajat){
        angajat.setId_user(insertUser(angajat));

        String query="insert into angajat(id_angajat,IBAN,functie,data_angajare,salariu_brut) values (\'"+angajat.getId_user()+"\',\'"+angajat.getIBAN()+"\',\'"+angajat.getFunctie()+"\',\'"+angajat.getDataAngajare()+"\',\'"+angajat.getSalariuBrut()+"\');";
        System.out.println(query);
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            insertProgram(angajat,angajat.getProgramGeneric());
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionAngajat: "+exception);
        }
    }
    public void insertAsistent(Asistent asistent){
        insertAngajat(asistent);
        String query="insert into asistent(id_asistent,grad,tip) values (\'"+asistent.getId_user()+"\',\'"+asistent.getGrad()+"\',\'"+asistent.getTip()+"\');";
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionAsistent: "+exception);
        }
    }
    public void insertMedic(Medic medic){
        medic.setSalariuBrut("-1");
        insertAngajat(medic);

        String query;
        if(medic.getTitlu().equals("") && medic.getPost().equals("")){
            query="insert into medic(id_medic,parafa,titlu_stiintific,post_didactic) values (\'"+medic.getId_user()+"\',\'"+medic.getParafa()+"\',"+"NULL"+","+"NULL"+");";
        }else if(medic.getTitlu().equals("") && !medic.getPost().equals("")){
            query="insert into medic(id_medic,parafa,titlu_stiintific,post_didactic) values (\'"+medic.getId_user()+"\',\'"+medic.getParafa()+"\',"+"NULL"+",\'"+medic.getPost()+"\');";
        }else if(!medic.getTitlu().equals("") && medic.getPost().equals("")){
            query="insert into medic(id_medic,parafa,titlu_stiintific,post_didactic) values (\'"+medic.getId_user()+"\',\'"+medic.getParafa()+"\',\'"+medic.getTitlu()+"\',"+"NULL"+");";
        }else{
            query="insert into medic(id_medic,parafa,titlu_stiintific,post_didactic) values (\'"+medic.getId_user()+"\',\'"+medic.getParafa()+"\',\'"+medic.getTitlu()+"\',\'"+medic.getPost()+"\');";
        }
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            for(int i=0;i<medic.getNrSpecializari();i++){
                String id_specializare=insertSpecializare(medic.getId_user(),medic.getSpecializare(i).getGrad(),medic.getSpecializare(i).getDenumire());
                for(int j=0;j<medic.getSpecializare(i).getNrCompetente();j++){
                    String id_competenta=insertCompetenta(id_specializare,medic.getSpecializare(i).getCompetenta(j));
                    insertServiciu(id_competenta,medic.getSpecializare(i).getDurata(j));
                }
            }
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionMedic: "+exception);
        }

    }
    public void insertProgram(Angajat angajat, ProgramGeneric programGeneric){
        System.out.println("ID:"+angajat.getId_user());
        String query="insert into program_angajat_generic(id_angajat, mon_start, mon_stop, mon_id_unitate, tues_start, tues_stop, tues_id_unitate, wed_start, wed_stop, wed_id_unitate, thurs_start, thurs_stop, thurs_id_unitate, fri_start, fri_stop, fri_id_unitate, sat_start, sat_stop, sat_id_unitate, sun_start, sun_stop, sun_id_unitate) " +
                "values(\'"+angajat.getId_user()+"\',\'"+
                programGeneric.getOraStart(0)+"\',\'"+programGeneric.getOraFinal(0)+"\',\'"+programGeneric.getUnitate(0)+"\',\'"+
                programGeneric.getOraStart(1)+"\',\'"+programGeneric.getOraFinal(1)+"\',\'"+programGeneric.getUnitate(1)+"\',\'"+
                programGeneric.getOraStart(2)+"\',\'"+programGeneric.getOraFinal(2)+"\',\'"+programGeneric.getUnitate(2)+"\',\'"+
                programGeneric.getOraStart(3)+"\',\'"+programGeneric.getOraFinal(3)+"\',\'"+programGeneric.getUnitate(3)+"\',\'"+
                programGeneric.getOraStart(4)+"\',\'"+programGeneric.getOraFinal(4)+"\',\'"+programGeneric.getUnitate(4)+"\',\'"+
                programGeneric.getOraStart(5)+"\',\'"+programGeneric.getOraFinal(5)+"\',\'"+programGeneric.getUnitate(5)+"\',\'"+
                programGeneric.getOraStart(6)+"\',\'"+programGeneric.getOraFinal(6)+"\',\'"+programGeneric.getUnitate(6)+"\');";
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionProgram: "+exception);
        }
    }
    public String insertSpecializare(String id_medic, String grad, String denumire_specializare){
        String query="insert into specializare(id_medic,grad,denumire_specializare) values (\'"+id_medic+"\',\'"+grad+"\',\'"+denumire_specializare+"\');";
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionSpecializare: "+exception);
        }
        query="select id_specializare from specializare where id_medic=\'"+id_medic+"\' and grad=\'"+grad+"\' and denumire_specializare=\'"+denumire_specializare+"\' order by id_specializare DESC;";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            resultSet.next();
            Object object=resultSet.getObject(1);
            String rez=object.toString();
            return rez;
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionSpecializare: "+exception);
        }
        return null;
    }
    public String insertCompetenta(String id_specializare, String denumire_competenta){
        String query="insert into competenta(id_specializare,denumire_competenta) values(\'"+id_specializare+"\',\'"+denumire_competenta+"\');";
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionCompetenta: "+exception);
        }
        query="select id_competenta from competenta where id_specializare=\'"+id_specializare+"\' and denumire_competenta=\'"+denumire_competenta+"\';";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            resultSet.next();
            Object object=resultSet.getObject(1);
            String rez=object.toString();
            return rez;
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionCompetenta: "+exception);
        }
        return null;
    }
    public void insertServiciu(String id_serviciu,String durata){
        String query="insert into serviciu_medical(id_serviciu,durata) values (\'"+id_serviciu+"\',\'"+durata+"\');";
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionServiciu: "+exception);
        }
    }

    public List<Angajat> getCautaAngajatList(String nume, String prenume) {
        List<Angajat> rezList=new ArrayList<>();
        String query="CALL cautaAngajatProcedure(\'"+nume+"\',\'"+prenume+"\');";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            while(resultSet.next()){
                Angajat angajat=new Angajat();
                Object objectIdAngajat=resultSet.getObject(1);
                angajat.setId_user(objectIdAngajat.toString());
                Object objectNume=resultSet.getObject(2);
                angajat.setNume(objectNume.toString());
                Object objectPrenume=resultSet.getObject(3);
                angajat.setPrenume(objectPrenume.toString());
                rezList.add(angajat);
            }
            return rezList;
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionCautaangajat: "+exception);
        }
        return null;
    }

    public List<User>getCautaPacientList(String nume, String prenume){
        List<User> rezList=new ArrayList<>();
        String query="CALL cautaPacientProcedure(\'"+nume+"\',\'"+prenume+"\');";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            while(resultSet.next()){
                User user=new User();
                Object objectIdPacient=resultSet.getObject(1);
                user.setId_user(objectIdPacient.toString());
                Object objectNume=resultSet.getObject(2);
                user.setNume(objectNume.toString());
                Object objectPrenume=resultSet.getObject(3);
                user.setPrenume(objectPrenume.toString());
                rezList.add(user);
            }
            return rezList;
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionCautapacient: "+exception);
        }
        return null;
    }
    public Angajat getVeziDetaliiAngajat(String id_user){
        String query="CALL veziDetaliiAngajat(\'"+id_user+"\');";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);
            resultSet.next();
            Angajat angajat=new Angajat();
            angajat.setId_user(resultSet.getObject(1).toString());
            angajat.setNume(resultSet.getObject(2).toString());
            angajat.setPrenume(resultSet.getObject(3).toString());
            angajat.setCNP(resultSet.getObject(4).toString());
            angajat.setAdresa(resultSet.getObject(5).toString());
            angajat.setTel(resultSet.getObject(6).toString());
            angajat.setEmail(resultSet.getObject(7).toString());
            angajat.setIBAN(resultSet.getObject(8).toString());
            angajat.setFunctie(resultSet.getObject(9).toString());
            angajat.setDataAngajare(resultSet.getObject(10).toString());
            angajat.setNrContract(resultSet.getObject(11).toString());
            ProgramGeneric programGeneric=new ProgramGeneric(resultSet.getObject(13).toString(),
                    resultSet.getObject(14).toString(),
                    resultSet.getObject(15).toString(),
                    resultSet.getObject(16).toString(),
                    resultSet.getObject(17).toString(),
                    resultSet.getObject(18).toString(),
                    resultSet.getObject(19).toString(),
                    resultSet.getObject(20).toString(),
                    resultSet.getObject(21).toString(),
                    resultSet.getObject(22).toString(),
                    resultSet.getObject(23).toString(),
                    resultSet.getObject(24).toString(),
                    resultSet.getObject(25).toString(),
                    resultSet.getObject(26).toString(),
                    resultSet.getObject(27).toString(),
                    resultSet.getObject(28).toString(),
                    resultSet.getObject(29).toString(),
                    resultSet.getObject(30).toString(),
                    resultSet.getObject(31).toString(),
                    resultSet.getObject(32).toString(),
                    resultSet.getObject(33).toString()
                    );

            angajat.setProgram(programGeneric);

            if(angajat.getFunctie().equals("Medic")){

                query="select parafa,titlu_stiintific,post_didactic from medic where id_medic=\'"+id_user+"\';";
                Medic medic=new Medic(angajat);
                medic.setNrSpecializari(0);
                stmt = connection.createStatement();
                resultSet=stmt.executeQuery(query);
                resultSet.next();
                medic.setParafa(resultSet.getObject(1).toString());
                medic.setTitlu(resultSet.getObject(2).toString());
                medic.setPost(resultSet.getObject(3).toString());
                query="select grad,denumire_specializare,id_specializare from specializare where id_medic=\'"+id_user+"\';";
                stmt = connection.createStatement();
                resultSet=stmt.executeQuery(query);
                while(resultSet.next()){
                    Specializare specializare0=new Specializare(resultSet.getObject(2).toString(),resultSet.getObject(1).toString());
                    specializare0.setNrCompetente(0);
                    String query2="select competenta.denumire_competenta,serviciu_medical.durata,serviciu_medical.pret from competenta join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where id_specializare=\'"+resultSet.getObject(3).toString()+"\';";
                    Statement stmt2=connection.createStatement();
                    ResultSet resultSet2=stmt2.executeQuery(query2);
                    while(resultSet2.next()){
                        String durata;
                        if(resultSet2.getObject(2)==null)durata="null";
                        else durata=resultSet2.getObject(2).toString();
                        specializare0.addCompetenta(resultSet2.getObject(1).toString(),durata,resultSet2.getObject(3).toString());
                    }
                    medic.addSpecializare(specializare0);
                }
                return medic;

            }else if(angajat.getFunctie().equals("Asistent")){
                Asistent asistent=new Asistent(angajat);
                query="select grad,tip from asistent where id_asistent=\'"+id_user+"\';";
                stmt = connection.createStatement();
                resultSet=stmt.executeQuery(query);
                resultSet.next();
                asistent.setGrad(resultSet.getObject(1).toString());
                asistent.setTip(resultSet.getObject(2).toString());
                return asistent;
            }else{
                return angajat;
            }
        }
        catch (SQLException exception){
            System.err.println("SQLExceptionGetVeziDetaliiAngajat: "+exception);
        }
        return null;
    }

    public List<Serviciu> getCautaServiciuList(String denumire){
        String query="CALL cautaServiciuProcedure(\'"+denumire+"\');";
        List<Serviciu> list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String durata;
                if(resultSet.getObject(4)==null)durata="null";
                else durata=resultSet.getObject(4).toString();
                Serviciu serviciu=new Serviciu(resultSet.getObject(1).toString(),resultSet.getObject(2).toString(),resultSet.getObject(3).toString(),durata);
                list.add(serviciu);
            }
            return list;
        }catch (SQLException exception){
            System.err.println("SqlExceptionServiciu:"+exception);
            return null;
        }
    }

    public IntervalOre getProgramPeData(String idServiciu,String data_programare){
        String query="call getProgramPeData(\'"+idServiciu+"\',\'"+data_programare+"\');";
        System.out.println(query);
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            IntervalOre intervalOre=new IntervalOre(resultSet.getObject(1).toString().substring(0,5),resultSet.getObject(2).toString().substring(0,5));
            return intervalOre;

        }catch (SQLException exception){
            System.err.println("SqlExceptionGeTProgramPeData:"+exception);
            return null;
        }
    }

    public List<ProgramSpecific> getProgramSpecific(String idServiciu,String data_programare){
        String query="call getProgramSpecificPeData(\'"+idServiciu+"\',\'"+data_programare+"\');";
        List<ProgramSpecific>programSpecificList=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                ProgramSpecific programSpecific=new ProgramSpecific(resultSet.getObject(1).toString().substring(0,5),resultSet.getObject(2).toString().substring(0,5));
                programSpecificList.add(programSpecific);
            }
            return programSpecificList;
        }catch (SQLException exception){
            System.err.println("SqlExceptiongetProgramSpecific:"+exception);
            return null;
        }

    }

    public Concediu getConcediuPeData(String idServiciu,String data_programare){
        String query="call getConcediuPeData(\'"+idServiciu+"\',\'"+data_programare+"\');";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next()){
                return new Concediu(resultSet.getObject(1).toString().substring(0,10));
            }else return null;
        }catch (SQLException exception){
            System.err.println("SqlExceptionGeTConcediuPeData:"+exception);
            return null;
        }
    }

    //getProgramariPeDataPe medic
    public List<Programare> getProgramariPeData(String idServiciu,String data_programare){
        String query="call getProgramariPeData(\'"+idServiciu+"\',\'"+data_programare+"\');";
        List<Programare> programareList=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                Programare programare=new Programare(resultSet.getObject(1).toString().substring(0,5),resultSet.getObject(2).toString().substring(0,5));
                programareList.add(programare);
            }
            return programareList;
        }catch (SQLException exception){
            System.err.println("SqlExceptionGetProgramariPeData:"+exception);
            return null;
        }
    }
    public String getCurrentUserId(){
        return loggedUserId;
    }

    public boolean insertProgramare(String id_pacient, String id_serviciu, String currentUserId, String dataProgramare, String oraStart, String oraStop) {
        String query="insert into programare(id_pacient,id_serviciu,id_receptioner,data_programare,programare_start,programare_stop) values(\'"+id_pacient+"\',\'"
                +id_serviciu+"\',\'"+currentUserId+"\',\'"+dataProgramare+"\',\'"+oraStart+"\',\'"+oraStop+"\');";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
            return true;
        }catch (SQLException exception){
            System.err.println("SqlExceptionInsertProgramare"+exception);
            return false;
        }
    }

    public String getCurrentUserFunctie(){
        String query="call getCurrentUserFunctie(\'"+loggedUserId+"\');";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            return resultSet.getObject(1).toString();

        }catch (SQLException exception){
            System.err.println("SqlExceptiongetCurrentUserFunctie"+exception);
            return null;
        }
    }

    public List<CreeazaRaportField> getCautaProgramareAsistent() {
        String query="select * from programariAsistent";
        List<CreeazaRaportField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String id_raport,id_analize;
                if(resultSet.getObject(9)==null)id_raport="null";
                else id_raport=resultSet.getObject(9).toString();
                if(resultSet.getObject(10)==null)id_analize="null";
                else id_analize=resultSet.getObject(10).toString();
                list.add(new CreeazaRaportField(resultSet.getObject(1).toString(),resultSet.getObject(2).toString(),resultSet.getObject(3).toString(),resultSet.getObject(4).toString(),resultSet.getObject(5).toString(),resultSet.getObject(6).toString(),
                        resultSet.getObject(7).toString(),resultSet.getObject(8).toString(),id_raport,id_analize));
            }
            return list;
        }catch (SQLException exception){
            System.err.println("SqlExceptiongetCautaProgramareAsistent"+exception);
            return null;
        }
    }

    public List<CreeazaRaportField> getCautaProgramareMedic() {
        String query="call programariMedic(\'"+loggedUserId+"\');";
        List<CreeazaRaportField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String id_raport,id_analize;
                if(resultSet.getObject(9)==null)id_raport="null";
                else id_raport=resultSet.getObject(9).toString();
                if(resultSet.getObject(10)==null)id_analize="null";
                else id_analize=resultSet.getObject(10).toString();
                list.add(new CreeazaRaportField(resultSet.getObject(1).toString(),resultSet.getObject(2).toString(),resultSet.getObject(3).toString(),resultSet.getObject(4).toString(),resultSet.getObject(5).toString(),resultSet.getObject(6).toString(),
                        resultSet.getObject(7).toString(),resultSet.getObject(8).toString(),id_raport,id_analize));
            }
            return list;
        }catch (SQLException exception){
            System.err.println("SqlExceptiongetCautaProgramareMedic"+exception);
            return null;
        }
    }

    public void parafeazaRaport(Raport raport,String id_programare){
        String query="call parafeazaRaport(\'"+raport.getIstoricRaport()+"\',\'"+raport.getSimptome()+"\',\'"+raport.getDiagnostic()+"\',\'"+raport.getRecomandari()+"\',\'"+id_programare+"\');";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException exception){
            System.err.println("SqlExceptionparafeazaRaport"+exception);
        }
    }

    public Raport getRaportDetails(String id_raport) {
        String query="select istoric_raport,simptome,diagnostic,recomandari from raport where id_raport=\'"+id_raport+"\';";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            return new Raport(resultSet.getObject(1).toString(),resultSet.getObject(2).toString(),resultSet.getObject(3).toString(),resultSet.getObject(4).toString());
        }catch (SQLException exception){
            System.err.println("SqlExceptiongetRaportDetails"+exception);
            return null;
        }
    }

    public Analize getAnalizeDetails(String id_analize) {
        String query="select wbc,lymph,neut,mono,hct from analize where id_analize=\'"+id_analize+"\';";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            return new Analize(resultSet.getObject(1).toString(),resultSet.getObject(2).toString(),resultSet.getObject(3).toString(),resultSet.getObject(4).toString(),resultSet.getObject(5).toString());

        }catch (SQLException exception){
            System.err.println("SqlExceptiongetAnalizeDetails"+exception);
            return null;
        }
    }

    public void valideazaAnalize(Analize analize, String id_programare,String id_asistent) {
        String query="call valideazaAnalize(\'"+analize.getWbc()+"\',\'"+analize.getLymph()+"\',\'"+analize.getNeut()+"\',\'"+analize.getMono()+"\',\'"+analize.getHct()+"\',\'"+id_programare+"\',\'"+id_asistent+"\');";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException exception){
            System.err.println("SqlExceptionvalideazaAnalize"+exception);
        }
    }

    public List<CreeazaRaportField> getProgramariAziAsistent() {
        String query="select * from getProgramariAziAsistent;";
        List<CreeazaRaportField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()) {
                String id_raport, id_analize;
                if (resultSet.getObject(9) == null) id_raport = "null";
                else id_raport = resultSet.getObject(9).toString();
                if (resultSet.getObject(10) == null) id_analize = "null";
                else id_analize = resultSet.getObject(10).toString();
                list.add(new CreeazaRaportField(resultSet.getObject(1).toString(), resultSet.getObject(2).toString(), resultSet.getObject(3).toString(), resultSet.getObject(4).toString(), resultSet.getObject(5).toString(), resultSet.getObject(6).toString(),
                        resultSet.getObject(7).toString(), resultSet.getObject(8).toString(), id_raport, id_analize));
            }
            return list;
        }catch (SQLException exception){
            System.err.println("SqlExceptiongetProgramariAziAsistent"+exception);
            return null;
        }
    }

    public List<CreeazaRaportField> getProgramariAziMedic() {
        String query="call programariMedicZiuaCurenta(\'"+loggedUserId+"\');";
        List<CreeazaRaportField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String id_raport,id_analize;
                if(resultSet.getObject(9)==null)id_raport="null";
                else id_raport=resultSet.getObject(9).toString();
                if(resultSet.getObject(10)==null)id_analize="null";
                else id_analize=resultSet.getObject(10).toString();
                list.add(new CreeazaRaportField(resultSet.getObject(1).toString(),resultSet.getObject(2).toString(),resultSet.getObject(3).toString(),resultSet.getObject(4).toString(),resultSet.getObject(5).toString(),resultSet.getObject(6).toString(),
                        resultSet.getObject(7).toString(),resultSet.getObject(8).toString(),id_raport,id_analize));
            }
            return list;
        }catch (SQLException exception){
            System.err.println("SqlExceptiongetProgramariAziMedic"+exception);
            return null;
        }
    }

    public List<EmiteFacturaField> getIstoricForFactura() {
        String query="select * from getIstoricForFactura;";
        List<EmiteFacturaField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String id_raport,id_analize,data_factura;
                if(resultSet.getObject(9)==null)id_raport="null";
                else id_raport=resultSet.getObject(9).toString();
                if(resultSet.getObject(10)==null)id_analize="null";
                else id_analize=resultSet.getObject(10).toString();
                if(resultSet.getObject(11)==null)data_factura="null";
                else data_factura=resultSet.getObject(11).toString();
                list.add(new EmiteFacturaField(resultSet.getObject(1).toString(),
                        resultSet.getObject(2).toString(),
                        resultSet.getObject(3).toString(),
                        resultSet.getObject(4).toString(),
                        resultSet.getObject(5).toString(),
                        resultSet.getObject(6).toString(),
                        resultSet.getObject(7).toString(),
                        resultSet.getObject(8).toString(),
                        id_raport,id_analize,data_factura));
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetIstoricForFactura" + exception);
            return null;
        }
    }

    public String getCurrentUserNume() {
        String query="select nume,prenume from date_user where id_user=\'"+loggedUserId+"\';";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            return resultSet.getObject(1).toString()+" "+resultSet.getObject(2).toString();
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetCurrentUserNume" + exception);
            return null;
        }
    }

    public boolean generareFactura(String id_factura,String id_receptioner, String data_generare){
        String query="update factura set id_receptioner=\'"+id_receptioner+"\', data_factura=\'"+data_generare+"\' where id_factura=\'"+id_factura+"\';";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
            return true;
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongenerareFactura" + exception);
            return false;
        }
    }

    public List<ConcediuField> getConcedii(String id_angajat) {
        String query="select id_angajat,zi_concediu from concediu where id_angajat=\'"+id_angajat+"\' order by zi_concediu;";
        List<ConcediuField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                list.add(new ConcediuField(resultSet.getObject(1).toString(),resultSet.getObject(2).toString()));
            }
            return list;
        }
        catch (SQLException exception) {
            System.err.println("SqlExceptiongetConcedii" + exception);
            return null;
        }
    }

    public boolean verifConcediu(String id_angajat,String data_start, String data_stop) {
        String query="call verifConcediu(\'"+id_angajat+"\',\'"+data_start+"\',\'"+data_stop+"\');";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next()){
                return false;
            }else{
                return true;
            }
        }catch (SQLException exception) {
            System.err.println("SqlExceptionverifConcediu" + exception);
            return false;
        }
    }

    public void insertConcediu(String id_angajat, String data_start, String data_stop) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(data_start,formatter);
        LocalDate date2=LocalDate.parse(data_stop,formatter);
        LocalDate now=LocalDate.now();

        if(date1.isEqual(date2)){
            String query="insert into concediu(id_angajat,zi_concediu)values(\'"+id_angajat+"\',\'"+date1.toString()+"\');";
            try{
                Statement statement=connection.createStatement();
                statement.executeUpdate(query);
            }catch (SQLException exception) {
                System.err.println("SqlExceptionverifConcediu" + exception);
            }
            return;
        }
        while(!date1.isEqual(date2)){
            String query="insert into concediu(id_angajat,zi_concediu)values(\'"+id_angajat+"\',\'"+date1.toString()+"\');";
            try{
                Statement statement=connection.createStatement();
                statement.executeUpdate(query);
            }catch (SQLException exception) {
                System.err.println("SqlExceptionverifConcediu" + exception);
                return;
            }
            System.out.println(date1);
            date1=date1.plusDays(1);
        }
        String query="insert into concediu(id_angajat,zi_concediu)values(\'"+id_angajat+"\',\'"+date1.toString()+"\');";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException exception) {
            System.err.println("SqlExceptionverifConcediu" + exception);
        }
    }

    public String getFirstIdServiciu(String idAngajat) {
        String query="call getFirstIdServiciu(\'"+idAngajat+"\');";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            return resultSet.getObject(1).toString();
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetFirstIdServiciu" + exception);
            return null;
        }
    }

    public boolean insertProgramSpecific(String id_user, String dataProgramare, String oraStart, String oraStop, String idUnitate) {
        String query="insert into program_angajat_specific(id_angajat,data_specifica,timp_start,timp_stop,id_unitate) values(\'"+
                id_user+"\',\'"+dataProgramare+"\',\'"+oraStart+"\',\'"+oraStop+"\',\'"+idUnitate+"\');";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
            return true;
        }catch (SQLException exception) {
            System.err.println("SqlExceptioninsertProgramSpecific" + exception);
            return false;
        }
    }

    public List<String> getUnitati() {
        String query="select id_unitate from unitate;";
        List<String>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                list.add(resultSet.getObject(1).toString());
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetUnitati" + exception);
            return null;
        }
    }

    public IntervalOre getProgramUnitatePeData(String id_unitate,String data_programare) {
        String query="call getProgramUnitatePeData(\'"+id_unitate+"\',\'"+data_programare+"\');";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            return new IntervalOre(resultSet.getObject(1).toString(),resultSet.getObject(2).toString());
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetProgramUnitatePeData" + exception);
            return null;
        }
    }

    public List<ProgramGeneric>getAllProgramUnitate(){
        String query="select * from program_unitate;";
        List<ProgramGeneric>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String[] oreStart=new String[7];
                String[] oreStop=new String[7];
                for(int i=2;i<=14;i+=2){
                    oreStart[i/2-1]=resultSet.getObject(i).toString().substring(0,5);
                }
                for(int i=3;i<=15;i+=2){
                    oreStop[i/2-1]=resultSet.getObject(i).toString().substring(0,5);
                }
                list.add(new ProgramGeneric(resultSet.getObject(1).toString(),oreStart,oreStop));
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetAllProgramUnitate" + exception);
            return null;
        }
    }
    public List<SalariuAngajatField>getSalariuCurrentAngajat(String data_start,String data_stop){
        String query="call getSalariuAngajatById(\'"+loggedUserId+"\',\'"+data_start+"\',\'"+data_stop+"\')";
        List<SalariuAngajatField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                if(resultSet.getMetaData().getColumnCount()==6){
                    list.add(new SalariuAngajatField(resultSet.getObject(1).toString(),resultSet.getObject(2).toString(),
                            resultSet.getObject(3).toString(),resultSet.getObject(4).toString(),
                            resultSet.getObject(5).toString(),resultSet.getObject(6).toString()));
                }
                else{
                    list.add(new SalariuAngajatField(resultSet.getObject(1).toString(),
                            resultSet.getObject(2).toString(),
                            resultSet.getObject(3).toString(),
                            resultSet.getObject(4).toString(),
                            resultSet.getObject(5).toString(),
                            resultSet.getObject(6).toString(),
                            resultSet.getObject(7).toString(),
                            resultSet.getObject(8).toString()));
                }
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptionetSalariuCurrentAngajat" + exception);
            return null;
        }
    }

    public List<FinanciarField> getFinanciarAngajat(String nume, String prenume,String functie, String data_start,String data_stop) {
        String query="call getSalariuAngajat(\'"+nume+"\',\'"+prenume+"\',\'"+functie+"\',\'"+data_start+"\',\'"+data_stop+"\');";
        List<FinanciarField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                list.add(new FinanciarField(resultSet.getObject(1).toString(),
                        resultSet.getObject(2).toString(),
                        resultSet.getObject(3).toString(),
                        resultSet.getObject(4).toString(),
                        resultSet.getObject(5).toString(),
                        resultSet.getObject(6).toString()));
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetFinanciarAngajat" + exception);
            return null;
        }
    }

    public List<FinanciarField> getFinanciarMedic(String numeMedic, String prenumeMedic, String datePicker1Medic, String datePicker2Medic) {
        String query="call getVenitMedicProfit(\'"+numeMedic+"\',\'"+prenumeMedic+"\',\'"+datePicker1Medic+"\',\'"+datePicker2Medic+"\');";
        List<FinanciarField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                list.add(new FinanciarField(
                        resultSet.getObject(1).toString(),
                        resultSet.getObject(2).toString(),
                        resultSet.getObject(3).toString(),
                        resultSet.getObject(4).toString(),
                        resultSet.getObject(5).toString(),
                        resultSet.getObject(6).toString(),
                        resultSet.getObject(7).toString(),
                        resultSet.getObject(8).toString()
                ));
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetFinanciarMedic" + exception);
            return null;
        }
    }

    public List<FinanciarField> getFinanciarSpecializare(String denumireSpecializare, String datePicker1Specializare, String datePicker2Specializare) {
        String query="call getVenituriSpecializari(\'"+denumireSpecializare+"\',\'"+datePicker1Specializare+"\',\'"+datePicker2Specializare+"\');";
        List<FinanciarField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                list.add(new FinanciarField(
                        resultSet.getObject(1).toString(),
                        resultSet.getObject(2).toString(),
                        resultSet.getObject(3).toString(),
                        resultSet.getObject(4).toString()
                ));
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetFinanciarSpecializare" + exception);
            return null;
        }
    }

    public FinanciarField getFinanciarTotal(String data_start, String data_stop) {
        String query="call getStatusTotal(\'"+data_start+"\',\'"+data_stop+"\');";
        List<FinanciarField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
            return new FinanciarField(
                    resultSet.getObject(1).toString(),
                    resultSet.getObject(2).toString(),
                    resultSet.getObject(3).toString()
            );
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetFinanciarTotal" + exception);
            return null;
        }
    }

    public List<FinanciarField> getFinanciarUnitate(String datePicker1Locatie, String datePicker2Locatie) {
        String query="call getFinanciarUnitati(\'"+datePicker1Locatie+"\',\'"+datePicker2Locatie+"\');";
        List<FinanciarField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                list.add(
                        new FinanciarField(
                                resultSet.getObject(1).toString(),
                                resultSet.getObject(2).toString(),
                                resultSet.getObject(3).toString(),
                                resultSet.getObject(4).toString(),
                                0
                        )
                );
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptiongetFinanciarUnitate" + exception);
            return null;
        }
    }

    public List<UserField> getDeleteUserList(String nume, String prenume) {
        String query="call cautaUser(\'"+nume+"\',\'"+prenume+"\');";
        List<UserField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            String status;


            while(resultSet.next()){
                if(resultSet.getObject(4)==null)
                    status="null";
                else
                    status=resultSet.getObject(4).toString();
                list.add(new UserField(
                        resultSet.getObject(1).toString(),
                        resultSet.getObject(2).toString(),
                        resultSet.getObject(3).toString(),
                        status
                ));
            }
            return list;
        }
        catch (SQLException exception) {
            System.err.println("SqlExceptioncautaUser" + exception);
            return null;
        }
    }

    public void deleteUser(String id) {
        String query="call deleteUser(\'"+id+"\');";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException exception) {
            System.err.println("SqlExceptiondeleteUser" + exception);
        }

    }

    public List<ProgramareField> getStergeProgramare(String datePicker1, String datePicker2) {
        String query="call cautaProgramariNecompletate(\'"+datePicker1+"\',\'"+datePicker2+"\');";
        List<ProgramareField>list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                list.add(
                        new ProgramareField(resultSet.getObject(1).toString(),
                                resultSet.getObject(2).toString(),
                                resultSet.getObject(3).toString(),
                                resultSet.getObject(4).toString(),
                                resultSet.getObject(5).toString(),
                                resultSet.getObject(6).toString())
                );
            }
            return list;
        }catch (SQLException exception) {
            System.err.println("SqlExceptionStergeProgramari" + exception);
            return null;
        }
    }

    public void deleteProgramare(String id) {
        String query="call stergeProgramare(\'"+id+"\');";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException exception) {
            System.err.println("SqlExceptionstergeProgramare" + exception);
        }
    }
}
