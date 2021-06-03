package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="login_master")

public class LoginEntity {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//int login_id;
	@Id
	int user_id ;
	@Column
	String password;
	@Column
	String user_type;
	
	public LoginEntity() {
		super();
	}




	public LoginEntity(int user_id, String password, String userType) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.user_type = userType;
	}




	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}




	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}




	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}




	


}
