package com.example.demo.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attendance_master")
public class AttendanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int attendance_id;
	@Column
	Date date;
	@Column
	String remark;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "s_id")
	StudentEntity s_id;

	public AttendanceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendanceEntity( Date date, String remark, StudentEntity student_id) {
		super();
		this.date = date;
		this.remark = remark;
		this.s_id = student_id;
	}

	public int getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the s_id
	 */
	public StudentEntity getS_id() {
		return s_id;
	}

	/**
	 * @param s_id the s_id to set
	 */
	public void setS_id(StudentEntity s_id) {
		this.s_id = s_id;
	}

	
	
	
	

	

}
