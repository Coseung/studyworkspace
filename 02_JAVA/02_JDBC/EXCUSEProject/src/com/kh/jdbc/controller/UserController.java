package com.kh.jdbc.controller;

import com.kh.jdbc.model.vo.User;
import com.kh.jdbc.service.UserService;
import com.kh.jdbc.view.ExcuseMenu;

public class UserController {
	private UserService us = new UserService();

	public void signup(User u) {
		int result = us.signup(u);
		if(result>0) {
			new ExcuseMenu().displaySuccess("회원가입이 완료되었습니다.");
		} else {
			new ExcuseMenu().displayFail("회원가입에 실패했습니다.");
		}
	}

	public User login(String userId, String password) {
		User user = us.login(userId, password);
		if(user == null) {
			new ExcuseMenu().displayFail("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		return user;
	}
}