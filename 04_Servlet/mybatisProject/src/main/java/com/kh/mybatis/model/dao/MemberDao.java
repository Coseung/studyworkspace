package com.kh.mybatis.model.dao;


import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Member;

public class MemberDao {
	public Member loginMember(SqlSession sqlSession, String userId,String userPwd) {
		HashMap<String, String> map = new HashMap<>();
		map.put("memberId", userId);
		map.put("memberPwd", userPwd);
		
		Member loginMember = sqlSession.selectOne("MemberMapper.loginMember", map);
		return loginMember;
	}
	
	public int idCheck(SqlSession sqlSession, String checkId) {
		return sqlSession.selectOne("MemberMapper.idCheck", checkId);
	}
	
	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("MemberMapper.insertMember", m);
	}

	public int updateMember(Member m, SqlSession sqlSession) {

		return sqlSession.update("MemberMapper.updateMember", m);
	}

	public Member selectMemberByUserId(String memberId, SqlSession sqlSession) {
		// TODO Auto-generated method stub

		Member selectMemberUserId = sqlSession.selectOne("MemberMapper.selectMemberByMemberId", memberId);
		return selectMemberUserId;
	}

	public int updateMemberPwd(String memberId, String updatePwd, SqlSession sqlSession) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("updatePwd", updatePwd);

		System.out.println("다오 데이터: " + map + "memberId" + memberId + "updatePwd" + updatePwd);
		int result = sqlSession.update("MemberMapper.updateMemberPwd", map);
		return result;
	}
}
















