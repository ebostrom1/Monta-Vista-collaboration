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

    public static ArrayList<Unemployment> parseUnemployed(String input){
        ArrayList<Unemployment> output = new ArrayList<>();
        input = removeUnwantedChars(input);
        input = removeUnwantedCommas(input);
        String[] lines = input.split("\n");
        for (String line : lines) {
            String[] fields= line.split(",");
            int year = Integer.parseInt(fields[0]);
            for (int i = 1; i < fields.length; i++) {
                String month = "";
                if(i == 1) month=("Jan");
                if(i == 2) month=("Feb");
                if(i == 3) month=("Mar");
                if(i == 4) month=("Apr");
                if(i == 5) month=("May");
                if(i == 6) month=("Jun");
                if(i == 7) month=("Jul");
                if(i == 8) month=("Aug");
                if(i == 9) month=("Sep");
                if(i == 10)month=("Oct");
                if(i == 11)month=("Nov");
                if(i == 12)month=("Dec");
                double unemplymentRate = Double.parseDouble(fields[i]);
                Time time = new Time(month, year);
                output.add(new Unemployment(time, unemplymentRate));
            }

        }
        return output;
    }
    public static ArrayList<Time> parseCrime (String input){
        ArrayList<Time> output = new ArrayList<>();
        input = removeUnwantedChars(input);
        String[] lines = input.split("\n");
        for (String line : lines) {
            line = removeUnwantedCommas(line);
            if(line != null) {
                String[] fields = line.split(",");
                String[] ints = fields[5].split("-");
                String month = ints[1];
                int year = Integer.parseInt(ints[0]);
                output.add(new Time(month, year));
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

}