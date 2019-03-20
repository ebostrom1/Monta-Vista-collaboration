import java.util.ArrayList;
import java.util.HashMap;

public class DataManager {
    HashMap<String, State> states = new HashMap<>();

    public DataManager() {
    }

    private void addData(ArrayList<ElectionData> data){
        for(ElectionData d : data){
            if(states.containsKey(d.getState())){
                states.get(d.getState()).addData(d);
            }else{
                State newState = new State(d.getState());
                states.put(d.getState(), newState);
                states.get(d.getState()).addData(d);
            }
        }
    }
    private void addData(ArrayList<EducationData> data){
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
    private void addData(ArrayList<UnemploymentData> data){
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
        addData(Utils.parseEducationData(Utils.readFileAsString(fileName)));
    }
    public void addElectionData(String fileName){
        addData(Utils.parseElectionResults(Utils.readFileAsString(fileName)));
    }
    public void addUnemployment(String fileName){
        addData(Utils.parseUnemploymentData(Utils.readFileAsString(fileName)));
    }
}
