package com.example.demo.entities;

import java.util.Date;

public class StudentLogin {

	int user_id;
	String password;

	String first_name;
	String middle_name;
	String last_name;
	String email;
	String contact_no;
	Date dob;
	String address;
	int class_id;
	public StudentLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentLogin(int user_id, String password, String first_name, String middle_name, String last_name,
			String email, String contact_no, Date dob, String address, int class_id) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.contact_no = contact_no;
		this.dob = dob;
		this.address = address;
		this.class_id = class_id;
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
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the middle_name
	 */
	public String getMiddle_name() {
		return middle_name;
	}
	/**
	 * @param middle_name the middle_name to set
	 */
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the contact_no
	 */
	public String getContact_no() {
		return contact_no;
	}
	/**
	 * @param contact_no the contact_no to set
	 */
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the class_id
	 */
	public int getClass_id() {
		return class_id;
	}
	/**
	 * @param class_id the class_id to set
	 */
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	
	
}
