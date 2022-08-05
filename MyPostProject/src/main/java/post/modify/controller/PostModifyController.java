package post.modify.controller;

import java.io.IOException;

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
 * Servlet implementation class PostModifyController
 */
@WebServlet("/modify")
public class PostModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int bnum = Integer.parseInt(request.getParameter("bNum"));
		Post post = new Post();
		post.setBnum(bnum);
		
		PostService service = new PostService();
		post = service.select_detail(bnum);
		
		if (post != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/board/board_modify.jsp");
			User user = (User) session.getAttribute("user");
			session.setAttribute("user", user);
			System.out.println(user.getId());
			request.setAttribute("post", post);
			rd.forward(request, response);
		} else {
			response.sendRedirect("/post/board/board_modify");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
