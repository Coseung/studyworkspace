package com.kh.jdbc.model.vo;

public class TardyCount {
	private String userId;
	private String name;
	private int tardyCount;
//지각 횟수
	public TardyCount() { super(); }
	public TardyCount(String userId, String name, int tardyCount) {
		super();
		this.userId = userId;
		this.name = name;
		this.tardyCount = tardyCount;
	}

	public String getUserId() {
		 return userId; 
	}
	public void setUserId(String userId) {
		 this.userId = userId; 
	}
	public String getName() {
		 return name; 
	}
	public void setName(String name) { 
		this.name = name; 
	}
	public int getTardyCount() { 
		return tardyCount; 
	}
	public void setTardyCount(int tardyCount) { 
		this.tardyCount = tardyCount; 
	}

	@Override
	public String toString() {
		return "이름=" + name + "(" + userId + "), 누적지각=" + tardyCount;
	}
}