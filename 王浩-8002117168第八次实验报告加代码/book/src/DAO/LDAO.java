package DAO;

import java.util.List;

import javabean.Book;

public interface LDAO {//图书馆内书的管理
	public int insertBook(Book book) throws Exception;
	public Book selectBook(String bid) throws Exception;
	public List<Book> selectAllBook() throws Exception;
	public int updateBook(Book book,String bid) throws Exception;
	public int deleteBook(String bid) throws Exception;
	
}
