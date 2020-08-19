package com.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.model.Sclass;
import com.learnersacademy.utils.HibernateUtil;

public class SclassDAO {

	public void createClass(Sclass sClass) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(sClass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void deleteSClass(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			Sclass sClass = session.get(Sclass.class, id);
			session.save(sClass);
			if (sClass != null) {
				session.delete(sClass);
			}
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void updateSClass(Sclass sClass) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(sClass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public List<Sclass> getAllSClass() {

		Transaction transaction = null;
		List<Sclass> sClassList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			sClassList = session.createQuery("From Sclass", Sclass.class).getResultList();

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return sClassList;
	}

	public Sclass getSClass(int id) {

		Transaction transaction = null;
		Sclass sClass = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			sClass = session.get(Sclass.class, id);

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return sClass;

	}

}
