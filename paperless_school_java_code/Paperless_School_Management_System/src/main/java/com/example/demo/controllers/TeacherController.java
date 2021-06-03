package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.TeacherEntity;
import com.example.demo.entities.TeacherLogin;
import com.example.demo.services.LoginService;
import com.example.demo.services.TeacherService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TeacherController {

	@Autowired
	LoginService lservice;
	@Autowired
	TeacherService tservice;
	@GetMapping("/allteachers")
	public List<TeacherEntity> getAllTeachers()
	{
		return tservice.getAllTeachers();
	}
	
	@PostMapping("/insertteacher")
	public TeacherEntity insertTeacher(@RequestBody TeacherLogin tl)
	{
		LoginEntity  log1 = new LoginEntity(tl.getUser_id(),tl.getPassword(), "Teacher");
		LoginEntity log2 = lservice.save(log1);
		
		TeacherEntity te = new TeacherEntity(tl.getFirst_name(),tl.getLast_name(),tl.getEmail(),tl.getContact_no(),tl.getQualification(),tl.getAddress(), log2);
		return tservice.insertTeacher(te);
		
		
	}
	
	@GetMapping("/allteacherdata")
	public List<TeacherEntity> allTeacherData()
	{
		return tservice.allTeacherData();
	}
}
