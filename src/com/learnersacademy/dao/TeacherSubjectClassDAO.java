package com.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.learnersacademy.model.TeacherSubjectClass;
import com.learnersacademy.utils.HibernateUtil;

public class TeacherSubjectClassDAO {

	public void createTeacherSubjectClass(TeacherSubjectClass teacherSubjectClass) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(teacherSubjectClass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void updateTeacherSubjectClass(TeacherSubjectClass teacherSubjectClass) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(teacherSubjectClass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void deleteTeacherSubjectClass(int id) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			TeacherSubjectClass teacherSubjectClass = session.get(TeacherSubjectClass.class, id);
			session.delete(teacherSubjectClass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	@SuppressWarnings("unchecked")
	public List<TeacherSubjectClass> getAllTeacherSubjectClass() {

		Transaction transaction = null;
		List<TeacherSubjectClass> teacherSubjectClassList = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			teacherSubjectClassList = session.createQuery("From TeacherSubjectClass").getResultList();
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return teacherSubjectClassList;

	}

	public TeacherSubjectClass getTeacherSubjectClass(int id) {

		Transaction transaction = null;
		TeacherSubjectClass teacherSubjectClass = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			teacherSubjectClass = session.get(TeacherSubjectClass.class, id);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return teacherSubjectClass;

	}

}
