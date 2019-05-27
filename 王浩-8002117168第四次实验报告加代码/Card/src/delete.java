

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.Card;
import JavaBean.Card_operate;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
		String item = request.getParameter("item");
		Card c = new Card();
		String select = request.getParameter("select");
		if(select.equals("name")){
			c.setName(item);
			n = 0;
		}else if(select.equals("sex")){
			c.setSex(item);
			n = 1;
		}else if(select.equals("age")){
			int age = Integer.parseInt(item);
			c.setAge(age);
			n = 2;
		}else if(select.equals("address")){
			c.setAddr(item);
			n = 3;
		}else{
			c.setTel(item);
			n = 4;
		}
		Card_operate co = new Card_operate();
		try {
			co.deleteCard(c, n);
			request.getRequestDispatcher("operate_success.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
