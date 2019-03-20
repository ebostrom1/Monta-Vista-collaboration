public class EducationData implements Data{
    private double percentNoHighSchool, percentHighSchool, percentSomeCollege, percentBachloresOrHigher;
    private String state, county;

    // field Index refers to index as entered in the CSV
    public EducationData(String[] Fields) {
        this.percentNoHighSchool = Double.parseDouble(Fields[43]);
        this.percentHighSchool = Double.parseDouble(Fields[44]);
        this.percentSomeCollege = Double.parseDouble(Fields[45]);
        this.percentBachloresOrHigher = Double.parseDouble(Fields[48]);
        this.state = Fields[2];
        this.county = Fields[3];
    }

    @Override
    public Object getSubClass() {
        return this;
    }

    public double getPercentNoHighSchool() {
        return percentNoHighSchool;
    }

    public double getPercentHighSchool() {
        return percentHighSchool;
    }

    public double getPercentSomeCollege() {
        return percentSomeCollege;
    }

    public double getPercentBachloresOrHigher() {
        return percentBachloresOrHigher;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    public void setPercentNoHighSchool(double percentNoHighSchool) {
        this.percentNoHighSchool = percentNoHighSchool;
    }

    public void setPercentHighSchool(double percentHighSchool) {
        this.percentHighSchool = percentHighSchool;
    }

    public void setPercentSomeCollege(double percentSomeCollege) {
        this.percentSomeCollege = percentSomeCollege;
    }

    public void setPercentBachloresOrHigher(double percentBachloresOrHigher) {
        this.percentBachloresOrHigher = percentBachloresOrHigher;
    }

    @Override
    public String toString() {
        return "EducationData{" +
                "percentNoHighSchool=" + percentNoHighSchool +
                ", percentHighSchool=" + percentHighSchool +
                ", percentSomeCollege=" + percentSomeCollege +
                ", percentBachloresOrHigher=" + percentBachloresOrHigher +
                '}';
    }
}
