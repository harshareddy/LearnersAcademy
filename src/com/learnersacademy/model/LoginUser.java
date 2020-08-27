package com.learnersacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN_USERS")
public class LoginUser {

	int id;
	String userName;
	String password;
	String role;

	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="ROLE")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", userName=" + userName + "]";
	}

}
