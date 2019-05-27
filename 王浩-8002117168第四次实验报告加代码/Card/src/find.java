

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JavaBean.*;
/**
 * Servlet implementation class find
 */
@WebServlet("/find")
public class find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public find() {
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
		int n;
		Card c = new Card();
		List<Card> c1 = new ArrayList<Card>();
		Card_operate co = new Card_operate();
		String item = request.getParameter("item");
		if(request.getParameter("select").equals("name")){
			c.setName(item);
			n = 0;
		}else if(request.getParameter("select").equals("sex")){
			c.setSex(item);
			n = 1;
		}else if(request.getParameter("select").equals("age")){
			int age = Integer.parseInt(item);
			c.setAge(age);
			n = 2;
		}else if(request.getParameter("select").equals("address")){
			c.setAddr(item);
			n = 3;
		}else{
			c.setTel(item);
			n = 4;
		}
		
		try {
			c1 = co.findCard(c,n);
			request.setAttribute("allcard", c1);
			request.getRequestDispatcher("show_card.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
