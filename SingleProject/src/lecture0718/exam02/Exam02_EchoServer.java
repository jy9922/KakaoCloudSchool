package lecture0718.exam02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Exam02_EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter pr = null;
		BufferedReader br = null;
		
		try {
			serverSocket = new ServerSocket(5679);
			System.out.println("Echo Server 기동 - 클라이언트 접속 대기");
			socket = serverSocket.accept(); 
			
			// 접속 성공
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pr = new PrintWriter(socket.getOutputStream());
			
			String msg = null;
			while(true) {
				msg = br.readLine();
				if (msg.equals("/exit") || (msg == null)) {
					break;
				}
				pr.println(msg);
				pr.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 사용된 resource를 해제
			try {
				// null인 경우 close가 되지 않을 수 있다.
				if (br != null) br.close();
				if (pr != null) pr.close();
				if (socket != null) socket.close();
				if (serverSocket != null) serverSocket.close();
				System.out.println("Echo Server 종료!");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
