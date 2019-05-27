package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import JDBC.DBConnection;
import javabean.User;

public class UserDAO implements UDAO{
	private String DELECT_SQL = "delete from user where username = ?";
	private String SELECT_SQL = "select * from user where username = ?";
	private String INSERT_SQL = "insert into user values(?,?)";
	
	public int deleteUser(String username) throws Exception {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(DELECT_SQL);
		ResultSet rs = null;
		ps.setString(1, username);
		if(ps.executeUpdate() == 1) {
			DBConnection.free(rs, ps, conn);
			return 1;
		}else {
			DBConnection.free(rs, ps, conn);
			return 0;
		}
	}
	public User selectUser(String username) throws Exception{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_SQL);
		ResultSet rs = null;
		ps.setString(1, username);
		rs = ps.executeQuery();
		User user = new User();
		if(rs.next()) {
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
		}else {
			return null;
		}
		return user;
	}
	
	public void insertUser(User u) throws Exception{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
		ResultSet rs = null;
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}

}
