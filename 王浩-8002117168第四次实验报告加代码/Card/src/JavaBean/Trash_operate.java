package JavaBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Trash_operate {
	private String INSERT_SQL = "insert into trash values(?,?,?,?,?)";
	private String FINDTRASH_SQL = "select * from trash ";
	private String FIND_SQL = "select * from trash where name = ?";
	private String DELETE_SQL = "delete from trash where name = ?";
	
	
	public void deleteToTrash(Card c,int n) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		Card_operate co = new Card_operate();
		List<Card> card = new ArrayList<Card>();
		conn = DBConnection.getConnection();
		switch(n){
			case 0:
				card = co.findCard(c,0);
				co.deleteCard(c,0);
				ps = conn.prepareStatement(INSERT_SQL);
				for(Card c1 : card){
					ps.setString(1, c1.getName());
					ps.setString(2, c1.getSex());
					ps.setInt(3, c1.getAge());
					ps.setString(4, c1.getAddr());
					ps.setString(5, c1.getTel());
					ps.executeUpdate();
				}
				break;
			case 1:
				card = co.findCard(c,1);
				co.deleteCard(c,1);
				ps = conn.prepareStatement(INSERT_SQL);
				for(Card c1 : card){
					ps.setString(1, c1.getName());
					ps.setString(2, c1.getSex());
					ps.setInt(3, c1.getAge());
					ps.setString(4, c1.getAddr());
					ps.setString(5, c1.getTel());
					ps.executeUpdate();
				}
				break;
			case 2:
				card = co.findCard(c,2);
				co.deleteCard(c,2);
				ps = conn.prepareStatement(INSERT_SQL);
				for(Card c1 : card){
					ps.setString(1, c1.getName());
					ps.setString(2, c1.getSex());
					ps.setInt(3, c1.getAge());
					ps.setString(4, c1.getAddr());
					ps.setString(5, c1.getTel());
					ps.executeUpdate();
				}
				break;
			case 3:
				card = co.findCard(c,3);
				co.deleteCard(c,3);
				ps = conn.prepareStatement(INSERT_SQL);
				for(Card c1 : card){
					ps.setString(1, c1.getName());
					ps.setString(2, c1.getSex());
					ps.setInt(3, c1.getAge());
					ps.setString(4, c1.getAddr());
					ps.setString(5, c1.getTel());
					ps.executeUpdate();
				}
				break;
			case 4:
				card = co.findCard(c,4);
				co.deleteCard(c,4);
				ps = conn.prepareStatement(INSERT_SQL);
				for(Card c1 : card){
					ps.setString(1, c1.getName());
					ps.setString(2, c1.getSex());
					ps.setInt(3, c1.getAge());
					ps.setString(4, c1.getAddr());
					ps.setString(5, c1.getTel());
					ps.executeUpdate();
				}
				break;
		}

		DBConnection.free(rs, ps, conn);
		
		
	}
	
	public List<Card> findTrash(Card c) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(FIND_SQL);
		ps.setString(1, c.getName());
		rs = ps.executeQuery();
		List<Card> cardlist = new ArrayList<Card>();
		while(rs.next()){
			Card card = new Card();
			card.setAddr(rs.getString("addr"));
			card.setSex (rs.getString("sex"));
			card.setAge(rs.getInt("age"));
			card.setName(rs.getString("name"));
			card.setTel(rs.getString("tel"));
			cardlist.add(card);
		}
		DBConnection.free(rs, ps, conn);
		return cardlist;
	}
	
	public List<Card> findAllTrash() throws Exception{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<Card> card = new ArrayList<Card>();
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(FINDTRASH_SQL);
		rs = ps.executeQuery();
	
		while(rs.next()){
			Card c = new Card();
			c.setName(rs.getString(1));
			c.setSex(rs.getString(2));
			c.setAge(rs.getInt(3));
			c.setAddr(rs.getString(4));
			c.setTel(rs.getString(5));
			card.add(c);
		}
		DBConnection.free(rs, ps, conn);
		return card;
		
	}
	
	public  void deleteTrash(Card c) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		conn = DBConnection.getConnection();
		ps = conn.prepareStatement(DELETE_SQL);
		ps.setString(1,c.getName());
		ps.executeUpdate();
		DBConnection.free(rs, ps, conn);
	}
	
	public void returnToCard() throws Exception{
		Card_operate co = new Card_operate();
		List<Card> card = new ArrayList<Card>();
		card = findAllTrash();
		for(Card c : card){
			co.insertCard(c);
			deleteTrash(c);
		}
		
	}
}
