package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ClassEntity;
import com.example.demo.repositories.ClassRepository;

@Service
public class ClassService {
	@Autowired
	ClassRepository classrepo;

	public List<ClassEntity> allClasses()
	{
		return classrepo.findAll();
	}
	
	public int assignClass(int t_id,int class_id)
	{
		return classrepo.assignClass( t_id,class_id);
	}
	
}
