package com.example.demo.entities;

public class Subject {
	
	String content;
	int subject_id;
	int chapter_id;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(String content, int subject_id, int chapter_id) {
		super();
		this.content = content;
		this.subject_id = subject_id;
		this.chapter_id = chapter_id;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return the chapter_id
	 */
	public int getChapter_id() {
		return chapter_id;
	}
	/**
	 * @param chapter_id the chapter_id to set
	 */
	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}
	
	
}
