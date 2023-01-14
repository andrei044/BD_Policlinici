import javax.swing.*;

public class SchedulerPanelButton extends JButton {
    private int hour;
    private int minute;

    public SchedulerPanelButton(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        if(minute>=10){
            this.setText(String.valueOf(minute));
        }
        else
            this.setText("0"+String.valueOf(minute));
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
    public String getTime(){
        String outHour,outMinute;
        if(hour<10)
            outHour="0"+String.valueOf(hour);
        else
            outHour=String.valueOf(hour);
        if(minute<10)
            outMinute="0"+String.valueOf(minute);
        else
            outMinute=String.valueOf(minute);
        return outHour+":"+outMinute;
    }
}
