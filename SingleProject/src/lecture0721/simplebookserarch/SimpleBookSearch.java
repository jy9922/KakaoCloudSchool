package lecture0721.simplebookserarch;


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
import lecture0721.simplebookserarch.service.BookService;
import lecture0721.simplebookserarch.vo.BookVO;

public class SimpleBookSearch extends Application{
	TextArea textarea;
	Button connBtn, connBtn2;
	TextField textfield;
	
	
	private static BasicDataSource basicDS;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// service 객체
		BookService service = new BookService();
		
		// 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // window 크기
		
		textarea = new TextArea();
		root.setCenter(textarea); // 화면 center에 textarea를 붙여요!
		
		textfield = new TextField();
		textfield.setPrefSize(350, 40);
		
		connBtn = new Button("키워드 검색");
		connBtn.setPrefSize(150, 40); // 버튼의 크기
		connBtn.setOnAction(e ->{
			textarea.clear();
			ArrayList<BookVO> result = service.bookSearchByKeyword(textfield.getText());
			for(BookVO i: result) {
				textarea.appendText(i.getBtitle()+", "+i.getBauthor()+", "+i.getBisbn()+"\n");
			}
			textfield.clear();
		});
		
		
		connBtn2 = new Button("ISBM으로 삭제");
		connBtn2.setPrefSize(150, 40); // 버튼의 크기
		connBtn2.setOnAction(e ->{
			textarea.clear();
			String result = service.bookDeleteByISBN(textfield.getText());
			textarea.appendText(result);
			textfield.clear();
			
		});
		
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10)); // 여백을 줘요!
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn); // 버튼 부착
		flowPane.getChildren().add(textfield); // 입력상자 부착
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

