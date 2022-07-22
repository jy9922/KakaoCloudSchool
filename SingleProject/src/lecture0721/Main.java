package lecture0721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC Driver Loading
			// MySQL 8.0부터는 아래의 class를 이용해요!
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
			// 2. 데이터베이스 연결
			String jdbcURL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			con = DriverManager.getConnection(jdbcURL, "root", "test1234");
			System.out.println("데이터 베이스 연결 성공!");
			
			String sql = "SELECT * FROM usertbl";
			// 3. Statement 생성
			stmt = con.createStatement();
			// PreparedStatement 생성
			pstmt = con.prepareStatement(sql);
			
			// 4. 실행
//			rs1 = stmt.executeQuery(sql); // 일반 statement와 짝을 이룸
//			rs2 = pstmt.executeQuery(); // preparedStatement와 짝을 이룸 (sql문 올리지 않음)
			rs = pstmt.executeQuery();
			
			// 5. 결과처리
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String addr = rs.getString(4);
				System.out.println(id + ", " + name + ", " + addr);
			}
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
			System.out.println(e2);
		} finally {
			// 6. 사용한 자원을 해제해요!
			try {
				if (rs != null) rs.close();
//				if (stmt != null) stmt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
