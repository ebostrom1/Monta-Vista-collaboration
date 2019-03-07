import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        System.out.println(Utils.readFileAsString("data/2016_Presidential_Results.csv"));
        ArrayList<ElectionResults> data = Utils.parse2016PresidentialResults(Utils.readFileAsString("data/2016_Presidential_Results.csv"));
        for(ElectionResults e : data){
            System.out.println(e);
        }
    }
}
