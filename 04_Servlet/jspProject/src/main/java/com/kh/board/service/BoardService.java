package com.kh.board.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
public class BoardService {
	
	public ArrayList<Board> selectList(){
		Connection conn = getConnection();

		
		ArrayList<Board> list = new BoardDao().selectList(conn);
		close(conn);
		
		
		return list;
		
	}

	public ArrayList<Category> selectCategoryList() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();

		ArrayList<Category> list = new BoardDao().selectCategoryList(conn);
		close(conn);

		return list;

	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();

		int result = new BoardDao().insertBoard(b, conn);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

}
