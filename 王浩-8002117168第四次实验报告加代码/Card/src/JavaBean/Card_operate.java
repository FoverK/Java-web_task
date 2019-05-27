package JavaBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Card_operate {
	private final static String INSERT_SQL = "insert into card values(?,?,?,?,?)";
	private  static String DELETE_SQL = "delete from card where ";
	private  static String FINDALL_SQL = "select * from card";
	private  static String SERACH_SQL = "select * from card where ";
	private  static String UPDATE_SQL = "update card set name = ? ,sex = ?,age = ?,addr = ?,tel = ? "
											+ "where name = ?";
	
	
	public  List<Card> findAll() throws Exception{
		
		
		List<Card> card = new ArrayList<Card>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;

		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(FINDALL_SQL);
		rs = ps.executeQuery();
		
		while(rs.next()){
			Card c = new Card();
			c.setName(rs.getString("name"));
			c.setSex(rs.getString("sex"));
			c.setAge(rs.getInt("age"));
			c.setAddr(rs.getString("addr"));
			c.setTel(rs.getString("tel"));
			card.add(c);
		}
		DBConnection.free(rs, ps, conn);
		return card;
	}
	
	public  void insertCard(Card card) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;

		try{
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setString(1, card.getName());
			ps.setString(2, card.getSex());
			ps.setInt(3, card.getAge());
			ps.setString(4, card.getAddr());
			ps.setString(5, card.getTel());
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.free(rs, ps, conn);
			
		}
	}
	
	public  void deleteCard(Card c,int n) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		conn = DBConnection.getConnection();
		switch(n){
			case 0:
				String sql1 = DELETE_SQL + "name = ?";
				ps = conn.prepareStatement(sql1);
				ps.setString(1,c.getName());
				break;
			case 1:
				String sql2 = DELETE_SQL + "sex = ?";
				ps = conn.prepareStatement(sql2);
				ps.setString(1,c.getSex());
				break;
			case 2:
				String sql3 = DELETE_SQL + "age = ?";
				ps = conn.prepareStatement(sql3);
				ps.setInt(1,c.getAge());
				break;
			case 3:
				String sql4 = DELETE_SQL + "addr = ?";
				ps = conn.prepareStatement(sql4);
				ps.setString(1,c.getAddr());
				break;
			case 4:
				String sql5 = DELETE_SQL + "tel = ?";
				ps = conn.prepareStatement(sql5);
				ps.setString(1,c.getTel());
				break;
		}

		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}
	
	public  List<Card> findCard(Card c,int n) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		List<Card> allcard = new ArrayList<Card>();
		try{
			conn = DBConnection.getConnection();
			switch(n){
				case 0:
					String sql1 = SERACH_SQL + "name = ?";
					ps = conn.prepareStatement(sql1);
					ps.setString(1,c.getName());
					break;
				case 1:
					String sql2 = SERACH_SQL + "sex = ?";
					ps = conn.prepareStatement(sql2);
					ps.setString(1,c.getSex());
					break;
				case 2:
					String sql3 = SERACH_SQL + "age = ?";
					ps = conn.prepareStatement(sql3);
					ps.setInt(1,c.getAge());
					break;
				case 3:
					String sql4 = SERACH_SQL + "addr = ?";
					ps = conn.prepareStatement(sql4);
					ps.setString(1,c.getAddr());
					break;
				case 4:
					String sql5 = SERACH_SQL + "tel = ?";
					ps = conn.prepareStatement(sql5);
					ps.setString(1,c.getTel());
					break;
			}
			rs = ps.executeQuery();
			while(rs.next()){
				Card card = new Card();
				card.setAddr(rs.getString("addr"));
				card.setName(rs.getString("name"));
				card.setAge(rs.getInt("age"));
				card.setTel(rs.getString("tel"));
				card.setSex(rs.getString("sex"));
				allcard.add(card);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.free(rs, ps, conn);
		}
		return allcard;
	}
	
	public void updateCard(Card c) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		try{
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(UPDATE_SQL);
			ps.setString(1, c.getName());
			ps.setString(2, c.getSex());
			ps.setInt(3, c.getAge());
			ps.setString(4, c.getAddr());
			ps.setString(5, c.getTel());
			ps.setString(6, c.getName());
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.free(rs, ps, conn);
		}
	}
	
	
}
