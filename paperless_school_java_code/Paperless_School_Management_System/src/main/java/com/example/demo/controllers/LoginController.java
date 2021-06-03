package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.services.LoginService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {

	@Autowired
	LoginService loginservice;
	
	@GetMapping("/checkLogin")
	public String checkLogin(@RequestParam("user_id") int userid, @RequestParam("password") String password)
	{
		return loginservice.checkLogin(userid,password);
	}
	
	@GetMapping("/alllogin")
	public List<LoginEntity> getAll(){
		return loginservice.getAll();
	}
	/*@PostMapping("/studentById")
	public StudentEntity getStudentById(@RequestParam("user_id") int user_id)
	{
		return loginservice.getStudentByUserId(user_id);
	}*/
	
	@PostMapping("/studentByUserId")
	public LoginEntity getStudentById(@RequestParam("user_id") int user_id)
	{
		return loginservice.getStudentByUserId(user_id);
	}
	
	
	@PostMapping("/teacherById")
	public LoginEntity getTeacherById(@RequestParam("user_id") int user_id)
	{
		return loginservice.getTeacherByUserId(user_id);
	}
}
