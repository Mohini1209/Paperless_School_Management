package com.example.demo.entities;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="subject_master")
public class SubjectEntity {

	@Id
	int subject_id;
	@Column
	String subject_name;
	
	@ManyToOne
	//@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="class_id")
	ClassEntity class_id;
	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubjectEntity(int subject_id, String subjectName, ClassEntity class_id) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subjectName;
		this.class_id = class_id;
	}
	/**
	 * @return the subject_id
	 */
	public int getSubject_id() {
		return subject_id;
	}
	/**
	 * @param subject_id the subject_id to set
	 */
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	
	/**
	 * @return the subject_name
	 */
	public String getSubject_name() {
		return subject_name;
	}
	/**
	 * @param subject_name the subject_name to set
	 */
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	/**
	 * @return the class_id
	 */
	public ClassEntity getClass_id() {
		return class_id;
	}
	/**
	 * @param class_id the class_id to set
	 */
	public void setClass_id(ClassEntity class_id) {
		this.class_id = class_id;
	}
	
	
	
	
}
