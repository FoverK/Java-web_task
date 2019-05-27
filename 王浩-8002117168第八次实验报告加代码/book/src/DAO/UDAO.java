package DAO;

import javabean.User;

public interface UDAO {
	public int deleteUser(String username) throws Exception;
	public User selectUser(String username) throws Exception;
}
