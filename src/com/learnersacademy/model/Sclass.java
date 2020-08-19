package com.learnersacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSES")
public class Sclass {

	private int id;

	private String Name;

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

	@Override
	public String toString() {
		return "Class [id=" + id + ", Name=" + Name + "]";
	}

}
