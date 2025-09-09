package com.kh.jdbc.model.vo;

import java.sql.Date;

public class AttendanceLog {
	private int logId;
	private String userId;
	private String category;
	private String reason;
	private Date logDate;
	private String name; 
	
	public AttendanceLog() { 
		super(); 
		}

	public AttendanceLog(String userId, String category, String reason) {
		super();
		this.userId = userId;
		this.category = category;
		this.reason = reason;
	}

	public int getLogId() { 
		return logId; 
		}
	
	public void setLogId(int logId) {
		this.logId = logId; 
	}
	
	public String getUserId() {
		return userId; 
	}
	
	public void setUserId(String userId) {
			this.userId = userId; 
		}
	
	public String getCategory() {
			return category; 
		}
	
	public void setCategory(String category) {
			this.category = category; 
		}
	
	public String getReason() {
			return reason; 
		}
	
	public void setReason(String reason) {
			this.reason = reason; 
		}
	
	public Date getLogDate() {
			return logDate; 
		}
	
	public void setLogDate(Date logDate) {
			this.logDate = logDate; 
		}
	
	public String getName() {
			return name; 
		}
	
	public void setName(String name) {
		this.name = name; 
		}

	@Override
	public String toString() {
		return "이름=" + (name != null ? name : userId) + ", 카테고리=" + category + ", 사유=" + reason + ", 일자=" + logDate;
	}
}
