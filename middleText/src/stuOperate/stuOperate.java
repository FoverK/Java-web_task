package stuOperate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JavaBean.Stu_Grade;
import JavaBean.Student;
public class stuOperate {
		private Connection conn = null;
		public PreparedStatement ps = null;
		private ResultSet rs = null;
		private String SELECT_STUDENT = "select * from student_info where Sname = ?";
		private String SELECT_GRADE = "select * from grade where Sname = ?";
		private String INSERT_GRADE = "insert into grade values(?,?)";
		private String INSERT_STUDENT = "insert into student_info values(?,?)";
		private String ORDER = "select  * from grade order by Grade";
		private String UPDATE = "update  grade  set  Grade = ? where Sname = ?";
		public Student selectStudent(String name)  throws Exception {
				conn = DBConnection.getConnection();
				ps = conn.prepareStatement(SELECT_STUDENT);
				ps.setString(1, name);
				rs = ps.executeQuery();
				Student s = new Student();
				while(rs.next()) {
					s.setName(rs.getString("Sname"));
					s.setPassword(rs.getString("Spwd"));
				}
				DBConnection.free(rs, ps, conn);
				return s;
		}
		public Stu_Grade selectGrade(String name)  throws Exception {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(SELECT_GRADE);
			ps.setString(1, name);
			rs = ps.executeQuery();
			Stu_Grade sg = new Stu_Grade();
			while(rs.next()) {
				sg.setName(rs.getString("Sname"));
				sg.setGrade(rs.getInt("Grade"));
			}
			DBConnection.free(rs, ps, conn);
			return sg;
	}
		
		public void  insertGrade(Stu_Grade sg) throws Exception {
				conn = DBConnection.getConnection();
				ps = conn.prepareStatement(INSERT_GRADE);
				ps.setString(1, sg.getName());
				ps.setInt(2, sg.getGrade());
				ps.executeUpdate();
		}
		
		public int insertStudent(Student s) throws Exception{
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(INSERT_STUDENT);
			ps.setString(1, s.getName());
			ps.setString(2, s.getPassword());
			return ps.executeUpdate();
		}
		
		public List<Stu_Grade> orderbyGrade() throws Exception{
			List<Stu_Grade> sg_list = new  ArrayList<Stu_Grade>();
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(ORDER);
			rs = ps.executeQuery();
			while(rs.next()) {
				Stu_Grade sg = new Stu_Grade(rs.getString(1),rs.getInt(2));
				sg_list.add(sg);
			}
			return sg_list;
		}
		public void updateGrade(Stu_Grade sg) throws Exception{
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(UPDATE);
			ps.setInt(1, sg.getGrade());
			ps.setString(2, sg.getName());
			ps.executeUpdate();
		}
}
