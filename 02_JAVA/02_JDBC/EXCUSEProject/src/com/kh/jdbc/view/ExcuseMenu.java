package com.kh.jdbc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.controller.ExcuseController;
import com.kh.jdbc.model.vo.Excuse;
import com.jdbc.thread.TCPClient;
import com.jdbc.thread.TCPServer;
import com.kh.jdbc.controller.AttendanceController;
import com.kh.jdbc.controller.UserController;
import com.kh.jdbc.model.vo.AttendanceLog;
import com.kh.jdbc.model.vo.TardyCount;
import com.kh.jdbc.model.vo.User;
//View : 사용자와의 상호작용을 하는 객체 -> 입력및 출력
public class ExcuseMenu {
	private Scanner sc;
	private ExcuseController ec;
	private UserController uc;
	private AttendanceController ac;
	private User loginUser;
	public ExcuseMenu() {
		super();
		this.sc = new Scanner(System.in);
		this.ec = new ExcuseController();
		this.loginUser = null;
		this.uc = new UserController();
		this.ac = new AttendanceController();
	}

	/*
	 * 사용자가 보게될 첫 화면(메인화면)
	 */
	public void mainMenu() {
		while(true) {
			System.out.println("┌──────────────────────────────┐");
	        System.out.println("    📝 변명 & 동기부여 추천프로그램      ");
	        System.out.println("└──────────────────────────────┘");
			System.out.println("1. 변명 추천 받기");
			System.out.println("2. 조회");
			System.out.println("3. 변명/동기부여 추가");
			System.out.println("4. 변명/동기부여 변경");
			System.out.println("5. 변명/동기부여 삭제");
			System.out.println("6. 채팅방");
			System.out.println("7. 로그인");
			System.out.println("8. 회원가입");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
				case 1: choose(); break; // 변명추천받기
				case 2: selectCategory();   break;// 조회
				case 3: insertExcuse(); break; //변명추가
				case 4: updateExcuse(); break;//변명 변경
				case 5: deleteExcuse(); break; // 삭제 
				case 6: chat(); break; // 채팅
				case 7: login(); break; // 로그인
				case 8: signup(); break; // 회원가입
				case 9: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못 입력하셨습니다. ");
			}
			
			System.out.println();
		}
	}
	
	
	//변명 추천받기
	public void choose() {
		System.out.println("\n========= 변명/동기부여 추천 ===========");
		System.out.println("1. 지각 변명 추천");
		System.out.println("2. 운동 핑계 추천");
		System.out.println("3. 운동 동기부여 추천");
		System.out.println("9. 메인메뉴");
		System.out.println(": ");
		
		int num = sc.nextInt();
		switch(num) {
		case 1:
			ec.randomExcuse("지각");
			break;
		case 2:
			ec.randomExcuse("운동_핑계");
			break;
		case 3:
			ec.randomExcuse("운동_동기부여");
			break;
		case 9:
			mainMenu();
			break;
		default:
			System.out.println("잘못입력하였습니다.");
		}
	}
	//카테고리 별 조회
	public void selectCategory() {
		System.out.println("\n========= 변명/동기부여 조회 선택 ===========");
		System.out.println("1. 지각 변명 조회");
		System.out.println("2. 운동 핑계 조회");
		System.out.println("3. 운동 동기부여 조회");
		System.out.println("4. 전체조회");

		System.out.println("9. 메인메뉴");
		System.out.print(": ");
		
		int num = sc.nextInt();
		sc.nextLine();
		switch(num) {
		case 1:
			ec.selectCategory("지각");
			break;
		case 2:
			ec.selectCategory("운동_핑계");
			break;
		case 3:
			ec.selectCategory("운동_동기부여");
			break;
		case 4:
			ec.selectAll();
			break;
		case 9:
			mainMenu();
			break;
		default:
			System.out.println("잘못입력하였습니다");
		}
	}
	//변명추가
	public void insertExcuse() {
		System.out.println("\n========= 변명/동기부여 추가 ===========");
		
		System.out.println("1. 지각 변명 추가");
		System.out.println("2. 운동 핑계 추가");
		System.out.println("3. 운동 동기부여 추가");
		System.out.println("9. 메인메뉴");
		System.out.print(": ");

		
		int num = sc.nextInt();
		sc.nextLine();

		switch(num) {
		case 1:
			System.out.print("지각 변명 :");
			String content = sc.nextLine();
			
			
			ec.insertExcuse(new Excuse("지각",content));
			break;
		case 2:
			System.out.print("운동 변명 :");
			String content2 = sc.nextLine();
			ec.insertExcuse(new Excuse("운동_핑계",content2));

			break;
		case 3:
			System.out.print("운동 동기부여 :");
			String content3 = sc.nextLine();
			ec.insertExcuse(new Excuse("운동_동기부여",content3));

			break;
		case 9:
			mainMenu();
			break;
		default:
			System.out.println("잘못입력하였습니다");
		}
	}
	
	
	
	public void updateExcuse() {
		System.out.println("\n========= 변명/동기부여 변경 ===========");
		System.out.println("1. 지각 변명 변경");
		System.out.println("2. 운동 핑계 변경");
		System.out.println("3. 운동 동기부여 변경");
		System.out.println("9. 메인메뉴");
		System.out.print(": ");
		
		
		int num = sc.nextInt();
		sc.nextLine();

		switch(num) {
		case 1:
			ec.selectCategory("지각");
			System.out.println();
			System.out.print("지각 변명 변경할 아이디:");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("수정 변명 :");
			String content = sc.nextLine();
			
			
			ec.updateExcuse(id ,new Excuse("지각",content));
			break;
		case 2:
			ec.selectCategory("운동_핑계");
			System.out.println();
			System.out.print("운동 변명 변경할 아이디:");
			int id1 = sc.nextInt();
			sc.nextLine();
			System.out.print("수정 변명 :");
			String content1 = sc.nextLine();
			
			
			ec.updateExcuse(id1 ,new Excuse("운동_핑계",content1));

			break;
		case 3:
			ec.selectCategory("운동_동기부여");
			System.out.println();
			System.out.print("운동 동기부여 변경할 아이디:");
			int id2 = sc.nextInt();
			sc.nextLine();
			System.out.print("동기부여 수정 :");
			String content2 = sc.nextLine();
			
			
			ec.updateExcuse(id2 ,new Excuse("운동_동기부여",content2));

			break;
		case 9:
			mainMenu();
			break;
		default:
			System.out.println("잘못입력하였습니다");
		}
	}
	
	public void deleteExcuse() {
		
		ec.selectAll();
		
		System.out.println();
		System.out.println("\n========= 변명 삭제 ===========");
		System.out.print("삭제할 아이디 : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		
		
		ec.deleteExcuse(id);
	}
	
	public void chat() {
System.out.println("\n========= 채팅방 ===========");
		
		System.out.println("1. 채팅방 만들기");
		System.out.println("2. 채팅방 참가하기");
		System.out.println("9. 메인메뉴");
		System.out.print(": ");

		
		int num = sc.nextInt();
		sc.nextLine();

		switch(num) {
		case 1:
			new TCPServer().chatServer();
			break;
		case 2:
			new TCPClient().chatClient();
			break;
		case 3:
			mainMenu();
			break;
		case 9:
			break;
		default:
			System.out.println("잘못입력하였습니다");
		}
	}	
	
	
	public void login() {
		System.out.println("\n========= 로그인 ===========");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		User user = uc.login(id, pw);
		if(user != null) {
			this.loginUser = user;
			System.out.println(user.getName() + "님 환영합니다. (" + user.getRole() + ")");
			if(user.getRole().equals("TEACHER")) {
				teacherMenu();
			} else {
				studentMenu();
			}
		}
	}
	
	public void signup() {
		System.out.println("\n========= 회원가입 ===========");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학생/강사 : ");
		
		String role = sc.nextLine();
		if (role.equals("학생")) {
			uc.signup(new User(id, pw, name, "STUDENT"));

		}else {
			uc.signup(new User(id, pw, name, "TEACHER"));

		}
		
	}
	
	// 권한별 메뉴
	public void teacherMenu() {
		while(true) {
			System.out.println("\n========= 강사님 메뉴 ===========");
			System.out.println("1. 출결 조회(모든 학생 사유/날짜/누적 지각)");
			System.out.println("2. 오늘 지각생 조회(지각/결석)");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1:
				ArrayList<AttendanceLog> all = ac.selectAllWithUser();
				if(all != null) {
					displayAttendanceList(all, "전체 출결");
				}
				ArrayList<TardyCount> counts = ac.selectTardyCountByUser();
				if(counts != null) {
					displayTardyCounts(counts, "누적 지각 횟수 ಠಿ_ಠ");
				}
				break;
			case 2:
				ArrayList<AttendanceLog> today = ac.selectTodayLateOrAbsent();
				if(today != null) {
					displayAttendanceList(today, "오늘 지각/결석 보고");
				}
				break;
			case 3:
				logout();
				return;
			default:
				System.out.println("잘못입력하였습니다");
			}
			System.out.println();
		}
	}
	
	public void studentMenu() {
		while(true) {
			System.out.println("\n========= 학생 메뉴 ===========");
			System.out.println("1) 지각 보고하기   예)오늘 배탈나서 못갈 것 같습니다");
			System.out.println("2) 지각 변명 추천 받기");
			System.out.println("3) 로그아웃");
			System.out.print("메뉴 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1:
				reportLate();
				break;
			case 2:
				ec.randomExcuse("지각");
				break;
			case 3:
				logout();
				return;
			default:
				System.out.println("잘못입력하였습니다");
			}
			System.out.println();
		}
	}
	
	private void logout() {
		if(loginUser != null) {
			System.out.println(loginUser.getName() + "님 로그아웃 되었습니다.");
		}
		loginUser = null;
	}
	
	// 학생 지각 보고 
	private void reportLate() {
		if(loginUser == null) {
			System.out.println("로그인이 필요합니다.");
			return;
		}
		System.out.print("지각 사유 : " );
		String reason = sc.nextLine();
		ac.insert(new AttendanceLog(loginUser.getUserId(), "지각", reason));

	}
	
	
	
	
	
	//========================= 응답화면 ===================================
	//서비스요청 처리 후 성공했을 때 사용자가 보게될 화면
	//msg : 기능별 성공메세지

	public void displayAttendanceList(ArrayList<AttendanceLog> list, String title) {
		System.out.println("\n------------------------------ " + title + " ------------------------------");
		for(Object o : list) {
			System.out.println(o);
		}
		

	}
	public void displayTardyCounts(ArrayList<TardyCount> list, String title) {
		System.out.println("\n------------------------------ " + title + " ------------------------------");
		for(Object o : list) {
			System.out.println(o);
		}
		System.out.println("\n\n");
		System.out.println("-----------------------------------------------------------------------");
	}
	public void displaySuccess(String msg) {
		System.out.println("\n서비스 요청 성공 : " + msg);
	}
	
	//서비스요청 처리 후 실패했을 때 사용자가 보게될 화면
	//msg : 기능별 실패메세지
	public void displayFail(String msg) {
		System.out.println("\n서비스 요청 실패 : " + msg);
	}
	
	public void displayNoData(String msg) {
		System.out.println("\n" + msg);
	}
	
	public void displayList(List list, String title) {
		System.out.println("========== " + title + " ==========");
		for(Object o : list) {
			System.out.println(o);
		}
		
	}
	public void displayRateExcuse(String msg) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("----------------지각 핑계 ---------------"); 
		 System.out.println("　   (/ΩΩ/);");
	        System.out.println("　　 / •• /;");
	        System.out.println("　　(＿ノ |;            " + "\'"+msg+"\'");
	        System.out.println("　　　 |　|;                   ￣￣￣￣￣ヽ___ノ￣￣￣￣￣");
	        System.out.println("　　　 |　|;");
	        System.out.println("　　 __|　|＿;");
	        System.out.println("　　/ヘ　　/)");
	        System.out.println("　　Lニニコ/");
	        System.out.println("　　 |￣￣￣￣|");
	        System.out.println("　　 |　　　 |――≦彡");
	        System.out.println("　　 |　∩　 |");
	        System.out.println("　　 |　||　|");
	        System.out.println("　　 |　||　|");
	        System.out.println("　　 |二||二| ..................................");
	        System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
	}
	
	public void displayMotivation(String msg) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		 System.out.println("┌───────────────────────────────────────────┐");
	        System.out.println("  " + msg);
	        System.out.println("└───────────────────────────────────────────┘");
	        System.out.println("　　　 ／⌒ヽ");
	        System.out.println("　　 　/ ^ω^ヽ    운동 갔다오도록 하세요.");
	        System.out.println("　＿ノ ヽ　ノ ＼＿");
	        System.out.println("/　`/ ⌒Ｙ⌒ Ｙ　 ヽ");
	        System.out.println("( 　(三ヽ人　 /　　|");
	        System.out.println("|　ﾉ⌒＼ ￣￣ヽ　 ノ");
	        System.out.println("ヽ＿＿＿＞､＿＿_／");
	        System.out.println("　　 ｜( 王 ﾉ〈");
	        System.out.println("　　 /ﾐ`ー―彡ヽ");
	        System.out.println("　　/　ヽ_／　 |");
	        System.out.println("　｜　　/　 ﾉノ");
	        System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
	}
	public void displayWorkout(String msg) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(" \\(•_•) ");
        System.out.println(" (   (> 포기 !");
        System.out.println("  /   \\");
        System.out.println();
        System.out.println(" (•_•)");
        System.out.println(" <)   )> 했지렁 !");
        System.out.println("  /    \\                              ");
        System.out.println("                          " + msg);
        System.out.println(" \t\t\t     ￣￣￣￣￣ヽ___ノ￣￣￣￣￣￣￣￣￣");
        System.out.println(" (•_•)");
        System.out.println(" <)   )╯운동 !                      ");
        System.out.println("  /    \\        ");
        System.out.println();
        System.out.println(" \\(•_•) ");
        System.out.println(" (   (> 포기 !");
        System.out.println("  /   \\");
        System.out.println();
        System.out.println(" (•_•)");
        System.out.println(" <)   )> 했지렁 !");
        System.out.println("  /    \\");
        System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	
}

















