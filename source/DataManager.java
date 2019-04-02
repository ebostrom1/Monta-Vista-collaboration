import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataManager {
    HashMap<Time, CSVLine> CSVData;

    public DataManager() {
        CSVData = new HashMap<>();
    }
    public void addUnemployment(ArrayList<Unemployment> unemploymentData){
        for(Unemployment unemployment:unemploymentData) {
            if (!CSVData.containsKey(unemployment.getTime())){
                CSVData.put(unemployment.getTime(), new CSVLine(unemployment.getTime()));
            }
            CSVData.get(unemployment.getTime()).addUnemployment(unemployment.getUnemploymentRate());
        }
    }

    public void addCrime(ArrayList<Time> crimeRecord){
        for(Time t: crimeRecord){
            if(!CSVData.containsKey(t)){
                CSVData.put(t, new CSVLine(t));
            }
            CSVData.get(t).addCrime();
        }
    }
    public void setEducationData(int year, double numberOfStudentsWithHighSchoolEducation){
        for(Map.Entry<Time ,CSVLine> entry: CSVData.entrySet()){
            if (entry.getKey().getYear() == year)
                entry.getValue().setEducation(numberOfStudentsWithHighSchoolEducation);
        }
    }

    public String printSortCSV(){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < CSVData.size(); i++) {
            Time smallestTime = new Time();
            for (Map.Entry<Time, CSVLine> line : CSVData.entrySet()) {
                if (line.getValue().getTime().comparableTime()<smallestTime.comparableTime()){
                    smallestTime = line.getValue().getTime();
                }
            }
            output.append(CSVData.remove(smallestTime));
        }
        return output.toString();
    }







}
