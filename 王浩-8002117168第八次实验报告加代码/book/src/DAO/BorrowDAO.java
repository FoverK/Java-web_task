package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import JDBC.DBConnection;
import javabean.Borrow;


//��¼���������û���

public class BorrowDAO implements BDAO{          
	private String UPDATEADD_SQL = "update borrow set bnum = bnum + 1 where username = ?";
	private String UPDATESUB_SQL = "update borrow set bnum = bnum - 1 where username = ?";
	private String INSERT_SQL = "insert into borrow values(?,?)";
	private String SELECT_SQL = "select * from borrow where username = ?";
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public void updateBorrowBook(String username) throws Exception {//�������
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(UPDATEADD_SQL);
		ps.setString(1, username);
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}

	public void updateReturnBook(String username) throws Exception {//�������
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(UPDATESUB_SQL);
		ps.setString(1, username);
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}
	
	public void insertInfo(String username) throws Exception{//���û���¼ʱ���ͽ���ʼ��
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(INSERT_SQL);
		ps.setString(1, username);
		ps.setInt(2, 0);
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}
	
	public Borrow selectInfo(String username) throws Exception{//���û����������ڽ���ĸ���
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
