import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Course  {
    private String courseName;
    private int courseCredit;
    ArrayList<Course> courseList = new ArrayList<Course>();


    public Course(){

    }
    public Course(String courseName, int courseCredit) {
        this.courseName = courseName;
        this.courseCredit = courseCredit;
    }


    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCourseCredit() {
        return courseCredit;
    }
    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public ArrayList<Course> takeCourses(int z) throws IOException, ParseException {
        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\Oğuzalp\\Desktop\\inputx.json");
        Object obj = jsonparser.parse(reader);
        JSONObject empjsonobj = (JSONObject)obj;
        for(int i = 1; i < z; i++ ) {
            JSONArray array = (JSONArray)empjsonobj.get("Semester" + i);
            for(int j=0; j < array.size(); j++) {
                JSONObject obj2 = (JSONObject) array.get(j);
                String courseName = (String) obj2.get("courseName");
                String credit = (String) obj2.get("courseCredit").toString();
                int qwe = Integer.parseInt(credit);
                Course x = new Course(courseName,qwe);
                courseList.add(x);
			/* System.out.println(" " + advisorName + " " + department + " ");
			System.out.println(); */
            }
        }
        return courseList;

    }
    public ArrayList<Course> courseArrayList(){

        return courseList;
    }
}