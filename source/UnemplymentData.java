public class UnemplymentData {
    private int totalLaborForce, employed, unemployed;
    private double unemploymentRate;

    public UnemplymentData(String[] fields) {
        this.totalLaborForce = Integer.parseInt(fields[46]);
        this.employed = Integer.parseInt(fields[47]);
        this.unemployed = Integer.parseInt(fields[48]);
        this.unemploymentRate = Double.parseDouble(fields[49]);
    }
}
