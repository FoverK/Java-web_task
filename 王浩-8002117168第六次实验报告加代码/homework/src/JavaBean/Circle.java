package JavaBean;

public class Circle {
	private double r;
	public void setR(double r){
		this.r = r;
	}
	public double getR(){
		return r;
	}
	public double getArea(){
		return r * r * 3.14;
	}
	public double getLength(){
		return r * 2 * 3.14;
	}
}
