package com.shape;

public class Rectangle extends Shape implements Movable{
	private int width;
	public Rectangle() {
		
	}
	public Rectangle(int width, int x, int y) {
		Point point = new Point(x, y);
		this.width = width;
		super.setPoint(point);
		super.getPoint();
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * width;
	}
	@Override
	public double getCircumference() {
		// TODO Auto-generated method stub
		return width *4;
	}
	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		point.setX(point.getX()+x+10);
		point.setY(point.getY()+y+10);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stubt
		return "Rectangle" + "\t" + width + "\t" + point.getX() + "\t" + point.getY();
	}
	
	
	
}
