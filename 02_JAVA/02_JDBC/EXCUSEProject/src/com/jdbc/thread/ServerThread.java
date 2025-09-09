package com.jdbc.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread{
	private Socket socket;
	private List<Socket> clientList;
	
	public ServerThread(Socket socket, List<Socket> clientList) {
        this.socket = socket;
        this.clientList = clientList;
    }

	@Override
	public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
        	String message;
        	while((message = br.readLine()) != null) {
        		String clientIp = socket.getInetAddress().getHostAddress();
                System.out.println("\n" + message);
				System.out.print("보낼 내용 : ");

                broadcast(message);
        	}
        
        }catch(IOException e){
        	
        } finally {
            // 연결이 끊어진 클라이언트를 리스트에서 제거
            clientList.remove(socket);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	private void broadcast(String message) {
		for(Socket clientSocket : clientList) {
			if(clientSocket != socket) {
				 try {
	                    PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
	                    pw.println(message);
	                } catch (IOException e) {
	                    System.err.println("메시지 전송 오류: " + e.getMessage());
	                }
			}
		}
	}
}
