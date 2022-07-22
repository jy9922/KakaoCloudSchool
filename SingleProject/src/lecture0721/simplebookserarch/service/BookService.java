package lecture0721.simplebookserarch.service;

import java.util.ArrayList;

import lecture0721.simplebookserarch.dao.BookDAO;
import lecture0721.simplebookserarch.vo.BookVO;

public class BookService {
	// 해야할 일 : 검색, 삭제
	private BookDAO dao;
	
	public BookService() {
		this.dao = new BookDAO();
	}
	public ArrayList<BookVO> bookSearchByKeyword(String keyword) {
		// 키워드를 이용해서 책을 찾는 로직 처리
		// for, if 등 다양한 로직처리가 일반적으로 나오는데
		// 우리는 Database 처리를 해야 한다.
		ArrayList<BookVO> result = dao.select(keyword);
		return result;
		
	}
	public String bookDeleteByISBN(String bisbn) {
		// 책 고유번호를 받아서 해당 책을 삭제하는 로직 처리
		String result = dao.delete(bisbn);
		return result;
	}
}
