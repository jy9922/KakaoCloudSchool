package lecture0712;

// 추상클래스(abstract class)
public abstract class UpperClass {
	// fields
	String name;
	int age;
	
	// method
	public abstract void printAll(); // abstract method (해당 메소드 앞에 abstract 키워드 붙임)
}

class subClass extends UpperClass{
	// 추상 메소드를 사용하기 위해서 재정의하면 된다(오버라이딩)
	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		
	}
}