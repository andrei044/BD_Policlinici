import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

public class SchedulerPanel extends JPanel {

    private static final int HOURS=24;
    private static final int MINUTES=60;
    private int[][] a=new int[HOURS][MINUTES];

    private int[] lastPressedHour=new int[2];
    private int[] lastPressedMinute=new int[2];
    List<SchedulerPanelButton>schedulerPanelButtonList=new ArrayList<>();
    private int nrClicked=0;

    private ActionListener listener;



    public SchedulerPanel(String startTime,String stopTime, List<ProgramSpecific> programSpecificList,List<Programare>programareList,Concediu concediu) {
        if(concediu!=null){
            for (int i = 0; i < HOURS; i++)
                for (int j = 0; j < MINUTES; j++)
                    a[i][j] = -1;
            this.setLayout(new GridLayout(25, 61));
            this.add(new JLabel("  "));
            for (int i = 0; i < MINUTES; i++)
                if (i < 10) this.add(new JLabel(" " + i));
                else this.add(new JLabel(String.valueOf(i)));
            for (int i = 0; i < HOURS; i++) {
                if (i < 10) this.add(new JLabel("0" + i));
                else this.add(new JLabel(String.valueOf(i)));
                for (int j = 0; j < MINUTES; j++) {
                    this.add(new Label("CC"));
                }
            }
        }else {
            int startH = Integer.parseInt(startTime.substring(0, 2));
            int endH = Integer.parseInt(stopTime.substring(0, 2));
            int startM = Integer.parseInt(startTime.substring(3, 5));
            int endM = Integer.parseInt(stopTime.substring(3, 5));

            //init cu -1
            for (int i = 0; i < HOURS; i++)
                for (int j = 0; j < MINUTES; j++)
                    a[i][j] = -1;
            //starth
            if (startH == endH)
                for (int i = startM; i <= endM; i++)
                    a[startH][i] = 0;
            else {
                for (int i = startM; i < MINUTES; i++)
                    a[startH][i] = 0;
                //mijloc
                for (int i = startH + 1; i < endH; i++)
                    for (int j = 0; j < MINUTES; j++)
                        a[i][j] = 0;
                //final
                for (int i = 0; i <= endM; i++)
                    a[endH][i] = 0;
            }


            for (int z = 0; z < programSpecificList.size(); z++) {
                int programSpecificStartHour = programSpecificList.get(z).getIntOraStart();
                int programSpecificStopHour = programSpecificList.get(z).getIntOraEnd();
                int programSpecificStartMinute = programSpecificList.get(z).getIntMinuteStart();
                int programSpecificStopMinute = programSpecificList.get(z).getIntMinuteEnd();
                if (programSpecificStartHour == programSpecificStopHour)
                    for (int i = programSpecificStartMinute; i <= programSpecificStopMinute; i++)
                        a[programSpecificStartHour][i] = 0;
                else {
                    for (int i = programSpecificStartMinute; i < MINUTES; i++)
                        a[programSpecificStartHour][i] = 0;
                    //mijloc
                    for (int i = programSpecificStartHour + 1; i < programSpecificStopHour; i++)
                        for (int j = 0; j < MINUTES; j++)
                            a[i][j] = 0;
                    //final
                    for (int i = 0; i <= programSpecificStopMinute; i++)
                        a[programSpecificStopHour][i] = 0;
                }


            }
            for (int z = 0; z < programareList.size(); z++) {
                int programareStartHour = programareList.get(z).getIntOraStart();
                int programareStopHour = programareList.get(z).getIntOraEnd();
                int programareStartMinute = programareList.get(z).getIntMinuteStart();
                int programareStopMinute = programareList.get(z).getIntMinuteEnd();

                if (programareStartHour == programareStopHour)
                    for (int i = programareStartMinute; i <= programareStopMinute; i++)
                        a[programareStartHour][i] = 1;
                else {
                    for (int i = programareStartMinute; i < MINUTES; i++)
                        a[programareStartHour][i] = 1;
                    //mijloc
                    for (int i = programareStartHour + 1; i < programareStopHour; i++)
                        for (int j = 0; j < MINUTES; j++)
                            a[i][j] = 1;
                    //final
                    for (int i = 0; i <= programareStopMinute; i++)
                        a[programareStopHour][i] = 1;
                }
            }

            this.setLayout(new GridLayout(25, 61));
            this.add(new JLabel("  "));
            for (int i = 0; i < MINUTES; i++)
                if (i < 10) this.add(new JLabel(" " + i));
                else this.add(new JLabel(String.valueOf(i)));
            for (int i = 0; i < HOURS; i++) {
                if (i < 10) this.add(new JLabel("0" + i));
                else this.add(new JLabel(String.valueOf(i)));
                for (int j = 0; j < MINUTES; j++) {
                    if (a[i][j] == -1)
                        this.add(new Label("X"));
                    else if (a[i][j] == 0) {
                        SchedulerPanelButton schedulerPanelButton = new SchedulerPanelButton(i, j);
                        schedulerPanelButton.addActionListener(listener);
                        schedulerPanelButton.setFont(new Font(Font.SERIF, Font.PLAIN, 8));
                        this.add(schedulerPanelButton);
                    } else this.add(new JLabel("O"));
                }
            }
        }
    }
    public void set(String startTime,String stopTime, List<ProgramSpecific> programSpecificList,List<Programare>programareList,Concediu concediu){
        if(concediu!=null){
            for (int i = 0; i < HOURS; i++)
                for (int j = 0; j < MINUTES; j++)
                    a[i][j] = -1;
            this.setLayout(new GridLayout(25, 61));
            this.add(new JLabel("  "));
            for (int i = 0; i < MINUTES; i++)
                if (i < 10) this.add(new JLabel(" " + i));
                else this.add(new JLabel(String.valueOf(i)));
            for (int i = 0; i < HOURS; i++) {
                if (i < 10) this.add(new JLabel("0" + i));
                else this.add(new JLabel(String.valueOf(i)));
                for (int j = 0; j < MINUTES; j++) {
                    this.add(new Label("CC"));
                }
            }
        }else{
            int startH = Integer.parseInt(startTime.substring(0, 2));
            int endH = Integer.parseInt(stopTime.substring(0, 2));
            int startM = Integer.parseInt(startTime.substring(3, 5));
            int endM = Integer.parseInt(stopTime.substring(3, 5));

            //init cu -1
            for (int i = 0; i < HOURS; i++)
                for (int j = 0; j < MINUTES; j++)
                    a[i][j] = -1;
            //starth
            if (startH == endH)
                for (int i = startM; i <= endM; i++)
                    a[startH][i] = 0;
            else {
                for (int i = startM; i < MINUTES; i++)
                    a[startH][i] = 0;
                //mijloc
                for (int i = startH + 1; i < endH; i++)
                    for (int j = 0; j < MINUTES; j++)
                        a[i][j] = 0;
                //final
                for (int i = 0; i <= endM; i++)
                    a[endH][i] = 0;
            }


            for (int z = 0; z < programSpecificList.size(); z++) {
                int programSpecificStartHour = programSpecificList.get(z).getIntOraStart();
                int programSpecificStopHour = programSpecificList.get(z).getIntOraEnd();
                int programSpecificStartMinute = programSpecificList.get(z).getIntMinuteStart();
                int programSpecificStopMinute = programSpecificList.get(z).getIntMinuteEnd();
                if (programSpecificStartHour == programSpecificStopHour)
                    for (int i = programSpecificStartMinute; i <= programSpecificStopMinute; i++)
                        a[programSpecificStartHour][i] = 0;
                else {
                    for (int i = programSpecificStartMinute; i < MINUTES; i++)
                        a[programSpecificStartHour][i] = 0;
                    //mijloc
                    for (int i = programSpecificStartHour + 1; i < programSpecificStopHour; i++)
                        for (int j = 0; j < MINUTES; j++)
                            a[i][j] = 0;
                    //final
                    for (int i = 0; i <= programSpecificStopMinute; i++)
                        a[programSpecificStopHour][i] = 0;
                }


            }

            for (int z = 0; z < programareList.size(); z++) {
                int programareStartHour = programareList.get(z).getIntOraStart();
                int programareStopHour = programareList.get(z).getIntOraEnd();
                int programareStartMinute = programareList.get(z).getIntMinuteStart();
                int programareStopMinute = programareList.get(z).getIntMinuteEnd();

                if (programareStartHour == programareStopHour)
                    for (int i = programareStartMinute; i <= programareStopMinute; i++)
                        a[programareStartHour][i] = 1;
                else {
                    for (int i = programareStartMinute; i < MINUTES; i++)
                        a[programareStartHour][i] = 1;
                    //mijloc
                    for (int i = programareStartHour + 1; i < programareStopHour; i++)
                        for (int j = 0; j < MINUTES; j++)
                            a[i][j] = 1;
                    //final
                    for (int i = 0; i <= programareStopMinute; i++)
                        a[programareStopHour][i] = 1;
                }
            }

            this.setLayout(new GridLayout(25, 61));
            this.add(new JLabel("  "));
            for (int i = 0; i < MINUTES; i++)
                if (i < 10) this.add(new JLabel(" " + i));
                else this.add(new JLabel(String.valueOf(i)));
            for (int i = 0; i < HOURS; i++) {
                if (i < 10) this.add(new JLabel("0" + i));
                else this.add(new JLabel(String.valueOf(i)));
                for (int j = 0; j < MINUTES; j++) {
                    if (a[i][j] == -1)
                        this.add(new Label("X"));
                    else if (a[i][j] == 0) {
                        SchedulerPanelButton schedulerPanelButton = new SchedulerPanelButton(i, j);
                        schedulerPanelButton.addActionListener(listener);
                        schedulerPanelButton.setFont(new Font(Font.SERIF, Font.PLAIN, 8));
                        this.add(schedulerPanelButton);
                    } else this.add(new JLabel("O"));
                }
            }
        }
        this.setVisible(false);
        this.setVisible(true);
    }

