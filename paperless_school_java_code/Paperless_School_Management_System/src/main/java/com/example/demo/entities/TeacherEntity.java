package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="teacher_master")
@Inheritance(strategy=InheritanceType.JOINED)
public class TeacherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int t_id;
	@OneToOne
	@JoinColumn(name="user_id")
	LoginEntity user_id;
	@Column
	String first_name;
	@Column
	String last_name;
	@Column
	String email;
	@Column
	String contact_no;
	@Column
	String qualification;
	@Column
	String address;
	
	
	public TeacherEntity() {
		super();
	}

	

	public TeacherEntity(String first_name, String last_name, String email, String contact_no, String qualification,
			String address, LoginEntity user_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.contact_no = contact_no;
		this.qualification = qualification;
		this.address = address;
		this.user_id = user_id;
	}



	

	public TeacherEntity(int t_id, String first_name, String last_name, String email, String contact_no,
			String qualification, String address) {
		super();
		this.t_id = t_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.contact_no = contact_no;
		this.qualification = qualification;
		this.address = address;
	}



	/**
	 * @return the t_id
	 */
	public int getT_id() {
		return t_id;
	}



	/**
	 * @param t_id the t_id to set
	 */
	public void setT_id(int t_id) {
		this.t_id = t_id;
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
