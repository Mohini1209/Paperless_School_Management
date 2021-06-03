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
import com.example.demo.entities.Query;
import com.example.demo.entities.QueryEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.services.QueryService;
import com.example.demo.services.StudentService;
import com.example.demo.services.SubjectService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class QueryController {
	
	@Autowired
	QueryService queryservice;
	@Autowired
	SubjectService subservice;
	@Autowired
	StudentService stuservice;
	
	@GetMapping("/selectsub")
	public List<SubjectEntity> selectSubject(@RequestParam("user_id") LoginEntity user_id)
	{
		return queryservice.selectSubject(user_id);
	}
	
	@GetMapping("/studentquery")
	public List<QueryEntity> studentQuery(@RequestParam("user_id") LoginEntity user_id)
	{
		return queryservice.studentQuery(user_id);
	}
	
	@PostMapping("/insertquery")
	public QueryEntity insertQuery(@RequestBody Query q)
	{
		SubjectEntity s = subservice.getOne(q.getSubject_id());
		StudentEntity st = stuservice.getOne(q.getStudent_id());
		QueryEntity qe = new QueryEntity(q.getQtext(),null,s,st);
		return queryservice.insertQuery(qe);
	}
	
	@GetMapping("/allqueries")
	public List<QueryEntity> allQueries(@RequestParam int subject_id, @RequestParam LoginEntity user_id)
	{
		return queryservice.allQueries(subject_id, user_id);
	}
	@PostMapping("/answerQuery")
	public int answerQuery(@RequestBody List<Query> answerquery)
	{
		List<Integer> listofupdatedanswers =new ArrayList<Integer>();
		for(Query ansq: answerquery)
		{
			SubjectEntity lsub = subservice.getOne(ansq.getSubject_id());
			StudentEntity lstud = stuservice.getOne(ansq.getStudent_id());	
			int listupdated = queryservice.answerQuery(ansq.getQtext(),ansq.getQanswer(),lsub,lstud);
			listofupdatedanswers.add(listupdated);
		}
		return Collections.frequency(listofupdatedanswers, 1);
		
		//QueryEntity ansqe =new QueryEntity(ansq.getQtext(),ansq.getQanswer(),s,st);
		//return queryservice.answerQuery(ansqe);
	}
	
	@PostMapping("/fetchquery")
	public List<QueryEntity> fetchQuery(@RequestParam("subject_id") int subject_id,@RequestParam("s_id") int s_id)
	{
		return queryservice.fetchQuery(subject_id, s_id);
	}
	
}
