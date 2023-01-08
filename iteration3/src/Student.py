
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
