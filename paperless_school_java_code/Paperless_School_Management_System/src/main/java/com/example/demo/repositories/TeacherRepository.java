package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.TeacherEntity;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

	/*@Query("select t.t_id, t.first_name from TeacherEntity t")
	public List<TeacherEntity> allTeachers();*/
	
	@Query("select t from TeacherEntity t where t.user_id = ?1")
	public TeacherEntity getByUserId(int user_id);
	
	@Query("select new TeacherEntity(t.t_id,t.first_name,t.last_name,t.email,t.contact_no,t.qualification,t.address) from TeacherEntity t")
	public List<TeacherEntity> allTeacherData();
}
