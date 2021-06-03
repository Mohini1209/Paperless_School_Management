package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MarksEntity;
import com.example.demo.entities.ProgressEntity;

@Repository
public interface ProgressRepository extends JpaRepository<ProgressEntity, Integer> {

	@Query(value = "select * from progress_master p where p.s_id =  (select s.s_id from student_master s where s.user_id = ?1 )" , nativeQuery = true )
	public ProgressEntity getComment(int user_id);
}
