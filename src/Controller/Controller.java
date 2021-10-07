//package Controller;
//
//import Model.DBinterface;
//import View.View;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Controller {
//
//    public View theView;
//    public DBinterface dbInterface;
//
//    public Controller (View theView, DBinterface theModel) {
//        this.dbInterface = theModel;
//        this.theView = theView;
//        theView.addActionListener(new SearchCatCourseListener(), new AddCourseListener(), new RemoveCourseListener(),
//                new ViewAllCoursesListener(), new ViewAllStudentCoursesListener(), new QuitListener(), new SubmitListener());
//    }
//
//    /**
//     * OPTION 1
//     */
//    class SearchCatCourseListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            theView.setMenuSelected(1);
//            theView.promptCourseName();
//            theView.promptCourseNumber();
//        }
//    }
//
//    /**
//     * OPTION 2
//     */
//    class AddCourseListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            theView.setMenuSelected(2);
//            theView.promptCourseName();
//            theView.promptCourseNumber();
//            theView.promptCourseSection();
//            theView.promptStudentID();
//        }
//    }
//
//    /**
//     * OPTION 3
//     */
//    class RemoveCourseListener implements ActionListener {
//         @Override
//        public void actionPerformed(ActionEvent e) {
//             theView.setMenuSelected(3);
//             theView.promptCourseName();
//             theView.promptCourseNumber();
//             theView.promptStudentID();
//         }
//    }
//
//    /**
//     * OPTION 4
//     */
//    class ViewAllCoursesListener implements ActionListener {
//         @Override
//        public void actionPerformed(ActionEvent e) {
//             theView.outputToUser(dbInterface.viewCoursesInCatalogue());
//         }
//    }
//
//    /**
//     * OPTION 5
//     */
//    class ViewAllStudentCoursesListener implements ActionListener {
//         @Override
//        public void actionPerformed(ActionEvent e) {
//             theView.setMenuSelected(5);
//             theView.promptStudentID();
//         }
//    }
//
//    /**
//     * OPTION 6
//     */
//    class QuitListener implements ActionListener {
//         @Override
//        public void actionPerformed(ActionEvent e) {
//             System.exit(0);
//         }
//    }
//
//    class SubmitListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int selection = theView.getMenuSelected();
//            String outputToUser = "";
//            String name = "";
//            int number = -1;
//            int section = -1;
//            int studentID = -1;
//            System.out.println(selection);
//            switch (selection) {
//                case 1:
//                    name = theView.getCourseName();
//                    number = theView.getCourseNumber();
//                    outputToUser = dbInterface.searchCatCourses(name, number)
//                            ? String.format("Course %s - %d exists!", name, number)
//                            : String.format("Course %s - %d does not exist!", name, number);
//                    break;
//                case 2:
//                    name = theView.getCourseName();
//                    number = theView.getCourseNumber();
//                    section = theView.getCourseSection();
//                    studentID = theView.getStudentID();
//                    outputToUser = dbInterface.addCourseToStudent(name, number, section, studentID)
//                            ? String.format("Student: %s was successfully registered in %s - %d in section %d", dbInterface.getStudentName(studentID), name, number, section)
//                            : String.format("Student: %s was not registered in %s - %d in section %d", dbInterface.getStudentName(studentID), name, number, section);
//                    break;
//                case 3:
//                    name = theView.getCourseName();
//                    number = theView.getCourseNumber();
//                    studentID = theView.getStudentID();
//                    outputToUser = dbInterface.removeStudentFromCourse(name, number, studentID)
//                            ? String.format("Student: %s was successfully removed from %s - %d", dbInterface.getStudentName(studentID), name, number)
//                            : String.format("Student: %s could not be removed from %s - %d ", dbInterface.getStudentName(studentID), name, number);
//                    break;
//                case 5:
//                    studentID = theView.getStudentID();
//                    outputToUser = dbInterface.viewStudentCourses(studentID);
//                    break;
//            }
//            theView.outputToUser(outputToUser);
//        }
//    }
//}
