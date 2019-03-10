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
    public static ArrayList<ElectionResults>  parse2016PresidentialResults(String input){
        ArrayList<ElectionResults> electionResults = new ArrayList<>();
        for( String[] line : primaryParse(input,11)){
            ElectionResults results = new ElectionResults(line);
            electionResults.add(results);
        }
        return electionResults;
    }
    public static ArrayList<EducationData>  parseEducationData(String input){
        ArrayList<EducationData> educationResults = new ArrayList<>();
        for( String[] line : primaryParse(input,47)){
            EducationData results = new EducationData(line);
            educationResults.add(results);
        }
        return educationResults;
    }
    public static ArrayList<UnemplymentData>  parseUnemploymentData(String input){
        ArrayList<UnemplymentData> UnemploymentResults = new ArrayList<>();
        for( String[] line : primaryParse(input,56)){
            UnemplymentData results = new UnemplymentData(line);
            UnemploymentResults.add(results);
        }
        return UnemploymentResults;
    }
    //,votes_dem,votes_gop,total_votes,per_dem,per_gop,diff,per_point_diff,state_abbr,county_name,combined_fips
    private static String[][] primaryParse(String input , int fields){
        String[] unparsedResults = input.split("\n");
        String[][]parsedData = new String[unparsedResults.length][fields];
        for(int i = 1; i < unparsedResults.length; i++){
            unparsedResults[i] = removeUnwantedChars(unparsedResults[i]);
            unparsedResults[i] = removeUnwantedCommas( unparsedResults[i]);
            parsedData[i] = split(unparsedResults[i], fields);
        }
        return parsedData;
    }
    private static String removeUnwantedChars(String input){
        return input.replaceAll("%","").replaceAll(" ","");
    }

    private static String[] split(String text, int numOfFields){
        String[] output = new String [numOfFields];
        int a = -1;
        for (int i = 0; i < numOfFields; i++) {
            int end = text.indexOf(",",a+1);
            if(text.indexOf(",",a+1) == -1) end = text.length();
            output[i]= text.substring(a+1,end);
            a = text.indexOf(",",a+1);
        }
        return output;
    }
    private static String removeUnwantedCommas(String line){
        boolean inQuote = false;
        int startIndex = 0;
        for (int i = 0; i < line.length(); i++) {
             if(line.charAt(i) == '\"' && !inQuote){
                 inQuote = true;
                 startIndex = i;
             }else if(line.charAt(i) == '\"'){
                 inQuote = false;
                 line = line.replaceAll(line.substring(startIndex, i+1) , line.substring(startIndex, i+1).replaceAll(",", "").replaceAll("\"",""));
             }
        }
        return line;
    }
}