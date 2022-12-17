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
    public void printStudentInfoOnConsole(Student student, Advisor advisor, Course course, double gano, double yano) {
    	
    	System.out.println("----- Students are created! -----");
    	System.out.println("For Example: ");
    	System.out.println();
    	System.out.println("Student Name: " + student.getName());
    	System.out.println("Student Number: " + student.getStudentNumber());
    	System.out.println("Student Year: " + student.getYear());
    	System.out.println("Student Semester: " + student.getSemester());
    	System.out.println("Student Department: " + student.getDepartment());
    	System.out.println("Student Title: " + student.getTitle());
    	System.out.println("Student Yano: " + String.format("%.2f", yano));
    	System.out.println("Student Gano: " + String.format("%.2f", gano));
    	System.out.println("Student Advisor Name and Title: " + advisor.getTitle() + " " + advisor.getName());
    	System.out.println();
    	System.out.println("Last Semester Course Names: ");
    	
    	for(int i = 0; i < course.getLastSemesterCourseList().size(); i++) {   		
    		System.out.println(i+1 + " " + course.getLastSemesterCourseList().get(i).getCourseName());
    	}
    	  	
    }
}
