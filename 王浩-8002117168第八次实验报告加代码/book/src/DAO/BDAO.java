package DAO;

import javabean.Borrow;

public interface BDAO {//��¼�������ͻ������Ľӿ�
	public void updateBorrowBook(String username) throws Exception;
	public void updateReturnBook(String username) throws Exception;
	public void insertInfo(String username) throws Exception;
	public Borrow selectInfo(String username) throws Exception;
}
