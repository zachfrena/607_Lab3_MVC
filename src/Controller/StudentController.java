package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DBinterface;
import View.View;

public class StudentController{
	
	 public View theView;
	 public DBinterface dbInterface;

	public StudentController(View theView, DBinterface dbInterface){
		this.theView=theView;
		this.dbInterface=dbInterface;
		theView.addStudentActionListener(new AddCourseListener(), new RemoveCourseListener(), 
										new ViewAllStudentCoursesListener(), 
										new SubmitListener());
				
	}//took out: new QuitListener()

    public void test(){};
	/**
     * OPTION 2
     */
    class AddCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setMenuSelected(2);
            theView.promptStudentID();
        }
    }
    
    /**
     * OPTION 3
     */
    class RemoveCourseListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.setMenuSelected(3);
             theView.promptStudentID();
         }
    }
    
    /**
     * OPTION 4
     */
    class ViewAllCoursesListener implements ActionListener {
        @Override
       public void actionPerformed(ActionEvent e) {
            theView.outputToUser(dbInterface.viewCoursesInCatalogue());
        }
   }
    
    
    /**
     * OPTION 5
     */
    class ViewAllStudentCoursesListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.setMenuSelected(5);
             theView.promptStudentID();
         }
    }
    
    /**
   * OPTION 6
   */
  class QuitListener implements ActionListener {
       @Override
      public void actionPerformed(ActionEvent e) {
           System.exit(0);
       }
  }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selection = theView.getMenuSelected();
            String outputToUser = "";
            String name = "";
            int number = -1;
            int section = -1;
            int studentID = -1;
            System.out.println(selection);
            switch (selection) {
                case 3:
                    name = theView.getCourseName();
                    number = theView.getCourseNumber();
                    studentID = theView.getStudentID();
                    outputToUser = dbInterface.removeStudentFromCourse(name, number, studentID)
                            ? String.format("Student: %s was successfully removed from %s - %d", dbInterface.getStudentName(studentID), name, number)
                            : String.format("Student: %s could not be removed from %s - %d ", dbInterface.getStudentName(studentID), name, number);
                    break;
                case 5:
                    studentID = theView.getStudentID();
                    outputToUser = dbInterface.viewStudentCourses(studentID);
                    break;
            }
            theView.outputToUser(outputToUser);
        }
    }
}