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
