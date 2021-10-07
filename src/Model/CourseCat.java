package Model;

import java.util.ArrayList;

public class CourseCat {

	private ArrayList<Course> courseList;

	public CourseCat() {
		courseList = loadFromDB();
	}

	private static ArrayList<Course> loadFromDB() {
		//In real life course would be loaded for the database or at least some sort of file
		//on disk. 

		//So imagine this is being loaded from the database!

		ArrayList<Course> imaginaryDB = new ArrayList<Course>();

		imaginaryDB.add(new Course("ENGG", 233));
		imaginaryDB.add(new Course("ENSF", 607));
		imaginaryDB.add(new Course("PHYS", 259));
		imaginaryDB.add(new Course("ENSF", 123));
		return imaginaryDB;
	}

	public Course searchCat(String courseName) {
		//search for courses that their name matches courseName return if course exists
		for (Course c : courseList) {
			if (c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		return null;
	}

	public Course searchCat(String courseName, int courseNum) {
		for (Course c : courseList) {
			if (c.getCourseNum() == courseNum && c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		return null;
	}

	public void createOffering(Course theCourse, int secNum, int secCap) {
		if (theCourse != null) {
			Offering theOffering = new Offering(secNum, secCap);
			theOffering.setTheCourse(theCourse);   //I set theCourse object reference in the courseRegistration.Model.Course
			theCourse.addOffering(theOffering);
		}
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		String st = "Courses in the catalogue are: ";
		for (Course c : courseList) {
			st += c.getCourseName() + c.getCourseNum() + ", ";
		}
		return st.substring(0, st.length() - 1);
	}
}
