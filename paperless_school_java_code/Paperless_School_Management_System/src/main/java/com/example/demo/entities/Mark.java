package com.example.demo.entities;

public class Mark {
	
	int out_of_marks;
	int obtain_marks;
	int subject_id;
	int progress_id;
	
	
	public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mark(int out_of_marks, int obtain_marks, int subject_id, int progress_id) {
		super();
		this.out_of_marks = out_of_marks;
		this.obtain_marks = obtain_marks;
		this.subject_id = subject_id;
		this.progress_id = progress_id;
	}
	
	public int getOut_of_marks() {
		return out_of_marks;
	}
	
	public void setOut_of_marks(int out_of_marks) {
		this.out_of_marks = out_of_marks;
	}
	
	public int getObtain_marks() {
		return obtain_marks;
	}
	
	public void setObtain_marks(int obtain_marks) {
		this.obtain_marks = obtain_marks;
	}
	
	public int getSubject_id() {
		return subject_id;
	}
	
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	
	public int getProgress_id() {
		return progress_id;
	}
	
	public void setProgress_id(int progress_id) {
		this.progress_id = progress_id;
	}
	

	
}
