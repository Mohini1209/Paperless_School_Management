package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="class_master")
@PrimaryKeyJoinColumn(name="user_id")
public class ClassEntity {
	@Id
	int class_id;
	@Column
	String standard;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "t_id")
	TeacherEntity t_id;

	public ClassEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassEntity(int class_id, String standard, TeacherEntity teacher_id) {
		super();
		this.class_id = class_id;
		this.standard = standard;
		this.t_id = teacher_id;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * @return the t_id
	 */
	public TeacherEntity getT_id() {
		return t_id;
	}

	/**
	 * @param t_id the t_id to set
	 */
	public void setT_id(TeacherEntity t_id) {
		this.t_id = t_id;
	}

	
	
	
}
