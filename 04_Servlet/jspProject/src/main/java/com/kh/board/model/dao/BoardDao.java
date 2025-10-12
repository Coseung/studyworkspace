package com.kh.board.model.dao;

import static com.kh.jsp.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.jsp.common.JDBCTemplate;

public class BoardDao {

private Properties prop = new Properties();
	
	public BoardDao() {
		super();
		
		String path = JDBCTemplate.class.getResource("/db/sql/board-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Board> selectList(Connection conn) {
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		


		String sql = prop.getProperty("selectList");


		try {

			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();


			while (rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setCategory(rset.getString("CATEGORY_NAME"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardWriter(rset.getString("MEMBER_ID"));
				b.setCount(rset.getInt("COUNT"));
				b.setCreateDate(rset.getString("CREATE_DATE"));
				list.add(b);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		System.out.println(list);
		return list;

	}

	public ArrayList<Category> selectCategoryList(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<Category> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectCategoryList");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Category c = new Category();
				c.setCategoryNo(rset.getInt("CATEGORY_NO"));
				c.setCategoryName(rset.getString("CATEGORY_NAME"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int insertBoard(Board b, Connection conn) {
		PreparedStatement pstmt = null;

		int result = 0;

		String sql = prop.getProperty("insertBoard");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBoardType());
			pstmt.setInt(2, b.getCategoryNo());
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardContent());
			pstmt.setInt(5, b.getMemberId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Board selectBoard(int boardDetailNo, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;

		String sql = prop.getProperty("selectBoard");

//		CATEGORY_NAME,
//        BOARD_TITLE,
//        BOARD_CONTENT,
//        MEMBER_ID,
//        TO_CHAR(CREATE_DATE, 'YYYY/MM/DD') AS "CREATE_DATE"

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDetailNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				b = new Board(boardDetailNo, rset.getString("CATEGORY_NAME"), rset.getString("BOARD_TITLE"),
						rset.getString("BOARD_CONTENT"), rset.getString("MEMBER_ID"), rset.getString("CREATE_DATE"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return b;
	}

	public int updateBoard(Board b, Connection conn) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, b.getBoardType());
			pstmt.setInt(2, b.getCategoryNo());
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardContent());
			pstmt.setInt(5, b.getBoardNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}
}
