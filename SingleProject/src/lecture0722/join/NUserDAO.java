package lecture0722.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// naver쪽 개발자가 해당 비즈니스 로직을 사용하기위해
// 인터페이스를 구현한 class를 만든
public class NUserDAO implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://localhost:3306/sqldb?charEncoding=UTF-8&serverTimezone=UTC&userSSL=false";
		Connection con = DriverManager.getConnection(jdbc_url,"root","test1234");
		return con;
	}
	
}

