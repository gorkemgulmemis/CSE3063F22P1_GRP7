import java.util.Random;

public class Transcript {

    private String letterGrade;

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
    public void generateRandomLetterGrade(){

        Random random = new Random();

        String[] grades = {"AA", "BA", "BB", "CB", "CC", "DC", "DD", "FD", "FF"};

        String letterGrade = grades[random.nextInt(grades.length)];
        setLetterGrade(letterGrade);
    }
    public double gradeChangeToDouble(String str) {

        switch(str) {
            case "AA" : {return 4;}

            case "BA" : {return 3.5;}

            case "BB" : {return 3;}

            case "CB" : {return 2.5;}

            case "CC" : {return 2;}

            case "DC" : {return 1.5;}

            case "DD" : {return 1;}

            case "FD" : {return 0.5;}

            case "FF" : {return 0;}

        }
        return 0;
    }
