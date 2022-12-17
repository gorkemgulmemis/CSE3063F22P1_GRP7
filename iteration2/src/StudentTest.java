import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

Student student=new Student();
// At this test class we are going to testing our methods which generates and assign the students semester, students full names and students number.

// GENERATE STUDENT SEMESTER METHOD TESTING BLOCK
    @Test
    public void testGenerateStudentSemester_year1() {
       int year = 1;
       int expect = 1;
       int actual = student.generateStudentNumber(1, 1);
    }
    
    @Test
    public void testGenerateStudentSemester_year2() {
       
        assertEquals(3,student.generateStudentSemester(2));
    }
    
    @Test
    public void testGenerateStudentSemester_year3() {
        int year = 3;
        int expect = 5;
        int actual = student.generateStudentNumber(3, 5);
     }
     
    @Test
    public void testGenerateStudentSemester_year4() {
       
        assertEquals(7,student.generateStudentSemester(4));
    }

    
//GENERATE STUDENT NUMBER TEST BLOCK
@Test
public void testGenerateStudentNumber() {
	
	assertEquals(150122002,student.generateStudentNumber(1, 1));
	
}

//GENERATE RANDOM STUDENT FULL NAME TEST BLOCK

/* 
This test does the following:

Creates an instance of NameGenerator.
Calls the generateRandomName method and stores the result in a variable called name.
Asserts that name is not null.
Splits name into first and last name parts using the space character as the delimiter.
Asserts that the resulting array has two elements.*/

@Test
public void testGenerateRandomName() {
    Student  nameGenerator = new Student();

    String name = nameGenerator.generateRandomName();
    assertNotNull(name);

    String[] parts = name.split(" ");
    assertEquals(2, parts.length);

    }

@Test
public void testFreshman() {
	Student student = new Student();
    String expected = "Freshman";
    String actual = student.giveTitleToStudent(1);
    assertEquals(expected, actual);
}

@Test
public void testSophomore() {
	Student student = new Student();
    String expected = "Sophomore";
    String actual = student.giveTitleToStudent(2);
    assertEquals(expected, actual);
}

@Test
public void testJunior() {
	Student student = new Student();
    String expected = "Junior";
    String actual = student.giveTitleToStudent(3);
    assertEquals(expected, actual);
}

@Test
public void testSenior() {
	Student student = new Student();
    String expected = "Senior";
    String actual = student.giveTitleToStudent(4);
    assertEquals(expected, actual);
}

@Test
public void testInvalidYear() {
	Student stdnt = new Student();
    String expected = "error occured";
    String actual = student.giveTitleToStudent(5);
    assertEquals(expected, actual);
}
}




