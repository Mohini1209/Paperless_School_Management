package com.example.demo.entities;

public class SubjectMarks {
	
	int out_of_marks;
	int obtain_marks;
	int subject_id;
	int progress_id;
	public SubjectMarks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubjectMarks(int out_of_marks, int obtain_marks, int subject_id, int progress_id) {
		super();
		this.out_of_marks = out_of_marks;
		this.obtain_marks = obtain_marks;
		this.subject_id = subject_id;
		this.progress_id = progress_id;
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
	 * @return the progress_id
	 */
	public int getProgress_id() {
		return progress_id;
	}
	/**
	 * @param progress_id the progress_id to set
	 */
	public void setProgress_id(int progress_id) {
		this.progress_id = progress_id;
	}
	
	

}
