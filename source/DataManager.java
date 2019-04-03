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
        System.out.println("Unemployment before " + CSVData);
        for(Unemployment unemployment:unemploymentData) {
            if (!CSVData.containsKey(unemployment.getTime())){
                CSVData.put(unemployment.getTime(), new CSVLine(unemployment.getTime()));
            }
            CSVData.get(unemployment.getTime()).addUnemployment(unemployment.getUnemploymentRate());
        }
        System.out.println("Unemployment After " + CSVData.size());
    }

    public void addCrime(ArrayList<Time> crimeRecord){
        System.out.println("Crime before " + CSVData.size());
        for(Time t: crimeRecord){
            if(!CSVData.containsKey(t)){
                CSVData.put(t, new CSVLine(t));
            }
            CSVData.get(t).addCrime();
        }
        System.out.println("Crime after " + CSVData.size());
    }
    public void setEducationData(int year, double numberOfStudentsWithHighSchoolEducation){
        System.out.println("Education before " + CSVData.size());
        for(Map.Entry<Time ,CSVLine> entry: CSVData.entrySet()){
            if (entry.getKey().getYear() == year)
                CSVData.get(entry.getKey()).setEducation(numberOfStudentsWithHighSchoolEducation);
        }
        System.out.println("Education After " + CSVData.size());
    }

    public String printSortCSV(){
        System.out.println("print size " + CSVData.size());
        int size = CSVData.size();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Time smallestTime = new Time();
            System.out.println(CSVData.size());
            System.out.println(i);

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
