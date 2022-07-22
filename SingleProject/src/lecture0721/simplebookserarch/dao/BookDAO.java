package lecture0721.simplebookserarch.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import lecture0721.simplebookserarch.vo.BookVO;

public class BookDAO {
	private static BasicDataSource basicDS;
	public BookDAO(){
		try {
			basicDS = new BasicDataSource();
			Properties properties = new Properties();
			
			InputStream is = new FileInputStream("resources/db.properties");
			properties.load(is); // 가지고 온 파일을 properties 객체로 받아드림
			
			basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
			basicDS.setUrl(properties.getProperty("JDBC_URL"));
			basicDS.setUsername(properties.getProperty("DB_USER"));
			basicDS.setPassword(properties.getProperty("DB_PASSWORD"));
			
			// 어떻게 설정해야 하나요?
			basicDS.setInitialSize(10);
			basicDS.setMaxTotal(10);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	public static DataSource getDataSource() {
		return basicDS;
	}
	public ArrayList<BookVO> select(String keyword) {
		ArrayList<BookVO> list = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			DataSource ds = getDataSource();
			
			try {
				
				con = ds.getConnection();
				con.setAutoCommit(false);
				
				String sql = "SELECT * FROM book WHERE btitle LIKE '%"+keyword+"%'";
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				con.commit();
				
				// ArrayList에 책 한권에 해당되는 정보를 하나씩 넣어주기
				list = new ArrayList<BookVO>();
				while (rs.next()) {
					BookVO tmp = new BookVO();

					tmp.setBtitle(rs.getString("btitle"));
					tmp.setBauthor(rs.getString("bauthor"));
					tmp.setBisbn(rs.getString("bisbn"));
					
					list.add(tmp);
				}
			
			} catch (SQLException e1) {
				System.out.println(e1);
			}
		
		} catch (Exception e2) {
			
		} finally {
			// 6. 사용한 자원을 해제해요!
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
		return list;
		
	}
	public String delete(String bisbn) {
		ArrayList<BookVO> list = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		String msg = "";
		try {
			DataSource ds = getDataSource();
			
			try {
				
				con = ds.getConnection();
				con.setAutoCommit(false);
				
				String sql = "DELETE FROM BOOK where bisbn = '"+bisbn+"'";
				pstmt = con.prepareStatement(sql);
				
				int result = pstmt.executeUpdate();
				con.commit();
				
				// ArrayList에 책 한권에 해당되는 정보를 하나씩 넣어주기
				if (result >= 1) {
					msg = "삭제 완료!\n";
				} else {
					msg = "/n 삭제 할 자료가 없습니다..!/n";
				}
			
			} catch (SQLException e1) {
				System.out.println(e1);
			}
		
		} catch (Exception e2) {
			
		} finally {
			// 6. 사용한 자원을 해제해요!
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
		return msg;

	}
}
