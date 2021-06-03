package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="progress_master")
public class ProgressEntity {
	@Id
	int progress_id;
	@Column
	String comment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "s_id")
	StudentEntity s_id;
	//int s_id;

	public ProgressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgressEntity(int progress_id, String comment, StudentEntity student_id) {
		super();
		this.progress_id = progress_id;
		this.comment = comment;
		this.s_id = student_id;
	}

	public int getProgress_id() {
		return progress_id;
	}

	public void setProgress_id(int progress_id) {
		this.progress_id = progress_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the student_id
	 */
	public StudentEntity getS_id() {
		return s_id;
	}

	/**
	 * @param student_id the student_id to set
	 */
	public void setS_id(StudentEntity student_id) {
		this.s_id = student_id;
	}

/*	public StudentEntity getStudent_id() {
		return student_id;
	}

	public void setStudent_id(StudentEntity student_id) {
		this.student_id = student_id;
	}

	*/
	
	

}
