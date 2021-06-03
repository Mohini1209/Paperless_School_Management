package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	//JPQL - similar like HQL - makes use of class, properties
		/*@Query("select s from Student s where city = 'Pune'")
		public  List<student_>  getFromPune();
		
		@Query("select s from Student s where city = ?1")
		public List<Student> getByCities(String city);
		
		//SQL query
		/*@Query(value = "select sid from students where percent > 80 ", nativeQuery = true)
		public List<Student> getByPercent(); */

	@Query("select s from StudentEntity s where s.user_id = ?1")
	public StudentEntity getByUserId(LoginEntity user_id);
	
	
}
