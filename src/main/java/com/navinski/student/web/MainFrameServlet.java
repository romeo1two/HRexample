package com.navinski.student.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.navinski.student.entity.Groups;
import com.navinski.student.entity.Students;
import com.navinski.student.entity_logic.ManagementSystemLocal;

public class MainFrameServlet extends HttpServlet {

	@EJB (name = "ManagementSystem")
	private ManagementSystemLocal ms;
	
	protected void processRequest (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		int answer = 0;
		answer = checkAction(req);
		if(answer == 1) {
			Students s = new Students();
			s.setStudentId(0);
			s.setDateOfBirth(new Date());
			s.setEducationYear(Calendar.getInstance().get(Calendar.YEAR));
			List<Groups> groups = ms.getGroupsList();
			StudentForm sForm = new StudentForm();
			sForm.initFromStudent(s);
			sForm.setGroups(groups);
			req.setAttribute("student", sForm);
			getServletContext().getRequestDispatcher("/StudentFrame.jsp").forward(req,  resp);
			return;
		}
		
		if(answer == 2) {
			if (req.getParameter("studentId") != null) {
				int stId = Integer.parseInt(req.getParameter("studentId"));
				Students s = ms.getStudents(stId);
				List<Groups> groups = ms.getGroupsList();
				StudentForm sForm = new StudentForm();
				sForm.initFromStudent(s);
				sForm.setGroups(groups);
				req.setAttribute("student", sForm);
				getServletContext().getRequestDispatcher("/StudentFrame.jsp").forward(req, resp);
				return;
			}
		}
	
		String gs = req.getParameter("groupId");
		String ys = req.getParameter("year");
		
		if (answer == 3) {
			String newGs = req.getParameter("newGroupId");
			String newYs = req.getParameter("newYear");
			ms.moveStudentsToGroup(Integer.parseInt(gs), Integer.parseInt(ys), Integer.parseInt(newGs), Integer.parseInt(newYs));
			gs = newGs;
			ys = newYs;
		}
		
		int groupId = -1;
		if (gs != null) {
			groupId = Integer.parseInt(gs);
		}
		int year = Calendar.getInstance().get(Calendar.YEAR);
		if (ys != null) {
			year = Integer.parseInt(ys);
		}
		MainFrameForm form = new MainFrameForm();
		List<Groups> groups = ms.getGroupsList();
		if (groupId == -1) {
			Iterator<Groups> i = groups.iterator();
			groupId = i.next().getGroupId();
		}
		List<Students> students = ms.getStudentsFromGroup(groupId,  year);
		form.setGroupId(groupId);
		form.setYear(year);
		form.setGroups(groups);
		form.setStudents(students);
		req.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
	}
	
	
	public void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		processRequest (req, resp);
	}
	
	private int checkAction (HttpServletRequest req) {
		if (req.getParameter("Add") != null) {
			return 1;
		}
		if (req.getParameter("Edit") != null) {
			return 2;
		}
		if (req.getParameter("MoveGroup") != null) {
			return 3;
		}
		if (req.getParameter("Delete") != null) {
			if (req.getParameter("Delete") != null) {
				ms.deleteStudents(Integer.parseInt(req.getParameter("StudentId")));
			}
			return 0;
		}
		return 0;
	}
}
