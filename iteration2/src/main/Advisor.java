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
