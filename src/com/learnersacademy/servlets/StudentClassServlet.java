package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.SclassDAO;
import com.learnersacademy.dao.StudentDAO;
import com.learnersacademy.model.Sclass;
import com.learnersacademy.model.Student;

public class StudentClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
	private SclassDAO sclassDAO;

	public StudentClassServlet() {

		studentDAO = new StudentDAO();
		sclassDAO = new SclassDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action=" + action);

		switch (action == null ? "" : action) {
		case "edit":
			editStudentClass(request, response);
			break;
		case "update":
			updateStudentClass(request, response);
			break;
		case "delete":
			deleteStudentClass(request, response);
			break;

		case "list":
			listStudentClass(request, response);

			break;

		default:
			listStudentClass(request, response);
			break;
		}

	}

	private void deleteStudentClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String studentId = request.getParameter("id");

		if (studentId != null) {
			Student student = studentDAO.getStudent(Integer.parseInt(studentId));
			student.setSclass(null);
			studentDAO.updateStudent(student);

		}
		
		response.sendRedirect(request.getContextPath()+"/StudentAllocation");

	}

	private void editStudentClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("id");
		Student student;
		List<Sclass> sclassList;
		if (studentId != null) {
			student = studentDAO.getStudent(Integer.parseInt(studentId));
			sclassList = sclassDAO.getAllSClass();

			request.setAttribute("student", student);
			request.setAttribute("sclassList", sclassList);

		}

		RequestDispatcher rd = request.getRequestDispatcher("/admin/studentallocation-form.jsp");
		rd.forward(request, response);

	}

	private void updateStudentClass(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String studentid = request.getParameter("id");
		String sclassid = request.getParameter("sclassid");

		if (studentid != null && sclassid != null) {

			Student student = studentDAO.getStudent(Integer.parseInt(studentid));
			Sclass sclass = sclassDAO.getSClass(Integer.parseInt(sclassid));
			student.setSclass(sclass);
			studentDAO.updateStudent(student);

		}
		response.sendRedirect(request.getContextPath() + "/StudentAllocation");

	}

	private void listStudentClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Student> studentList = studentDAO.getAllStudent();
		request.setAttribute("studentList", studentList);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/studentallocation-list.jsp");
		rd.forward(request, response);

	}

}
