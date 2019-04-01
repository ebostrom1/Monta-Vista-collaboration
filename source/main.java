import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        DataManager data = new DataManager();
        data.addEducationData("data/Education.csv");
        data.addUnemployment("data/Unemployment.csv");
        data.addCrimeData("data/Crime.csv");
    }
}
