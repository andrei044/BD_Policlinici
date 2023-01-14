public class Programare {
    private String timpStart;
    private String timpEnd;
    private String oraStart;
    private String oraEnd;
    private String minuteStart;
    private String minuteEnd;
    private int intOraStart;
    private int intOraEnd;
    private int intMinuteStart;
    private int intMinuteEnd;

    public Programare(String newTimpStart,String newTimpEnd) {
        timpStart=newTimpStart;
        timpEnd=newTimpEnd;
        oraStart=timpStart.substring(0,2);
        minuteStart=timpStart.substring(3,5);
        oraEnd=timpEnd.substring(0,2);
        minuteEnd=timpEnd.substring(3,5);
        intOraStart=Integer.parseInt(oraStart);
        intOraEnd=Integer.parseInt(oraEnd);
        intMinuteStart=Integer.parseInt(minuteStart);
        intMinuteEnd=Integer.parseInt(minuteEnd);
    }

    public String getTimpStart() {
        return timpStart;
    }

    public String getTimpEnd() {
        return timpEnd;
    }

    public String getOraStart() {
        return oraStart;
    }

    public String getOraEnd() {
        return oraEnd;
    }

    public String getMinuteStart() {
        return minuteStart;
    }

    public String getMinuteEnd() {
        return minuteEnd;
    }

    public int getIntOraStart() {
        return intOraStart;
    }

    public int getIntOraEnd() {
        return intOraEnd;
    }

    public int getIntMinuteStart() {
        return intMinuteStart;
    }

    public int getIntMinuteEnd() {
        return intMinuteEnd;
    }

    @Override
    public String toString() {
        return "Programare{" +
                "timpStart='" + timpStart + '\'' +
                ", timpEnd='" + timpEnd + '\'' +
                ", oraStart='" + oraStart + '\'' +
                ", oraEnd='" + oraEnd + '\'' +
                ", minuteStart='" + minuteStart + '\'' +
                ", minuteEnd='" + minuteEnd + '\'' +
                ", intOraStart=" + intOraStart +
                ", intOraEnd=" + intOraEnd +
                ", intMinuteStart=" + intMinuteStart +
                ", intMinuteEnd=" + intMinuteEnd +
                '}';
    }
}
