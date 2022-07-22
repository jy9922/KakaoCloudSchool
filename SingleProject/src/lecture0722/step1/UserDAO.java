/* UserDao.java */
package lecture0722.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	// 사용자 정보를 insert 처리
	// Exception 처리를 던지게 해서 무분별한 try-catch를 없앤다.
	public void insert(User user) throws ClassNotFoundException, SQLException {
		// try - catch를 사용하지 않아요! (다른 곳에서 에러 처리)
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://localhost:3306/sqldb?charEncoding=UTF-8&serverTimezone=UTC&userSSL=false";
		Connection con = DriverManager.getConnection(jdbc_url,"root","test1234");
		
		String sql = "INSERT INTO users VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	public User select(String id) throws ClassNotFoundException, SQLException {
		// try - catch를 사용하지 않아요! (다른 곳에서 에러 처리)
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://localhost:3306/sqldb?charEncoding=UTF-8&serverTimezone=UTC&userSSL=false";
		Connection con = DriverManager.getConnection(jdbc_url,"root","test1234");
		
		String sql = "SELECT * FROM users WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
		
	}
	
	

}
