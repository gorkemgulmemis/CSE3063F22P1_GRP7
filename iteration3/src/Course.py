
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
