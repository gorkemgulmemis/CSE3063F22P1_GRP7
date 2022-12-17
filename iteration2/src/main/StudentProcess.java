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
