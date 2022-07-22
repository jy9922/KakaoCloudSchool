package lecture0718.exam01;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/* Server쪽 Process */
public class Exam01_DateServer {
	public static void main(String[] args) {
		// server쪽 Process는 프로그램 시작과 동시에 server socket이 필요하다.
		// server socket이 class로 존재 -> instance로 만들면 된다.
		// server socket에는 port 번호(1024~)를 들고 있어야 한다.
		// server socket은 try-catch가 강제되는 코드!
		try {
			ServerSocket serverSocket = new ServerSocket(5678); 
			System.out.println("Date Server 기동 - 포트번호(5678)");
			Socket socket = serverSocket.accept(); 
			// accept(), blocking(포트번호를 가지고 client의 접속을 기다리라는 의미)
			// 그리고 client와 접속이 성공하는 순간 서버의 socket이 만들어 진다.
			
			// 접속이 성공했어요!
			// 소켓에 연결된 output stream을 열어야 한다.
			// 문자열을 쉽게 보내기 위해 PrintWriter을 이용한다.
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			Date date = new Date();
			pr.println(date.toLocaleString());
			
			// printerWriter의 동작 과정 (버퍼를 이용한 스트림)
			// 버퍼 안에 들어가 있는 데이터를 스트림을 통해서 내보내는 시점은
			// 1. 스트림이 강제로 종료될 경우 (close)
			// 2. 버퍼의 공간이 다 찰 경우
			// 3. method를 이용해서 flush()시킬 경우
			
			pr.flush(); 
			// 현재 가지고 있는 데이터를 보내라는 코드
			// 만약에 flush, close를 안하는 경우, resource를 해제하지 안한다면
			// 데이터가 오지 않는다.. (버퍼에만 존재하고 실제로 전송되지 않는다)
			
			// 사용한 자원을 반납
			pr.close(); 
			socket.close();
			serverSocket.close();
			
			System.out.println("Date Server 종료");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
