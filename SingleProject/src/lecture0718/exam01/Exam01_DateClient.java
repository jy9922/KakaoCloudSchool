package lecture0718.exam01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javafx.application.Application; // 창에 띄우기 위해
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_DateClient extends Application {
	TextArea textarea;
	Button connBtn;
	
	@Override
	public void start(Stage primaryStage) throws Exception { 
		// 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // window 크기
		
		textarea = new TextArea();
		root.setCenter(textarea); // 화면 center에 textarea를 붙여요!
		
		connBtn = new Button("Date Server 접속");
		connBtn.setPrefSize(150, 40); // 버튼의 크기
		connBtn.setOnAction(e ->{
			textarea.clear(); 
			// 서버 process에 접속을 시도
			// 프로토콜은 내부적으로 설정되어 있기에 명시하지 않아도 됨, ip와 port가 있어야 통신해야 된다.
			try {
				Socket socket = new Socket("localhost", 5678); // ip, port번호 (접속을 시도한다는 의미) 
				   											   // 접속이 되면 소켓 instance가 만들어 진다.
				// 접속에 성공했으니 이제 stream을 열어보아요!!
				// InputStreamReader은 한줄 단위로 읽는 능력이 없어요..ㅜㅜ
				InputStreamReader ir = new InputStreamReader(socket.getInputStream());
				// InputStreamReader을 사용하기 편하게 만들어볼게요!
				// ButteredReader은 한 라인 단위로 읽어서 완전 편합니다..!
				BufferedReader br = new BufferedReader(ir);
				
				// 보내기도 전에 readline 할 수 있다. (But, 걱정 노노..)
				// 그런데 readline은 blocking 메서드이므로
				// 읽을게 있을 때 메서드가 진행되기 때문에 서버가 보내줄 때까지 대기하고 있다.
				String msg = br.readLine();
				
				textarea.appendText(msg + "\n"); // 나중에 문제가 생길 수 있어요..!
										  		 // 채팅 프로그램에서 문제가 생길 수 있음..
				
				// 사용한 리소스를 반드시 해체해줘야 한다! - 그렇지 않으면 메모리 leak (역순으로 닫아줘야 함)
				br.close();
				ir.close();
				socket.close();
				
				textarea.appendText("서버와의 연결이 종료되었어요!");
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}); // 버튼 클릭했을 때, 안에 있는 코드를 실행하라는 의미!
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10)); // 여백을 줘요!
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn); // 버튼 부착
		
		root.setBottom(flowPane);
		
		// 화면에 띄우기 위한 코드
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(); // 화면에 창을 띄우는 준비 작업 완료!
	}

}
