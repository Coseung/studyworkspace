package com.kh.jdbc.model.dao;

import static com.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jdbc.model.vo.Excuse;

public class ExcuseDao {
	private Properties prop = new Properties();
	
	public ExcuseDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public int insertMember(Connection conn) {
//		
//	}
	
	//회원목록을 반환하는 메서드
	public ArrayList<Excuse> selectByCategory(String Category, Connection conn){
		ResultSet rset = null;
		ArrayList<Excuse> list = new ArrayList<>(); //비어있는 상태
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBycategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Category);

			rset = pstmt.executeQuery();
			while(rset.next()){
				Excuse e = new Excuse();
				
				e.setExcuseId(rset.getInt("EXCUSE_ID"));
				e.setCategory(rset.getString("CATEGORY"));
				e.setContent(rset.getString("CONTENT"));
				list.add(e);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
			
		}
		return list;
		
		
		
	}
	
	
	public int insertExcuse(Excuse e, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertExcuse");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getCategory());
			pstmt.setString(2, e.getContent());
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally{
			close(pstmt);
			
		}		
		return result;
	}
	
	
	public int updateExcuse(int id, Excuse e, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("updateExcuse");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getContent());
			pstmt.setInt(2, id);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	
	public ArrayList<Excuse> selectAll(Connection conn){
		ResultSet rset = null;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("selectAll");
		
		ArrayList<Excuse> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Excuse e = new Excuse();
				
				e.setExcuseId(rset.getInt("EXCUSE_ID"));
				e.setCategory(rset.getString("CATEGORY"));
				e.setContent(rset.getString("CONTENT"));
				list.add(e);
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
	

	public int deleteExcuse(int id, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteEXCUSE");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}


	
}
