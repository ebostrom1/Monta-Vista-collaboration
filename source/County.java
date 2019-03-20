public class County {
    private String name, State;
    private EducationData edData;
    private UnemploymentData jobData;
    public boolean complete;

    public County(String name, String state) {
        this.name = name;
        State = state;
        complete = false;
    }

    public void addData(EducationData educationData){
        this.edData = educationData;
    }
    public void addData(UnemploymentData unemploymentData){
        this.jobData = unemploymentData;
        checkIfComplete();
    }

    private void checkIfComplete() {
        if(edData != null && jobData != null) complete = true;
    }

    public EducationData getEdData() {
        return edData;
    }

    public UnemploymentData getJobData() {
        return jobData;
    }


}
