import random
import json

from Advisor import Advisor
from Course import Course
from Transcript import Transcript


class StudentProcess:

    def __init__(self, new_student = None):
        self.__student = new_student
        self.__List = []
        self.List2 = []

    def getList(self):
        return self.__List

    def setList(self, List):
        self.__List.append(List)

    def getList2(self):
        return self.__List2

    def setList2(self, List2):
        self.__List2 = List2

    def getStudent(self):
        return self.__student

    def setStudent(self, student):
        self.__student = student
