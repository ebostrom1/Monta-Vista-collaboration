public class UnemploymentData{
    private int totalLaborForce, employed, unemployed;
    private double unemploymentRate;
    private String state, county;

    public UnemploymentData(String[] fields) {
        this.state = fields[2];
        this.county = fields[3];
        this.totalLaborForce = Integer.parseInt(fields[46]);
        this.employed = Integer.parseInt(fields[47]);
        this.unemployed = Integer.parseInt(fields[48]);
        this.unemploymentRate = Double.parseDouble(fields[49]);
    }
    public UnemploymentData(){

    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public int getEmployed() {
        return employed;
    }

    public int getUnemployed() {
        return unemployed;
    }

    public double getUnemploymentRate() {
        return unemploymentRate;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    public void setEmployed(int employed) {
        this.employed = employed;
    }

    public void setUnemployed(int unemployed) {
        this.unemployed = unemployed;
    }

    public void setUnemploymentRate(double unemploymentRate) {
        this.unemploymentRate = unemploymentRate;
    }
}
