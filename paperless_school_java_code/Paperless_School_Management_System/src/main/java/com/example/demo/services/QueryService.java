package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.Query;
import com.example.demo.entities.QueryEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.repositories.QueryRepository;

@Service
public class QueryService {
	@Autowired
	QueryRepository queryrepo;
	
	public List<SubjectEntity> selectSubject(LoginEntity user_id)
	{
		return queryrepo.selectSubject(user_id);
	}
	
	public List<QueryEntity> studentQuery(LoginEntity user_id)
	{
		return queryrepo.studentQuery(user_id);
	}
	
	public QueryEntity insertQuery(QueryEntity qe)
	{
		return queryrepo.save(qe);
	}
	public List<QueryEntity> allQueries(int subject_id, LoginEntity user_id)
	{
		return queryrepo.allQueries(subject_id, user_id);
	}
	public int answerQuery(String question,String answer,SubjectEntity sub,StudentEntity stud)
	{
		return queryrepo.answerQuery(question,sub.getSubject_id(),stud.getS_id(),answer);
	}
	
	public List<QueryEntity>fetchQuery(int subject_id,int s_id)
	{
		return queryrepo.fetchQuery(subject_id, s_id);
	}
}
