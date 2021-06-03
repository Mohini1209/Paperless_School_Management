package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ClassEntity;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.entities.TeacherEntity;
import com.example.demo.repositories.SubjectRepository;


@Service
public class SubjectService {

	@Autowired
	SubjectRepository subrepo;
	
	public List<SubjectEntity> selectSubject(int t_id)
	{
		return subrepo.selectSubject(t_id);
	}
	
	public List<SubjectEntity> allsubjects()
	{
		return subrepo.findAll();
	}
	
	public SubjectEntity getOne(int subject_id)
	{
		Optional <SubjectEntity> os = subrepo.findById(subject_id);
		SubjectEntity s = null;
		try
		{
			s = os.get();
		}
		catch(NoSuchElementException e)
		{
			s = null;
		}
		return s;
	}
	
	public List<SubjectEntity> selectSubjectstud(int user_id)
	{
		return subrepo.selectSubjectstud(user_id);
	}
}
