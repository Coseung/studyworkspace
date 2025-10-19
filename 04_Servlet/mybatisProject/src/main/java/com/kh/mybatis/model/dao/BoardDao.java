package com.kh.mybatis.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;

public class BoardDao {
	public int selectAllBoardCount(SqlSession sqlSession) {
		return sqlSession.selectOne("BoardMapper.selectAllBoardCount");
	}
	
	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi){
		//mybatis에서 자체적으로 페이징처리를 위해 RowBounds라는 class를 제공
		//offset : 몇개의 게시글을 건너뛰고 조회할 것인가
		//boardLimit : 몇개의 게시글을 가지고 올 것인가?
		//51~60 = 50개를 건너뛰고 10개를 가지고오고싶어
		
		//한페이지 보여줄 boardLimit 10
		// 1 -> 1~10 -> 0
		// 2 -> 11~20 -> 10
		// 3 -> 21~30 -> 20
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectAllBoard", null, rowBounds);
		return list;
	}

	public int increaseCount(SqlSession sqlSession, int boardNo) {
		// TODO Auto-generated method stub

		return sqlSession.update("BoardMapper.increaseCount", boardNo);
	}

	public Board selectBoardByBoardNo(SqlSession sqlSession, int boardNo) {

		Board b = sqlSession.selectOne("BoardMapper.selectBoardByBoardNo", boardNo);
		return b;
	}

	public ArrayList<Category> selectAllCategory(SqlSession sqlSession) {

		ArrayList<Category> list = (ArrayList) sqlSession.selectList("BoardMapper.selectAllCategory");

		return list;
	}

	public int updateBoard(SqlSession sqlSession, Board b) {
		// TODO Auto-generated method stub

		int result = sqlSession.update("BoardMapper.updateBoard", b);
		return result;
	}

	public int updateAttachment(SqlSession sqlSession, Attachment at) {
		int result = sqlSession.update("BoardMapper.updateAttachment", at);
		return result;
	}

	public int insertNewAttachment(SqlSession sqlSession, Attachment at) {
		int result = sqlSession.insert("BoardMapper.insertNewAttachment", at);
		return result;
	}

	public int insertBoard(SqlSession sqlSession, Board b) {
		int result = sqlSession.insert("BoardMapper.insertBoard", b);
		return result;
	}

	public int insertAttachment(SqlSession sqlSession, Attachment at) {
		int result = sqlSession.insert("BoardMapper.insertAttachment", at);
		return result;
	}

	public Attachment selectAttachment(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("BoardMapper.selectAttachment", boardNo);
	}

}
