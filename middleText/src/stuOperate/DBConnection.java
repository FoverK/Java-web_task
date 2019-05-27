package stuOperate;
import java.sql.*;
public class DBConnection {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "1111";
	private static String url = "jdbc:mysql://localhost:3306/user?user=" + user + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8";
	
	public DBConnection(){}
	
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		return DriverManager.getConnection(url);
	}
	
	public static void free(ResultSet rs,PreparedStatement ps,Connection conn){
		try{
			if(rs!=null)   rs.close();
			if(ps!=null)   ps.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
