package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Attendance;
import com.example.demo.entities.AttendanceEntity;
import com.example.demo.entities.LoginEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.TeacherEntity;
import com.example.demo.services.AttendanceService;
import com.example.demo.services.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AttendanceController {
	@Autowired
	AttendanceService attservice;

	@Autowired
	StudentService sservice;
	/*@GetMapping("/attendance")
	public List<Object[]> checkAttendance(@RequestParam(defaultValue = "2021001") int student_id,@RequestParam("month") int month)
	{
		System.out.println("request received");
		return attservice.checkAttendance( student_id,month);
	}*/
	
	@PostMapping("/attendance")
	public int checkAt(@RequestParam("user_id") int user_id, @RequestParam("month") int month)
	{
		return attservice.checkAt(user_id, month);
	}
	
	@PostMapping("/remark")
	public int checkRemark(@RequestParam("user_id") int user_id, @RequestParam("month") int month)
	{
		return attservice.checkRemark(user_id, month);
	}
	
	/*@PostMapping("/selectstudent")
	public List<StudentEntity> selectList(@RequestParam("user_id") int user_id)
	{
		return attservice.selectList(user_id);
	}*/
	
	@GetMapping("/studlist")
	public List<StudentEntity> studList(@RequestParam("user_id") LoginEntity user_id)
	{
		return attservice.studList(user_id);
	}
	@PostMapping("/insertAttendance")
	public int updateContent(@RequestBody  List<Attendance> att)
	{
		List<Integer> lintCountofInsertedRecords= new ArrayList<Integer>();
		for (Attendance attendance : att)
		{
			StudentEntity lStudentEntity = sservice.getOne(attendance.getS_id());
			AttendanceEntity lAttendanceEntity = new AttendanceEntity(attendance.getDate(),attendance.getRemark(),lStudentEntity);
			int lisUploaded = attservice.insertAttendance(lAttendanceEntity,lStudentEntity.getS_id());
			lintCountofInsertedRecords.add(lisUploaded);
		}
		 return Collections.frequency(lintCountofInsertedRecords, 1);
		
	}
	
}
