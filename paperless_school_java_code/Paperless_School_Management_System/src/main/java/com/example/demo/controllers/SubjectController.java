package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ClassEntity;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.entities.TeacherEntity;
import com.example.demo.services.SubjectService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SubjectController {

	@Autowired
	SubjectService subservice;
	
	@PostMapping("/selectsubject")
	public List<SubjectEntity> selectSubject(@RequestParam("user_id") int t_id)
	{
		return subservice.selectSubject(t_id);
	}
	
	@GetMapping("/allsubjects")
	public List<SubjectEntity> allsubjects()
	{
		return subservice.allsubjects();
	}
	
	@GetMapping("/getonesub")
	public SubjectEntity getOneSub(int subject_id) {
		return subservice.getOne(subject_id);
	}
	@GetMapping("/selectsubjectstud")
	public List<SubjectEntity> selectSubjectstud(@RequestParam("user_id") int user_id)
	{
		return subservice.selectSubjectstud(user_id);
	}
}
