public class Unemployment {
    private Time time;
    private Double unemploymentRate;

    public Unemployment(Time time, Double unemploymentRate) {
        this.time = time;
        this.unemploymentRate = unemploymentRate;
    }

    public Time getTime() {
        return time;
    }

    public Double getUnemploymentRate() {
        return unemploymentRate;
    }
}
