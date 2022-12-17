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
    public void createStudentJsonFile() throws ParseException{

		String path = "C:\\Users\\90554\\eclipse-workspace\\Projemiz\\Student\\" + student.getStudentNumber() + ".json";
		course = new Course();
		advisor = new Advisor();
		transcript = new Transcript();
		JSONObject json = new JSONObject();

		try {

			json.put("Student Name ", student.getStudentArrayList().get(0).getName());
			json.put("Student Year ", student.getStudentArrayList().get(0).getYear());
			json.put("Student Semester ", student.getStudentArrayList().get(0).getSemester());
			json.put("Student Number ", student.getStudentArrayList().get(0).getStudentNumber());
			json.put("Student Title ", student.getStudentArrayList().get(0).getTitle());
			json.put("Student Department ", student.getStudentArrayList().get(0).getDepartment());

			course.takeCoursesFromInputFile(student.getStudentArrayList().get(0).getSemester() + 1);
			course.takeLastSemesterCourseFromInputFile(student.getStudentArrayList().get(0).getSemester());

			double totalGrade = 0;
			double semesterTotalGrade = 0;
			for(int i = 0; i < course.getCourseList().size(); i++) {
				transcript.generateRandomLetterGrade();
				String courseInfo = course.getCourseList().get(i).getCourseName() + " - " + transcript.getLetterGrade();
				json.put("Course Name " + (i+1), courseInfo);

				totalGrade +=  course.getCourseList().get(i).getCourseCredit() * transcript.gradeChangeToDouble(transcript.getLetterGrade());
				if(i < course.getLastSemesterCourseList().size()) {
           	        semesterTotalGrade += course.getLastSemesterCourseList().get(i).getCourseCredit() * transcript.gradeChangeToDouble(transcript.getLetterGrade());
				}
			}
			
			int totalCredit = 0;
			int semesterTotalCredit = 0;
			for(int i = 0; i < course.getCourseList().size(); i++) {
				totalCredit += course.getCourseList().get(i).getCourseCredit();
			}
			for(int i = 0; i < course.getLastSemesterCourseList().size(); i++) {
				semesterTotalCredit += course.getLastSemesterCourseList().get(i).getCourseCredit();
			}

			json.put("Total Credit " , totalCredit);

			double Gano = totalGrade / totalCredit;
			double Yano = semesterTotalGrade / semesterTotalCredit;
			
			json.put("GANO " , String.format("%.2f", Gano));
			json.put("YANO " , String.format("%.2f", Yano));

			Random random = new Random();
			course.takeElectiveCoursesFromInputFile();

			for(int i = 2; i <= student.getSemester(); i++) {
				switch(i) {
					case 2 : {
						json.put("Elective Course " + (i-1) ,course.getElectiveCourseList().get(random.nextInt(8)).getCourseName());
						break;
					}
					case 3 : {
						json.put("Elective Course " + (i-1) ,course.getElectiveCourseList().get(random.nextInt(8)).getCourseName());
						break;
					}
					case 7 : {
						json.put("Elective Course " + (i-4) ,course.getElectiveCourseList().get(random.nextInt(8)+8).getCourseName());
						json.put("Elective Course " + (i-3) ,course.getElectiveCourseList().get(random.nextInt(8)+16).getCourseName());
						json.put("Elective Course " + (i-2) ,course.getElectiveCourseList().get(random.nextInt(8)+16).getCourseName());
						break;
					}
				}
			}

			advisor.takeAdvisorFromInputFile();
			json.put("Advisor Info ", advisor.randomAdvisorAssignment());
			
				
			if(student.getStudentArrayList().get(0).getStudentNumber() == 150120001)
				transcript.printStudentInfoOnConsole(student, advisor, course, Gano, Yano);
			

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			FileWriter out = new FileWriter(path);
			String str = json.toString();
			out.write(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
