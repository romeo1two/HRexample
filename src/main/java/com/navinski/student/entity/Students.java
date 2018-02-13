package com.navinski.student.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// new updates 
@Entity
@Table (name = "students")
@NamedQueries({
	@NamedQuery (name = "Students.findByStudentId",
			query = ("SELECT s FROM Students s WHERE s.studentId = :studentId")),
	@NamedQuery (name = "Students.findBySurName",
		query = ("SELECT s FROM Students s WHERE s.surName = :surName")),
	@NamedQuery (name = "Students.findByPatronimics",
		query = ("SELECT s FROM Students s WHERE s.patronymic = :patronimic")),
	@NamedQuery (name = "Students.findByDateOfBirth",
		query = ("SELECT s FROM Students s WHERE s.dateOfBirth = :dateOfBirth")),
	@NamedQuery (name = "Students.findBySex",
		query = ("SELECT s FROM Students s WHERE s.sex = :sex")),
	@NamedQuery (name = "Students.findByGroupId",
		query = ("SELECT s FROM Students s WHERE s.groupId = :groupId")),
	@NamedQuery (name = "Students.findByEducationYear",
		query = ("SELECT s FROM Students s WHERE s.educationYear = :educationYear")),
	@NamedQuery (name = "Students.findByGroupAndYear",
		query = ("SELECT s FROM Students s WHERE s.groupId = :groupId AND s.educationYear = :educationYear")),
	@NamedQuery(name = "Students.updateGroupAndYear",
    	query = "UPDATE Students s SET s.groupId=:groupId, s.educationYear=:educationYear "
    			+ "WHERE s.groupId = :oldGroupId AND s.educationYear=:oldEducationYear")

})

public class Students implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "student_id", nullable = false)
	private Integer studentId;
	@Column (name = "firstName", nullable = false)
	private String firstName;
	@Column(name = "surName", nullable = false)
    private String surName;
    @Column(name = "patronymic", nullable = false)
    private String patronymic;
    @Column(name = "dateOfBirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "sex")
    private Character sex = 'M';
    @Column(name = "group_id", nullable = false)
    private int groupId;
    @Column(name = "educationYear", nullable = false)
    private int educationYear;
	
    public Students() {}
    
    public Students (Integer studentId) {
    	this.studentId = studentId;
    }

	public Students(Integer studentId, String firstName, String surName, String patronymic, Date dateOfBirth,
			int groupId, int educationYear) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.surName = surName;
		this.patronymic = patronymic;
		this.dateOfBirth = dateOfBirth;
		this.groupId = groupId;
		this.educationYear = educationYear;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getEducationYear() {
		return educationYear;
	}

	public void setEducationYear(int educationYear) {
		this.educationYear = educationYear;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Students [studentId=" + studentId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}
    
    
    
}
