import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;


public class StudentProcess {

    public Student student;
    private Course course;
    private Advisor advisor;
    private Transcript transcript;

    public StudentProcess(Student newStudent) {
        this.student = newStudent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
