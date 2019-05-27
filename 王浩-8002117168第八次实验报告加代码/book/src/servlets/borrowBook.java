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
import javabean.Borrow;
import javabean.BorrowBook;

/**
 * Servlet implementation class borrowBook
 */
@WebServlet("/borrowBook")
public class borrowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String[] borrowBook = request.getParameterValues("book");
		int length = borrowBook.length;
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		BorrowDAO bd = new BorrowDAO();
		Borrow b = new Borrow();
		BorrowInfoDAO bi = new BorrowInfoDAO();
		try {
			b = bd.selectInfo(username);
			if(b.getBnum()+length <= 8) {
				for(int i = 0;i<length;i++) {
					BorrowBook bb = new BorrowBook();
					bb.setUsername(username);
					bb.setBname(borrowBook[i]);
					bi.insertBorrowInfo(bb);
					bd.updateBorrowBook(username);
				}
				request.getRequestDispatcher("success_borrow.jsp").forward(request, response);
			}else {
				System.out.printf("无法借书，所借书的数量大于8！");
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
