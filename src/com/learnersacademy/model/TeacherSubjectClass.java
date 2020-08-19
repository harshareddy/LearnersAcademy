package com.learnersacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER_SUBJECT_CLASS")
public class TeacherSubjectClass {

	private int id;
	private SubjectClass subjectClass;
	private Teacher teacher;

	public TeacherSubjectClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherSubjectClass(SubjectClass subjectClass, Teacher teacher) {
		super();
		this.subjectClass = subjectClass;
		this.teacher = teacher;
	}

	public TeacherSubjectClass(int id, SubjectClass subjectClass, Teacher teacher) {
		super();
		this.id = id;
		this.subjectClass = subjectClass;
		this.teacher = teacher;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TEACHER_ALLOCATION_ID")
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	@OneToOne
	@JoinColumn(name="SUBJECT_CLASS_ID")
	public SubjectClass getSubjectClass() {
		return subjectClass;
	}

	public void setSubjectClass(SubjectClass subjectClass) {
		this.subjectClass = subjectClass;
	}
    
	@ManyToOne
	@JoinColumn(name="TEACHER_ID")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "TeacherSubjectClass [id=" + id + "]";
	}

}
