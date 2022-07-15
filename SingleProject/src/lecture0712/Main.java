package lecture0712;
// Java에선 Object class가 최상위(Object 생략가능)
class Person extends Object{
	String name; 	// 이름
	String mobile; 	// 전화번호
	public void printAll() {
		System.out.println("모두 출력!!");
	}
}
class Student extends Person{
	String dept; 	// 학과
	
	// default constructor
	public Student() {
		this("홍길동"); // 현재 자신이 가지고 있는 생성자의 다른 생성자 호출
	}
	public Student(String name) { 
		this.name = name; // 여기 안으로 들어감
	}
}

public class Main {
	public static void main(String[] args) {
		Student s = new Student();
	}
}

//2초 동안 Thread1 자고있음
// main 스레드 실행
// Thread2 실행
// Thread1 실행