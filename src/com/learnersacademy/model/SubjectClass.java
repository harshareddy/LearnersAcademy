package com.learnersacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTS_CLASSES")
public class SubjectClass {

	private int id;

	private Subject subject;

	private Sclass sclass;

	public SubjectClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectClass(Subject subject, Sclass sclass) {
		super();
		this.subject = subject;
		this.sclass = sclass;
	}

	public SubjectClass(int id, Subject subject, Sclass sclass) {
		super();
		this.id = id;
		this.subject = subject;
		this.sclass = sclass;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SUJBECT_CLASS_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@ManyToOne
	@JoinColumn(name="CLASS_ID")
	public Sclass getSclass() {
		return sclass;
	}

	public void setSclass(Sclass sclass) {
		this.sclass = sclass;
	}

	@Override
	public String toString() {
		return "SubjectClass [id=" + id + "]";
	}

}
