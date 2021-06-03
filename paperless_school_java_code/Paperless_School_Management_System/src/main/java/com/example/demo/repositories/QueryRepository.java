package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.QueryEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.SubjectEntity;

@Repository
public interface QueryRepository extends JpaRepository<QueryEntity, Integer> {

	@Query("select s from SubjectEntity s where s.class_id = (select st.class_id from StudentEntity st where st.s_id = (select stu.s_id from StudentEntity stu where stu.user_id = ?1))")
	public List<SubjectEntity> selectSubject(LoginEntity user_id);
	
	
	//@Query(value = "select * from paperless_school.subject_master s where s.class_id = (select st.class_id from student_master st where st.user_id = ?1  )",nativeQuery = true)
	//public List<SubjectEntity> selectSubject(int user_id);
	
	@Query("select q from QueryEntity q where q.s_id = (select s.s_id  from StudentEntity s where s.user_id= ?1)")
	public List<QueryEntity> studentQuery(LoginEntity user_id);
	
	@Query(value = "select * from query_master q where q.subject_id = ?1 and q.s_id IN (select s.s_id from student_master s where s.class_id = (select c.class_id from class_master c where c.t_id = (select t.t_id from teacher_master t where t.user_id = ?2)));",nativeQuery = true)
	public List<QueryEntity> allQueries(int subject_id, LoginEntity user_id);
	
	@Modifying
	@Transactional
	@Query(value="update query_master q set q.answer=?4 where q.question=?1 and q.subject_id=?2 and s_id=?3",nativeQuery=true)
	public int answerQuery(String qtext,int subject_id,int s_id,String answer);
	
	@Query(value="select * from query_master q where q.subject_id=?1 and q.s_id=?2",nativeQuery=true)
	public List<QueryEntity> fetchQuery(int subject_id,int s_id);

}
