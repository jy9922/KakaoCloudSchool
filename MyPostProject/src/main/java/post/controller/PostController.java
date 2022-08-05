package post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import post.service.PostService;
import post.vo.Post;
import user.vo.User;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String btitle = request.getParameter("btitle");
		String bdetail = request.getParameter("bdetail");
		
		Post post = new Post();
		post.setBid(userid);
		post.setBcount(0);
		post.setBlike(0);
		post.setBtitle(btitle);
		post.setBdetail(bdetail);
		post.setBview(0);
		post.setBdate(bdetail);
		
		PostService service = new PostService();
		String msg = service.insert(post);
		ArrayList<Post> list = service.select();
		
		if (msg.equals("success")) {
			RequestDispatcher rd = request.getRequestDispatcher("/board/board_index.jsp");
			User user = (User)session.getAttribute("user");
			session.setAttribute("user", user);
			request.setAttribute("post", list);
			rd.forward(request, response);
		}else {
			response.sendRedirect("/post/board/insert.jsp");
		}
	}

}
