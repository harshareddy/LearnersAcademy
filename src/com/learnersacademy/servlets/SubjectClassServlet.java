package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.SclassDAO;
import com.learnersacademy.dao.SubjectClassDAO;
import com.learnersacademy.dao.SubjectDAO;
import com.learnersacademy.model.Sclass;
import com.learnersacademy.model.Subject;
import com.learnersacademy.model.SubjectClass;

public class SubjectClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectClassDAO subjectClassDAO;
	private SubjectDAO subjectDAO;
	private SclassDAO sclassDAO;

	public SubjectClassServlet() {
		super();
		subjectClassDAO = new SubjectClassDAO();
		subjectDAO = new SubjectDAO();
		sclassDAO = new SclassDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {

			action = "list";
		}

		switch (action) {

		case "new":
			newSubjectClass(request, response);

			break;
		case "insert":
			insertSubjectClass(request, response);

			break;
		case "edit":
			editSubjectClass(request, response);
			break;
		case "update":
			updateSubjectClass(request, response);
			break;
		case "delete":
			 deleteSubjectClass(request,response);
			 break;

		case "list":
			listSubjectClass(request, response);

			break;
			

		default:
			break;
		}

	}

	

	private void newSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Subject> subjectList = subjectDAO.getAllSubjects();
		List<Sclass> sclassList = sclassDAO.getAllSClass();

		request.setAttribute("subjectList", subjectList);
		request.setAttribute("sclassList", sclassList);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/subjectclass-form.jsp");
		rd.forward(request, response);

	}

	private void insertSubjectClass(HttpServletRequest request, HttpServletResponse response) throws IOException {

		SubjectClass subjectclass = new SubjectClass();
		String subjectId = request.getParameter("subject");
		String scalssId = request.getParameter("sclass");
		Subject subject = subjectDAO.getSubject(Integer.parseInt(subjectId));
		Sclass sclass = sclassDAO.getSClass(Integer.parseInt(scalssId));

		subjectclass.setSubject(subject);
		subjectclass.setSclass(sclass);

		subjectClassDAO.createSubjectClass(subjectclass);

		response.sendRedirect(request.getContextPath() + "/SubjectAllocation");

	}

	private void editSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Subject> subjectList = subjectDAO.getAllSubjects();
		List<Sclass> sclassList = sclassDAO.getAllSClass();

		String subjectclassId = request.getParameter("id");
		SubjectClass subjectclass = subjectClassDAO.getSubjectClass(Integer.parseInt(subjectclassId));		
		request.setAttribute("subjectclass", subjectclass);
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("sclassList", sclassList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/subjectclass-form.jsp");
		rd.forward(request, response);

	}

	private void updateSubjectClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SubjectClass subjectclass = new SubjectClass();
		String subjectId = request.getParameter("subject");
		String scalssId = request.getParameter("sclass");
		String subjectclassId = request.getParameter("id");

		if (subjectclassId != null) {
			Subject subject = subjectDAO.getSubject(Integer.parseInt(subjectId));
			Sclass sclass = sclassDAO.getSClass(Integer.parseInt(scalssId));

			subjectclass.setId(Integer.parseInt(subjectclassId));
			subjectclass.setSubject(subject);
			subjectclass.setSclass(sclass);

			subjectClassDAO.updateSubjectClass(subjectclass);
		}

		response.sendRedirect(request.getContextPath() + "/SubjectAllocation");

	}
	
	private void deleteSubjectClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		String subjectclassId = request.getParameter("id");
		
		if (subjectclassId!= null) {
			
			subjectClassDAO.deleteSubjectClass(Integer.parseInt(subjectclassId));

		}
		response.sendRedirect(request.getContextPath() + "/SubjectAllocation");		
	}

	private void listSubjectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<SubjectClass> subjectClassList = null;

		subjectClassList = subjectClassDAO.getAllSubjectClass();

		request.setAttribute("subjectclassList", subjectClassList);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/subjectclass-list.jsp");

		rd.forward(request, response);

	}

}
