package JavaBean;

public class User {
	private String name;
	private String sex;
	private int age;
	private String addr;
	private String tel;
	public User(){}
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
		this.tel = tel;
	}
	public String getName(){
		return this.name;
	}
	public String getSex(){
		return this.sex;
	}
	public String getAddr(){
		return this.addr;
	}
	public String getTel(){
		return this.tel;
	}
	public int getAge(){
		return this.age;
	}
}
