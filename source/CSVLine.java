public class CSVLine {
    Time time;
    int education;
    int crime;
    double unemployment;
    int count;
    public CSVLine(Time time){
        this.time =  time;
        count = 0;
    }

    public Time getTime() {
        return time;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public void addCrime() {
        crime++;
    }

    public void addUnemployment(double unemploymentRate){
        unemployment = unemployment*count;
        unemployment = (unemployment+unemploymentRate)/(count+1);
        count++;
    }
    @Override
    public String toString() {
        return time +
                "," + education +
                "," + crime +
                "," + unemployment +
                "\n";
    }
}
