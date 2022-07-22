package lecture0722.step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
	
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://localhost:3306/sqldb?charEncoding=UTF-8&serverTimezone=UTC&userSSL=false";
		Connection con = DriverManager.getConnection(jdbc_url,"root","test1234");
		return con;
	}
	
}
