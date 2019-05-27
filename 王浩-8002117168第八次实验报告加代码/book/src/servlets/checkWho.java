package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import javabean.User;

/**
 * Servlet implementation class checkWho
 */
@WebServlet("/checkWho")
public class checkWho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkWho() {
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
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		User user = new User();
		UserDAO ud = new UserDAO();
		try {
			user = ud.selectUser(username);
			if(user == null) {
				request.getRequestDispatcher("login_fail.jsp").forward(request, response);
			}
			else if(user.getPassword().equals(password) && username.equals("admin")) {
				request.getRequestDispatcher("admin_manage.jsp").forward(request, response);
			}else if(user.getPassword().equals(password)) {
				session.setAttribute("username", username);
				request.getRequestDispatcher("user_manage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
