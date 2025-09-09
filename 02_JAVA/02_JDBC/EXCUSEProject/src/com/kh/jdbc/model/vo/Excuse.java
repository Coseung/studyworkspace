package com.kh.jdbc.model.vo;

import java.time.LocalDateTime;


public class Excuse {
	
	private int excuse_id;
	private String category;
	private String content;
	
	
	public Excuse() {
		super();
	}


	public Excuse(String category, String content) {
		super();
		
		this.category = category;
		this.content = content;
	}


	public int getExcuseId() {
		return excuse_id;
	}



	public void setExcuseId(int excus_id) {
		this.excuse_id = excus_id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "아이디=" + excuse_id + ", 카테고리=" + category + ", 내용=" + content;
	}

	
}
