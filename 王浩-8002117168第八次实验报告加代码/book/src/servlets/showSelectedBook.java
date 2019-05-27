package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class showSelectedBook
 */
@WebServlet("/showSelectedBook")
public class showSelectedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showSelectedBook() {
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
		List<BorrowBook> b_list = new ArrayList<BorrowBook>();
		BorrowInfoDAO bi = new BorrowInfoDAO();
		BorrowDAO bd = new BorrowDAO();
		Borrow b = new Borrow();
		HttpSession session = request.getSession(true);
		try {
			b = bd.selectInfo((String)session.getAttribute("username"));
			b_list = bi.getInfo((String)session.getAttribute("username"));
			request.setAttribute("b_list", b_list);
			request.setAttribute("b", b);
			request.getRequestDispatcher("showSelectedBook.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