    public void showSchedule(){
        for(int i=0;i<HOURS;i++){
            for(int j=0;j<MINUTES;j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }
    }

    public boolean verif(){
        if(lastPressedHour[0]==lastPressedHour[1]){
            if(lastPressedMinute[0]>lastPressedMinute[1])
            {
                int aux=lastPressedMinute[0];
                lastPressedMinute[0]=lastPressedMinute[1];
                lastPressedMinute[1]=aux;

            }
            for(int i=lastPressedMinute[0];i<lastPressedMinute[1];i++){
                if(a[lastPressedHour[0]][i]!=0)return false;
            }
        }else{
            if(lastPressedHour[0]>lastPressedHour[1]){
                int aux=lastPressedHour[0];
                lastPressedHour[0]=lastPressedHour[1];
                lastPressedHour[1]=aux;
                aux=lastPressedMinute[0];
                lastPressedMinute[0]=lastPressedMinute[1];
                lastPressedMinute[1]=aux;
            }
            for(int i=lastPressedMinute[0];i<MINUTES;i++)
                if(a[lastPressedHour[0]][i]!=0)return false;
            for(int i=lastPressedHour[0]+1;i<lastPressedHour[1];i++){
                for(int j=0;j<MINUTES;j++)
                    if(a[i][j]!=0)return false;
            }
            for(int i=0;i<=lastPressedMinute[1];i++){
                if(a[lastPressedHour[1]][i]!=0)return false;
            }
        }
        return true;
    }
    public String getMinutes(){
        LocalTime t0 = LocalTime.parse( schedulerPanelButtonList.get(0).getTime() );
        LocalTime t1 = LocalTime.parse( schedulerPanelButtonList.get(1).getTime() );
        return String.valueOf(Duration.between(t0,t1).plusMinutes(1).toMinutes());
    }

    public void buttonClicked(SchedulerPanelButton pressedButton){
        if(nrClicked<2){
            lastPressedHour[nrClicked]=pressedButton.getHour();
            lastPressedMinute[nrClicked]=pressedButton.getMinute();
            schedulerPanelButtonList.add(pressedButton);
            pressedButton.setVisible(false);
            nrClicked++;
        }
    }
    public void resetButtonClicked(){
        nrClicked=0;
        while(!schedulerPanelButtonList.isEmpty()){
            schedulerPanelButtonList.get(0).setVisible(true);
            schedulerPanelButtonList.remove(0);
        }
    }

    public Programare getProgramare(){
        String startH;
        if(lastPressedHour[0]<10) startH="0"+String.valueOf(lastPressedHour[0]);
        else startH=String.valueOf(lastPressedHour[0]);
        String stopH;
        if(lastPressedHour[1]<10) stopH="0"+String.valueOf(lastPressedHour[1]);
        else stopH=String.valueOf(lastPressedHour[1]);
        String startM;
        if(lastPressedMinute[0]<10)startM="0"+String.valueOf(lastPressedMinute[0]);
        else startM=String.valueOf(lastPressedMinute[0]);
        String stopM;
        if(lastPressedMinute[1]<10)stopM="0"+String.valueOf(lastPressedMinute[1]);
        else stopM=String.valueOf(lastPressedMinute[1]);

        Programare programare=new Programare(startH+":"+startM,stopH+":"+stopM);
        return programare;
    }

    public static void main(String[] args) {
        List<ProgramSpecific> programSpecificList=new ArrayList<>();
        programSpecificList.add(new ProgramSpecific("17:25","19:00"));
        programSpecificList.add(new ProgramSpecific("19:04","23:00"));
        List<Programare> programareList=new ArrayList<>();
        programareList.add(new Programare("08:00","08:15"));
        programareList.add(new Programare("08:15","09:20"));
        programareList.add(new Programare("17:26","17:59"));
        programareList.add(new Programare("19:05","23:00"));

        SchedulerPanel schedulerPanel=new SchedulerPanel("08:00","16:00",programSpecificList,programareList,new Concediu("2023-01-05"));
        schedulerPanel.showSchedule();
        JFrame jFrame=new JFrame();
        jFrame.setContentPane(schedulerPanel);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void reset(){
        while(this.getComponentCount()!=0){
            this.remove(0);
        }
        this.setVisible(false);
        this.setVisible(true);
        resetButtonClicked();
    }
    public void setTest(){
        this.setLayout(new GridLayout(25,61));
        this.add(new Label(" "));
        for(int i=0;i<MINUTES;i++)this.add(new Label("XX"));
        for(int i=0;i<HOURS;i++){
            this.add(new JLabel("HH"));
            for(int j=0;j<MINUTES;j++){
                this.add(new JButton("BB"));
            }
        }
    }

    public void addClickInsideSchedulerListener(ActionListener actionListener){
        listener=actionListener;
    }

    public IntervalOre getOreButoane(){
        return new IntervalOre(schedulerPanelButtonList.get(0).getTime(),schedulerPanelButtonList.get(1).getTime());
    }

    public SchedulerPanel() {
    }

    public void setProgramSpecific(String startTime, String stopTime, List<ProgramSpecific> programSpecificList, Concediu concediu) {
        if(concediu!=null){
            for (int i = 0; i < HOURS; i++)
                for (int j = 0; j < MINUTES; j++)
                    a[i][j] = -1;
            this.setLayout(new GridLayout(25, 61));
            this.add(new JLabel("  "));
            for (int i = 0; i < MINUTES; i++)
                if (i < 10) this.add(new JLabel(" " + i));
                else this.add(new JLabel(String.valueOf(i)));
            for (int i = 0; i < HOURS; i++) {
                if (i < 10) this.add(new JLabel("0" + i));
                else this.add(new JLabel(String.valueOf(i)));
                for (int j = 0; j < MINUTES; j++) {
                    this.add(new Label("CC"));
                }
            }
        }else{

            int startH = Integer.parseInt(startTime.substring(0, 2));
            int endH = Integer.parseInt(stopTime.substring(0, 2));
            int startM = Integer.parseInt(startTime.substring(3, 5));
            int endM = Integer.parseInt(stopTime.substring(3, 5));
            //init cu -1
            for (int i = 0; i < HOURS; i++)
                for (int j = 0; j < MINUTES; j++)
                    a[i][j] = -1;
            //starth
            if (startH == endH)
                for (int i = startM; i <= endM; i++)
                    a[startH][i] = 0;
            else {
                for (int i = startM; i < MINUTES; i++)
                    a[startH][i] = 0;
                //mijloc
                for (int i = startH + 1; i < endH; i++)
                    for (int j = 0; j < MINUTES; j++)
                        a[i][j] = 0;
                //final
                for (int i = 0; i <= endM; i++)
                    a[endH][i] = 0;
            }

            for (int z = 0; z < programSpecificList.size(); z++) {
                int programSpecificStartHour = programSpecificList.get(z).getIntOraStart();
                int programSpecificStopHour = programSpecificList.get(z).getIntOraEnd();
                int programSpecificStartMinute = programSpecificList.get(z).getIntMinuteStart();
                int programSpecificStopMinute = programSpecificList.get(z).getIntMinuteEnd();
                if (programSpecificStartHour == programSpecificStopHour)
                    for (int i = programSpecificStartMinute; i <= programSpecificStopMinute; i++)
                        a[programSpecificStartHour][i] = 1;
                else {
                    for (int i = programSpecificStartMinute; i < MINUTES; i++)
                        a[programSpecificStartHour][i] = 1;
                    //mijloc
                    for (int i = programSpecificStartHour + 1; i < programSpecificStopHour; i++)
                        for (int j = 0; j < MINUTES; j++)
                            a[i][j] = 1;
                    //final
                    for (int i = 0; i <= programSpecificStopMinute; i++)
                        a[programSpecificStopHour][i] = 1;
                }


            }

            this.setLayout(new GridLayout(25, 61));
            this.add(new JLabel("  "));
            for (int i = 0; i < MINUTES; i++)
                if (i < 10) this.add(new JLabel(" " + i));
                else this.add(new JLabel(String.valueOf(i)));
            for (int i = 0; i < HOURS; i++) {
                if (i < 10) this.add(new JLabel("0" + i));
                else this.add(new JLabel(String.valueOf(i)));
                for (int j = 0; j < MINUTES; j++) {
                    if (a[i][j] == -1)
                        this.add(new Label("X"));
                    else if (a[i][j] == 0) {
                        SchedulerPanelButton schedulerPanelButton = new SchedulerPanelButton(i, j);
                        schedulerPanelButton.addActionListener(listener);
                        schedulerPanelButton.setFont(new Font(Font.SERIF, Font.PLAIN, 8));
                        this.add(schedulerPanelButton);
                    } else this.add(new JLabel("O"));
                }
            }
        }
        this.setVisible(false);
        this.setVisible(true);
    }
}
