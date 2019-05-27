package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBConnection;
import javabean.Book;

public class LibraryDAO implements LDAO {
	private String INSERT_SQL = "insert into library values(?,?,?,?,?)";
	private String SELECTONE_SQL = "select * from library where bid = ?";
	private String SELECTALL_SQL = "select * from library";
	private String DELECT_SQL = "delete from library where bid = ?";
	private String UPDATE_SQL = "update library set bid = ?,bname = ?,author = ?,price = ?,addition = ? where bid = ?";
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public int insertBook(Book book) throws Exception  {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(INSERT_SQL);
		ps.setString(1, book.getBid());
		ps.setString(2, book.getBname());
		ps.setString(3, book.getAuthor());
		ps.setDouble(4, book.getPrice());
		ps.setString(5, book.getAddition());
		if(ps.executeUpdate() == 1) {
			DBConnection.free(rs, ps, conn);
			return 1;
		}else {
			DBConnection.free(rs, ps, conn);
			return 0;
		}
	}
	
	public Book selectBook(String bid) throws Exception {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(SELECTONE_SQL);
		ps.setString(1, bid);
		Book book = new Book();
		rs = ps.executeQuery();
		while(rs.next()) {
			book.setBid(rs.getString(1));
			book.setBname(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPrice(rs.getDouble(4));
			book.setAddition(rs.getString(5));	
		}
		DBConnection.free(rs, ps, conn);
		return book;
	}
	
	public List<Book> selectAllBook() throws Exception{
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(SELECTALL_SQL);
		rs = ps.executeQuery();
		List<Book> lb = new ArrayList<Book>();
		while(rs.next()) {
			Book book = new Book();
			book.setBid(rs.getString(1));
			book.setBname(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPrice(rs.getDouble(4));
			book.setAddition(rs.getString(5));
			lb.add(book);
		}
		DBConnection.free(rs, ps, conn);
		return lb;
	}
	
	public int updateBook(Book book,String bid) throws Exception{
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(UPDATE_SQL);
		ps.setString(1, book.getBid());
		ps.setString(2, book.getBname());
		ps.setString(3, book.getAuthor());
		ps.setDouble(4, book.getPrice());
		ps.setString(5, book.getAddition());
		ps.setString(6, bid);
		if(ps.executeUpdate() == 1) {
			DBConnection.free(rs, ps, conn);
			return 1;
		}else {
			DBConnection.free(rs, ps, conn);
			return 0;
		}
	}
	
	public int deleteBook(String bid) throws Exception{
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(DELECT_SQL);
		ps.setString(1, bid);
		if(ps.executeUpdate() == 1) {
			DBConnection.free(rs, ps, conn);
			return 1;
		}else {
			DBConnection.free(rs, ps, conn);
			return 0;
		}
	}
}
