package com.navinski.student.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class StudentFrameServlet extends HttpServlet {

	@EJB (name = "ManagementSystem")
	private ManagementSystemLocal ms;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
	protected void processRequest (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sId = req.getParameter("StudentId");
		if (sId != null && req.getParameter("OK") != null) {
			try {
				if (Integer.parseInt(sId) > 0){
					updateStudent(req);
				} else {
					insertStudent(req);
				}
			} catch (SQLException sql_e) {
				sql_e.printStackTrace();
				throw new IOException(sql_e.getMessage());
			} catch (ParseException p_e){
				throw new IOException(p_e.getMessage());
			}
		} 
		String gs = req.getParameter("groupId");
		String ys = req.getParameter("educationYear");
		int groupId = -1;
		if (gs != null) {
			groupId = Integer.parseInt(gs);
		}
		int year = Calendar.getInstance().get(Calendar.YEAR);
		if (ys != null) {
			year = Integer.parseInt(ys);
		}
		// some more changes NOT
		// 
		
		MainFrameForm form = new MainFrameForm();
		List<Groups> groups = ms.getGroupsList();
		if (groupId == -1) {
			Iterator<Groups> i = groups.iterator();
			groupId = i.next().getGroupId();
		}
		List<Students> students = ms.getStudentsFromGroup(groupId, year);
		form.setGroupId(groupId);
		form.setYear(year);
		form.setGroups(groups);
		form.setStudents(students);
		req.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	public void doPost (HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		processRequest(req, resp);
	}
	
	private void updateStudent(HttpServletRequest req) throws SQLException, ParseException {
		Students s = prepareStudent (req);
		ms.insertStudents(s);
	}
	
	private void insertStudent(HttpServletRequest req) throws SQLException, ParseException {
		Students s = prepareStudent(req);
		ms.insertStudents(s);
	}
	
	private Students prepareStudent (HttpServletRequest req) throws ParseException {
		
		Students s = new Students();
		if(Integer.parseInt(req.getParameter("studentId")) > 0) {
			s.setStudentId(Integer.parseInt(req.getParameter("studentId")));
		}
		s.setFirstName(req.getParameter("firstName").trim());
		s.setSurName(req.getParameter("surName").trim());
		s.setPatronymic(req.getParameter("patronymic").trim());
		s.setDateOfBirth(sdf.parse(req.getParameter("dateOfBirth").trim()));
		if (req.getParameter("sex").equals("0")) {
			s.setSex('M');
		} else {
			s.setSex('F');
		}
		s.setGroupId(Integer.parseInt(req.getParameter("groupId").trim()));
		s.setEducationYear(Integer.parseInt(req.getParameter("educationYear")));
		return s;
	}
}
