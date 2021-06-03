package com.example.demo.entities;

public class Chapter {
	int chapter_id;
	String chapter_name;
	String content;
	int subject_id;
	
	
	
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Chapter(int chapter_id, String chapter_name, String content, int subject_id) {
		super();
		this.chapter_id = chapter_id;
		this.chapter_name = chapter_name;
		this.content = content;
		this.subject_id = subject_id;
	}



	public int getChapter_id() {
		return chapter_id;
	}



	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}



	public String getChapter_name() {
		return chapter_name;
	}



	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getSubject_id() {
		return subject_id;
	}



	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	
	
	
	

}
