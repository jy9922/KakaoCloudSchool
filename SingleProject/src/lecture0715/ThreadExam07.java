package lecture0715;

class ThreadEx_07_1 extends Thread{
	@Override
	public void run() {
		for (int i=0; i<300; i++) {
			System.out.print("-");
		}
	}
}
class ThreadEx_07_2 extends Thread{
	@Override
	public void run() {
		for (int i=0; i<300; i++) {
			System.out.print("|");
		}
	}
}
public class ThreadExam07 {
	public static void main(String[] args) {
		Thread t1 = new ThreadEx_07_1();
		Thread t2 = new ThreadEx_07_2();
		
		t1.start();
		t2.start();
		
		try {
			// 내가 수행되는 것을 hold 시키고, 지정한 thread가 동작하게 함
			// 실행중인 main thread를 일시적으로 block시킴..
			// blocked된 thread를 Runnable 상태로 변환시키기 위해 try-catch문 사용함
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("<<main>> 종료"); 
	}
}
