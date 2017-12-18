package com.navinski.student.entity_logic;

import java.util.List;

import com.navinski.student.entity.Groups;
import com.navinski.student.entity.Students;

public interface ManagementSystemLocal {
	
	// get data about particular student
	Students getStudents (int studentId);
	// get list of all groups
	List<Groups> getGroupsList();
	// get list of all students for particular group
	List<Students> getStudentsFromGroup (int groupId, int year);
	// move students from one group to another
	void moveStudentsToGroup (int groupId, int year, int newGroupId, int newYear);
	// add new student
	void insertStudents(Students st);
	// update data of student
	void updateStudents(Students st);
	// delete student
	void deleteStudents(int studentsId);
	
}
