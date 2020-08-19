package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.SubjectClassDAO;
import com.learnersacademy.dao.TeacherDAO;
import com.learnersacademy.dao.TeacherSubjectClassDAO;
import com.learnersacademy.model.SubjectClass;
import com.learnersacademy.model.Teacher;
import com.learnersacademy.model.TeacherSubjectClass;

public class TeacherSubjectClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherSubjectClassDAO teacherSubjectClassDAO;
	private TeacherDAO teacherDAO;
	private SubjectClassDAO subjectClassDAO;

	public TeacherSubjectClassServlet() {
		super();
		teacherSubjectClassDAO = new TeacherSubjectClassDAO();
		teacherDAO = new TeacherDAO();
		subjectClassDAO = new SubjectClassDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}

		switch (action) {
		case "new":

			newTeacherSubjectClass(request, response);
			break;
		case "insert":

			insertTeacherSubjectClass(request, response);
			break;
		case "edit":

			editTeacherSubjectClass(request, response);
			break;
		case "update":

			updateTeacherSubjectClass(request, response);
			break;
		case "delete":

			deleteTeacherSubjectClass(request, response);
			break;

		case "list":

			listTeacherSubjectClass(request, response);

			break;

		default:
			listTeacherSubjectClass(request, response);
			break;
		}
	}

	private void newTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Teacher> teacherList = teacherDAO.getAllTeachers();
		List<SubjectClass> subjectClassList = subjectClassDAO.getAllSubjectClass();

		request.setAttribute("teacherList", teacherList);
		request.setAttribute("subjectClassList", subjectClassList);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/teacherallocation-form.jsp");
		rd.forward(request, response);

	}

	private void insertTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String teacherid = request.getParameter("teacherid");
		String subjectclassid = request.getParameter("subjectclassid");

		if (teacherid != null && subjectclassid != null) {
			Teacher teacher = teacherDAO.getTeacher(Integer.parseInt(teacherid));
			SubjectClass subjectClass = subjectClassDAO.getSubjectClass(Integer.parseInt(subjectclassid));
			TeacherSubjectClass teacherSubjectClass = new TeacherSubjectClass(subjectClass, teacher);
			teacherSubjectClassDAO.createTeacherSubjectClass(teacherSubjectClass);

		}
		response.sendRedirect(request.getContextPath() + "/TeacherAllocation");

	}

	private void editTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teacher_allocation_id = request.getParameter("id");
		List<Teacher> teacherList = teacherDAO.getAllTeachers();
		List<SubjectClass> subjectClassList = subjectClassDAO.getAllSubjectClass();
		TeacherSubjectClass teacherSubjectClass = null;
		if (teacher_allocation_id != null) {

			teacherSubjectClass = teacherSubjectClassDAO
					.getTeacherSubjectClass(Integer.parseInt(teacher_allocation_id));

		}

		request.setAttribute("teacherList", teacherList);
		request.setAttribute("subjectClassList", subjectClassList);
		request.setAttribute("teacherSubjectClass", teacherSubjectClass);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/teacherallocation-form.jsp");
		rd.forward(request, response);

	}

	private void updateTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String teacherid = request.getParameter("teacherid");
		String subjectclassid = request.getParameter("subjectclassid");
		String teacherAssociationId = request.getParameter("id");

		if (teacherid != null && subjectclassid != null && teacherAssociationId != null) {
			Teacher teacher = teacherDAO.getTeacher(Integer.parseInt(teacherid));
			SubjectClass subjectClass = subjectClassDAO.getSubjectClass(Integer.parseInt(subjectclassid));
			int id = Integer.parseInt(teacherAssociationId);
			TeacherSubjectClass teacherSubjectClass = new TeacherSubjectClass(id, subjectClass, teacher);
			teacherSubjectClassDAO.updateTeacherSubjectClass(teacherSubjectClass);

		}
		response.sendRedirect(request.getContextPath() + "/TeacherAllocation");

	}

	private void deleteTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String teacherAssociationId = request.getParameter("id");

		if (teacherAssociationId != null) {
			teacherSubjectClassDAO.deleteTeacherSubjectClass(Integer.parseInt(teacherAssociationId));
		}

		response.sendRedirect(request.getContextPath() + "/TeacherAllocation");
	}

	private void listTeacherSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<TeacherSubjectClass> teacherSubjectClassList = teacherSubjectClassDAO.getAllTeacherSubjectClass();

		request.setAttribute("teacherSubjectClassList", teacherSubjectClassList);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/teacherallocation-list.jsp");
		rd.forward(request, response);

	}

}
