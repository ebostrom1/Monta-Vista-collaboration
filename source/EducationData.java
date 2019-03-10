public class EducationData {
    private double percentNoHighSchool, percentHighSchool, percentSomeCollege, percentBachloresOrHigher;

    // field Index refers to index as entered in the CSV
    public EducationData(String[] Fields) {
        this.percentNoHighSchool = Double.parseDouble(Fields[43]);
        this.percentHighSchool = Double.parseDouble(Fields[44]);
        this.percentSomeCollege = Double.parseDouble(Fields[45]);
        this.percentBachloresOrHigher = Double.parseDouble(Fields[48]);
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
