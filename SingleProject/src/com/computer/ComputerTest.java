package com.computer;

public class ComputerTest {
	public static void main(String[] args) {
		Computer arrays [] = new Computer[4];
		arrays[0] = new Labtop("Lap01",2,1024,2000);
		arrays[1] = new Labtop("Lap02",3,2048,2300);
		arrays[2] = new Tab("Tab01",2,1024,1200);
		arrays[3] = new Tab("Tab02",3,2048,1300);
		
		System.out.println("name  cpu  memory  battery");
		System.out.println("---------------------------");
		for (int i = 0; i < 4; i++) {
			System.out.println(arrays[i]);
		}
		
		System.out.println("name  cpu  memory  battery rendering time");
		System.out.println("----------------------------------");
		for (int i = 0; i < 4; i++) {
			System.out.print(arrays[i] +"  ");
			arrays[i].operate(55);
			System.out.println("    "+String.format("%.2f",((Graphic)arrays[i]).rendering(100)));
		}
		
		
	}
}
