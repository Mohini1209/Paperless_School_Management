package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ChapterEntity;
import com.example.demo.entities.ClassEntity;
import com.example.demo.entities.Subject;
import com.example.demo.entities.SubjectEntity;

@Repository
public interface ChapterRepository extends JpaRepository<ChapterEntity, Integer> {

	@Query(value = "SELECT * FROM paperless_school.chapter_master ch WHERE ch.subject_id IN (Select c.subject_id from paperless_school.subject_master c WHERE c.class_id = (select c.class_id from class_master c where c.t_id = (select t.t_id from teacher_master t where t.user_id = ?1)) and ch.subject_id = ?2) ",nativeQuery = true)
	public List<ChapterEntity> selectChapter(int user_id, int subject_id);
	
	@Modifying
	@Transactional
	@Query(value = "Update chapter_master c set c.content = ?1 where subject_id = ?2 and chapter_id = ?3 ",nativeQuery = true)
	public int updateContent(String content, SubjectEntity subject_id, int chapter_id);
	
	@Query(value = "select * from chapter_master ch where ch.subject_id IN (select c.subject_id from subject_master c where c.class_id = (select st.class_id from student_master st where st.user_id = ?1)) and ch.subject_id = ?2",nativeQuery = true)
	public List<ChapterEntity> selectChapterstud(int user_id, int subject_id);
	
	@Query(value = "select * from chapter_master ch where subject_id = ?1 and chapter_id = ?2",nativeQuery = true)
	public ChapterEntity showcontent(int subject_id, int chapter_id);
}
