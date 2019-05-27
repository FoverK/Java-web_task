package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LibraryDAO;
import javabean.Book;

/**
 * Servlet implementation class updateBook
 */
@WebServlet("/updateBook")
public class updateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateBook() {
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
		String bname = request.getParameter("bname");
		String bid = request.getParameter("bid");
		String author = request.getParameter("author");
		double price = Double.parseDouble(request.getParameter("price"));
		String addition = request.getParameter("addition");
		Book book = new Book();
		HttpSession session = request.getSession(true);
		book.setAddition(addition);
		book.setAuthor(author);
		book.setBid(bid);
		book.setBname(bname);
		book.setPrice(price);
		LibraryDAO ld = new LibraryDAO();
		try {
			if(ld.updateBook(book, (String) session.getAttribute("bid")) == 1) {
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
