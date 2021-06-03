package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.MarksEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.SubjectMarks;


@Repository
public interface MarksRepository extends JpaRepository<MarksEntity, Integer> {

	@Query(value = "select * from marks_master m where m.progress_id = (select p.progress_id from progress_master p where p.s_id = (select s.s_id from student_master s where s.user_id = ?1 ))" , nativeQuery = true )
	public List<MarksEntity> getMarks(LoginEntity user_id);
	
	@Query("select m from MarksEntity m where m.progress_id = (select p.progress_id from ProgressEntity p where p.s_id = ?1)")
	public List<MarksEntity> getMarks1(StudentEntity s);
	
	@Query(value = "Select  m.out_of_marks, m.obtain_marks, s.subject_name, m.progress_id, p.s_id, p.comment from marks_master m JOIN progress_master p ON(m.progress_id = p.progress_id) JOIN subject_master s ON(m.subject_id = s.subject_id) where p.s_id = (select st.s_id from student_master st where st.user_id = ?1)",nativeQuery = true)
	public List<MarksEntity> stumarks(LoginEntity user_id);
	

	@Transactional
	@Modifying
	@Query(value="insert into marks_master (out_of_marks,obtain_marks,subject_id,progress_id)values(?1,?2,?3,?4)",nativeQuery= true)
	public int insertmarks(int out_of_marks,int obtain_marks,int subject_id,int progress_id);
}
