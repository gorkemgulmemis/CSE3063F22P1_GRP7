import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import org.json.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Student extends Person {

    private int studentNumber;
    private int year;
    private int semester;
    private ArrayList<Student> studentArrayList = new ArrayList<Student>();

    public Student() {
        super();
    }

    public Student(String name, String department,  int year, int studentNumber, int semester, String rank) {
        super(name,department,rank);
        this.studentNumber = studentNumber;
        this.year = year;
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {

        this.semester = generateStudentSemester(semester);
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }
