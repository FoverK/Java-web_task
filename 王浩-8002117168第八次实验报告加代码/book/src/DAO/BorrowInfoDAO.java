package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBConnection;
import javabean.BorrowBook;

//插入和删除借书的用户和书名
public class BorrowInfoDAO implements BIDAO{
	private String INSERTINFO_SQL = "insert into borrow_book values(?,?)";
	private String DELETEINFO_SQL = "delete from borrow_book where username = ? and bname = ?";
	private String SELECTALL_SQL  = "select * from borrow_book";
	private String SELECT_SQL  = "select * from borrow_book where username = ?";
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public void insertBorrowInfo(BorrowBook bb) throws Exception {//插入借书信息
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(INSERTINFO_SQL);
		ps.setString(1, bb.getUsername());
		ps.setString(2, bb.getBname());
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}

	public void deleteBorrowInfo(BorrowBook bb) throws Exception {//删除借书信息
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(DELETEINFO_SQL);
		ps.setString(1, bb.getUsername());
		ps.setString(2, bb.getBname());
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}
	
	public List<BorrowBook> selectAllInfo() throws Exception{//查询所有借书信息
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(SELECTALL_SQL);
		rs = ps.executeQuery();
		
		List<BorrowBook> b_list = new ArrayList<BorrowBook>();
		while(rs.next()) {
			BorrowBook bb = new BorrowBook();
			bb.setUsername(rs.getString(1));
			bb.setBname(rs.getString(2));
			b_list.add(bb);
		}
		DBConnection.free(rs, ps, conn);
		return b_list;
	}

	public List<BorrowBook> getInfo(String username) throws Exception {
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(SELECT_SQL);
		ps.setString(1, username);
		rs = ps.executeQuery();
		
		List<BorrowBook> b_list = new ArrayList<BorrowBook>();
		while(rs.next()) {
			BorrowBook bb = new BorrowBook();
			bb.setUsername(rs.getString(1));
			bb.setBname(rs.getString(2));
			b_list.add(bb);
		}
		DBConnection.free(rs, ps, conn);
		return b_list;
	}
}
