import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataManager {
    ArrayList<CSVLine> CSVLine = new ArrayList<>();

    public DataManager() {
    }
    public void addData(String fileName, String dataType){
        for(Year y: Utils.parse(fileName, dataType)){
            years.add(y);
        }
    }







}
