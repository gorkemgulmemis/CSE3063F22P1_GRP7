import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Course  {

    private String courseName;
    private int courseCredit;

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<Course> electiveCourseList = new ArrayList<Course>();
    private ArrayList<Course> lastSemesterCourseList = new ArrayList<Course>();

    public Course(){
        super();
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

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public ArrayList<Course> getElectiveCourseList() {
        return electiveCourseList;
    }

    public void setElectiveCourseList(ArrayList<Course> electiveCourseList) {
        this.electiveCourseList = electiveCourseList;
    }

    public ArrayList<Course> getLastSemesterCourseList() {
        return lastSemesterCourseList;
    }

    public void setLastSemesterCourseList(ArrayList<Course> lastSemesterCourseList) {
        this.lastSemesterCourseList = lastSemesterCourseList;
    }

    public ArrayList<Course> takeCoursesFromInputFile(int semester) throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\Oğuzalp\\Desktop\\input.json");
        Object object = jsonparser.parse(reader);
        JSONObject coursejsonobject = (JSONObject)object;
        for(int i = 1; i < semester; i++ ) {
            JSONArray array = (JSONArray)coursejsonobject.get("Semester" + i);
            for(int j = 0; j < array.size(); j++) {
                JSONObject object2 = (JSONObject) array.get(j);
                String courseName = (String) object2.get("courseName");
                String courseCredit = (String) object2.get("courseCredit").toString();
                int courseCreditIntegerState = Integer.parseInt(courseCredit);
                Course courseObject = new Course(courseName,courseCreditIntegerState);
                courseList.add(courseObject);

            }
        }
        return courseList;
    }
    public ArrayList<Course> takeElectiveCoursesFromInputFile() throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\90554\\eclipse-workspace\\Projemiz\\input.json");
        Object object = jsonparser.parse(reader);
        JSONObject coursejsonobject = (JSONObject)object;


        JSONArray array = (JSONArray)coursejsonobject.get("NTE");
        for(int j = 0; j < array.size(); j++) {
            JSONObject object2 = (JSONObject) array.get(j);
            String courseName = (String) object2.get("courseName");
            String courseCredit = (String) object2.get("courseCredit").toString();
            int electiveCourseCreditIntegerState = Integer.parseInt(courseCredit);
            Course electiveNTECourseObject = new Course(courseName,electiveCourseCreditIntegerState);
            electiveCourseList.add(electiveNTECourseObject);

        }

        JSONArray array1 = (JSONArray)coursejsonobject.get("ENG-UE");
        for(int j = 0; j < array1.size(); j++) {
            JSONObject object2 = (JSONObject) array.get(j);
            String courseName = (String) object2.get("courseName");
            String courseCredit = (String) object2.get("courseCredit").toString();
            int electiveCourseCreditIntegerState = Integer.parseInt(courseCredit);
            Course electiveUECourseObject = new Course(courseName,electiveCourseCreditIntegerState);
            electiveCourseList.add(electiveUECourseObject);

        }
        JSONArray array2 = (JSONArray)coursejsonobject.get("TE");
        for(int j = 0; j < array2.size(); j++) {
            JSONObject object2 = (JSONObject) array.get(j);
            String courseName = (String) object2.get("courseName");
            String courseCredit = (String) object2.get("courseCredit").toString();
            int electiveCourseCreditIntegerState = Integer.parseInt(courseCredit);
            Course electiveTECourseObject = new Course(courseName,electiveCourseCreditIntegerState);
            electiveCourseList.add(electiveTECourseObject);

        }

        JSONArray array3 = (JSONArray)coursejsonobject.get("ENG-FTE");
        for(int j = 0; j < array3.size(); j++) {
            JSONObject object2 = (JSONObject) array.get(j);
            String courseName = (String) object2.get("courseName");
            String courseCredit = (String) object2.get("courseCredit").toString();
            int electiveCourseCreditIntegerState = Integer.parseInt(courseCredit);
            Course electiveFTECourseObject = new Course(courseName,electiveCourseCreditIntegerState);
            electiveCourseList.add(electiveFTECourseObject);

        }

        return electiveCourseList;
    }
    public ArrayList<Course> takeLastSemesterCourseFromInputFile(int semester) throws IOException, ParseException {
        JSONParser jsonparser1 = new JSONParser();
        FileReader reader1 = new FileReader("C:\\Users\\Oğuzalp\\Desktop\\input.json");
        Object object1 = jsonparser1.parse(reader1);
        JSONObject empjsonobj1 = (JSONObject)object1;
        JSONArray array1 = (JSONArray)empjsonobj1.get("Semester" + semester);
        for(int j = 0; j < array1.size(); j++) {
            JSONObject object3 = (JSONObject) array1.get(j);
            String lastSemesterCourseName = (String) object3.get("courseName");
            int lastSemesterCredit = Integer.parseInt((String) object3.get("courseCredit").toString());
            setCourseCredit(lastSemesterCredit);
            Course lastSemesterCourseObject = new Course(lastSemesterCourseName,lastSemesterCredit);
            lastSemesterCourseList.add(lastSemesterCourseObject);
        }
        return lastSemesterCourseList;
    }
}
