package com.navinski.student.web;

import java.text.SimpleDateFormat;
import java.util.Collection;

import com.navinski.student.entity.Students;
import com.navinski.student.logic.Student;

public class StudentForm {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	private int studentId;
	private String firstName;
	private String surName;
	private String patronymic;
	private String dateOfBirth;
	private int sex;
	private int groupId;
	private int educationYear;
	private Collection groups;
	
	public void initFromStudent(Students st) {
		this.studentId = st.getStudentId();
		this.firstName = st.getFirstName();
		this.surName = st.getSurName();
		this.patronymic = st.getPatronymic();
		this.dateOfBirth = sdf.format(st.getDateOfBirth());
		if(st.getSex() == 'M') {
			this.sex = 0;
		} else {
			this.sex = 1;
		}
		this.groupId = st.getGroupId();
		this.educationYear = st.getEducationYear();
	} // no new descriptions available for now
	// some new description of new method
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth() {
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getEducationYear() {
		return educationYear;
	}
	public void setEducationYear(int educationYear) {
		this.educationYear = educationYear;
	}
	// comments for old line here today
	// comment #55
	// or some other comments for documents right here
	
	public int getGroupId() {
		return groupId;
	}
	// comments set to describe a new method
	// new description added today
	public void setGroupId() {
		this.groupId=groupId;
	}
	public int getStudentId() {
        return studentId;
    }
 
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getPatronymic() {
        return patronymic;
    }
 
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
 
    public String getSurName() {
        return surName;
    }
 
    public void setSurName(String surName) {
        this.surName = surName;
    }
 
    public int getSex() {
        return sex;
    }
 
    public void setSex(int sex) {
        this.sex = sex;
    }
 
    public void setGroups(Collection groups) {
        this.groups = groups;
    }
 
    public Collection getGroups() {
        return groups;
    }
}