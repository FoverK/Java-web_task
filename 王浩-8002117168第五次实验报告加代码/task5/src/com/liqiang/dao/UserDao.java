package com.liqiang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.liqiang.bean.User;
import com.liqiang.util.DataSourceUtils;

public class UserDao {
	
    private static DataSourceUtils db;
    private String sql;
    
	public UserDao() {
		 db  = new DataSourceUtils();
	}
	
	
	public void addUser(User user){
		sql = "insert into user values(?,?,?)";
		Connection conn = db.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getUserid());
			ps.setObject(2, user.getUsername());
			ps.setObject(3, user.getSex());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close();
		}
	}
	
	public void deleteUser(String userid) {
		sql = "delete from user where userid = ?";
		Connection conn = db.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1,userid);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close();
		}
	}
	
	public void updateUser(User user) {
		sql = "update user set username = ?,sex = ? where userid = ?";
		Connection conn = db.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, user.getUsername());
			ps.setObject(2, user.getSex());
			ps.setObject(3, user.getUserid());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close();
		}
	}
	
	public User selectUser(String userid) {
		sql = "select * from user where userid = ?";
		Connection conn = db.getConnection();
		PreparedStatement ps;
		User user = new User();
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1,userid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserid(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setSex(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close();
		}
		return user;
	}
	
	
	public ArrayList<User> queryAllUserInfo(){
		sql = "select * from user";
		ArrayList<User> list = new ArrayList<User>();
		
		Connection conn = db.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setUserid(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setSex(rs.getString(3));
				System.out.println("userid:"+user.getUserid());
				list.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close();
		}
		return  list;
	}
	
	public int check(String username,String psw)
	{
		//注意这里username和 = 得分开
		sql = "select * from tb_user where username = ? and psw = ?";
		Connection conn = db.getConnection();
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, username);
			ps.setObject(2, psw);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			
			if(count > 0)
				return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		
		return 0;
	}
}
