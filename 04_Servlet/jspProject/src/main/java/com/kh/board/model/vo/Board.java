package com.kh.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {


	private int boardNo;
	private int boardType;
	private String category;
	private int categoryNo;
	private String boardTitle;
	private String boardContent;
	private int memberId;
	private String boardWriter;
	private int count;
	private String createDate;
	private String status;
	private String titleImg;
	
	public Board(int boardNo, String category, String boardTitle, String boardWriter, int count, String createDate) {
		this.boardNo = boardNo;
		this.category = category;
		this.boardTitle = boardTitle;
		this.count = count;
		this.boardWriter = boardWriter;
		this.createDate = createDate;

	}

	public static Board insertCreateBoard(int boardType, int categoryNo, String title, String content,
			int memberId) {

		Board b = new Board();
		b.setBoardType(boardType);
		b.setCategoryNo(categoryNo);
		b.setBoardTitle(title);
		b.setBoardContent(content);
		b.setMemberId(memberId);
		return b;
	}

	public static Board updateBoard(int boardNo, int boardType, int categoryNo, String title, String content) {

		Board b = new Board();
		b.setBoardNo(boardNo);
		b.setBoardType(boardType);
		b.setCategoryNo(categoryNo);
		b.setBoardTitle(title);
		b.setBoardContent(content);
		return b;
	}

	public Board(int boardNo, String category, String boardTitle, String boardContent, String boardWriter,
			String createDate) {
		this.boardNo = boardNo;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
	}
	
}
