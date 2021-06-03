package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="marks_master")
public class MarksEntity {
	@Id
	//@Column(name = "mark_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int mark_id;
	@Column
	int out_of_marks;
	@Column
	int obtain_marks;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	SubjectEntity subject_id;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "progress_id")
	ProgressEntity progress_id;


	public MarksEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MarksEntity( int outOfMarks, int obtainMarks, SubjectEntity subject_id,
			ProgressEntity progress_id) {
		super();
		
		this.out_of_marks = outOfMarks;
		this.obtain_marks = obtainMarks;
		this.subject_id = subject_id;
		this.progress_id = progress_id;
	}


	public int getMark_id() {
		return mark_id;
	}


	public void setMark_id(int mark_id) {
		this.mark_id = mark_id;
	}


	public SubjectEntity getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(SubjectEntity subject_id) {
		this.subject_id = subject_id;
	}


	/**
	 * @return the out_of_marks
	 */
	public int getOut_of_marks() {
		return out_of_marks;
	}


	/**
	 * @param out_of_marks the out_of_marks to set
	 */
	public void setOut_of_marks(int out_of_marks) {
		this.out_of_marks = out_of_marks;
	}


	/**
	 * @return the obtain_marks
	 */
	public int getObtain_marks() {
		return obtain_marks;
	}


	/**
	 * @param obtain_marks the obtain_marks to set
	 */
	public void setObtain_marks(int obtain_marks) {
		this.obtain_marks = obtain_marks;
	}


	public ProgressEntity getProgress_id() {
		return progress_id;
	}


	public void setProgress_id(ProgressEntity progress_id) {
		this.progress_id = progress_id;
	}


	

	

}
