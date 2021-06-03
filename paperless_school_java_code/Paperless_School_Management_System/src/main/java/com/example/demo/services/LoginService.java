package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository lrepo;
	
	public String checkLogin(int user_id, String password)
	{
		return lrepo.checkLogin(user_id,password);
	}
	public List<LoginEntity> getAll()
	{
		return lrepo.findAll();
	}
	public LoginEntity getOne(int user_id)
	{
		Optional <LoginEntity> ol = lrepo.findById(user_id);
		LoginEntity l = null;
		try {
			l = ol.get();
		}
		catch(NoSuchElementException e){
			l = null;
			
		}
		return l;
	}
	public LoginEntity save(LoginEntity l)
	{
		return lrepo.save(l);
		
		
	}
	/*public StudentEntity getStudentByUserId(int user_id)
	{
		return lrepo.getByUserId(user_id);
	}*/
	
	public LoginEntity getStudentByUserId(int user_id)
	{
		return lrepo.getByUserId(user_id);
	}
	

	public LoginEntity getTeacherByUserId(int user_id)
	{
		return lrepo.getByUserId(user_id);
	}
	
}
