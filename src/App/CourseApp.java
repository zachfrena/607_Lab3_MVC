package App;
import Controller.CourseCatController;
import Controller.StudentController;
import Model.DBinterface;
import View.View;

public class CourseApp {
    public static void main (String [] args) {

        View theView = new View ();
        DBinterface dbInterface = new DBinterface();
        StudentController studentController = new StudentController (theView, dbInterface);
        CourseCatController courseCatController = new CourseCatController (theView, dbInterface);
//        theView.setVisible(true);
    }
}
