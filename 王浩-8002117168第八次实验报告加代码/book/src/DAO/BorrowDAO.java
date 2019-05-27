package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import JDBC.DBConnection;
import javabean.Borrow;


//记录借书数和用户名

public class BorrowDAO implements BDAO{          
	private String UPDATEADD_SQL = "update borrow set bnum = bnum + 1 where username = ?";
	private String UPDATESUB_SQL = "update borrow set bnum = bnum - 1 where username = ?";
	private String INSERT_SQL = "insert into borrow values(?,?)";
	private String SELECT_SQL = "select * from borrow where username = ?";
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public void updateBorrowBook(String username) throws Exception {//借书操作
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(UPDATEADD_SQL);
		ps.setString(1, username);
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}

	public void updateReturnBook(String username) throws Exception {//还书操作
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(UPDATESUB_SQL);
		ps.setString(1, username);
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}
	
	public void insertInfo(String username) throws Exception{//在用户登录时，就将初始化
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(INSERT_SQL);
		ps.setString(1, username);
		ps.setInt(2, 0);
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}
	
	public Borrow selectInfo(String username) throws Exception{//按用户名查找现在借书的个数
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(SELECT_SQL);
		ps.setString(1, username);
		rs = ps.executeQuery();
		Borrow b = new Borrow();
		if(rs.next()){
			b.setUsername(username);
			b.setBnum(rs.getInt(2));
		}
		DBConnection.free(rs, ps, conn);
		return b;
	}

}
