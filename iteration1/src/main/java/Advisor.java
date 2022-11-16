import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Advisor {
    private String advisorName;
    private String department;
    private String rank;

    public Advisor(String advisorName, String department, String rank) {
        this.advisorName = advisorName;
        this.department = department;
        this.rank = rank;
    }
    public Advisor() {

    }
    ArrayList<Advisor> advisorList = new ArrayList<Advisor>();

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public ArrayList<Advisor> takeAdvisor() throws IOException, ParseException {
        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\Oğuzalp\\Desktop\\inputx.json");
        Object obj = jsonparser.parse(reader);
        JSONObject empjsonobj = (JSONObject)obj;
        JSONArray array = (JSONArray)empjsonobj.get("advisors");
        for(int j=0; j < array.size(); j++) {
            JSONObject advisors = (JSONObject) array.get(j);
            String advisorName = (String) advisors.get("advisorName");
            String department = (String) advisors.get("department");
            String rank = (String) advisors.get("rank");
            Advisor x = new Advisor(advisorName,department,rank);
            advisorList.add(x);
        }
        return advisorList;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public ArrayList<Advisor> advisorArrayList(){

        return advisorList;
    }
}