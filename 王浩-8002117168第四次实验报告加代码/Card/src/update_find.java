

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JavaBean.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update_find
 */
@WebServlet("/update_find")
public class update_find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_find() {
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
		String name = request.getParameter("name");
		Card c = new Card();
		c.setName(name);
		List<Card> card = new ArrayList<Card>();
		int n = 0;
		Card_operate co = new Card_operate();
		try {
			card = co.findCard(c, n);
			if(card!=null){
				request.setAttribute("name", card.get(0).getName());
				request.setAttribute("sex", card.get(0).getSex());
				request.setAttribute("age", card.get(0).getAge());
				request.setAttribute("addr", card.get(0).getAddr());
				request.setAttribute("tel", card.get(0).getTel());
				request.getRequestDispatcher("update_card.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("noneCard.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
