import unittest

class TestStudent(unittest.TestCase):

    """This method checks which semester the student is in. 
       The main reason for the existence of this method is that,
       the student will choose elective courses depending on different course codes. 
       According to the semester they are in."""
       
    def test_generateStudentSemester(self):
        student = TestStudent()
        self.assertEqual(student.generateStudentSemester(1), 1)
        self.assertEqual(student.generateStudentSemester(2), 3)
        self.assertEqual(student.generateStudentSemester(3), 5)
        self.assertEqual(student.generateStudentSemester(4), 7)

if _name_ == '_main_':
    unittest.main()
