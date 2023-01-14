import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.Arrays;

public class ProgramGeneric extends JPanel {
    private String[] oraStart=new String[7];
    private String[] oraFinal=new String[7];
    private String[] unitate=new String[7];
    private String id_unitate;
    JLabel[] oreStartLabel=new JLabel[7];
    JLabel[] oreStopLabel=new JLabel[7];
    JLabel idUnitateLabel=new JLabel();
    public ProgramGeneric(){
    }
    public ProgramGeneric(String mon_start, String mon_stop, String mon_id_unitate, String tues_start, String tues_stop, String tues_id_unitate, String wed_start, String wed_stop, String wed_id_unitate, String thurs_start, String thurs_stop, String thurs_id_unitate, String fri_start, String fri_stop, String fri_id_unitate, String sat_start, String sat_stop, String sat_id_unitate, String sun_start, String sun_stop, String sun_id_unitate) {
        oraStart[0]=mon_start;
        oraStart[1]=tues_start;
        oraStart[2]=wed_start;
        oraStart[3]=thurs_start;
        oraStart[4]=fri_start;
        oraStart[5]=sat_start;
        oraStart[6]=sun_start;

        oraFinal[0]=mon_stop;
        oraFinal[1]=tues_stop;
        oraFinal[2]=wed_stop;
        oraFinal[3]=thurs_stop;
        oraFinal[4]=fri_stop;
        oraFinal[5]=sat_stop;
        oraFinal[6]=sun_stop;

        unitate[0]=mon_id_unitate;
        unitate[1]=tues_id_unitate;
        unitate[2]=wed_id_unitate;
        unitate[3]=thurs_id_unitate;
        unitate[4]=fri_id_unitate;
        unitate[5]=sat_id_unitate;
        unitate[6]=sun_id_unitate;
    }

    public void setProgram(String mon_start, String mon_stop, String mon_id_unitate, String tues_start, String tues_stop, String tues_id_unitate, String wed_start, String wed_stop, String wed_id_unitate, String thurs_start, String thurs_stop, String thurs_id_unitate, String fri_start, String fri_stop, String fri_id_unitate, String sat_start, String sat_stop, String sat_id_unitate, String sun_start, String sun_stop, String sun_id_unitate){
        oraStart[0]=mon_start;
        oraStart[1]=tues_start;
        oraStart[2]=wed_start;
        oraStart[3]=thurs_start;
        oraStart[4]=fri_start;
        oraStart[5]=sat_start;
        oraStart[6]=sun_start;

        oraFinal[0]=mon_stop;
        oraFinal[1]=tues_stop;
        oraFinal[2]=wed_stop;
        oraFinal[3]=thurs_stop;
        oraFinal[4]=fri_stop;
        oraFinal[5]=sat_stop;
        oraFinal[6]=sun_stop;

        unitate[0]=mon_id_unitate;
        unitate[1]=tues_id_unitate;
        unitate[2]=wed_id_unitate;
        unitate[3]=thurs_id_unitate;
        unitate[4]=fri_id_unitate;
        unitate[5]=sat_id_unitate;
        unitate[6]=sun_id_unitate;
    }

    public void setProgram(ProgramGeneric programGeneric){
        oraStart[0]= programGeneric.getOraStart(0);
        oraStart[1]=programGeneric.getOraStart(1);
        oraStart[2]=programGeneric.getOraStart(2);
        oraStart[3]=programGeneric.getOraStart(3);
        oraStart[4]=programGeneric.getOraStart(4);
        oraStart[5]=programGeneric.getOraStart(5);
        oraStart[6]=programGeneric.getOraStart(6);

        oraFinal[0]= programGeneric.getOraFinal(0);
        oraFinal[1]=programGeneric.getOraFinal(1);
        oraFinal[2]=programGeneric.getOraFinal(2);
        oraFinal[3]=programGeneric.getOraFinal(3);
        oraFinal[4]=programGeneric.getOraFinal(4);
        oraFinal[5]=programGeneric.getOraFinal(5);
        oraFinal[6]=programGeneric.getOraFinal(6);

        unitate[0]= programGeneric.getUnitate(0);
        unitate[1]=programGeneric.getUnitate(1);
        unitate[2]=programGeneric.getUnitate(2);
        unitate[3]=programGeneric.getUnitate(3);
        unitate[4]=programGeneric.getUnitate(4);
        unitate[5]=programGeneric.getUnitate(5);
        unitate[6]=programGeneric.getUnitate(6);
    }

    public ProgramGeneric(String id_unitate,String[] oraStart, String[] oraFinal) {
        this.id_unitate=id_unitate;
        this.oraStart = oraStart;
        this.oraFinal = oraFinal;
        idUnitateLabel.setText(id_unitate);
        this.setLayout(new GridLayout(1,15));
        this.setPreferredSize(new Dimension(100,25));
        this.setMaximumSize(new Dimension(10000,25));
        this.add(idUnitateLabel);
        for(int i=0;i<7;i++){
            oreStartLabel[i]=new JLabel(oraStart[i]);
            oreStopLabel[i]=new JLabel(oraFinal[i]);
            this.add(oreStartLabel[i]);
            this.add(oreStopLabel[i]);
        }
    }

    public void setOraStart(String ora, int index){
        oraStart[index]=ora;
    }
    public void setOraFinal(String ora,int index){
        oraFinal[index]=ora;
    }
    public void setUnitate(String newUnitate,int index){
        unitate[index]=newUnitate;
    }
    public void setZi(String oraS,String oraF,String newUnitate,int index){
        oraStart[index]=oraS;
        oraFinal[index]=oraF;
        unitate[index]=newUnitate;
    }
    public String getOraStart(int index){
        return oraStart[index];
    }
    public String getOraFinal(int index){
        return oraFinal[index];
    }
    public String getUnitate(int index){
        return unitate[index];
    }

    public String getId_unitate() {
        return id_unitate;
    }

    @Override
    public String toString() {
        return "ProgramGeneric{" +
                "oraStart=" + Arrays.toString(oraStart) +
                ", oraFinal=" + Arrays.toString(oraFinal) +
                ", unitate=" + Arrays.toString(unitate) +
                '}';
    }
    public boolean verif(int zi,String oraStart,String oraStop){
        LocalTime oraStartConv = LocalTime.parse( oraStart ) ;
        LocalTime oraStopConv = LocalTime.parse( oraStop ) ;
        LocalTime oraStartUnitConv = LocalTime.parse( this.oraStart[zi] ) ;
        LocalTime oraStopUnitConv = LocalTime.parse( this.oraFinal[zi] ) ;
        if(oraStartConv.isAfter(oraStopConv))return false;
        if(oraStartConv.isBefore(oraStartUnitConv))return false;
        if(oraStartConv.isAfter(oraStopUnitConv))return false;
        if(oraStopConv.isBefore(oraStartUnitConv))return false;
        if(oraStopConv.isAfter(oraStopUnitConv))return false;
        return true;
    }
}
