package com.kh.jdbc.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.model.vo.Excuse;
import com.kh.jdbc.service.ExcuseService;
import com.kh.jdbc.view.ExcuseMenu;

/*
 * Controller : View를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 *              해당 메서드로 전달된 데이터를 가공한 후 dao로 전달하여 기능을 수행.
 *              dao로부터 반환받은 결과에 따라서 성공/실해 여부를 판단해서 응답화면 결정 -> View호출
 * */
public class ExcuseController {
	private ExcuseService es = new ExcuseService();
	
	public ExcuseController() {
		super();

	}

	
	//핑계 랜덤으로 가져오기 
	public void randomExcuse(String category) {
		Excuse excuse = es.randomExcuse(category);
		
		if(excuse ==null) {
			new ExcuseMenu().displayNoData("핑계/동기부여 가 없습니다.");
		}else {
			if(category.equals("지각")) {
				new ExcuseMenu().displayRateExcuse(excuse.getContent());
			}else if(category.equals("운동_동기부여")) {
				new ExcuseMenu().displayMotivation(excuse.getContent());

			}else {
				new ExcuseMenu().displayWorkout(excuse.getContent());
			}
		}
	}		
	
	public void selectCategory(String category) {
		ArrayList<Excuse> list = es.selectCategory(category);
		
		if(list ==null) {
			new ExcuseMenu().displayNoData("카테고리에 내용이 없습니다.");
		}else {
			new ExcuseMenu().displayList(list,category);
		}
	}
	
		
	public void insertExcuse(Excuse e) {
		int result = es.insertExcuse(e);
		
		if(result >0) {
			System.out.println("성공적으로 추가되었습니다.");
		}else {
			System.out.println("추가 되지않았습니다.");
		}
		
	}
 
	public void updateExcuse(int id, Excuse e) {
		int result = es.updateExcuse(id, e);
		
		if(result >0) {
			System.out.println("성공적으로 변경되었습니다.");
		}else {
			System.out.println("변경 되지않았습니다.");
		}
		
	}
	
	public void selectAll() {
		ArrayList<Excuse> list = es.selectAll();
		
		if(list.isEmpty()) {
			System.out.println("내용이 없습니다.");
			
		}else {
			new ExcuseMenu().displayList(list,"전체 조회");
		}
		
		
	}


	public void deleteExcuse(int id) {
		
		int result = es.deleteExcuse(id);
		
		if(result > 0) {
			System.out.println("아이디 :"+id+" 삭제되었습니다." );
		}else {
			new ExcuseMenu().displayFail("변명/ 동기부여 가 삭제 되지않았습니다.");
		}
		
	}
		
	
		
		
		
	
//	
//	public void insertMember(String category, String content) {
//		
//		//view로부터 전달받은 값을 바로 dao에 전달x
//		//vo에 잘 담아서 전달
//		Excuse m = new Excuse(category,content);
//		
//		int result = ms.insertMember(m);
//		
//		if(result > 0) {
//			//성공화면
//			new ExcuseMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
//		} else {
//			//실패화면
//			new ExcuseMenu().displayFail("회원추가에 실패하였습니다.");
//		}
//	}
//	
//	//회원을 모두 조회
//	public void selectMemberAll() {
//		List<Excuse> list = ms.selectMemberList();
//		
//		//조회된 결과에 따라서 사용자가 보게될 화면
//		if(list.isEmpty()) {
//			new ExcuseMenu().displayNoData("회원목록 조회결과가 없습니다.");
//		}else {
//			new ExcuseMenu().displayList(list, "회원 목록");
//		}
//	}
//	
//	//userId, email, phone, address, hobby를 전달받아
//	//Member를 수정하는 메서드
//	public void updateMember(String userId, String email, String phone, String address, String hobby) {
//		Excuse m = new Excuse();
//		m.setUserId(userId);
//		m.setEmail(email);
//		m.setPhone(phone);
//		m.setAddress(address);
//		m.setHobby(hobby);
//		
//		int result = ms.updateMember(m);
//		
//		if(result > 0) {
//			new ExcuseMenu().displaySuccess("성공적으로 회원정보를 수정하였습니다.");
//		} else {
//			new ExcuseMenu().displayFail("회원정보를 수정하는데 실패하였습니다.");
//		}
//	}
//	
//	public void deleteMember(String userId, String userPwd) {
//		Excuse m = new Excuse();
//		m.setUserId(userId);
//		m.setUserPwd(userPwd);
//		
//		int result = ms.deleteMember(m);
//		if(result > 0) {
//			new ExcuseMenu().displaySuccess("성공적으로 회원탈퇴가 되었습니다.");
//		} else {
//			new ExcuseMenu().displayFail("회원탈퇴에 실패하였습니다.");
//		}
//	}
//	
//	
//	
//	public void bulkInsertMembers(ArrayList<Excuse> list) {
//		int result = ms.bulkInsertMembers(list);
//		
//		if(result > 0) {
//			new ExcuseMenu().displaySuccess(result+"명이 성공적으로 회원 추가 되었습니다.");
//		} else {
//			new ExcuseMenu().displayFail("회원추가에 전부 실패하였습니다.");
//		}
//	}
}










