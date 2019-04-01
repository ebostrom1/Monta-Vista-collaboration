import org.w3c.dom.css.CSSCharsetRule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public static ArrayList<Year> parse(String fileName, String DataType){
        String CSVtext = readFileAsString(fileName);
        if(DataType.equals("Education")){
            return parseEducationData(CSVtext);
        }
        if(DataType.equals("Unemployment")){
            return parseUnemploymentData(CSVtext);
        }
        if(DataType.equals("Crime")){
            return parseCrimeData(CSVtext);
        }
        return null;
    }
    private static ArrayList<Year> parseEducationData(String input){
        ArrayList<Year> output = new ArrayList<>();
        for (String[] arr: primaryParse(input, new int[]{6})) {
            for (int i = 0; i < arr.length; i++) {
                String s = arr[i];

            }

        }
    }

    private static String[] parseUnemploymentData(String input){
        ArrayList<Year> output = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            output.add(new Year(2016+i, "Unemployment"));
        }
        for (String[] arr: primaryParse(input, new int[]{1,2,6})) {

            output.add()

        }
    }
    private static ArrayList<Year> parseCrimeData(String input){

    }

    private static String[][] primaryParse(String input,int priorityIndex[]){
        input = removeUnwantedChars(input);
        String[] line = input.split("\n");
        String[][] output = new String[line.length][3];
        for(int i = 1; i < line.length; i++){
            line[i] = removeUnwantedCommas(line[i]);
            String[] fields = line[i].split(",");
            for (int j = 0; j < fields.length; j++) {
                for (int k = 0; k < priorityIndex.length; k++) {
                    if(j == priorityIndex[k]){
                        output[i][k]= fields[j];
                    }

                }
            }
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
             if(line.contains(",,")) return null;
        }
        return line;
    }

    public static void WriteCSVfile(String fileName, String body){
        File file = new File(fileName);
        try{
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(body);
            writer.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static String generateTableTemplet(int[] numYears, String crimeFile, String employmentFile, String educationFile){
        String output = "";
        for (int i = 0; i < numYears.length; i++) {
            for (int j = 0; j < 12; j++) {
                if(j == 1) output+=("January " + numYears + ","+ "" "\n");
                if(j == 2) output+=("Febuary " + numYears+ "\n");
                if(j == 3) output+=("March " + numYears+ "\n");
                if(j == 4) output+=("April " + numYears+ "\n");
                if(j == 5) output+=("May " + numYears+ "\n");
                if(j == 6) output+=("June " + numYears+ "\n");
                if(j == 7) output+=("July " + numYears+ "\n");
                if(j == 8) output+=("August " + numYears+ "\n");
                if(j == 9) output+=("September " + numYears+ "\n");
                if(j == 10) output+=("October " + numYears+ "\n");
                if(j == 11) output+=("November " + numYears+ "\n");
                if(j == 12) output+=("December " + numYears+ "\n");
            }

        }
    }


}