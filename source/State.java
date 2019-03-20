import java.util.HashMap;

public class State {
    private String name;
    private HashMap<String, County> counties;
    public State(String name)  {
        this.name = name;
    }

    private void createNewCounty(String county) {
        County newCounty = new County(county, this.name);
        counties.put(county, newCounty);
    }

    public void addData(ElectionData electionData){
        if (counties.containsValue(electionData.getCounty())) {
            counties.get(electionData.getCounty()).addData(electionData); {
            }
        }else {
            createNewCounty(electionData.getCounty());
            counties.get(electionData.getCounty()).addData(electionData);
        }
    }
    public void addData(UnemploymentData unemploymentData){
        if (counties.containsValue(unemploymentData.getCounty())) {
            counties.get(unemploymentData.getCounty()).addData(unemploymentData); {
            }
        }else {
            createNewCounty(unemploymentData.getCounty());
            counties.get(unemploymentData.getCounty()).addData(unemploymentData);
        }
    }
    
}
