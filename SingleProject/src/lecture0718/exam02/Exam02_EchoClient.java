package lecture0718.exam02;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application; // 창에 띄우기 위해
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {
	TextArea textarea;
	Button connBtn;
	TextField idField, textfield;
	
	Socket socket;
	BufferedReader br;
	PrintWriter pr;
	
	@Override
	public void start(Stage primaryStage) throws Exception { 
		// 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // window 크기
		
		textarea = new TextArea();
		root.setCenter(textarea); // 화면 center에 textarea를 붙여요!
		
		connBtn = new Button("Echo Server 접속");
		connBtn.setPrefSize(150, 40); // 버튼의 크기
		connBtn.setOnAction(e ->{
			textarea.clear();
			try {
				socket = new Socket("localhost", 5679);
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pr = new PrintWriter(socket.getOutputStream());
				textarea.appendText("Echo 서버 접속 성공"+"\n");
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		});
		
		idField = new TextField();
		idField.setPrefSize(100, 40);
		
		textfield = new TextField();
		textfield.setPrefSize(300, 40);
		textfield.setOnAction(e -> {
			String msg = idField.getText() + ": " + textfield.getText();
			pr.println(msg);
			pr.flush();
			
			if (textfield.getText().equals("/exit")) {
				textarea.appendText("서버와의 연결을 종료합니다.");
				textfield.setDisable(true);
			} else {
				try {
					String serverMsg = br.readLine();
					textarea.appendText(serverMsg + "\n");
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
			textfield.clear();
			
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10)); // 여백을 줘요!
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn); // 버튼 부착
		flowPane.getChildren().add(idField);
		flowPane.getChildren().add(textfield); // 입력상자 부착
		
		
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

