package com.liqiang.bean;

public class CircleBean {
    private double radius;
    private double area;
    
	public void setArea(double area) {
		this.area = area;
	}

	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return area = this.radius*this.radius*3.1415926;
	}
   
}
