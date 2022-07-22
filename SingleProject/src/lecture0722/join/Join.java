package lecture0722.join;

import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Join extends Application {
	TextArea textarea;
	Button connBtn, connBtn2;
	TextField idField, nameField, pwdField;
	
	
	private static BasicDataSource basicDS;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// service 객체
		JoinService service = new JoinService();
		
		// 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // window 크기
		
		textarea = new TextArea();
		root.setCenter(textarea); // 화면 center에 textarea를 붙여요!
		
		idField = new TextField();
		idField.setPrefSize(120, 40);
		
		nameField = new TextField();
		nameField.setPrefSize(120, 40);
		
		pwdField = new TextField();
		pwdField.setPrefSize(120, 40);
		
		connBtn = new Button("회원가입");
		connBtn.setPrefSize(130, 40); // 버튼의 크기
		connBtn.setOnAction(e ->{
			textarea.clear();
			try {
				service.userJoin(idField.getText(), nameField.getText(), pwdField.getText());
				textarea.appendText("새 사용자 등록");
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
//			ArrayList<BookVO> result = service.bookSearchByKeyword(idField.getText());
//			for(BookVO i: result) {
//				textarea.appendText(i.getBtitle()+", "+i.getBauthor()+", "+i.getBisbn()+"\n");
//			}
	
		});
		
		
		connBtn2 = new Button("id로 검색");
		connBtn2.setPrefSize(130, 40); // 버튼의 크기
		connBtn2.setOnAction(e ->{
//			textarea.clear();
//			String result = service.bookDeleteByISBN(idField.getText());
//			textarea.appendText(result);
			try {
				User user = service.userSearch(idField.getText());
				textarea.appendText(user.getName()+" "+user.getPassword());
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		});
		
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10)); // 여백을 줘요!
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn); // 버튼 부착
		flowPane.getChildren().add(idField); // 입력상자 부착
		flowPane.getChildren().add(nameField);
		flowPane.getChildren().add(pwdField);
		flowPane.getChildren().add(connBtn2);
		
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
