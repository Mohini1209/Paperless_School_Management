package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.TeacherEntity;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository srepo;
	
	public List<StudentEntity> getAllStudents()
	{
		return srepo.findAll();
	}
	public StudentEntity getStudentById(LoginEntity user_id)
	{
		return srepo.getByUserId(user_id);
		/*Optional<StudentEntity> stu = srepo.getByUserId(user_id);
		StudentEntity s = null;
		try
		{
			s = stu.get();
		}
		catch(NoSuchElementException e)
		{
			s=null;
		}
		return s;*/
	}
	
	public StudentEntity getStudentById1(LoginEntity user_id)
	{
		return srepo.getByUserId(user_id);
	}
	/*public StudentEntity getStudentByUserId(int user_id)
	{
		return srepo.getByUserId(user_id);
	}*/
	
	public  StudentEntity insertStudent(StudentEntity student)
	{
		 return srepo.save(student);
	}
	
	
	
	public StudentEntity getOne(int sid)
	{
		Optional<StudentEntity> stu = srepo.findById(sid);
		StudentEntity s = null;
		try
		{
			s = stu.get();
		}
		catch(NoSuchElementException e)
		{
			s=null;
		}
		return s;
	}
	/*
	public List<Student> getFromPune()
	{
		return srepo.getFromPune();
	}
	
	public List<Student> getByCities(String city)
	{
		return srepo.getByCities(city);
	}
	*/

}
