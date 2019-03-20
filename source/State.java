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

    public void addData(UnemploymentData unemploymentData){
        if (counties.containsValue(unemploymentData.getCounty())) {
            counties.get(unemploymentData.getCounty()).addData(unemploymentData); {
            }
        }else {
            createNewCounty(unemploymentData.getCounty());
            counties.get(unemploymentData.getCounty()).addData(unemploymentData);
        }
    }
    public void addData(EducationData educationData){
        if (counties.containsValue(educationData.getCounty())) {
            counties.get(educationData.getCounty()).addData(educationData); {
            }
        }else {
            createNewCounty(educationData.getCounty());
            counties.get(educationData.getCounty()).addData(educationData);
        }
    }
    public HashMap<String, County> getCounties(){
        return counties;
    }
}
