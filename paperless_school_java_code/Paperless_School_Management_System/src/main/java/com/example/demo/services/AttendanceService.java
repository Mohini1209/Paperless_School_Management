package com.example.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Attendance;
import com.example.demo.entities.AttendanceEntity;
import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.TeacherEntity;
import com.example.demo.repositories.AttendanceRepository;

@Service
public class AttendanceService {
	@Autowired
	AttendanceRepository attrepo;

	/*public List<Object[]> checkAttendance(int student_id, int month)
	{
		return attrepo.checkAttendance(student_id, month);
	}*/
	
	public int checkAt(int user_id, int month)
	{
		return attrepo.checkAttendance(user_id, month);
	}
	
	public int checkRemark(int user_id, int month)
	{
		return attrepo.checkRemark(user_id, month);
	}
	
	/*public List<StudentEntity> selectList(int user_id)
	{
		return attrepo.selectList(user_id);
	}*/
	
	public List<StudentEntity> studList(LoginEntity user_id)
	{
		return attrepo.studList(user_id);
	}
	
	public int insertAttendance(AttendanceEntity at,int s_id)
	{
		return attrepo.insertAttendance(at.getDate(), at.getRemark(),s_id);
	}
	
	public List<AttendanceEntity> viewAttendance(LoginEntity user_id,int month)
	{
		return attrepo.viewAttendance(user_id, month);
	}
	
}
