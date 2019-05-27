package JavaBean;

public class Complex {
	private double rno;
	private double vno;
	public Complex() {
	}
	public Complex(double r,double v) {
		this.rno = r;
		this.vno = v;
	}
	public void setRno(double rno) {
		this.rno = rno;
	}

	public void setVno(double vno) {
		this.vno = vno;
	}

	public double getRno() {
		return rno;
	}
	public double getVno() {
		return vno;
	}
	public Complex add(Complex a) {
		return new Complex(this.rno + a.rno,this.rno + a.vno);
	}
	public Complex sub(Complex a) {
		return new Complex(this.rno - a.rno,this.rno - a.vno);
	}
	public Complex mul(Complex a) {
		double x = this.rno * a.rno - this.vno * a.vno;
		double y = this.rno * a.vno + this.vno * a.rno;
		return new Complex(x,y);
	}
	public Complex div(Complex a) {
		double z = a.rno*a.rno + a.vno * a.vno;
		double x = (this.rno * a.rno + this.vno * a.rno) / z;
		double y = (this.rno * a.vno - this.vno * a.vno) / z;
		return new Complex(x,y);
	}
	
	public String getInfor() {
		if( vno >= 0.0)
			return rno + "+" + vno + "i";
		else
			return rno + "-" + (-vno) + "i";
	}
	
}
