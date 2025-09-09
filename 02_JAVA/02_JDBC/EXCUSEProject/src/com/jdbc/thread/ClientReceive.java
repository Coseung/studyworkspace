package com.jdbc.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceive extends Thread{
	private Socket socket;
	public ClientReceive(Socket socket) {
		super();
		this.socket = socket;
		
	}

	@Override
	public void run() {
		//스레드를 통해서 메세지를 받아서 출력
		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message;
            while ((message = br.readLine()) != null) {
                // 항상 새 줄에서 출력
                System.out.println("\n"+message);
                // 다시 프롬프트 출력
                System.out.print("보낼 내용 : ");
            }
        } catch (IOException e) {
            System.out.println("서버 연결이 종료되었습니다.");
        }
		
		
//		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			
//			while(true) {		
//				String message = br.readLine();
//				System.out.println("서버로부터 전달받은 메세지 : " + message);
//			}
//		
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
	}
	
	
}
