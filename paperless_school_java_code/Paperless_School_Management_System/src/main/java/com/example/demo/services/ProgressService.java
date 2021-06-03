package com.example.demo.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ProgressEntity;
import com.example.demo.repositories.ProgressRepository;

@Service
public class ProgressService {

	@Autowired
	ProgressRepository progrepo;
	
	public ProgressEntity getComment(int user_id)
	{
		return progrepo.getComment(user_id);
	}
	public ProgressEntity getOne(int progress_id)
	{
		Optional <ProgressEntity> ps = progrepo.findById(progress_id);
		ProgressEntity p = null;
		try
		{
			p = ps.get();
		}
		catch(NoSuchElementException e)
		{
			p = null;
		}
		return p;
	}
}
