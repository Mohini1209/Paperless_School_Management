package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ChapterEntity;
import com.example.demo.entities.ClassEntity;
import com.example.demo.entities.QueryEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.Subject;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.services.ChapterService;
import com.example.demo.services.SubjectService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ChapterController {
	@Autowired
	ChapterService chapservice;
	
	@Autowired
	SubjectService subservice;
	@GetMapping("/selectchapter")
	public List<ChapterEntity> selectChapter(@RequestParam int user_id,@RequestParam int subject_id)
	{
		return chapservice.selectChapter(user_id, subject_id);
	}
	
	@PostMapping("/updatecontent")
	public int updateContent(@RequestBody Subject sub)
	{
		SubjectEntity se  = subservice.getOne(sub.getSubject_id());
		//ChapterEntity ch = new ChapterEntity(sub.getContent(),se,sub.getChapter_id());
		//Subject ch = new Subject(sub.getContent(),sub.getSubject_id(),sub.getChapter_id());
		return chapservice.updateContent(sub.getContent(),se,sub.getChapter_id());
	}
	
	@GetMapping("/selectchapterstud")
	public List<ChapterEntity> selectChapterstud(@RequestParam int user_id,@RequestParam int subject_id)
	{
		return chapservice.selectChapterstud(user_id, subject_id);
	}
	
	@PostMapping("/showcontent")
	public ChapterEntity showcontent(@RequestParam("subjectid") int subject_id, @RequestParam("chapterid") int chapter_id)
	{
		return chapservice.showcontent(subject_id, chapter_id);
	}
}
