package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.MarksEntity;
import com.example.demo.entities.ProgressEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.entities.SubjectMarks;
import com.example.demo.repositories.MarksRepository;

@Service
public class MarksService {
	@Autowired
	MarksRepository marksrepo;

	public List<MarksEntity> getMarks(LoginEntity user_id)
	{
		return marksrepo.getMarks(user_id);
	}
	
	public List<MarksEntity> getMarks1(StudentEntity  s)
	{
		return marksrepo.getMarks1(s);
		
}
	public int insertmarks(int out_of_marks,int obtain_marks,SubjectEntity sub,ProgressEntity prog)
	{
		return marksrepo.insertmarks(out_of_marks, obtain_marks,sub.getSubject_id(), prog.getProgress_id());
	}
}
