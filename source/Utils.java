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
    public ArrayList<ElectionResults>  parse2016PresidentialResults(String input){
        String[] unparsedElectionResults = input.split("\n");
        ArrayList<ElectionResults> electionResults = new ArrayList<>();
        for(int i = 1; i < unparsedElectionResults.length; i++){
            String[] fields = unparsedElectionResults[i].split(",");
            double votes_dem = Double.parseDouble(fields[1].trim());
            double votes_gop = Double.parseDouble(fields[2].trim());
            double total_votes = Double.parseDouble(fields[3].trim());
            double per_dem = Double.parseDouble(fields[4].trim());
            double per_gop = Double.parseDouble(fields[5].trim());
            String diff = fields[6].trim();
            double per_point = Double.parseDouble(fields[7].trim());
            String state_abbr = fields[8].trim();
            String county_name = fields[9].trim();
            int combined_fips = Integer.parseInt(fields[10].trim());
            ElectionResults results = new ElectionResults(votes_dem, votes_gop, total_votes, per_dem, per_gop, per_point, diff, state_abbr,county_name,combined_fips);
            electionResults.add(results);
        }
        return electionResults;
    }
}
