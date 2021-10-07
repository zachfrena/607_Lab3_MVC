package Model;

import java.util.HashMap;

public class DBinterface {

    private CourseCat cat;
    private HashMap<Integer, Student> students;

    public DBinterface() {
        this.cat = new CourseCat();  //This loads the courses from our "DB"
        this.students = new HashMap<>(); // students database. courseRegistration.Model.Student ID acts as key
        Student st1 = new Student("Jimmy Conway", 1);
        Student st2 = new Student("Henry Hill", 2);
        Student st3 = new Student("Tommy DeVito", 3);
        Student st4 = new Student("Karen Hill", 4);
        this.students.put(st1.getStudentId(), st1);
        this.students.put(st2.getStudentId(), st2);
        this.students.put(st3.getStudentId(), st3);
        this.students.put(st4.getStudentId(), st4);

        createFakeOfferingDB(cat, "ENGG", 233);
        createFakeOfferingDB(cat, "ENSF", 607);
        createFakeOfferingDB(cat, "PHYS", 259);
        createFakeOfferingDB(cat, "ENSF", 123);

        st1.registerForCourse(cat, "ENGG", 233, 1);
        st2.registerForCourse(cat, "ENGG", 233, 1);
        st3.registerForCourse(cat, "ENGG", 233, 2);
        st4.registerForCourse(cat, "ENGG", 233, 2);
    }

    /**
     * Create fake database to use
     *
     * @param cat
     * @param courseName
     * @param courseNum
     */
    private void createFakeOfferingDB(CourseCat cat, String courseName, int courseNum) {
        Course myCourse = cat.searchCat(courseName, courseNum);
        if (myCourse != null) {
            cat.createOffering(myCourse, 1, 100);
            cat.createOffering(myCourse, 2, 100);
        }
    }

    /**
     * User option 1 - Works
     */
    public boolean searchCatCourses(String courseName, int courseNum) {
        Course c;
        c = this.cat.searchCat(courseName, courseNum);
        return c != null;
    }

    /**
     * Return course
     */
    private Course getCatCourse(String courseName, int courseNum) {
        Course c;
        c = this.cat.searchCat(courseName, courseNum);
        return c;
    }


    /**
     * User option 2
     *
     * @return true if student was successfully added to the given course
     */
    public boolean addCourseToStudent(String courseName, int courseNumber, int courseSection, int studentID) {

        // check course exists
        if (!searchCatCourses(courseName, courseNumber)) {
            return false;
        }
        // get student from ID
        Student student = students.get(studentID);

        // register for course
        student.registerForCourse(cat, courseName, courseNumber, courseSection);
        return true;
    }

    /**
     * User option 3
     * remove student registration from offering:studentList and student:regList
     * and set the registration object to null
     */
    public boolean removeStudentFromCourse(String courseName, int courseNumber, int studentID) {
        Course c = getCatCourse(courseName, courseNumber);
        // check course exists
        if (c == null) {
            return false;
        }
        // return student from student ID
        Student student = students.get(studentID);
        if (student == null) {
            return false;
        }
        student.removeCourseFromStudentCourses(c);
        return true;
    }

    /**
     * User option 4
     */
    public String viewCoursesInCatalogue() {
        return cat.toString();
    }

    /**
     * User option 5
     */
    public String viewStudentCourses(int studentID) {
        Student student = students.get(studentID);
        if (student == null) { return "Student not found!"; }
        return student.showAllCoursesTaken();
    }

    /**
     * Helper method to print student name to the user
     * @param id
     * @return
     */
    public String getStudentName(int id) {
        String name = "Not Found";
        Student student = students.get(id);
        if (student != null) {
            name = student.getStudentName();
        }
        return name;
    }
}
