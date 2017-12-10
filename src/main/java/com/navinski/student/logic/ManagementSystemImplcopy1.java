package com.navinski.student.logic;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ManagementSystemImplcopy1 {
	private List<Group> groups;
	private Collection<Student> students;
	
	// variable for singleton pattern template
	private static ManagementSystemImplcopy1 instance;
	
	// private access Constructor
	private ManagementSystemImplcopy1(){
		loadGroups();
		loadStudents();
	}
	
	// Method will verify if the static variable has been initialized before
	// in case it has not? it will initialize it and return the result
	public static synchronized ManagementSystemImplcopy1 getInstance() {
		if(instance == null) {
			instance = new ManagementSystemImplcopy1();
		}
		return instance;
	}
	
	// Main Method, to be started at the beginning of the application
//	public static void main (String[] args) {
//		// following code will allow us to redirect standard output to the file
//		// Because text printed to the console is not very suitable for our purposes
//		// we will print text to the file
//		try {
//			System.setOut(new PrintStream("set_out.txt"));
//		} catch (FileNotFoundException ex) {
//			ex.printStackTrace();
//			return;
//		}
//		
//		ManagementSystemImpl ms = ManagementSystemImpl.getInstance();
//		
//		// Printing the full list of groups
//		printString(LocalTime.now());
//		printString("Full list of groups");
//		printString("*******************");
//		List<Group> allGroups = ms.getGroups();
//		for (Group gi : allGroups) {
//			printString(gi);
//		}
//		printString();
//		
//		// Printing the full list of Students
//		printString("Full list of Students");
//		printString("*********************");
//		Collection<Student> allStudents = ms.getAllStudents();
//		for(Student si : allStudents) {
//			printString(si);
//		}
//		printString();
//		
//		// Printing all the students BY particular group
//		printString("List of all students BY particular group");
//		printString("****************************************");
//		List<Group> groups = ms.getGroups();
//		// checking all the groups
//		for (Group gi : groups) {
//			printString("---> Group: " + gi.getNameGroup());
//			// getting all the students for particular group
//			Collection<Student> students = ms.getStudentsFromGroup(gi, 2006);
//			for (Student si : students) {
//				printString(si);
//			}
//		}
//		printString();
//		
//		// Lets create new student and add him to the list
//		Student s = new Student();
//		s.setStudentId(5);
//		s.setFirstName("Oleg");
//		s.setPatronymic("G");
//		s.setSurName("Buhlakov");
//		s.setSex('m');
//		Calendar c1 = Calendar.getInstance();
//		c1.set(1991,  8, 31);
//		s.setDateOfBirth(c1.getTime());
//		s.setGroupId(1);
//		s.setEducationYear(2006);
//		printString("Adding new student: " + s);
//		printString("********************");
//		ms.insertStudent(s);
//		printString("--> Full list of students after addition");
//		allStudents = ms.getAllStudents();
//		for (Student si : allStudents) {
//			printString(si);
//		}
//		printString();
//		
//		// Lets change all info about particular student
//		// we will create a student entry with a existing id
//		s = new Student();
//		s.setStudentId(5);
//		s.setFirstName("Oleg");
//		s.setPatronymic("G");
//		s.setSurName("NewBuhlakov");
//		s.setSex('m');
//		c1 = Calendar.getInstance();
//		c1.set(1991,  8, 31);
//		s.setDateOfBirth(c1.getTime());
//		s.setGroupId(1);
//		s.setEducationYear(2006);
//		printString("Modifing student info: " + s);
//		printString("********************");
//		ms.insertStudent(s);
//		printString("--> Full list of students after modification");
//		allStudents = ms.getAllStudents();
//		for (Student si : allStudents) {
//			printString(si);
//		}
//		printString();
//		
//		// Lets delete particular student
//		printString("Deleting a student:" + s);
//		printString("*******************");
//		ms.deleteStudent(s);
//		printString("--->> Full list of Students after deletion");
//		allStudents = ms.getAllStudents();
//		for(Student si : allStudents) {
//			printString(si);
//		}
//		printString();
//		
//		// Here we will move all students from one group to another
//		Group g1 = groups.get(0);
//		Group g2 = groups.get(1);
//		
//		printString("Moving students from first group to second group");
//		printString("************************************************");
//		ms.moveStudentsToGroup(g1, 2006, g2, 2007);
//		printString("--->> Full list of students after moving to the new group");
//		allStudents = ms.getAllStudents();
//		for(Student si : allStudents) {
//			printString(si);
//		}
//		printString();
//		
//		// Deleting students from the group
//		printString("Deleting students from the group: " + g2 + " in the year 2006");
//		printString("*************************************************************");
//		ms.removeStudentsFromGroup(g2,  2006);
//		printString("--->> Full list of students after deletion");
//		allStudents = ms.getAllStudents();
//		for (Iterator i = allStudents.iterator(); i.hasNext();) {
//			printString(i.next());
//		}
//	}
	
	
	
	
	
	// Method that creates 2 different groups and puts it into the list collection
	public void loadGroups() {
		// Verify if the list is not created yet
		if (groups == null) {
			groups = new ArrayList<Group>();
		} else {
			groups.clear();
		}
		Group g = null;
		
		g = new Group();
		g.setGroupId(1);
		g.setNameGroup("FirstGroup");
		g.setCurator("Sergei Ivanich");
		g.setSpeciality("Mathematics");
		groups.add(g);
		
		g = new Group();
		g.setGroupId(2);
		g.setNameGroup("SecondGroup");
		g.setCurator("Vasili Petrovich");
		g.setSpeciality("Phisics");
		groups.add(g);
	}
	
	// Method that creates several students and puts them into the collection
	public void loadStudents() {
		if (students == null) {
			// in this case we will use collection that sorts its entryes
			students = new TreeSet<Student>();
		} else {
			students.clear();
		}
		
		Student s = null;
		Calendar c = Calendar.getInstance();
		
		// Second group
		s = new Student();
		s.setStudentId(1);
		s.setFirstName("Vasili");
		s.setPatronymic("M");
		s.setSurName("Ivanov");
		s.setSex('m');
		c.set(1990, 3, 20);
		s.setDateOfBirth(c.getTime());
		s.setGroupId(2);
		s.setEducationYear(2006);
		students.add(s);
		
		s = new Student();
        s.setStudentId(2);
        s.setFirstName("Natalia");
        s.setPatronymic("A");
        s.setSurName("Semenova");
        s.setSex('f');
        c.set(1990, 6, 10);
        s.setDateOfBirth(c.getTime());
        s.setGroupId(2);
        s.setEducationYear(2006);
        students.add(s);
        
     // first group
     	s = new Student();
     	s.setStudentId(3);
     	s.setFirstName("Maxim");
     	s.setPatronymic("P");
     	s.setSurName("Zaebalov");
     	s.setSex('m');
     	c.set(1990, 5, 25);
     	s.setDateOfBirth(c.getTime());
     	s.setGroupId(1);
     	s.setEducationYear(2006);
     	students.add(s);
     		
     	s = new Student();
        s.setStudentId(4);
        s.setFirstName("Marina");
        s.setPatronymic("A");
        s.setSurName("Krasotkina");
        s.setSex('f');
        c.set(1990, 7, 11);
        s.setDateOfBirth(c.getTime());
        s.setGroupId(1);
        s.setEducationYear(2006);
        students.add(s);
	}
	
	// Method for getting list of groups
	public List<Group> getGroups(){
		return groups;
	}
	
	// Method for getting list of all Students
	
	public Collection<Student> getAllStudents(){
		return students;
	}
	
	// Method for getting list of Students for particular group
	public Collection<Student> getStudentsFromGroup (Group group, int year) {
		Collection<Student> l = new TreeSet<Student>();
		for (Student si : students) {
			if (si.getGroupId() == group.getGroupId() && si.getEducationYear() == year) {
				l.add(si);
			}
		}
		return l;
	}
	
	// Method for movin students from one group to another
	public void moveStudentsToGroup (Group oldGroup, int oldYear, Group newGroup, int newYear) {
		for(Student si : students) {
			if(si.getGroupId() == oldGroup.getGroupId() && si.getEducationYear() == oldYear) {
				si.setGroupId(newGroup.getGroupId());
				si.setEducationYear(newYear);
			}
		}
	}
	
	// Delete all the students from particular group
	public void removeStudentsFromGroup(Group group, int year) {
		// We will create a new list of student without those that needs to be deleted
		Collection<Student> tmp = new TreeSet<Student>();
		for(Student si : students) {
			if(si.getGroupId() != group.getGroupId() || si.getEducationYear() != year) {
				tmp.add(si);
			}
		}
		students = tmp;
	}
	
	// Method for adding new student
	public void insertStudent(Student student){
		// adding new Student object to the collection
		students.add(student);
	}
	
	// Update info about student
	public void updateStudent(Student student) {
		// We need to find particular student by ID
		Student updStudent = null;
		for (Student si : students) {
			if (si.getStudentId() == student.getStudentId()) {
				updStudent = si;
				break;
			}
		}
		updStudent.setFirstName(student.getFirstName());
		updStudent.setPatronymic(student.getPatronymic());
		updStudent.setSurName(student.getSurName());
		updStudent.setSex(student.getSex());
		updStudent.setDateOfBirth(student.getDateOfBirth());
		updStudent.setGroupId(student.getGroupId());
		updStudent.setEducationYear(student.getEducationYear());
	}
	
	// Delete student
	public void deleteStudent(Student student) {
		// first we nedd to find particular student
		Student delStudent = null;
		for (Student si : students) {
			if (si.getStudentId() == student.getStudentId()) {
				// once match found - student need to be reasigned and loop terminated
				delStudent = si;
				break;
			}
		}
		students.remove(delStudent);
	}
	
	public static void printString(Object s) {
		try {
			System.out.println(new String(s.toString().getBytes("windows-1251"), "windows-1252"));
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void printString() {
		System.out.println();
	}
	
	
}
