package com.learnersacademy.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSES")
public class Sclass {

	private int id;

	private String Name;

	private Set<SubjectClass> subjectClassSet;

	private Set<Student> studentSet;

	public Sclass() {
	}

	public Sclass(String name) {
		super();
		Name = name;
	}

	public Sclass(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLASS_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CLASS_NAME")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@OneToMany(mappedBy = "sclass", cascade = CascadeType.ALL)
	public Set<SubjectClass> getSubjectClassSet() {
		return subjectClassSet;
	}

	public void setSubjectClassSet(Set<SubjectClass> subjectClassSet) {
		this.subjectClassSet = subjectClassSet;
	}

	@OneToMany(mappedBy = "sclass", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.EAGER)
	public Set<Student> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", Name=" + Name + "]";
	}

}
