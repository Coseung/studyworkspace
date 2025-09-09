package com.jdbc.thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.kh.jdbc.controller.ExcuseController;
import com.kh.jdbc.model.dao.ExcuseDao;
import com.kh.jdbc.model.vo.Excuse;
import com.kh.jdbc.view.ExcuseMenu;

public class ServerSend extends Thread{
	private Socket socket;

	public ServerSend(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Scanner sc = new Scanner(System.in)){
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			while(true) {	
				System.out.print("보낼 내용 : ");
				String sendMessage = sc.nextLine();
				if(sendMessage.contains("/저장")) {
					String[] parts = sendMessage.split(" ", 3);
					if (parts.length >= 3) {
	                    String category = parts[1];
	                    String content = parts[2];

	                    // Excuse 객체 생성
	                    Excuse excuse = new Excuse(category, content);

	                    // DAO 통해 DB 저장
	                    new ExcuseController().insertExcuse(excuse);

	                    System.out.println("DB 저장 완료: " + "카테고리 : " +excuse.getCategory()+" 내용 : "+excuse.getContent());
	                } else {
	                    System.out.println("/저장 [카테고리] [내용] 순으로 써주세요");
	                }
				}else if(sendMessage.contains("/변명추천")){
					new ExcuseController().randomExcuse("지각");
				
				}else if (sendMessage.equals("/나가기")) {
	                System.out.println("채팅을 종료합니다.");
	                pw.println("상대방이 채팅을 종료했습니다.");
	                pw.flush();
	                socket.close(); 
	                
	                
	                break; 
	            }
				else {
					pw.println(sendMessage); //클라이언트 스트림에 출력
					pw.flush(); //스트림에 있는 데이터 강제로 전부 내보내기
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
