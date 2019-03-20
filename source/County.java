public class County {
    private String name, State;
    private EducationData edData;
    private UnemploymentData jobData;
    private ElectionData electData;

    public County(String name, String state) {
        this.name = name;
        State = state;
    }

    public void addData(EducationData educationData){
        this.edData = educationData;
    }
    public void addData(ElectionData electionData){
        this.electData =electionData;
    }
    public void addData(UnemploymentData unemploymentData){
        this.jobData = unemploymentData;
    }

    public EducationData getEdData() {
        return edData;
    }

    public UnemploymentData getJobData() {
        return jobData;
    }

    public ElectionData getElectData() {
        return electData;
    }

}
