package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.dao.LoginUserDAO;
import com.learnersacademy.model.LoginUser;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginUserDAO loginuserDAO;

	public LoginServlet() {
		super();
		loginuserDAO = new LoginUserDAO();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("inputemail");
		String password = request.getParameter("password");

		RequestDispatcher requestDispatcher;
		List<LoginUser> loginUserlist = loginuserDAO.getLoginUser(username, password, "admin_role");

		if (!loginUserlist.isEmpty()) {

			HttpSession session = request.getSession(true);

			session.setAttribute("username", username);
			requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");
			requestDispatcher.forward(request, response);
		} else {
			requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
			request.setAttribute("loginmessage", "Login is Invalid, please login again");
			requestDispatcher.include(request, response);

		}
	}

}
