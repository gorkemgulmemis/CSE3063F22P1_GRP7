import logging
import json
import random

from OOPProject.StudentProcess import StudentProcess
from Person import Person
from configparser import ConfigParser


class Student(Person):

    def __init__(self, year = None, studentNumber = None, semester = None):
        self.__studentNumber = studentNumber
        self.__year = year
        self.__semester = semester
        self.__studentList = []

    def getStudentNumber(self):
        return self.__studentNumber

    def setStudentNumber(self, studentNumber):
        self.__studentNumber = studentNumber

    def getSemester(self):
        return self.__semester

    def setSemester(self, semester):
        if semester < 1 or semester > 8:
            # If enter a value that less than 1 or more than 8 print error message
            raise ValueError("Semester can't be both less than 1 and more than 8.")
        self.__semester = semester


    def getYear(self):
        return self.__year

    def setYear(self, year):
        if year < 1 or year > 4:
            # If enter a value that less than 1 or more than 4 print error message
            raise ValueError("Year can't be both less than 1 and more than 4.")
        self.__year = year

    def __addStudentList(self, student):
        self.getStudentList().append(student)

    def getStudentList(self):
        return self.__studentList

    def setStudentList(self, studentList):
        self.__studentList = studentList
        
        
        logging.basicConfig(filename='student.log',level=logging.INFO)

def generateStudentSemester(self, year):
        logger = logging.getLogger(_name_)
        if year == 1:
            logger.debug("Student is in the 1st year and 1st semester")
            return 1
        elif year == 2:
            logger.debug("Student is in the 2nd year and 3rd semester")
            return 3
        elif year == 3:
            logger.debug("Student is in the 3rd year and 5th semester")
            return 5
        elif year == 4:
            logger.debug("Student is in the 4th year and 7th semester")
            return 7
        else:
            logger.warning("Year entered is invalid")
            return None

print(student.generateStudentSemester(1))  # Output is gonna be 1.
print(student.generateStudentSemester(2))  # Output is gonna be 3.
print(student.generateStudentSemester(3))  # Output is gonna be 5.
print(student.generateStudentSemester(4))  # Output is gonna be 7.
print(student.generateStudentSemester(5))  # Output is gonna be None.


   def createStudent(self):
        # Read a config
        config = ConfigParser()
        config.read("config.ini")
        studentNumber = config["StudentNumber"]
        for year in range(1, 4):
            for i in range(int(studentNumber['studentnumber'])):
                self.setName(self.generateRandomName())
                self.setStudentNumber(self.generateStudentNumber(year, i))
                self.setSemester(self.generateStudentSemester(year))
                self.setYear(year)
                self.setTitle(self.giveTitleToStudent(year))
                self.setDepartment("CSE")
                self.__addStudentList(self)
                StudentProcess(self).createStudentJsonFile()
