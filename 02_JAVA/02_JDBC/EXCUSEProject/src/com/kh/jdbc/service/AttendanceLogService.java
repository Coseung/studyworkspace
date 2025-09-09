package com.kh.jdbc.service;

import static com.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jdbc.model.dao.AttendanceLogDao;
import com.kh.jdbc.model.vo.AttendanceLog;
import com.kh.jdbc.model.vo.TardyCount;

public class AttendanceLogService {
	private AttendanceLogDao ad = new AttendanceLogDao();

	public int insert(AttendanceLog log) {
		Connection conn = getConnection();
		int result = ad.insertAttendanceLog(conn, log);
		if(result>0) {
            commit(conn);
        } else {
            rollback(conn);
        }
		close(conn);
		return result;
	}

	public ArrayList<AttendanceLog> findAllWithUser() {
		Connection conn = getConnection();
		ArrayList<AttendanceLog> list = ad.selectAllWithUser(conn);
		close(conn);
		return list.isEmpty() ? null : list;
	}

	public ArrayList<AttendanceLog> findTodayLateOrAbsent() {
		Connection conn = getConnection();
		ArrayList<AttendanceLog> list = ad.selectTodayLateOrAbsent(conn);
		close(conn);
		return list.isEmpty() ? null : list;
	}

	public ArrayList<TardyCount> findTardyCountByUser() {
		Connection conn = getConnection();
		ArrayList<TardyCount> list = ad.selectTardyCountByUser(conn);
		close(conn);
		return list.isEmpty() ? null : list;
	}
}