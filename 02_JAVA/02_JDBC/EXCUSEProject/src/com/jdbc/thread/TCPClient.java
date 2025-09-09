package com.jdbc.thread;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public void chatClient() {
		String serverIP = "192.168.10.29";
		int port = 3000;
		Scanner sc=new Scanner(System.in);
		try {
			//1) 서버로 연결 요청(서버의 ip와 port로 연결을 요청)
			Socket socket = new Socket(serverIP, port);
			
			if(socket != null) {
				System.out.println("서버 접속 성공");
				System.out.println("닉네임을 입력하시오:");
				String name = sc.nextLine();
				System.out.println("닉네임 : "+name);
				ClientReceive cr = new ClientReceive(socket);
				cr.start();
				
				ClientSend cs = new ClientSend(socket,name);
				cs.start();
				cs.join();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
