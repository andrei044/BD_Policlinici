public class IntervalOre {
    String oraStart;
    String oraStop;
    public IntervalOre(String oraStart, String oraStop) {
        this.oraStart = oraStart;
        this.oraStop = oraStop;
    }

    @Override
    public String toString() {
        return "IntervalOre{" +
                "oraStart='" + oraStart + '\'' +
                ", oraStop='" + oraStop + '\'' +
                '}';
    }

    public String getOraStart() {
        return oraStart;
    }

    public String getOraStop() {
        return oraStop;
    }
}
