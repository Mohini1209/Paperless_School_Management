package com.example.demo.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="student_master")
@PrimaryKeyJoinColumn(name="class_id")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int s_id;
	@OneToOne
	@JoinColumn(name="user_id")
	LoginEntity user_id;
	@Column
	String first_name;
	@Column
	String middle_name;
	@Column
	String last_name;
	@Column
	String email;
	@Column
	String contact_no;
	@Column
	String address;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	Date dob;	
	@Column
	int class_id;

	
	public StudentEntity() {
		super();
	}

	

	


	public StudentEntity( LoginEntity user_id, String first_name, String middle_name, String last_name,
			String email, String contact_no, String address, Date dob, int class_id) {
		super();
	
		this.user_id = user_id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.contact_no = contact_no;
		this.address = address;
		this.dob = dob;
		this.class_id = class_id;
	}














	/**
	 * @return the s_id
	 */
	public int getS_id() {
		return s_id;
	}







	/**
	 * @param s_id the s_id to set
	 */
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}













	/**
	 * @return the user_id
	 */
	public LoginEntity getUser_id() {
		return user_id;
	}






	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(LoginEntity user_id) {
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
