package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.Mark;
import com.example.demo.entities.MarksEntity;
import com.example.demo.entities.ProgressEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.services.MarksService;
import com.example.demo.services.ProgressService;
import com.example.demo.services.StudentService;
import com.example.demo.services.SubjectService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MarksController {
	@Autowired
	MarksService marksservice;
	
	@Autowired
	StudentService sservice;
	
	@Autowired
	SubjectService subservice;
	
	@Autowired
	ProgressService progservice;

	@GetMapping("/getmarks")
	public List<MarksEntity> getMarks(LoginEntity user_id)
	{
		StudentEntity se = sservice.getStudentById(user_id);
		return marksservice.getMarks(user_id);
	}
	
	@GetMapping("/getstudmarks")
	public List<MarksEntity> getMarks1(@RequestParam("s_id") StudentEntity s)
	{
		return marksservice.getMarks1(s);
	}
	
	@GetMapping("/stumarks")
	public List<MarksEntity> stumarks(@RequestParam int sid)
	{
		StudentEntity st = sservice.getOne(sid);
		return marksservice.getMarks1(st);
	}
	@PostMapping("/insertMarks")
	public int insertMarks(@RequestBody  List<Mark> mark)
	{
		List<Integer> listofupdaeMarks =new ArrayList<Integer>();
		for(Mark m: mark)
		{
			SubjectEntity lsub = subservice.getOne(m.getSubject_id());
			ProgressEntity lprogress = progservice.getOne(m.getProgress_id());	
			int listupdated = marksservice.insertmarks(m.getOut_of_marks(),m.getObtain_marks(),lsub,lprogress);
			listofupdaeMarks.add(listupdated);
		}
		return Collections.frequency(listofupdaeMarks, 1);
		
	}
}
