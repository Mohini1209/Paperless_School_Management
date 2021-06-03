package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.TeacherEntity;
import com.example.demo.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository trepo;
	public List<TeacherEntity> getAllTeachers()
	{
		return trepo.findAll();
	}
	public TeacherEntity getTeacherByUserId(int user_id)
	{
		return trepo.getByUserId(user_id);
	}
	public  TeacherEntity insertTeacher(TeacherEntity teacher)
	{
		 return trepo.save(teacher);
	}
	public List<TeacherEntity> allTeacherData()
	{
		return trepo.allTeacherData();
	}
}
