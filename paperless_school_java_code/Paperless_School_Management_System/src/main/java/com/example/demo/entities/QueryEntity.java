package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="query_master")
public class QueryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int query_id;
	@Column
	String question;
	@Column
	String answer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="subject_id")
	SubjectEntity subject_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="s_id")
	StudentEntity s_id;
	public QueryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QueryEntity(int query_id, String question, String answer, SubjectEntity subject_id,
			StudentEntity student_id) {
		super();
		this.query_id = query_id;
		this.question = question;
		this.answer = answer;
		this.subject_id = subject_id;
		this.s_id = student_id;
	}
	
	
	
	public QueryEntity(String question, String answer, SubjectEntity subject_id, StudentEntity s_id) {
		super();
		this.question = question;
		this.answer = answer;
		this.subject_id = subject_id;
		this.s_id = s_id;
	}
	/**
	 * @return the query_id
	 */
	public int getQuery_id() {
		return query_id;
	}
	/**
	 * @param query_id the query_id to set
	 */
	public void setQuery_id(int query_id) {
		this.query_id = query_id;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * @return the subject_id
	 */
	public SubjectEntity getSubject_id() {
		return subject_id;
	}
	/**
	 * @param subject_id the subject_id to set
	 */
	public void setSubject_id(SubjectEntity subject_id) {
		this.subject_id = subject_id;
	}
	/**
	 * @return the student_id
	 */
	public StudentEntity getS_id() {
		return s_id;
	}
	public void setS_id(StudentEntity s_id) {
		this.s_id = s_id;
	}
	
	
}