package lecture0725;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 여러 thread에 의해 공용된다. (필드는 공용됨)
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받고 (request 객체를 받아야 함)
		// 한가지 주의해야 할 점은... 입력을 받을 때 사용되는 Stream의 encoding이 ISO-8859-1 (한글이 깨짐)
		// 만약 한글 데이터를 전달받으려면 약간의 처리를 해 주어야 해요!
		// - 만약 GET방식인 경우, Tomcat의 입력 stream의 encoding을 변경해줘야 한다. (server-tomcat-server.xml 수정)
		String email = request.getParameter("userEmail");
		String pw = request.getParameter("userPassword");
		// 2. 로직처리
		// 입력된 email과 password가 database table에 존재하는지 확인!
		// JDBC code
		String jdbcURL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginStatus = false;
		try {
			con = DriverManager.getConnection(jdbcURL, "root", "test1234");
			String sql = "SELECT * FROM tmpuser where email=? and password=?";
	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
		
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				loginStatus = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close 처리 진행
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		// 3. 출력처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(response.getOutputStream());
		if (loginStatus) {
			out.println("환영합니다!"); }
		else {
			out.println("로그인에 실패했습니다");	
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// - 만약 POST방식인 경우,
//		request.setCharacterEncoding("EUC-KR");
	}

}
