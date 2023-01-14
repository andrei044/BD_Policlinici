import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class CreateProgramPanel extends JPanel {
//    JLabel monLabel=new JLabel("Luni:");
//    JLabel tuesLabel=new JLabel("Marti:");
//    JLabel wedLabel=new JLabel("Miercuri:");
//    JLabel thursLabel=new JLabel("Joi:");
//    JLabel friLabel=new JLabel("Vineri:");
//    JLabel satLabel=new JLabel("Sambata:");
//    JLabel sunLabel=new JLabel("Duminica:");
//
//    TextFieldWithPlaceHolder monStartTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder monStopTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder tuesStartTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder tuesStopTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder wedStartTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder wedStopTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder thursStartTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder thursStopTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder friStartTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder friStopTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder satStartTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder satStopTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder sunStartTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder sunStopTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder monUnitateTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder tuesUnitateTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder wedUnitateTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder thursUnitateTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder friUnitateTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder satUnitateTextField=new TextFieldWithPlaceHolder();
//    TextFieldWithPlaceHolder sunUnitateTextField=new TextFieldWithPlaceHolder();

    private DayOfWeekField[] dayOfWeekFields=new DayOfWeekField[7];
    private JButton backButton=new JButton("Inapoi");
    private JButton submitProgramButton=new JButton("Finalizeaza");
    private JButton modificaProgramButton=new JButton("Modifica");
    private JPanel buttonsPanel=new JPanel();
    private ProgramUnitatePanel programUnitatePanel=new ProgramUnitatePanel();
    private static final int DAYSOFWEEK=7;

    public CreateProgramPanel() {
        buttonsPanel.add(backButton);
        buttonsPanel.add(submitProgramButton);

        dayOfWeekFields[0]=new DayOfWeekField("Luni:");
        dayOfWeekFields[1]=new DayOfWeekField("Marti:");
        dayOfWeekFields[2]=new DayOfWeekField("Miercuri:");
        dayOfWeekFields[3]=new DayOfWeekField("Joi:");
        dayOfWeekFields[4]=new DayOfWeekField("Vineri:");
        dayOfWeekFields[5]=new DayOfWeekField("Sambata:");
        dayOfWeekFields[6]=new DayOfWeekField("Duminica:");
        for(int i=0;i<DAYSOFWEEK;i++){
            this.add(dayOfWeekFields[i]);
        }
        this.add(buttonsPanel);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(programUnitatePanel);
        this.setPreferredSize(new Dimension(300,320));
    }
    public CreateProgramPanel(ProgramGeneric programGeneric){
        buttonsPanel.add(modificaProgramButton);

        dayOfWeekFields[0]=new DayOfWeekField("Luni:");
        dayOfWeekFields[1]=new DayOfWeekField("Marti:");
        dayOfWeekFields[2]=new DayOfWeekField("Miercuri:");
        dayOfWeekFields[3]=new DayOfWeekField("Joi:");
        dayOfWeekFields[4]=new DayOfWeekField("Vineri:");
        dayOfWeekFields[5]=new DayOfWeekField("Sambata:");
        dayOfWeekFields[6]=new DayOfWeekField("Duminica:");
        for(int i=0;i<DAYSOFWEEK;i++){
            this.add(dayOfWeekFields[i]);
        }
        this.setProgramGeneric(programGeneric);
        this.add(buttonsPanel);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300,320));
    }
    public CreateProgramPanel(int x){
        buttonsPanel.add(modificaProgramButton);

        dayOfWeekFields[0]=new DayOfWeekField("Luni:");
        dayOfWeekFields[1]=new DayOfWeekField("Marti:");
        dayOfWeekFields[2]=new DayOfWeekField("Miercuri:");
        dayOfWeekFields[3]=new DayOfWeekField("Joi:");
        dayOfWeekFields[4]=new DayOfWeekField("Vineri:");
        dayOfWeekFields[5]=new DayOfWeekField("Sambata:");
        dayOfWeekFields[6]=new DayOfWeekField("Duminica:");
        for(int i=0;i<DAYSOFWEEK;i++){
            this.add(dayOfWeekFields[i]);
        }
        //this.setProgramGeneric(programGeneric);
        this.add(buttonsPanel);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300,320));
    }
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        CreateProgramPanel createProgramPanel=new CreateProgramPanel();
        jFrame.add(createProgramPanel);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void reset(){
        for(int i=0;i<DAYSOFWEEK;i++){
            dayOfWeekFields[i].reset();
        }
    }

    public ProgramGeneric getProgramGeneric(){
        ProgramGeneric program=new ProgramGeneric(
                dayOfWeekFields[0].getStart(),dayOfWeekFields[0].getStop(),dayOfWeekFields[0].getUnitate(),
                dayOfWeekFields[1].getStart(),dayOfWeekFields[1].getStop(),dayOfWeekFields[1].getUnitate(),
                dayOfWeekFields[2].getStart(),dayOfWeekFields[2].getStop(),dayOfWeekFields[2].getUnitate(),
                dayOfWeekFields[3].getStart(),dayOfWeekFields[3].getStop(),dayOfWeekFields[3].getUnitate(),
                dayOfWeekFields[4].getStart(),dayOfWeekFields[4].getStop(),dayOfWeekFields[4].getUnitate(),
                dayOfWeekFields[5].getStart(),dayOfWeekFields[5].getStop(),dayOfWeekFields[5].getUnitate(),
                dayOfWeekFields[6].getStart(),dayOfWeekFields[6].getStop(),dayOfWeekFields[6].getUnitate()
                );
        return program;
    }
    public void setProgramGeneric(ProgramGeneric programGeneric){
        dayOfWeekFields[0].setStart(programGeneric.getOraStart(0));
        dayOfWeekFields[1].setStart(programGeneric.getOraStart(1));
        dayOfWeekFields[2].setStart(programGeneric.getOraStart(2));
        dayOfWeekFields[3].setStart(programGeneric.getOraStart(3));
        dayOfWeekFields[4].setStart(programGeneric.getOraStart(4));
        dayOfWeekFields[5].setStart(programGeneric.getOraStart(5));
        dayOfWeekFields[6].setStart(programGeneric.getOraStart(6));

        dayOfWeekFields[0].setStop(programGeneric.getOraFinal(0));
        dayOfWeekFields[1].setStop(programGeneric.getOraFinal(1));
        dayOfWeekFields[2].setStop(programGeneric.getOraFinal(2));
        dayOfWeekFields[3].setStop(programGeneric.getOraFinal(3));
        dayOfWeekFields[4].setStop(programGeneric.getOraFinal(4));
        dayOfWeekFields[5].setStop(programGeneric.getOraFinal(5));
        dayOfWeekFields[6].setStop(programGeneric.getOraFinal(6));

        dayOfWeekFields[0].setUnitate(programGeneric.getUnitate(0));
        dayOfWeekFields[1].setUnitate(programGeneric.getUnitate(1));
        dayOfWeekFields[2].setUnitate(programGeneric.getUnitate(2));
        dayOfWeekFields[3].setUnitate(programGeneric.getUnitate(3));
        dayOfWeekFields[4].setUnitate(programGeneric.getUnitate(4));
        dayOfWeekFields[5].setUnitate(programGeneric.getUnitate(5));
        dayOfWeekFields[6].setUnitate(programGeneric.getUnitate(6));
    }

    public void addBackCreateUserListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void addSubmitCreateUserListener(ActionListener actionListener) {
        submitProgramButton.addActionListener(actionListener);
    }
    public void addModificaListener(ActionListener actionListener){
        modificaProgramButton.addActionListener(actionListener);
    }

    public ProgramUnitatePanel getProgramUnitatePanel() {
        return programUnitatePanel;
    }
    public boolean verif(){
        for(int i=0;i<DAYSOFWEEK;i++){
            if(dayOfWeekFields[i].getStart().equals("") || dayOfWeekFields[i].getStart().matches(".*[a-z].*")
                    || dayOfWeekFields[i].getStart().charAt(2)!=':' || dayOfWeekFields[i].getStart().length()!=5)return false;
            if(dayOfWeekFields[i].getStop().equals("") || dayOfWeekFields[i].getStop().matches(".*[a-z].*")
                    || dayOfWeekFields[i].getStop().charAt(2)!=':' || dayOfWeekFields[i].getStop().length()!=5)return false;
            if(dayOfWeekFields[i].getUnitate().matches(".*[a-z].*"))return false;
            if(!programUnitatePanel.verif(dayOfWeekFields[i].getUnitate(),i,dayOfWeekFields[i].getStart(),dayOfWeekFields[i].getStop()))return false;
        }
        return true;
    }
}
