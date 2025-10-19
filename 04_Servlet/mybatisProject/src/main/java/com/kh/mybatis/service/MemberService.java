package com.kh.mybatis.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.Template;
import com.kh.mybatis.model.dao.MemberDao;
import com.kh.mybatis.model.vo.Member;

public class MemberService {
	private MemberDao memberDao = new MemberDao();
	
	public Member loginMember(String userId, String userPwd) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member m = memberDao.loginMember(sqlSession, userId, userPwd);
		
		sqlSession.close();
		
		return m;
	}
	
	public int idCheck(String checkId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int count = memberDao.idCheck(sqlSession, checkId);
		
		sqlSession.close();
		
		return count;
	}
	
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	public Member updateMember(Member updateMember) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = Template.getSqlSession();
		int result = memberDao.updateMember(updateMember, sqlSession);

		Member updMember = null;

		if (result > 0) {
			sqlSession.commit();
			updMember = new MemberDao().selectMemberByUserId(updateMember.getMemberId(), sqlSession);
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();
		return updMember;
	}

	public Member updateMemberPwd(String memberId, String updatePwd) {

		SqlSession sqlSession = Template.getSqlSession();
		System.out.println("서비스 데이터 : " + memberId + " 업데이트 : " + updatePwd);

		int result = new MemberDao().updateMemberPwd(memberId, updatePwd, sqlSession);
		Member updateMember = null;
		if (result > 0) {
			sqlSession.commit();

			updateMember = new MemberDao().selectMemberByUserId(memberId, sqlSession);
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return updateMember;

	}
}
