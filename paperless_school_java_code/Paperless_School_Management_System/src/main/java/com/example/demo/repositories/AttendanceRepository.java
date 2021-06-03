package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AttendanceEntity;
import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.TeacherEntity;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Integer> {

	/*@Query(value = "SELECT date, remark from attendance_master where student_id = ?1 and month(date)= ?2",nativeQuery = true )
	public List<Object[]> checkAttendance(int student_id, int month);*/
	
	@Query(value = "SELECT count(date) from attendance_master where s_id = (select s.s_id from student_master s where s.user_id = ?1) and month(date)= ?2",nativeQuery = true )
	public int checkAttendance(int user_id, int month);
	
	@Query(value = "SELECT count(date) from attendance_master where (s_id = (select s.s_id from student_master s where s.user_id = ?1) and month(date)= ?2) and remark = 'P' ",nativeQuery = true )
	public int checkRemark(int user_id, int month);
	
	/*@Query(value="select * from student_master s where s.class_id = (select c.class_id from class_master c where c.t_id = (select t.t_id from teacher_master t where t.user_id = ?1) )",nativeQuery = true)
	public List<StudentEntity> selectList(int user_id);*/
	
	/*@Query(value = "select * from student_master s where s.class_id = (select c.class_id from class_master c where c.t_id = (select t.t_id from teacher_master t where t.user_id = ?1)) ",nativeQuery = true)
	public List<StudentEntity> studList(LoginEntity user_id);*/
	
	@Query( "select s from StudentEntity s where s.class_id = (select c.class_id from ClassEntity c where c.t_id = (select t.t_id from TeacherEntity t where t.user_id = ?1)) ")
	public List<StudentEntity> studList(LoginEntity user_id);
	
	
	
	@Transactional
	@Modifying
	@Query(value="insert into attendance_master (date,remark,s_id)values(?1,?2,?3)",nativeQuery=true)
	public int insertAttendance(Date date,String remark,int s_id);
	
	@Query(value="select a.date,a.remark from attendance_master a where a.s_id=(select s.s_id from student_master s where s.user_id =?1) and month(a.date)=?2",nativeQuery=true)
	public List<AttendanceEntity> viewAttendance(LoginEntity user_id,int month);

}
