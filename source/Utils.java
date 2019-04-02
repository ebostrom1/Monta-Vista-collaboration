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

    public static ArrayList<Unemployment> parseUnemployed

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