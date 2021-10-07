package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DBinterface;
import View.View;

public class CourseCatController {

	 public View theView;
	 public DBinterface dbInterface;

	public CourseCatController(View theView, DBinterface dbInterface) {
		this.theView=theView;
		this.dbInterface=dbInterface;
		theView.addCatActionListener(new SearchCatCourseListener(), new AddCourseListener(), 
									new RemoveCourseListener(), new ViewAllCoursesListener(),
									new QuitListener(), new SubmitListener());
	} 
	
	/**
     * OPTION 1
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
     * OPTION 2
     */
    class AddCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setMenuSelected(2);
            theView.promptCourseName();
            theView.promptCourseNumber();
            theView.promptCourseSection();
        }
    }
    
    /**
     * OPTION 3
     */
    class RemoveCourseListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.setMenuSelected(3);
             theView.promptCourseName();
             theView.promptCourseNumber();
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
         }
    }
    /**
//   * OPTION 6
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
                    studentID= theView.getStudentID();
                    outputToUser = dbInterface.addCourseToStudent(name, number, section,studentID)
                            ? String.format("Student: %s was successfully registered in %s - %d in section %d", dbInterface.getStudentName(studentID), name, number, section)
                            : String.format("Student: %s was not registered in %s - %d in section %d", dbInterface.getStudentName(studentID), name, number, section);

                    		break;
            }
            theView.outputToUser(outputToUser);
        }
    }
}
