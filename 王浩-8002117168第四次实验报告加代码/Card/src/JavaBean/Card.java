package JavaBean;

public class Card {
	private String name;
	private String sex;
	private int age;
	private String addr;
	private String tel;
	public Card(){}
	public void setName(String name){
		this.name = name;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setAddr(String addr){
		this.addr = addr;
	}
	public void setTel(String tel){
		this.tel= tel;
	}
	public String getSex(){
		return sex;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getAddr(){
		return addr;
	}
	public String getTel(){
		return tel;
	}
}
