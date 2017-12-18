package com.navinski.student.entity_logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.navinski.student.entity.Groups;
import com.navinski.student.entity.Students;

public class ManagementSystemBean implements ManagementSystemLocal {

	@PersistenceContext
	private EntityManager em;
	
	public void persist(Object object) {
		em.persist(object);
	}
	
	public Students getStudents(int studentId) {
		return em.find(Students.class, studentId);
	}

	public List<Groups> getGroupsList() {
		Query q = em.createQuery("SELECT g FROM Groups g");
		List<Groups> l = q.getResultList();
		return l;
	}

	public List<Students> getStudentsFromGroup(int groupId, int year) {
		Query q = em.createNamedQuery("Students.findByGroupAndYear");
		q.setParameter("groupId", groupId);
		q.setParameter("educationYear", year);
		List<Students> l = q.getResultList();
		return l;
	}

	public void moveStudentsToGroup(int groupId, int year, int newGroupId, int newYear) {
		Query q = em.createNamedQuery("Students.updateGroupAndYear");
		q.setParameter("groupId", newGroupId);
		q.setParameter("educationYear", newYear);
		q.setParameter("oldGroupId", groupId);
		q.setParameter("oldEducationYear", year);
		q.executeUpdate();	
	}

	public void insertStudents(Students st) {
		em.persist(st);
	}

	public void updateStudents(Students st) {
		Students sOld = em.find(Students.class, st.getStudentId());
		sOld.setFirstName(st.getFirstName());
		sOld.setSurName(st.getSurName());
		sOld.setPatronymic(st.getPatronymic());
		sOld.setDateOfBirth(st.getDateOfBirth());
		sOld.setGroupId(st.getGroupId());
		sOld.setSex(st.getSex());
		
		
	}

	public void deleteStudents(int studentsId) {
		Students sOld = em.find(Students.class, studentsId);
		em.remove(sOld);
	}
	
}
