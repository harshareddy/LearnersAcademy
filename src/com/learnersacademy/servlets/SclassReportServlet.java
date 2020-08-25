package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.SclassDAO;
import com.learnersacademy.dao.SubjectDAO;
import com.learnersacademy.dao.TeacherDAO;
import com.learnersacademy.model.Sclass;
import com.learnersacademy.model.Student;
import com.learnersacademy.model.Subject;
import com.learnersacademy.model.Teacher;

public class SclassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SclassDAO sclassDAO;
	private SubjectDAO subjectDAO;
	private TeacherDAO teacherDAO;

	public SclassReportServlet() {
		super();

		sclassDAO = new SclassDAO();
		teacherDAO = new TeacherDAO();
		subjectDAO = new SubjectDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action == null ? "list" : action) {

		case "createreport":
			createReport(request, response);
			break;
		case "list":
			listCourseForm(request, response);

			break;

		default:
			listCourseForm(request, response);

			break;
		}

	}

	private void createReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int sclassId = Integer.parseInt(request.getParameter("sclassid"));

		List<Subject> subjectList = subjectDAO.getAllSubjects(sclassId);
		Set<Student> studentSet = sclassDAO.getSClass(sclassId).getStudentSet();
		List<Teacher> teacherList = teacherDAO.getAllTeachers(sclassId);

		request.setAttribute("subjectList", subjectList);
		request.setAttribute("studentSet", studentSet);
		request.setAttribute("teacherList", teacherList);
		
		RequestDispatcher rd = request.getRequestDispatcher("classreport-list.jsp");
		rd.forward(request, response);

	}

	private void listCourseForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Sclass> sclassList = sclassDAO.getAllSClass();

		request.setAttribute("sclassList", sclassList);

		RequestDispatcher rd = request.getRequestDispatcher("classreport-form.jsp");
		rd.forward(request, response);

	}

}
