import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
    //,votes_dem,votes_gop,total_votes,per_dem,per_gop,diff,per_point_diff,state_abbr,county_name,combined_fips
    public static ArrayList<ElectionResults>  parse2016PresidentialResults(String input){
        String[] unparsedElectionResults = input.split("\n");
        ArrayList<ElectionResults> electionResults = new ArrayList<>();
        for(int i = 1; i < unparsedElectionResults.length; i++){
            unparsedElectionResults[i].replaceAll("%", "");
            ElectionResults results = new ElectionResults(split(unparsedElectionResults[i]));
            electionResults.add(results);
        }
        return electionResults;
    }
    private static String RemoveCandQ(String input){
        input.replaceAll("\"", "" );
        return input.replaceAll(",","");
    }
    private static String[] split(String text){
        String[] output = new String [11];
        int a =0;
        for (int i = 0; i < 6; i++) {
           output[i]= text.substring(a,text.indexOf(",",a));
           a = text.indexOf(",",a);
        }
        int b = text.length();
        for (int i = 11; i > 6; i--) {
            output[i]= text.substring(text.lastIndexOf(",",b),b);
            a = text.lastIndexOf(",",b);
        }
        output[6] = RemoveCandQ(text.substring(a,b));
        return output;
    }
}