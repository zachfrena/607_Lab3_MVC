package Model;

import java.util.ArrayList;

public class Offering {
	
	private int sectionNum;
	private int sectionCap;
	private Course theCourse;
	
	private ArrayList <Registration> studentList;  //student list
	public Offering (int sectionNum, int sectionCap) {
		setSectionNum(sectionNum);
		setSectionCap(sectionCap);
		studentList = new ArrayList <Registration> ();
	}
	public void addRegistration (Registration reg) {
		//We need to add logic to ensure the requirement for the 
		//minimum number of students in a section is met.
		studentList.add(reg);
	}

	public void removeRegistration(Registration reg) {
		for (int i = 0; i < studentList.size(); i++) {
			Registration thisReg = studentList.get(i);
			if (thisReg == reg) {
				studentList.remove(i);
				break;
			}
		}
		return;
	}
	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public int getSectionCap() {
		return sectionCap;
	}

	public void setSectionCap(int sectionCap) {
		this.sectionCap = sectionCap;
	}

	public Course getTheCourse() {
		return theCourse;
	}

	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}

	public ArrayList <Registration> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList <Registration> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString () {
		String st = "";
		st += getTheCourse().toString() + " - Section: " + getSectionNum();
		return st;
	}

}
