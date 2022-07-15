package com.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {
	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>();
		Rectangle r1 = new Rectangle(4, 7, 5);
		Rectangle r2 = new Rectangle(5, 4, 6);
		Circle c1 = new Circle(6, 6, 7);
		Circle c2 = new Circle(7, 8, 3);
		
		list.add(r1);
		list.add(r2);
		list.add(c1);
		list.add(c2);
		
		// instanceof 사용해서 구하기 (Circle인지 아닌지 구분)
		System.out.println("구분\t\t길이\tX좌표\tY좌표\tArea\tCircumference");
		for (Shape a: list) {
			System.out.println(a.toString()+"\t"+String.format("%.0f",a.getArea())+"\t"+String.format("%.0f",a.getCircumference()));
			
		}
		System.out.println("이동 후...");
		for (Shape a: list) {
			((Movable)a).move(2,2);
			System.out.println(a.toString());
			
		}
	}
}
