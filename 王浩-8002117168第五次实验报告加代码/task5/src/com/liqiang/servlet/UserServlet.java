package com.liqiang.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liqiang.bean.User;
import com.liqiang.dao.UserDao;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int method = Integer.parseInt(request.getParameter("method"));
		
		if(method == 0) {
			queryAllUserInfo(request,response);
		}
		/*
		 * 添加用户
		 * */
		else if(method == 1) 
		{
			addUser(request,response);
		}
		/*
		 * 删除用户
		 * */
		else if(method == 2) 
		{
			deleteUser(request,response);
		}
		
		/*
		 * 修改用户
		 * */
		else if(method == 3) 
		{
			updateUser(request,response);
		}
		/*
		 * 查询用户
		 * */
		else if(method == 4) 
		{
			selectUser(request,response);
		}
		/*
		 * 得到特定ID的用户对象
		 * */
		else if(method == 5)
		{
			queryUserInfo(request,response);
		}
		
	}
	
	public void queryAllUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		ArrayList<User> entities = new ArrayList<User>();
		entities = dao.queryAllUserInfo();
		request.setAttribute("entities", entities);
	}
	
	
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		user.setUserid(userid);
		user.setUsername(username);
		user.setSex(sex);
		UserDao dao = new UserDao();
		dao.addUser(user);
		queryAllUserInfo(request,response);
		request.getRequestDispatcher("show1.jsp").forward(request, response);
	}
	
	
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UserDao dao = new UserDao();
		dao.deleteUser(userid);
		queryAllUserInfo(request,response);
		request.getRequestDispatcher("show1.jsp").forward(request, response);
	}
	
	
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		user.setUserid(userid);
		user.setUsername(username);
		user.setSex(sex);
		
		UserDao dao = new UserDao();
		
		dao.updateUser(user);
		queryAllUserInfo(request,response);
		request.getRequestDispatcher("show1.jsp").forward(request, response);
	}
	
	
	public void selectUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UserDao dao = new UserDao();
		User user = dao.selectUser(userid);
		request.setAttribute("user", user);
		request.getRequestDispatcher("selectUser.jsp").forward(request, response);
	}
	
	public void queryUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UserDao dao = new UserDao();
		User user = dao.selectUser(userid);
		request.setAttribute("user", user);
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
	}

}
