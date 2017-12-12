package com.navinski.student.frame;

import java.text.DateFormat;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.navinski.student.logic.Student;

public class StudentTableModel extends AbstractTableModel {
	
	// lets create a storage for our list of students
	private Vector students;
	
	// at the time of creation model receives list of students
	public StudentTableModel(Vector student) {
		this.students = students;
	}
	
	// number of lines equals to number of entryes
	public int getRowCount() {
		if(students != null) {
			return students.size();
		}
		return 0;
	}
	
	// number of columns - 4
	public int getColumnCount() {
		return 4;
	}
	
	// returning name of the column
	public String getColumnName(int column) {
		String[] colNames = {"LastName", "FirstName", "SurName", "Date"};
		return colNames[column];
	}
	
	// returning data for particular line and column
	public Object getValueAt (int rowIndex, int columnIndex) {
		if (students != null) {
			// getting a student of a vector
			Student st = (Student) students.get(rowIndex);
			// depending on the column returning firstname, lastname etc
			switch (columnIndex) {
			case 0:
				return st.getSurName();
			case 1:
				return st.getFirstName();
			case 2:
				return st.getPatronymic();
			case 3:
				return DateFormat.getDateInstance(DateFormat.SHORT)
						.format(st.getDateOfBirth());	
			}
		}
		return null;
	}
	
	//lets method, that returns student buy the line number
	public Student getStudent (int rowIndex) {
		if(students != null) {
			if(rowIndex < students.size() && rowIndex>=0) {
				return (Student) students.get(rowIndex);
			}
		}
		return null;
	}
	
	
}
