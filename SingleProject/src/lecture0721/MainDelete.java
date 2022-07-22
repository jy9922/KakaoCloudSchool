package lecture0721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainDelete {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver Loading
			// MySQL 8.0부터는 아래의 class를 이용해요!
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
			// 2. 데이터베이스 연결
			String jdbcURL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			con = DriverManager.getConnection(jdbcURL, "root", "test1234");
			System.out.println("데이터 베이스 연결 성공!");
			
			con.setAutoCommit(false); // transaction의 시작
			
			// PreparedStatement는 IN Parameter를 사용할 수 있어요. (여러개 사용 가능, 값이 매핑되는 곳에만 사용 가능)
			String sql = "DELETE FROM buytbl WHERE userID = ?";
			// 3. Statement 생성
			// PreparedStatement 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "BBK"); // (물음표 순서(DBMS표준 : 1부터 시작), 넣을 값)
			
			// 4. 실행
//			rs1 = stmt.executeQuery(sql); // 일반 statement와 짝을 이룸
//			rs2 = pstmt.executeQuery(); // preparedStatement와 짝을 이룸 (sql문 올리지 않음)
			int result = pstmt.executeUpdate();
			
			// 5. 결과처리
			System.out.println("총" + result + "개 행이 삭제되었습니다.");
			
			con.rollback(); // transaction이 종료
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
			System.out.println(e2);
		} finally {
			// 6. 사용한 자원을 해제해요!
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
