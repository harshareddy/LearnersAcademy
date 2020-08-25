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
import com.learnersacademy.model.Sclass;
import com.learnersacademy.model.Student;

import com.learnersacademy.model.SubjectClass;

public class SclassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SclassDAO sclassDAO;

	public SclassReportServlet() {
		super();
		sclassDAO = new SclassDAO();

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

	private void createReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sclassId = Integer.parseInt(request.getParameter("sclassid"));

		Sclass sclass = sclassDAO.getSClass(sclassId);
		Set<SubjectClass> subjectClassSet = sclass.getSubjectClassSet();
		Set<Student> studentSet = sclassDAO.getSClass(sclassId).getStudentSet();

		request.setAttribute("studentSet", studentSet);
		request.setAttribute("subjectClassSet", subjectClassSet);

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
