package com.jdbc.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceive extends Thread{
	private Socket socket;

	public ServerReceive(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message;
            while ((message = br.readLine()) != null) {
                // 줄바꿈을 먼저 넣고 출력
                System.out.println("\n[친구] " + message);
                // 다시 입력 프롬프트를 띄워줌
                System.out.print("친구에게 보낼 내용 : ");
            }
        } catch (IOException e) {
            System.out.println("클라이언트 연결이 종료되었습니다.");
        }
		
		
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));){
//			while(true) {
//				String message = br.readLine();
//				System.out.println("클라이언트로부터 전달받은 메세지 : " + message);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	
}
