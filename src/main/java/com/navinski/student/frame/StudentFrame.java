package com.navinski.student.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import com.navinski.student.logic.Group;
import com.navinski.student.logic.ManagementSystemImpl;
import com.navinski.student.logic.Student;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class StudentFrame extends JFrame {
	ManagementSystemImpl ms = ManagementSystemImpl.getInstance();
    private JList grpList;
    private JList stdList;
    private JSpinner spYear;
 
    public StudentFrame() {
        // Setting up layout for the whole client side form
        getContentPane().setLayout(new BorderLayout());
 
        // Creating upper panel, where field for entering the year is going to be
        JPanel top = new JPanel();
        // Setting up layout for it
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
 
        // Inserting description comment
        top.add(new JLabel("Year of education:"));
        // Creating spin-field
        //   1. Setting up behavioral model - numbers only
        //   2. Inserting into the panel
        SpinnerModel sm = new SpinnerNumberModel(2006, 1900, 2100, 1);
        spYear = new JSpinner(sm);
        top.add(spYear);
 
        // Creating bottom panel and setting up layout for it
        JPanel bot = new JPanel();
        bot.setLayout(new BorderLayout());
 
        // Creating left panel for displaying list of groups
        JPanel left = new JPanel();
        // Setting up layout and setting a border aroud panel
        left.setLayout(new BorderLayout());
        left.setBorder(new BevelBorder(BevelBorder.RAISED));
 
        // Receiving a list of groups
        Vector<Group> gr = new Vector<Group>(ms.getGroups());
        // Creating a comment
        left.add(new JLabel("Groups:"), BorderLayout.NORTH);
        // Creating a display list and inserting it into the scroll
        // panel, which is being put on the left panel
        grpList = new JList(gr);
        left.add(new JScrollPane(grpList), BorderLayout.CENTER);
 
        // Creating left panel for displaying of list of students
        JPanel right = new JPanel();
        // Setting up layout and setting a border line around panel
        right.setLayout(new BorderLayout());
        right.setBorder(new BevelBorder(BevelBorder.RAISED));
 
        // Getting list of students
        Vector<Student> st = new Vector<Student>(ms.getAllStudents());
        // Creating a label description
        right.add(new JLabel("Students:"), BorderLayout.NORTH);
        // Creating a visual list and inserting it into the scrollable panel
        // which is being placed on the right panel
        stdList = new JList(st);
        right.add(new JScrollPane(stdList), BorderLayout.CENTER);
 
        // Inserting a panels with a list of groups and students into the bottom panel
        bot.add(left, BorderLayout.WEST);
        bot.add(right, BorderLayout.CENTER);
 
        // Inserting top panel and bottom panel in to the form
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(bot, BorderLayout.CENTER);
 
        // Setting up borders of the form
        setBounds(100, 100, 600, 400);
    }
 
    public static void main(String args) {
        // It's better to run a form in the separate thread
        // event-dispatching thread - EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StudentFrame sf = new StudentFrame();
                sf.setDefaultCloseOperation(EXIT_ON_CLOSE);
                sf.setVisible(true);
            }
        });
    }
}
