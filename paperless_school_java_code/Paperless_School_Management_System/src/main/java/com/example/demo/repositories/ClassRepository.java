package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.ClassEntity;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {

	@Modifying
	@Transactional
	@Query(value="Update class_master c set  c.t_id=?1 where c.class_id = ?2",nativeQuery = true)
	public int assignClass(int t_id, int class_id);
}
