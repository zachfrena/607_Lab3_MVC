package View;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class View extends JFrame {

    private JPanel GUI;
    private JPanel input;
    private JPanel output;
    private JFrame frame;
    private JButton searchCatCourseButton = new JButton ("Search catalogue courses");
    private JButton addCourseButton = new JButton ("Add course to student courses");
    private JButton removeCourseButton = new JButton ("Remove course from student courses");
    private JButton viewAllCoursesButton = new JButton ("View All courses in catalogue");
    private JButton viewAllStudentCoursesButton = new JButton ("View all courses taken by student");
    private JButton quitButton = new JButton ("                        Quit                     ");
    private JButton submitButton = new JButton("                        Submit                  ");
    private JTextField courseNameText;
    private JTextField courseNumberText;
    private JTextField courseSectionText;
    private JTextField studentIDText;
    private JLabel outputToUser;
    private JLabel courseNameLabel;
    private JLabel courseNumberLabel;
    private JLabel courseSectionLabel;
    private JLabel studentIDLabel;
    private int menuSelected;
    private boolean submitShown = false;

    public View() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,1000);
        frame.setBackground(Color.RED);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        GUI = new JPanel();
        GUI.setPreferredSize(new Dimension(390,250));
        GUI.setBackground(Color.GRAY);
        GUI.add(searchCatCourseButton);
        GUI.add(addCourseButton);
        GUI.add(removeCourseButton);
        GUI.add(viewAllCoursesButton);
        GUI.add(viewAllStudentCoursesButton);
        GUI.add(quitButton);

        input = new JPanel();
        input.setPreferredSize(new Dimension(390,390));
        input.setBackground(new Color(169, 192, 212));

        output = new JPanel();
        output.setPreferredSize(new Dimension(460,200));
        output.setBackground(new Color(169, 192, 212));

        frame.add(GUI);
        frame.add(input);
        frame.add(output);
        frame.setVisible(true);
    }


    public void setMenuSelected(int menuSelected) { this.menuSelected = menuSelected; }


    public int getMenuSelected() { return this.menuSelected;}


    public void outputToUser(String out) {
        outputToUser = new JLabel(out);
        output.add(outputToUser);
        frame.setVisible(true);
    }


    private void updateGUI(JTextField textField, JLabel labelField) {
        input.add(labelField);
        input.add(textField);
        frame.setVisible(true);
    }


    public void promptCourseName() {
        showSubmitButton();
        courseNameText = new JTextField(10);
        courseNameLabel = new JLabel("Enter Course Name eg. ENGG, PHYS, ENSF: ");
        updateGUI(courseNameText, courseNameLabel);
    }


    public void promptCourseNumber() {
        showSubmitButton();
        courseNumberText = new JTextField(10);
        courseNumberLabel = new JLabel("Enter Course Number eg. 233, 607, 259, 123: ");
        updateGUI(courseNumberText, courseNumberLabel);
    }


    public void promptCourseSection() {
        showSubmitButton();
        courseSectionText = new JTextField(10);
        courseSectionLabel = new JLabel("Enter Course Section from [1-2]: ");
        updateGUI(courseSectionText, courseSectionLabel);
    }


    public void promptStudentID() {
        showSubmitButton();
        studentIDText = new JTextField(10);
        studentIDLabel = new JLabel("Enter Student ID from [1-4]: ");
        updateGUI(studentIDText, studentIDLabel);
    }


    private void showSubmitButton() {
        if (!submitShown) {
            this.GUI.add(submitButton);
            submitShown = true;
        }
    }

    // ALL BELOW CALLED ON SUBMIT
    public String getCourseName() { return courseNameText.getText().toUpperCase(); }
    public int getCourseNumber() { return Integer.parseInt(courseNumberText.getText()); }
    public int getCourseSection() { return Integer.parseInt(courseSectionText.getText()); }
    public int getStudentID() { return Integer.parseInt(studentIDText.getText()); }

    // ADD ACTION LISTENERS FOR STUDENT CONTROLLER
    public void addStudentActionListener (ActionListener studentCourseListener,
                                          ActionListener quitListener,
                                          ActionListener submitListener) {

        viewAllStudentCoursesButton.addActionListener(studentCourseListener);
		quitButton.addActionListener(quitListener);
        submitButton.addActionListener(submitListener);
    }

    // ADD ACTION LISTENERS FOR CATALOGUE CONTROLLER
    public void addCatActionListener (ActionListener searchListener,
                                      ActionListener allCourseListener,
                                   ActionListener submitListener,
                                      ActionListener addListener,
                                      ActionListener removeListener) {

        searchCatCourseButton.addActionListener(searchListener);
        viewAllCoursesButton.addActionListener(allCourseListener);
        submitButton.addActionListener(submitListener);
        addCourseButton.addActionListener(addListener);
       removeCourseButton.addActionListener(removeListener);
    }


}
