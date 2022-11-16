import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Student {

    private int studentNumber;
    private String studentName;
    private int year;
    private int semester;

    ArrayList<Student>  studentArrayList = new ArrayList<Student>();
    public Student() {

    }
	/*
	public Student() {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.year = year;
		this.semester = semester;
	}

	public Student(int studentNumber, String studentName, int year, int semester) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.year = year;
		this.semester = semester;
	}

*/

    public Student(String studentName) {
        this.studentName = studentName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String generateRandomName() {
        Random random = new Random();

        String[] firstNames = {"Selim", "Kaan", "Ali", "Muzaffer", "Elif", "Berke", "Sadık", "Bekir", "Kemal",
                "Gökçe", "Mert", "Ayşenur", "Ferhat", "Ebrar", "Görkem", "Oğuzalp", "Melikşah", "İrfancan", "Atilla", "Dilara", "Şevval",
                "Muhammed", "Fedai", "Batuhan", "Eda", "Taylan", "Korkut", "Ömer Faruk", "Ebubekir Sıddık", "Deniz", "Meryem", "Danyal",
                "Emre", "Nazım", "Hikmet", "Talha", "Yakup", "Zülfikar", "Ceylin", "Emircan", "Mervan", "Pekgüzel", "Büşra",
                "İrem", "Mehlika", "Asena", "Ahsen", "Yağmur", "Enes"};
        String[] lastNames = {"iğrek", "Mungan", "Mustan", "Koçoğlu", "Dizer", "Yıldırım", "Meydan", "Erkam",
                "Bilge", "Albeni", "Aktemur", "Tatlı", "Dikici", "Balta", "Demirel", "Yavaş", "Aktaş",
                "Kıl", "Zengin", "Koç", "Sabancı", "Terim", "Ülker", "Yandaş", "Yıldırım", "Tüfekci", "Karaköse",
                "İpek", "Gülmemiş", "Bal", "Derici", "Belözoğlu", "Bayındır", "Aziz", "Kahveci", "Kadıoğlu", "Karaçay",
                "Kamaylı"};

        String fullName = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];

        return fullName;

    }

    public int generateStudentNumber(int year, int count) {

        String numberStart = Integer.toString(150123-year);
        numberStart += "0";
        String studentNum = "";
        if (count<10)
            studentNum = numberStart + "0"+ Integer.toString(count + 1);
        else
            studentNum = numberStart + Integer.toString(count + 1);

        return Integer.parseInt(studentNum);
    }

    public int generateStudentSemester(int year) {
        Random random = new Random();

        int number =0;
        if(year==1) {
            number=1;
        }
        else if(year==2) {
            number=3;
        }
        else if(year==3) {
            number=5;
        }
        else if(year==4) {
            number=7;
        }
        return number;
    }


    public static void createStudent(int year, int i) throws ParseException {
        int a=0;

        Student student = new Student();
        student.setStudentName(student.generateRandomName());
        student.setYear(year);
        student.setStudentNumber(student.generateStudentNumber(year,i));
        student.setSemester(year);
        student.studentArrayList.add(student);

        student.createJson(a);
        a++;

    }
    public ArrayList<Student> Method(){

        return studentArrayList;
    }

    public void createJson(int a) throws ParseException{

        String path = "\\C:\\Users\\Oğuzalp\\Desktop\\student\\"+this.getStudentNumber() +".json";

        JSONObject json = new JSONObject();
        try {
            json.put("student name:", Method().get(a).studentName);
            json.put("student year:", Method().get(a).year);
            json.put("student semester:", Method().get(a).semester);
            json.put("student number:", Method().get(a).studentNumber);
            Course course = new Course();
            Advisor advisor = new Advisor();
            course.takeCourses(this.Method().get(a).getSemester() + 1);
            for(int i = 0; i < course.courseList.size(); i++) {
                json.put("course name " + i,course.courseList.get(i).getCourseName());
                json.put("course name:", course.courseArrayList().get(a).getCourseName());
            }
            advisor.takeAdvisor();
            json.put("advisor name ", advisor.advisorArrayList().get(0).getAdvisorName());
            //json.put("course name:", Course.Method().get(a).getCourseName());

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}