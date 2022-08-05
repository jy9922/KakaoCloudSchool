package book.service;

import java.util.ArrayList;

import book.dao.BookDAO;
import book.vo.Book;

public class BookService {
	
	
	public ArrayList<Book> searchByKeyword(String keyword){
		ArrayList<Book> list = null;
		try {
			BookDAO dao = new BookDAO();
			list = dao.select(keyword);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
}
