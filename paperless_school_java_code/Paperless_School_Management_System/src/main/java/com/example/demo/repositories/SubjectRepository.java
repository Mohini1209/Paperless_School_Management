package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ClassEntity;
import com.example.demo.entities.SubjectEntity;
import com.example.demo.entities.TeacherEntity;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {

	@Query(value = "select * from paperless_school.subject_master s where s.class_id = (select c.class_id from class_master c where c.t_id = (select t.t_id from teacher_master t where t.user_id = ?1 )  )",nativeQuery = true)
	public List<SubjectEntity> selectSubject(int user_id);
	
	@Query(value = "select * from subject_master s where s.class_id = (select st.class_id from student_master st where st.user_id = ?1)",nativeQuery = true)
	public List<SubjectEntity> selectSubjectstud(int user_id);
}
