package DAO;

import java.util.List;

import javabean.BorrowBook;

//�����ɾ��������û��������Ľӿ�
public interface BIDAO {
	public void insertBorrowInfo(BorrowBook bb) throws Exception;
	public void deleteBorrowInfo(BorrowBook bb) throws Exception;
	public List<BorrowBook> selectAllInfo() throws Exception;
	public List<BorrowBook> getInfo(String username) throws Exception;
}
