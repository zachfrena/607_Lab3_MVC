package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DBinterface;
import View.View;

public class StudentController extends Controller{
	
	 public View theView;
	 public DBinterface dbInterface;

	public StudentController(View theView, DBinterface dbInterface){
		this.theView=theView;
		this.dbInterface=dbInterface;
		theView.addStudentActionListener(new ViewAllStudentCoursesListener(),
                                        new QuitListener(),
										new SubmitListener());
	}

    
    /**
     * OPTION 5 : view all courses for single student
     */
    class ViewAllStudentCoursesListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.setMenuSelected(5);
             theView.promptStudentID();
         }
    }
    
//    /**
//   * OPTION 6 : quit
//   */
//  class QuitListener implements ActionListener {
//       @Override
//      public void actionPerformed(ActionEvent e) {
//           System.exit(0);
//       }
//  }

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
                case 5:
                    studentID = theView.getStudentID();
                    outputToUser = dbInterface.viewStudentCourses(studentID);
                    break;
            }
            // Update view
            theView.outputToUser(outputToUser);
        }
    }
}
