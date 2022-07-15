package lecture0715;

import java.io.*;

//import java.io.*;
// notepad를 만들어 보아요!
// JAVAFX를 이용할거예요!
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class MyNotepad extends Application{
	
	TextArea textarea;
	Button openBtn, saveBtn;
	File file;
	
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg+"\n");
		});
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면을 구성하는 전체 판.
		BorderPane root = new BorderPane();
		// BoarderPane의 가로 세로 길이
		root.setPrefSize(700, 500);
		
		// TextArea 생성
		textarea = new TextArea();
		root.setCenter(textarea);
		
		// 버튼을 만들어 보아요!
		openBtn = new Button("파일 열기");
		openBtn.setPrefSize(150, 40);
		
		// EventHandler은 interface이다!
		// 추상 메서드를 오버라이딩하고 있기 때문에 동적으로 인스턴스를 생성할 수 있다.
		// 이벤트가 버튼에서 발생 -> 이벤트 처리 객체를 위임하는 것
//		openBtn.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				System.out.println("버튼이 눌렸어요!");
//				
//			}
//		});
		// 1. 축약해서 표현
		openBtn.setOnAction(e -> {
			// 오픈할 파일을 찾아서 그 내용을 textarea에 출력
			textarea.clear(); // textarea의 내용을 다 지워요! 새로운 내용을 넣어야 하기 때문에
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("오픈할 파일을 선택해주세요!");
			file = fileChooser.showOpenDialog(primaryStage);
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while ((line=br.readLine()) != null) {
					printMsg(line); // 메서드로 빼서 사용 -> closure의 기능(JS에서의 함수형 특성)
				}
				br.close(); // 사용된 리소스 해제 (통로 닫아주기)
				
			} catch (FileNotFoundException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}

		});
		
		saveBtn = new Button("파일 저장");
		saveBtn.setPrefSize(150,40);
		
		saveBtn.setOnAction(e-> {
			String text = textarea.getText();
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(text);
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setColumnHalignment(HPos.CENTER); // 가운데 정렬
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10); //  컴포넌트 간 간격
		
		// flowPane에 버튼을 붙여요
		flowPane.getChildren().add(openBtn);
		flowPane.getChildren().add(saveBtn);
		
		root.setBottom(flowPane);
		
		// Scene 객체를 생성
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("메모장");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(); // 내부적으로 스레드가 생성되는 static 메서드
	}

	
}
