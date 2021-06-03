package com.example.demo.entities;

import java.util.Date;

public class Attendance {

	Date date;
	String remark;
	int s_id;
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attendance(Date date, String remark, int s_id) {
		super();
		this.date = date;
		this.remark = remark;
		this.s_id = s_id;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the s_id
	 */
	public int getS_id() {
		return s_id;
	}
	/**
	 * @param s_id the s_id to set
	 */
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	
	
}
