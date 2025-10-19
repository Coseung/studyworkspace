package com.kh.mybatis.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.Template;
import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.dao.BoardDao;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;

public class BoardService {
	private BoardDao boardDao = new BoardDao();
	
	public int selectAllBoardCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = boardDao.selectAllBoardCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public ArrayList<Board> selectAllBoard(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectAllBoard(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}

	public int increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();

		int result = new BoardDao().increaseCount(sqlSession, boardNo);
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();
		return result;
	}

	public Board selectBoardByBoardNo(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();

		Board board = new BoardDao().selectBoardByBoardNo(sqlSession, boardNo);

		sqlSession.close();
		return board;

	}

	public ArrayList<Category> selectAllCategory() {
		SqlSession sqlSession = Template.getSqlSession();

		ArrayList<Category> categroyList = new BoardDao().selectAllCategory(sqlSession);

		sqlSession.close();

		return categroyList;
	}

	public int updateBoard(Board b, Attachment at) {
		// 새로운 첨부파일이 존재하지 않을 때 -> (b, null) -> board update
		// 새로운 첨부파일이 존재하고 기존첨부파일이 존재할 때 -> (b, at(fileNo)) -> board update, attachment
		// update
		// 새로운 첨부파일이 존재하고 기존첨부파일이 존재하지 않을 때 -> (b, at(refBoardNo)) -> board update,
		// attachment insert

		SqlSession sqlSession = Template.getSqlSession();
		BoardDao boardDao = new BoardDao();

		int result = boardDao.updateBoard(sqlSession, b);

		if (at != null) {
			if (at.getFileNo() != 0) { // 기존첨부파일이 존재할 때
				result *= boardDao.updateAttachment(sqlSession, at);
			} else { // 기존첨부파일이 존재하지 않을 때
				result *= boardDao.insertNewAttachment(sqlSession, at);
			}
		}

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();
		return result;
	}

	public int insertBoard(Board b, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();

		BoardDao bDao = new BoardDao();

		int result = bDao.insertBoard(sqlSession, b);

		if (at != null) {
			result *= bDao.insertAttachment(sqlSession, at);
		}

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();
		return result;
	}

	public Attachment selectAttachment(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();

		Attachment at = new BoardDao().selectAttachment(sqlSession, boardNo);

		sqlSession.close();

		return at;
	}
}
