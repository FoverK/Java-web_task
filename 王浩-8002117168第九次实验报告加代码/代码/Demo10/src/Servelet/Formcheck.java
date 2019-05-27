package Servelet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Formcheck
 */
@WebServlet("/formcheck")
public class Formcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formcheck() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String userid=request.getParameter("userid");
		char u[]=userid.toCharArray();
		if(u[0]<'A'||(u[0]>'Z'&&u[0]<'a')||u[0]>'z'){
			out.println("用户名需要字母开头");
		}		
		if(u.length<5){
			out.println("用户名至少6位");
		}
		else{
		for(int i=1;i<u.length;i++){
			if(u[i]<48||(u[i]>57&&u[i]<64)||(u[i]>90&&u[i]<97)||u[i]>122){
				out.println("用户名格式不对");
			}
		}	
		if("a12345".equals(userid) || "b12345".equals(userid)){
			out.println("用户名已存在");
		}
		else{
			String userpwd=request.getParameter("userpwd");
			String userpwd_1=request.getParameter("userpwd_1");
			if(!"".equals(userpwd) && !"".equals(userpwd_1)){
				char []p=userpwd.toCharArray();
				int flag=1;
				if(p.length<5||p.length>9){
					out.println("密码必须为6~10位");
				}
				else{
					for(int i=0;i<p.length;i++){
						if(p[i]<'0'||p[i]>'9'){
							out.println("密码必须由数字组成");
							flag=0;
							break;
						}
					}
				if(userpwd.equals(userpwd_1)&&flag==1)
					out.println("注册成功");
				else if(flag==1){
					out.println("两次输入的密码不一致，注册失败");		
				}
				
			}	
			}	
		}
	}
	}
}
