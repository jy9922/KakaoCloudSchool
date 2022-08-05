package post.service;

import java.util.ArrayList;

import post.dao.PostDAO;
import post.vo.Post;

public class PostService {

	public ArrayList<Post> select() {
		ArrayList<Post> list = null; 
		try {
			PostDAO dao = new PostDAO();
			list = dao.search();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}

	public String insert(Post post) {
		// TODO Auto-generated method stub
		String msg = "";
		try {
			PostDAO dao = new PostDAO();
			msg = dao.insert(post);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return msg;
	}

	public Post select_detail(int bnum) {
		Post post = new Post();
		try {
			PostDAO dao = new PostDAO();
			post = dao.search_detail(bnum);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return post;
	}

	public String modify(Post post) {
		String msg = "";
		try {
			PostDAO dao = new PostDAO();
			msg = dao.modify(post);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return msg;
		
	}
 
}
