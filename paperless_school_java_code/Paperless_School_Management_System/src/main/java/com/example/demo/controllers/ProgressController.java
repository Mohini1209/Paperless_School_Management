package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ProgressEntity;
import com.example.demo.services.ProgressService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProgressController {
	@Autowired
	ProgressService progservice;

	@GetMapping("/getcomment")
	public ProgressEntity getComment(@RequestParam("user_id") int user_id)
	{
		return progservice.getComment(user_id);
	}
	@GetMapping("/getoneprogress")
	public ProgressEntity getOneSub(int progress_id) {
		return progservice.getOne(progress_id);
	}
}
