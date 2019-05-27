package DAO;

import javabean.Borrow;

public interface BDAO {//记录借书数和还书数的接口
	public void updateBorrowBook(String username) throws Exception;
	public void updateReturnBook(String username) throws Exception;
	public void insertInfo(String username) throws Exception;
	public Borrow selectInfo(String username) throws Exception;
}
