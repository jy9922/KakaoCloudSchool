/* UserDao.java */
package lecture0722.step5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	private ConnectionMaker connectionMaker;
	
	// 객체를 주입받아요(DI)
	public UserDAO(ConnectionMaker connectionMaker){
		// 위 인터페이스를 구현한 객체를 파라미터로 받아서
		// 직접 DAO 안에서 객체를 만들지 않고, 받아와서 사용한다
		// 클래스 내에서 다른 클래스 이름이 나오지 않는다
		// Main으로 이동 -> 객체를 인자로 넣어주어야 한다
		this.connectionMaker = connectionMaker;
	}
	
	public void insert(User user) throws ClassNotFoundException, SQLException {
		// try - catch를 사용하지 않아요! (다른 곳에서 에러 처리)
		Connection con = connectionMaker.makeConnection();
		
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
		Connection con = connectionMaker.makeConnection();
		
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
