package lecture0712;

interface myInterface{
	// fields
	// public static final은 자동적으로 설정(안써줘도 자동설정)
	int kk = 0;
	String aa = "Hello";
	
	// methods
	public abstract void printAll();
	
	public abstract void myPrint();
}

// 인터페이스를 구현해서 MyClass2를 정의한다는 뜻 (상위 클래스 개념으로 사용함)
// 내가 구현할 해당 인터페이스들을 모두 오버라이딩 해줘야 한다.
public class MyClass2 implements myInterface {

	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
		
	}
	
}
