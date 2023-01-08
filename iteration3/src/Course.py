import json

class Course:

    def __init__(self, courseName = None, courseCredit = None):
        self.__courseName = courseName
        self.__courseCredit = courseCredit
        self.__courseList = []
        self.__electiveCourseList = []
        self.__lastSemesterCourseList = []
        self.__currentSemesterCourseList = []

    def getCourseName(self):
        return self.__courseName

    def setCourseName(self, courseName):
        self.__courseName = courseName

    def getCourseCredit(self):
        return self.__courseCredit

    def setCourseCredit(self, courseCredit):
        self.__courseCredit = courseCredit

    def __addCourseList(self, course):
        self.getCourseList().append(course)

    def __addElectiveCourseList(self, electiveCourse):
        self.getElectiveCourseList().append(electiveCourse)

    def __addLastSemesterCourseList(self, lastSemesterCourse):
        self.getLastSemesterCourseList().append(lastSemesterCourse)

    def getCourseList(self):
        return self.__courseList

    def setCourseList(self, courseList):
        self.__courseList = courseList

    def getElectiveCourseList(self):
        return self.__electiveCourseList

    def setElectiveCourseList(self, electiveCourseList):
        self.__electiveCourseList = electiveCourseList

    def getLastSemesterCourseList(self):
        return self.__lastSemesterCourseList

    def setLastSemesterCourseList(self, lastSemesterCourseList):
        self.__lastSemesterCourseList = lastSemesterCourseList
        
    def takeElectiveCoursesFromInputFile(self):
        with open("C:\\Users\\90554\\PycharmProjects\\OOPProject\\input.json") as file:
            data = json.load(file)
            for key in ["NTE", "ENG-UE", "TE", "ENG-FTE"]:
                array = data[key]
                for j in range(len(array)):
                    object = array[j]
                    courseName = object["courseName"]
                    courseCredit = object["courseCredit"]
                    self.setCourseName(courseName)
                    self.setCourseCredit(courseCredit)
                    self.__addElectiveCourseList(self)
