import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
       // System.out.println(Utils.readFileAsString("data/2016_Presidential_Results.csv"));
        DataManager data = new DataManager();
        data.addEducationData("data/Education.csv");
        data.addElectionData("data/2016_Presidential_Results.csv");
        data.addUnemployment("data/Unemployment.csv");
    }
}
