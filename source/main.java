import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        DataManager data = new DataManager();
        data.addUnemployment(Utils.parseUnemployed(Utils.readFileAsString("data/Unemployment.csv")));
        data.addCrime(Utils.parseCrime(Utils.readFileAsString("data/Crime.csv")));
        data.setEducationData(2016 ,1.67);
        data.setEducationData(2017 ,1.72);
        data.setEducationData(2015 ,1.45);
        Utils.WriteCSVfile("MontaVista.csv" , data.printSortCSV());
    }
}
