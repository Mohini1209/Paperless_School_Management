package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChapterEntity;
import com.example.demo.entities.ClassEntity;
import com.example.demo.entities.Subject;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.repositories.AttendanceRepository;
import com.example.demo.repositories.ChapterRepository;

@Service
public class ChapterService {
	@Autowired
	ChapterRepository chaprepo;

	public List<ChapterEntity> selectChapter(int user_id, int subject_id)
	{
		return chaprepo.selectChapter(user_id, subject_id);
	}
	
	public int updateContent(String content, SubjectEntity subject_id, int chapter_id)
	{
		return chaprepo.updateContent(content, subject_id, chapter_id);
	}
	
	public List<ChapterEntity> selectChapterstud(int user_id, int subject_id)
	{
		return chaprepo.selectChapterstud(user_id, subject_id);
	}
	public ChapterEntity showcontent(int subject_id, int chapter_id)
	{
		return chaprepo.showcontent(subject_id, chapter_id);
	}
	
}
