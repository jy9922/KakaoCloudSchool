package post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import post.vo.Post;

public class PostDAO {
	private DataSource ds;
	
	public PostDAO() throws Exception{
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	
	public ArrayList<Post> search() throws Exception{
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공!");
		
		String sql = "SELECT * FROM user_board";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Post> list = new ArrayList<Post>();
		
		while(rs.next()) {
			Post post = new Post();
			post.setBnum(rs.getInt("bnum"));
			post.setBtitle(rs.getString("btitle"));
			post.setBid(rs.getString("bid"));
			post.setBdetail(rs.getString("bdetail"));
			post.setBdate(rs.getString("bdate"));
			post.setBlike(rs.getInt("blike"));
			post.setBview(rs.getInt("bview"));
			post.setBcount(rs.getInt("bcount"));
			
			list.add(post);
		}
		return list;
	}

	public String insert(Post post) throws Exception {
		String msg = "";
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공!");
		
		String sql = "INSERT INTO user_board (btitle, bid, bdetail, bdate, blike, bview, bcount) VALUES (?,?,?,now(),?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, post.getBtitle());
		pstmt.setString(2, post.getBid());
		pstmt.setString(3, post.getBdetail());
		pstmt.setInt(4, post.getBlike());
		pstmt.setInt(5, post.getBview());
		pstmt.setInt(6, post.getBcount());
		
		int result = pstmt.executeUpdate();
		if (result >= 1) {
			msg = "success";
		} else {
			msg = "fail";
		}
		return msg;
	}

	public Post search_detail(int bnum) throws Exception {
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공!");
		
		String sql = "SELECT * FROM user_board WHERE bnum=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bnum);
		
		ResultSet rs = pstmt.executeQuery();
		Post post = new Post();
		
		if(rs.next()) {
			post.setBnum(rs.getInt("bnum"));
			post.setBtitle(rs.getString("btitle"));
			post.setBid(rs.getString("bid"));
			post.setBdetail(rs.getString("bdetail"));
			post.setBdate(rs.getString("bdate"));
			post.setBlike(rs.getInt("blike"));
			post.setBview(rs.getInt("bview"));
			post.setBcount(rs.getInt("bcount"));
			
			return post;
		}
		return null;
		
		
	}

	public String modify(Post post) throws Exception{
		// TODO Auto-generated method stub
		String msg = "";
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공!");
		
		String sql = "UPDATE user_board SET btitle=?, bdetail=?, bdate=now() WHERE bNum=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, post.getBtitle());
		pstmt.setString(2, post.getBdetail());
		pstmt.setInt(3, post.getBnum());
		
		int result = pstmt.executeUpdate();
		if (result >= 1) {
			msg = "success";
		} else {
			msg = "fail";
		}
		return msg;
	
	}

	

}
