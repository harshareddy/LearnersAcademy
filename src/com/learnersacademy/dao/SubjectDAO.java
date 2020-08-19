package com.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.model.Subject;
import com.learnersacademy.utils.HibernateUtil;

public class SubjectDAO {

	public void createSubject(Subject subject) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void deleteSubject(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			Subject subject = session.get(Subject.class, id);			
			if (subject != null) {
				session.delete(subject);
			}
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void updateSubject(Subject subject) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(subject);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubjects() {

		Transaction transaction = null;
		List<Subject> subjectList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			subjectList = session.createQuery("From Subject").getResultList();

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return subjectList;
	}

	public Subject getSubject(int id) {

		Transaction transaction = null;
		Subject subject = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			subject = session.get(Subject.class, id);

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return subject;

	}

}
