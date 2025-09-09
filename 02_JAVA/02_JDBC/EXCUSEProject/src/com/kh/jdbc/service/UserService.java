package com.kh.jdbc.service;

import static com.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.jdbc.model.dao.UserDao;
import com.kh.jdbc.model.vo.User;

public class UserService {
	private UserDao ud = new UserDao();

	public int signup(User u) {
		Connection conn = getConnection();
		int result = ud.insertUser(conn, u);
		if(result>0){
			commit(conn); 
		}else {
			rollback(conn);	
		}
		close(conn);
		return result;
	}

	public User login(String userId, String password) {
		Connection conn = getConnection();
		User user = ud.selectByIdAndPassword(conn, userId, password);
		close(conn);
		return user;
	}
}