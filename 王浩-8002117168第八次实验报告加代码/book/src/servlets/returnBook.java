package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BorrowDAO;
import DAO.BorrowInfoDAO;
import javabean.BorrowBook;

/**
 * Servlet implementation class returnBook
 */
@WebServlet("/returnBook")
public class returnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public returnBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String[] returnBook = request.getParameterValues("book");
		int length = returnBook.length;
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		BorrowDAO bd = new BorrowDAO();//对借书记录数的操作
		BorrowInfoDAO bi = new BorrowInfoDAO();//对借书信息的操作
		try{
			for(int i = 0;i<length;i++) {
				BorrowBook bb = new BorrowBook();//借书信息
				bb.setUsername(username);
				bb.setBname(returnBook[i]);
				bi.deleteBorrowInfo(bb);
				bd.updateReturnBook(username);
				request.getRequestDispatcher("success_return.jsp").forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
