package com.jdbc.thread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {
	private static List<Socket> clientList = new ArrayList<>();
	public  void chatServer() {
		
		try {
			ServerSocket server = new ServerSocket(3000);
			System.out.println("클라이언트 요청을 기다립니다.");
			
			while(true) {
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress().getHostAddress() + "가 연결을 요첨함...");
				
				clientList.add(socket);
				System.out.println("현재 접속자 : "+clientList.size());
				
				 ServerThread serverThread = new ServerThread(socket, clientList);
	             serverThread.start();
	             
	             ServerSend ss = new ServerSend(socket);
	             ss.start();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
