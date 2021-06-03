package com.example.demo.entities;

public class ClassTeacher {
	
	int class_id;
	String standard;
	
	int user_id;
	String first_name;
	String last_name;
	String email;
	String contact_no;
	String qualification;
	String address;
	public ClassTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassTeacher(int class_id, String standard, int user_id, String first_name, String last_name, String email,
			String contact_no, String qualification, String address) {
		super();
		this.class_id = class_id;
		this.standard = standard;
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.contact_no = contact_no;
		this.qualification = qualification;
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
	/**
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}
	/**
	 * @param standard the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
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
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
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
	
	

}
