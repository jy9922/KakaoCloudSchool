package user.service;

import user.dao.UserDAO;
import user.vo.User;

public class UserService {
	
	public String insert(User user) {
		String msg = "";
		try {
			UserDAO dao = new UserDAO();
			msg = dao.insert(user);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return msg;
	}
	
	public User select(User user) {
		try {
			UserDAO dao = new UserDAO();
			user = dao.select(user);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return user;
		
	}
}
