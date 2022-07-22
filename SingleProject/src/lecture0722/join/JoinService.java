package lecture0722.join;

import java.sql.SQLException;
import java.util.ArrayList;


public class JoinService {
	private UserDAO dao;
	private User user;
	
	ConnectionMaker connectionMaker = new NUserDAO();
	
	public JoinService() {
		this.dao = new UserDAO(connectionMaker);
	}
	public void userJoin(String id, String name, String pwd) throws ClassNotFoundException, SQLException{
		user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(pwd);
		
		dao.insert(user);
	}
	public User userSearch(String id) throws ClassNotFoundException, SQLException{
		User result = dao.select(id);
		return result;
	}
	
	
}
