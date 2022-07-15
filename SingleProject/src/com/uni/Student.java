package com.uni;

public class Student extends Human {
	private String number;
	private String major;
	
	public Student() {
		
	}
	
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.setNumber(number);
		this.setMajor(major);
	}
	
	public String printInformation() {
		return super.printInformation()+" "+this.getNumber()+" "+this.getMajor();	
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
