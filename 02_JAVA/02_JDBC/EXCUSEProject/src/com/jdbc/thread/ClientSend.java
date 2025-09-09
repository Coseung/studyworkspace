package com.jdbc.thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread{
	private Socket socket;
	private String name;

	public ClientSend(Socket socket,String name) {
		super();
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try (Scanner sc = new Scanner(System.in)){
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				System.out.print("보낼 내용 : ");
				String sendMessage = sc.nextLine();
				if (sendMessage.equals("/나가기")) {
	                System.out.println("채팅을 종료합니다.");
	                pw.println("상대방이 채팅을 종료했습니다.");
	                pw.flush();
	                socket.close(); 
	                break; 
	            }else {
	            	pw.println(name+" : " +sendMessage);
					pw.flush();
	            }
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
