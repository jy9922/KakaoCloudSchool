package lecture0714;

class ThreadEx_01_1 extends Thread{
	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(getName()); // 스레드의 이름을 알아내는 메서드
		}
	}
}
class ThreadEx_01_2 implements Runnable{
	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			
			System.out.println(Thread.currentThread().getName()); 
			// 아직 스레드가 아니여서 this.getName() 사용 못함.
			// 스레드가 가지고 있는 static 메서드 사용
			// 이 코드가 실행되는데 현재 실행되고 있는 스레드를 지칭함
		}
	}
}
public class ThreadExam01 {
	public static void main(String[] args) {
		
		ThreadEx_01_1 t1 = new ThreadEx_01_1();
		
		ThreadEx_01_2 r = new ThreadEx_01_2();
		Thread t2 = new Thread(r);
		
		// multi-core 환경에서는 우선순위의 의미가 없다
		t1.setPriority(10);
		
		t2.setPriority(2);
		t1.start();
		t2.start();
		
		System.out.println("main thread 종료");
	}
}

// 어떤 스레드가 먼저 실행되는지 알 수 없다.
// 스케줄러에 의해서 선택되어서 실행되기 때문에 어떤게 선택되는지 알 수 없다
