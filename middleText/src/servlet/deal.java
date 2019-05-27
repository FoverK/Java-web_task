package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import JavaBean.*;
import stuOperate.stuOperate;

/**
 * Servlet implementation class deal
 */
@WebServlet("/deal")
public class deal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deal() {
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
		int grade = 0;
		int sure = 0;
		int error = 0;
		HttpSession session = request.getSession(true);
		
		String r[] = request.getParameterValues("result");
		int[] result =new int[r.length] ;
		for(int i = 0 ;i<r.length;i++) {
			result[i] = 0;
		}
		for(int i = 0 ;i<r.length;i++) {
			result[i] = Integer.parseInt(r[i]);
		}
		int[] correctAnswer = (int[]) session.getAttribute("answer");
		int totalQuestion = correctAnswer.length;
		int n = 100/totalQuestion;
		for(int i = 0;i<totalQuestion;i++) {
				if(correctAnswer[i] == result[i]) {
					grade = grade + n;
					sure++;
				}else {
					error++;
				}
		}
		Stu_Grade sg = new Stu_Grade((String)session.getAttribute("name"),grade);
		stuOperate so = new stuOperate();
		List<Stu_Grade> sg_list = new ArrayList<Stu_Grade>();
		try {
			if(so.selectGrade(sg.getName()) == null)
					so.insertGrade(sg);
			else
					so.updateGrade(sg);
					sg_list = so.orderbyGrade();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("sg_list", sg_list);
		request.setAttribute("quesNum", totalQuestion);
		request.setAttribute("grade", grade);
		request.setAttribute("sure", sure);
		request.setAttribute("error", error);
		request.getRequestDispatcher("show_Grade.jsp").forward(request, response);
	}

}
