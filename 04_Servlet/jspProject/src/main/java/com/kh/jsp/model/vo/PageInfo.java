package com.kh.jsp.model.vo;

public class PageInfo {

	private int currentPage = 1;
	private int listCount;
	private int pageLimit = 5;
	private int boardLimit = 5;

	private int maxPage;
	private int startPage;
	private int endPage;


	public PageInfo(int currentPage, int listCount, int pageLimit, int boardLimit) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		this.maxPage = (int) Math.ceil((double) this.listCount / this.boardLimit);
	}

}
