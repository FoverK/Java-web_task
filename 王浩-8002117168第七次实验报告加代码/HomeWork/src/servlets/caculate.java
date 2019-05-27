package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JavaBean.Complex;

/**
 * Servlet implementation class caculate
 */
public class caculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public caculate() {
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
		double rno1 = Double.parseDouble(request.getParameter("rno1"));
		double vno1 = Double.parseDouble(request.getParameter("vno1"));
		double rno2 = Double.parseDouble(request.getParameter("rno2"));
		double vno2 = Double.parseDouble(request.getParameter("vno2"));
		String oper = request.getParameter("oper");
		Complex a = new Complex(rno1,vno1);
		Complex b = new Complex(rno2,vno2);
		Complex c = new Complex();
		if(oper.equals("+")) {
			c = a.add(b);
		}else if(oper.equals("-")) {
			c = a.sub(b);
		}else if(oper.equals("/")) {
			c = a.mul(b);
		}else {
			c = a.div(b);
		}
		request.setAttribute("output", c.getInfor());
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

}
