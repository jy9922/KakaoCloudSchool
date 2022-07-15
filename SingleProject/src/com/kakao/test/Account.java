package com.kakao.test;

public class Account {
	private String actName;
	private String actNum;
	private int money;
	
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getActNum() {
		return actNum;
	}
	public void setActNum(String actNum) {
		this.actNum = actNum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	// 예금
	public void deposit(int money) {
		System.out.println(money + "원 입금합니다.");
		this.money += money;
	}
	
	// 출금
	public void withdraw(int money) {
		System.out.println(money + "원 출금합니다.");
		this.money -= money;
	}
	
	public static void main(String[] args) {
		Account a = new Account();
		a.setActName("홍길동");
		a.setActNum("123-456789");
		a.setMoney(10000);
		System.out.println("실행 결과");
		System.out.println("계좌:"+ a.getActNum() + "(예금주 : "+ a.getActName()+")");
		System.out.println("잔액:"+ a.getMoney() + "원");
		a.deposit(20000);
		System.out.println("잔액:"+ a.getMoney() + "원");
		a.withdraw(45000);
		System.out.println("잔액:"+ a.getMoney() + "원");
	}
	
}
