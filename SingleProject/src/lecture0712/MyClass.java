//package lecture0712;
//
//public class MyClass {
//	
//	// field
//	int aaa;
//	static int bbb = staticCall();
//	
//	// 생성자
//	public MyClass() {
//		// default constructor가 아닌 웬만하면 쓰는게 좋음
//	}
//	// static block
//	static {
//		// main이 실행되기 직전에 다른 library같은것들을 loading할 필요가 있을 때
//		System.out.println("static block"); 
//	}
//	// method
//	static int staticCall() {
//		System.out.println("staticCall 호출되었어요!"); 
//		return 100;
//	}
////	public static void main(String[] args) {
////		System.out.println("main 호출"); 
////	}
//}
//
///*
//staticCall 호출되었어요!
//static block
//main 호출
//*/