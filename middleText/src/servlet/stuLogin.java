package servlet;
import stuOperate.*;
import test.GeneratePaper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import JavaBean.Student;

/**
 * Servlet implementation class stuLogin
 */
@WebServlet("/stuLogin")
public class stuLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stuLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		stuOperate so = new stuOperate();
		Student s;
		GeneratePaper gp = new GeneratePaper();
		gp.gQuestion();
		session.setAttribute("name", name);
		session.setAttribute("question", gp.getQuestion());
		session.setAttribute("answer", gp.getAnswer());
		try {
			s = so.selectStudent(name);
			if(password.equals(s.getPassword())){
				request.getRequestDispatcher("test.jsp").forward(request, response);
		}else {
				request.getRequestDispatcher("failLogin.jsp").forward(request, response);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
