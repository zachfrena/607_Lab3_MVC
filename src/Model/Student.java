package Model;

import java.util.ArrayList;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList <Registration> regList;    //list of course sections
	private final int maxClasses = 6;

	public Student  (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		this.setRegList(new ArrayList <Registration>());
	}
	public void registerForCourse (CourseCat cat, String courseName, int courseNum, int section) {
		if (this.isInSixClasses()) { return; } // do not register if already in 6 classes
		Course myCourse = cat.searchCat(courseName, courseNum);
		if (myCourse == null) { return; } // do not register if course does not exist
		//Now the student needs to make sure the section exists. and if it does, register!
		//A student registers by:
		//Creating a registration object
		//and calling the 
		Offering theOffering = myCourse.getOfferingList().get(section - 1);//must fix this!!
		Registration reg = new Registration ();
		reg.register(this, theOffering);
	}

	public void removeCourseFromStudentCourses (Course course) {
		// first find in the regList the registration corresponding to this course
		for (int i = 0; i < regList.size(); i++) {
			Registration reg = regList.get(i);
			Offering off = reg.getTheOffering();
			// this is the registration we want to remove
			if (off.getTheCourse() == course) {
				// 3 things we have to remove
				// 1) in the offering remove the student registration from list of student registrations
				// 2) remove the registration from this student's registration
				// 3) set the registration object to null
				off.removeRegistration(reg);
				regList.remove(i);
				reg = null;
				System.out.println("courseRegistration.Model.Student " + getStudentName() + " has been successfully removed from course " + course.getCourseName()+course.getCourseNum());
				return;
			}
		}
		System.out.println("courseRegistration.Model.Student " + getStudentName() + " cannot be removed because they were not enrolled in course " + course.getCourseName()+course.getCourseNum());
		return;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public ArrayList <Registration> getRegList() {
		return regList;
	}

	public void setRegList(ArrayList <Registration> regList) {
		this.regList = regList;
	}

	public void addRegistration(Registration registration) {
		regList.add(registration);
	}

	/**
	 * @return if student is enrolled in maximum number of classes (6)
	 */
	private boolean isInSixClasses() {
		return this.regList.size() == this.maxClasses;
	}

	@Override
	public String toString () {
		return studentName;
	}

	public String showAllCoursesTaken() {
		String st = getStudentName() + " is enrolled in: \n";
		for (Registration r : regList) {
			st += r.getTheOffering().toString() + "| \n";
		}
		return st;
	}
}
