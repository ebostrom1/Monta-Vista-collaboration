import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataManager {
    HashMap<String, State> states = new HashMap<>();

    public DataManager() {
    }


    private void addData(ArrayList<EducationData> data, EducationData erasureFix){
        for(EducationData d : data){
            if(states.containsKey(d.getState())){
                states.get(d.getState()).addData(d);
            }else{
                State newState = new State(d.getState());
                states.put(d.getState(), newState);
                states.get(d.getState()).addData(d);
            }
        }
    }
    private void addData(ArrayList<UnemploymentData> data, UnemploymentData erasureFix){
        for(UnemploymentData d : data){
            if(states.containsKey(d.getState())){
                states.get(d.getState()).addData(d);
            }else{
                State newState = new State(d.getState());
                states.put(d.getState(), newState);
                states.get(d.getState()).addData(d);
            }
        }
    }
    public void addEducationData(String fileName){
        addData(Utils.parseEducationData(Utils.readFileAsString(fileName)), new EducationData());
    }

    public void addUnemployment(String fileName){
        addData(Utils.parseUnemploymentData(Utils.readFileAsString(fileName)), new UnemploymentData());
    }

    public ArrayList<EducationData> getAllEducationData() {
        ArrayList<EducationData> output = new ArrayList<>();
        for (Map.Entry<String, State> StateEntry : states.entrySet()) {
            for (Map.Entry<String, County> countyEntry : StateEntry.getValue().getCounties().entrySet()) {
                output.add(countyEntry.getValue().getEdData());
            }
        }
        return output;
    }

    public ArrayList<UnemploymentData> getAllUnemploymentData() {
        ArrayList<UnemploymentData> output = new ArrayList<>();
        for (Map.Entry<String, State> StateEntry : states.entrySet()) {
            for (Map.Entry<String, County> countyEntry : StateEntry.getValue().getCounties().entrySet()) {
                output.add(countyEntry.getValue().getJobData());
            }
        }
        return output;
    }
    private County getCounty( String state, String county){
        return states.get(state).getCounties().get(county);
    }
    private void removeIncompleteCounties(){
        for (Map.Entry<String, State> StateEntry : states.entrySet()) {
            for (Map.Entry<String, County> countyEntry : StateEntry.getValue().getCounties().entrySet()) {
                if(countyEntry.getValue().complete == false) StateEntry.getValue().getCounties().remove(countyEntry.getKey());
            }
        }
    }


}
