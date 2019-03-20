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
    public static ArrayList<EducationData> parseEducationData(String input){
        ArrayList<EducationData> data = new ArrayList<>();
        for(String[] fields : primaryParse(input)){
            data.add(new EducationData(fields));
        }
        return data;
    }

    public static ArrayList<UnemploymentData> parseUnemploymentData(String input){
        ArrayList<UnemploymentData> data = new ArrayList<>();
        for(String[] fields : primaryParse(input)){
            data.add(new UnemploymentData(fields));
        }
        return data;
    }

    private static ArrayList<String[]> primaryParse(String input){
        input = removeUnwantedChars(input);
        input = removeUnwantedCommas(input);
        String[] line = input.split("\n");
        ArrayList<String[]> output = new ArrayList<>();
        for(int i = 1; i < line.length; i++){
            output.add(line[i].split(","));
        }
        return output;
    }
    private static String removeUnwantedChars(String input){
        return input.replaceAll("%","").replaceAll(" ","");
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

    public int Average(int[] data){
        int count = 0;
        for(int i : data){
            count+= i;
        }
        return count/data.length;
    }

}