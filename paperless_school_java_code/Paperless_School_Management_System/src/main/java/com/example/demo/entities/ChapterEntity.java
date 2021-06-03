package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="chapter_master")
public class ChapterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int c_id;
	@Column
	int chapter_id;
	@Column
	String chapter_name;
	@Column
	String content;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	SubjectEntity subject_id;

	public ChapterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChapterEntity( int chapter_id, String chapterName, String content, SubjectEntity subject_id) {
		super();
		
		this.chapter_id = chapter_id;
		this.chapter_name = chapterName;
		this.content = content;
		this.subject_id = subject_id;
	}

	

	public ChapterEntity( String content, SubjectEntity subject_id,int chapter_id) {
		super();
		this.chapter_id = chapter_id;
		this.content = content;
		this.subject_id = subject_id;
	}

	public int getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}

	

	/**
	 * @return the chapter_name
	 */
	public String getChapter_name() {
		return chapter_name;
	}

	/**
	 * @param chapter_name the chapter_name to set
	 */
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public SubjectEntity getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(SubjectEntity subject_id) {
		this.subject_id = subject_id;
	}

	
}
