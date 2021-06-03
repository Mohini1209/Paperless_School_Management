package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

	@Query("select l.user_type from LoginEntity l where user_id = ?1 and password =?2")
	public String checkLogin(int user_id, String password);
	
	@Query("select l from LoginEntity l where l.user_id = ?1")
	public LoginEntity getByUserId(int user_id);
	
}
