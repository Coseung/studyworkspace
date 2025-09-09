package com.kh.jdbc.model.dao;

import static com.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jdbc.model.vo.AttendanceLog;
import com.kh.jdbc.model.vo.TardyCount;

public class AttendanceLogDao {
	private Properties prop = new Properties();

	public AttendanceLogDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertAttendanceLog(Connection conn, AttendanceLog log) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttendanceLog");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, log.getUserId());
			pstmt.setString(2, log.getCategory());
			pstmt.setString(3, log.getReason());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<AttendanceLog> selectAllWithUser(Connection conn) {
		ArrayList<AttendanceLog> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttendanceAllWithUser");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				AttendanceLog l = new AttendanceLog();
				l.setUserId(rset.getString("user_id"));
				l.setName(rset.getString("name"));
				l.setCategory(rset.getString("category"));
				l.setReason(rset.getString("reason"));
				l.setLogDate(rset.getDate("log_date"));
				list.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<AttendanceLog> selectTodayLateOrAbsent(Connection conn) {
		ArrayList<AttendanceLog> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTodayLateOrAbsent");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				AttendanceLog l = new AttendanceLog();
				l.setUserId(rset.getString("user_id"));
				l.setName(rset.getString("name"));
				l.setCategory(rset.getString("category"));
				l.setReason(rset.getString("reason"));
				l.setLogDate(rset.getDate("log_date"));
				list.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<TardyCount> selectTardyCountByUser(Connection conn) {
		ArrayList<TardyCount> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTardyCountByUser");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				TardyCount tc = new TardyCount(
					rset.getString("user_id"),
					rset.getString("name"),
					rset.getInt("tardy_count")
				);
				list.add(tc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
}