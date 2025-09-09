package com.kh.jdbc.service;

//static으로 import시 static메서드를 직접 가져와서 사용할 수 있음.
import static com.kh.jdbc.common.JDBCTemplate.close;
import static com.kh.jdbc.common.JDBCTemplate.commit;
import static com.kh.jdbc.common.JDBCTemplate.getConnection;
import static com.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.model.dao.ExcuseDao;
import com.kh.jdbc.model.vo.Excuse;

/*
 * Service
 * 트랜잭션 관리와같은 비즈니스 로직을 처리하는 계층, Dao와 Contoller의 중간역할
 */
public class ExcuseService {
	
	ExcuseDao ed = new ExcuseDao();
	public ExcuseService() {
		super();
	}

	
	public Excuse randomExcuse(String category){
		Connection conn = getConnection();
		
		List<Excuse> list = ed.selectByCategory(category,conn);
		close(conn);
		
		if(list.isEmpty()) {
			return null;
		}
		
		int randomIndex = (int)(Math.random()*list.size());
		
		return list.get(randomIndex);
		
	}
	public ArrayList<Excuse> selectCategory(String category){
		Connection conn = getConnection();
		
		ArrayList<Excuse> list = ed.selectByCategory(category,conn);
		close(conn);
		
		if(list.isEmpty()) {
			return null;
		}
		
		
		return list;
		
	}
	
	
	
	
	public int insertExcuse(Excuse e) {
		Connection conn = getConnection();
		
		int result = ed.insertExcuse(e,conn);

		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public int updateExcuse(int id, Excuse e) {
		Connection conn = getConnection();
		int result = ed.updateExcuse(id,e, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
		
	}
	public ArrayList<Excuse> selectAll(){
		
		Connection conn = getConnection();
		
		ArrayList<Excuse> list = ed.selectAll(conn);
		close(conn);
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}


	public int deleteExcuse(int id) {
		Connection conn = getConnection();
		
		int result = ed.deleteExcuse(id,conn);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
}
