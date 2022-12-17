import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Advisor extends Person {

    private ArrayList<Advisor> AdvisorArrayList = new ArrayList<Advisor>();

    public Advisor() {
        super();
    }

    public Advisor(String AdvisorName, String department, String rank) {
        super(AdvisorName,department,rank);
    }

    public ArrayList<Advisor> getAdvisorList() {
        return AdvisorArrayList;
    }

    public void setAdvisorList(ArrayList<Advisor> AdvisorList) {
        AdvisorArrayList = AdvisorList;
    }
    
    public ArrayList<Advisor> takeAdvisorFromInputFile() throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\90554\\eclipse-workspace\\Projemiz\\input.json");
        Object obj = jsonparser.parse(reader);
        JSONObject empjsonobj = (JSONObject)obj;
        JSONArray advisorArray = (JSONArray)empjsonobj.get("advisors");
        for(int j = 0; j < advisorArray.size(); j++) {
            JSONObject Advisors = (JSONObject) advisorArray.get(j);
            String AdvisorName = (String) Advisors.get("advisorName");
            String department = (String) Advisors.get("department");
            String title = (String) Advisors.get("rank");
            Advisor AdvisorObj = new Advisor(AdvisorName,department,title);
            AdvisorArrayList.add(AdvisorObj);
        }
        return AdvisorArrayList;
    }
