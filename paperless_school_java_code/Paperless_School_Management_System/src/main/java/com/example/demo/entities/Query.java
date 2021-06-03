package com.example.demo.entities;

public class Query {
	
	String qtext;
	int subject_id;
	int student_id;
	String qanswer;
	public Query() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*public Query(String qtext, int subject_id, int student_id) {
		super();
		this.qtext = qtext;
		this.subject_id = subject_id;
		this.student_id = student_id;
	}
	*/
	
	public Query(String qtext, int subject_id, int student_id, String qanswer) {
		super();
		this.qtext = qtext;
		this.subject_id = subject_id;
		this.student_id = student_id;
		this.qanswer = qanswer;
	}
	/**
	 * @return the qtext
	 */
	public String getQtext() {
		return qtext;
	}
	/**
	 * @param qtext the qtext to set
	 */
	public void setQtext(String qtext) {
		this.qtext = qtext;
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
	 * @return the student_id
	 */
	public int getStudent_id() {
		return student_id;
	}
	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	/**
	 * @return the qanswer
	 */
	public String getQanswer() {
		return qanswer;
	}
	/**
	 * @param qanswer the qanswer to set
	 */
	public void setQanswer(String qanswer) {
		this.qanswer = qanswer;
	}
	
	
	
	
	
}
