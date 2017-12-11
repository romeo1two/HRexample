package com.navinski.student.frame;

import java.sql.SQLException;
import java.util.Vector;
 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import com.navinski.student.logic.Group;
import com.navinski.student.logic.ManagementSystemImpl;

public class StudentFrame extends JFrame {
	//lets create buttons names - which will be used later
	private static final String MOVE_GR = "moveGroup";
	private static final String CLEAR_GR = "clearGroup";
	private static final String INSERT_ST = "insertStudent";
	private static final String UPDATE_ST = "updateStudent";
	private static final String DELETE_ST = "deleteStudent";
	private static final String ALL_STUDENTS = "allStudents";
	
	ManagementSystemImpl ms = null;
    private JList grpList;
    private JTable stdList;
    private JSpinner spYear;
 
    public StudentFrame() throws Exception {
        // Setting up layout for the whole client side form
        getContentPane().setLayout(new BorderLayout());
 
        // lets create menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // lets create drop down menu
        JMenu menu = new JMenu("Reports");
        
        // let create a point int the drop down menu
        JMenuItem menuItem = new JMenuItem("All students");
        menuItem.setName(ALL_STUDENTS);
        // adding a listener
//        menuItem.addActionListener(this);
        // inserting point into drop down menu
        menu.add(menuItem);
        // inserting drop down menu into the menu bar
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
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
        GroupPanel left = new GroupPanel();
        // Setting up layout and setting a border aroud panel
        left.setLayout(new BorderLayout());
        left.setBorder(new BevelBorder(BevelBorder.RAISED));

        ms = ManagementSystemImpl.getInstance();
        // Receiving a list of groups
        Vector<Group> gr = new Vector<Group>(ms.getGroups());
        // Creating a comment
        left.add(new JLabel("Groups:"), BorderLayout.NORTH);
        //creating visual list and inserting it into the scroll panel
        grpList = new JList(gr);
        left.add(new JScrollPane(grpList), BorderLayout.CENTER);
        
        // creating buttons for groups
        JButton btnMvGr = new JButton("Move");
        btnMvGr.setName(MOVE_GR);
        JButton btnClGr = new JButton("Clear");
        btnClGr.setName(CLEAR_GR);
        // creating the panel in wich our buttons will be placed at
        JPanel pnlBtnGr = new JPanel();
        pnlBtnGr.setLayout(new GridLayout(1, 2));
        pnlBtnGr.add(btnMvGr);
        pnlBtnGr.add(btnClGr);
        left.add(pnlBtnGr, BorderLayout.SOUTH);
        
//        // we need to handle exception on database request
//        Vector gr = null;
//        Vector st = null;
//        //gettin connection to the database
//        ms = ManagementSystemImpl.getInstance();
//        // receiving list of groups
//        gr = new Vector<Group>(ms.getGroups());
//        // receiving list of students
//        st = new Vector<Student>(ms.getAllStudents());
//        // creating label
//        left.add(new JLabel("Croups: "), BorderLayout.NORTH);
//        
//        // Creating a display list and inserting it into the scroll
//        // panel, which is being put on the left panel
//        grpList = new JList(gr);
//        left.add(new JScrollPane(grpList), BorderLayout.CENTER);
// 
        // Creating right panel for displaying of list of students
        JPanel right = new JPanel();
        // Setting up layout and setting a border line around panel
        right.setLayout(new BorderLayout());
        right.setBorder(new BevelBorder(BevelBorder.LOWERED));
 
//        // Getting list of students
//        Vector<Student> st = new Vector<Student>(ms.getAllStudents());
//        // Creating a label description
        
        right.add(new JLabel("Students:"), BorderLayout.NORTH);
        // Creating a visual list and inserting it into the scrollable panel
        // which is being placed on the right panel
        stdList = new JTable(1, 4);
        right.add(new JScrollPane(stdList), BorderLayout.CENTER);
        // creating button for students
        JButton btnAddSt = new JButton("Add");
        btnAddSt.setName(INSERT_ST);
        JButton btnUpdSt = new JButton("Update");
        btnAddSt.setName(UPDATE_ST);
        JButton btnDelSt = new JButton("Delete");
        btnAddSt.setName(DELETE_ST);
        
        // creating panel for students buttons
        JPanel pnlBtnSt = new JPanel();
        pnlBtnSt.setLayout(new GridLayout(1, 3));
        pnlBtnSt.add(btnAddSt);
        pnlBtnSt.add(btnUpdSt);
        pnlBtnSt.add(btnDelSt);
        right.add(pnlBtnSt, BorderLayout.SOUTH);
        
        // Inserting a panels with a list of groups and students into the bottom panel
        bot.add(left, BorderLayout.WEST);
        bot.add(right, BorderLayout.CENTER);
 
        // Inserting top panel and bottom panel in to the form
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(bot, BorderLayout.CENTER);
 
        // separating first group
        grpList.setSelectedIndex(0);
        
        // Setting up borders of the form
        setBounds(100, 100, 600, 400);
    }
 
    public static void main(String[] args) {
        // It's better to run a form in the separate thread
        // event-dispatching thread - EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
	                StudentFrame sf = new StudentFrame();
	                sf.setDefaultCloseOperation(EXIT_ON_CLOSE);
	                sf.setVisible(true);
            	} catch (Exception ex) {
            		ex.printStackTrace();
            	}
            }
        });
    }
}

class GroupPanel extends JPanel {
	public Dimension getPreferredSize() {
		return new Dimension(250, 0);
	}
}
