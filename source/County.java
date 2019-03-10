import java.util.ArrayList;

public class County {
    private int FPSnum;
    private String name, State;
    private EducationData edData;
    private UnemplymentData jobData;
    private ElectionResults electData;

    public County(int FPSnum, String name, String state, EducationData edData, UnemplymentData jobData, ElectionResults electData) {
        this.FPSnum = FPSnum;
        this.name = name;
        State = state;
        this.edData = edData;
        this.jobData = jobData;
        this.electData = electData;
    }
}
