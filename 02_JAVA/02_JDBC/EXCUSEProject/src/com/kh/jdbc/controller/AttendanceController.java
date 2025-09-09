package com.kh.jdbc.controller;

import java.util.ArrayList;

import com.kh.jdbc.model.vo.AttendanceLog;
import com.kh.jdbc.model.vo.TardyCount;
import com.kh.jdbc.service.AttendanceLogService;
import com.kh.jdbc.view.ExcuseMenu;

public class AttendanceController {
	private AttendanceLogService as = new AttendanceLogService();

	public void insert(AttendanceLog log) {
		int result = as.insert(log);
		if(result>0) {
			new ExcuseMenu().displaySuccess("지각 보고가되었습니다.");
		}
		else {
			new ExcuseMenu().displayFail("지각 보고 저장에 실패했습니다.");
		}
	}

	public ArrayList<AttendanceLog> selectAllWithUser() {
		ArrayList<AttendanceLog> list = as.findAllWithUser();
		if(list == null) {
			new ExcuseMenu().displayNoData("출결 로그가 없습니다.");
		}
		return list;
	}

	public ArrayList<AttendanceLog> selectTodayLateOrAbsent() {
		ArrayList<AttendanceLog> list = as.findTodayLateOrAbsent();
		if(list == null) {
			new ExcuseMenu().displayNoData("오늘 지각/결석 보고가 없습니다.");
		}
		return list;
	}

	public ArrayList<TardyCount> selectTardyCountByUser() {
		ArrayList<TardyCount> list = as.findTardyCountByUser();
		if(list == null) {
			new ExcuseMenu().displayNoData("누적 지각 데이터가 없습니다.");
		}
		return list;
	}
}