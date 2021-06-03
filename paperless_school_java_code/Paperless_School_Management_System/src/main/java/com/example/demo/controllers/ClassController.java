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
import com.example.demo.services.ClassService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ClassController {

	@Autowired
	ClassService classservice;
	
	@GetMapping("/allclasses")
	public List<ClassEntity> getClasses()
	{
		return classservice.allClasses();
	}
	
	@PostMapping("/assignclass")
	public int assignClass(@RequestParam("t_id") int t_id,@RequestParam("class_id") int class_id)
	{
		return classservice.assignClass(t_id,class_id);
	}
}
