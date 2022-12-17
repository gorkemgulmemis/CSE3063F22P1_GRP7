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

        public String giveTitleToStudent(int year){
        switch (year){
            case 1 : {return "Freshman";}

            case 2 : {return "Sophomore";}

            case 3 : {return "Junior";}

            case 4 : {return "Senior";}
        }
        return "a";
    }
