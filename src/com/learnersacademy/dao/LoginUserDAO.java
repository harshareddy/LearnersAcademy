package com.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.learnersacademy.model.LoginUser;
import com.learnersacademy.utils.HibernateUtil;

public class LoginUserDAO {
	
	@SuppressWarnings("unchecked")
	public List<LoginUser> getLoginUser(String userName , String password, String role) {

		Transaction transaction = null;
		List<LoginUser> loginUserList = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			
		     Query query  = session.createQuery("From LoginUser lu "
		     		+ " Where lu.userName = :userName"
		    		+ " and lu.password = :password"
		    		+ " and lu.role = :role "	);
		     query.setParameter("userName", userName);
		     query.setParameter("password", password);
		     query.setParameter("role", role);
		      loginUserList =  query.getResultList();

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return loginUserList;

	}


}
