package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받고
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		// 2. 로직처리
		// 	  로직처리하기 위해서 서비스 객체를 생성(service class가 필요)
		//    client에서 입력받은 데이터를 service에 전달하기 위해 VO가 필요하다
		//    VO를 만들기 위해 class가 있어야 한다
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		MemberService service = new MemberService();
		member = service.login(member);
		// 3. 출력
		// 로그인에 성공하면 vo객체 안에 로그인한 사람의 이름이 들어가 있다
		if (member != null) {
			// 로그인에 성공하면 JSP 이용해서 출력해야 해요!
			// member VO 객체를 JSP에게 전달해야 해요
			// 즉, Controller servlet이 request를 전달해서 다른 servlet(JSP)을 호출
			// 여기서는 경로가 context root까지 잡히는 점 주의하자!
			RequestDispatcher rd = request.getRequestDispatcher("/member/loginSuccess.jsp");
			request.setAttribute("member", member); // 결과 데이터를 붙여서 보내줘야 한다
			rd.forward(request, response);
		}else {
			// 내가 가지고 있는 오류에 관련된 HTML을 적으면 된다.
			// context root부터 경로를 적어준다.
			response.sendRedirect("/book/member/loginfail.html");
		}
	}
}
