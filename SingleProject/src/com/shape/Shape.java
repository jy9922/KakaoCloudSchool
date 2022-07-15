package com.shape;

public abstract class Shape {
	protected Point point;
	
	public Shape() {
		
	}
	public Shape(Point point) {
		super();
		this.setPoint(point);
	}
	public abstract double getArea();
	public abstract double getCircumference();
		
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
}
