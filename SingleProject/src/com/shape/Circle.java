package com.shape;

public class Circle extends Shape implements Movable{
	private int radius;
	
	public Circle() {
		
	}
	public Circle(int radius, int x, int y) {
		super(new Point(x, y));
		this.radius = radius;

	}
	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		point.setX(point.getX()+11);
		point.setY(point.getY()+11);
		
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius * radius * 3.14;
	}
	@Override
	public double getCircumference() {
		// TODO Auto-generated method stub
		return radius * 2 * 3.14;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stubt
		return "Circle" + "\t\t" + radius + "\t" + point.getX() + "\t" + point.getY();
	}
	
}
