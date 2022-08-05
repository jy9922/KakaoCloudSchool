package book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.service.BookService;
import book.vo.Book;

/**
 * Servlet implementation class BookSearchController
 */
@WebServlet("/bsearch")
public class BookSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력
		String keyword = request.getParameter("keyword");
		// 2. 서비스를 이용한 로직처리
		BookService service = new BookService();
		
		ArrayList<Book> list = service.searchByKeyword(keyword);
		// 3. 결과처리(View 처리)
		if (list != null) {
			// 성공
			// list를 jsp에게 전달해서 결과를 클라이언트에게 전송
			RequestDispatcher rd = request.getRequestDispatcher("/book/bookSearchResult.jsp");
			request.setAttribute("result", list);
			rd.forward(request, response);
		} else {
			// error
			// 오류페이지를 만들어서 사용자에게 redirect
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
