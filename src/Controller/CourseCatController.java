package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DBinterface;
import View.View;

/**
 * Course Catalogue Controller implements action listeners for
 */
public class CourseCatController extends Controller{

	 public View theView;
	 public DBinterface dbInterface;

	public CourseCatController(View theView, DBinterface dbInterface) {
	    this.theView=theView;
		this.dbInterface=dbInterface;
		theView.addCatActionListener(new SearchCatCourseListener(),
                                    new ViewAllCoursesListener(),
									new SubmitListener(),
                                    new AddCourseListener(),
                                    new RemoveCourseListener());
	} 
	
	/**
     * OPTION 1 : search course catalogue
     */
    class SearchCatCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setMenuSelected(1);
            theView.promptCourseName();
            theView.promptCourseNumber();
        }
    }

    /**
     * OPTION 2 : add student to course
     */
    class AddCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setMenuSelected(2);
            theView.promptCourseName();
            theView.promptCourseNumber();
            theView.promptCourseSection();
            theView.promptStudentID();
        }
    }

    /**
     * OPTION 3 : remove student from course
     */
    class RemoveCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setMenuSelected(3);
            theView.promptCourseName();
            theView.promptCourseNumber();
            theView.promptStudentID();
        }
    }
    
    /**
     * OPTION 4 : view all courses in catalogue
     */
    class ViewAllCoursesListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.outputToUser(dbInterface.viewCoursesInCatalogue());
         }
    }


    /**
     * submit button
     */
    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selection = theView.getMenuSelected();
            String outputToUser = "";
            String name = "";
            int number = -1;
            int section = -1;
            int studentID = -1;
            switch (selection) {
                case 1:
                    name = theView.getCourseName();
                    number = theView.getCourseNumber();
                    outputToUser = dbInterface.searchCatCourses(name, number)
                            ? String.format("Course %s - %d exists!", name, number)
                            : String.format("Course %s - %d does not exist!", name, number);
                    break;
                case 2:
                    name = theView.getCourseName();
                    number = theView.getCourseNumber();
                    section = theView.getCourseSection();
                    studentID = theView.getStudentID();
                    outputToUser = dbInterface.addCourseToStudent(name, number, section, studentID)
                            ? String.format("Student: %s was successfully registered in %s - %d in section %d", dbInterface.getStudentName(studentID), name, number, section)
                            : String.format("Student: %s was not registered in %s - %d in section %d", dbInterface.getStudentName(studentID), name, number, section);
                    break;
                case 3:
                    name = theView.getCourseName();
                    number = theView.getCourseNumber();
                    studentID = theView.getStudentID();
                    outputToUser = dbInterface.removeStudentFromCourse(name, number, studentID)
                            ? String.format("Student: %s was successfully removed from %s - %d", dbInterface.getStudentName(studentID), name, number)
                            : String.format("Student: %s could not be removed from %s - %d ", dbInterface.getStudentName(studentID), name, number);
                    break;
            }
            // Update view
            theView.outputToUser(outputToUser);
        }
    }
}
