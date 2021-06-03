package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.StudentLogin;
import com.example.demo.entities.TeacherEntity;
import com.example.demo.entities.TeacherLogin;
import com.example.demo.services.LoginService;
import com.example.demo.services.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {
	@Autowired
	StudentService sservice;
	@Autowired
	LoginService lservice;
	@GetMapping("/allstudents")
	public List<StudentEntity> getAllStudents()
	{
		return sservice.getAllStudents();
	}
	
	/*@PostMapping("/studentById")
	public StudentEntity getStudentById(@RequestParam("user_id") int user_id)
	{
		return sservice.getStudentById(user_id);
	}*/
	
	@PostMapping("/insertstudent")
	public StudentEntity insertStudent(@RequestBody StudentLogin sl)
	{
		LoginEntity  log1 = new LoginEntity(sl.getUser_id(),sl.getPassword(), "Student");
		LoginEntity log2 = lservice.save(log1);
		
		StudentEntity se= new StudentEntity(log2,sl.getFirst_name(),sl.getMiddle_name(),sl.getLast_name(),sl.getEmail(),sl.getContact_no(),sl.getAddress(),sl.getDob(),sl.getClass_id());
		return sservice.insertStudent(se);
		
		
	}
	/*@PostMapping("/studentbyid")
	public StudentEntity getStudentById1(@RequestParam("user_id") LoginEntity user_id)
	{
		return sservice.getStudentById1(user_id);
	}*/
	
	@GetMapping("/studentById")
	public StudentEntity studentById(@RequestParam int userid)
	{
		LoginEntity l = lservice.getOne(userid);
		return sservice.getStudentById(l);
	}
	@PostMapping("/studentbyid")
	public StudentEntity getStudentById1(@RequestParam("user_id") LoginEntity user_id)
	{
		return sservice.getStudentById1(user_id);
	}
	
	//http://localhost:8080/getone?sid=101
	//in front of url in the form of key-value pair
	@GetMapping("/getone")
	public StudentEntity getOne(@RequestParam("sid")int id)
	{
		return sservice.getOne(id);
	}
	
	/*
	//http://localhost:8080/getone?sid=101
	//in front of url in the form of key-value pair
	@GetMapping("/getone")
	public Student getOne(@RequestParam("sid")int id)
	{
		return sservice.getOne(id);
	}
	
	//http://localhost:8080/getstudent/101
	//info in not in the form key-value pair, is a part of URL
	@GetMapping("/getstudent/{sid}")
	public Student getStudent(@PathVariable("sid") int id)
	{
		return sservice.getOne(id);
	}
	
	@GetMapping("/getfrompune")
	public List<Student> getFromPune()
	{
		return sservice.getFromPune();
	}
	
	@GetMapping("/getbycity")
	public List<Student> getByCities(@RequestParam("city")String city)
	{
		return sservice.getByCities(city);
	}
	
	*/
	
}
