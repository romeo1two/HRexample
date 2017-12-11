package com.navinski.student.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.Date;
import java.util.Locale;

public class Student implements Comparable {
	 // variable Student ID
    private int studentId;
    // variable Name
    private String firstName;
    // variable LastName
    private String surName;
    // variable MiddleName
    private String patronymic;
    // variable date of birth
    private Date dateOfBirth;
    // variable sex
    private char sex;
    // variable group ID
    private int groupId;
    // variable education year
    private int educationYear;
    
    // constructor gets data from database
    public Student(ResultSet rs) throws SQLException {
    	setStudentId(rs.getInt(1));
    	setFirstName(rs.getString(2));
    	setPatronymic(rs.getString(3));
    	setSurName(rs.getString(4));
    	setSex(rs.getString(5).charAt(0));
    	setDateOfBirth(rs.getDate(6));
    	setGroupId(rs.getInt(7));
    	setEducationYear(rs.getInt(8));
    }
    
    // get or set Student ID
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	// get or set Student First Name
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// get or set Last Name
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	// get or set Otchestvo
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	
	// get / set Date of birth
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	// get or set Students sex
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	// ger or set Group ID
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	// get or set Education year
	public int getEducationYear() {
		return educationYear;
	}
	public void setEducationYear(int educationYear) {
		this.educationYear = educationYear;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", surName=" + surName
				+ ", groupId=" + groupId + ", educationYear="
				+ educationYear + "]";
	}
    
    public int compareTo(Object obj) {
    	Collator c = Collator.getInstance(new Locale("ru"));
    	c.setStrength(Collator.PRIMARY);
    	return c.compare(this.toString(), obj.toString());
    }
}
