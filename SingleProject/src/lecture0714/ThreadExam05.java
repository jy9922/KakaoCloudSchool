package lecture0714;

class ThreadEx_05 implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
		
	}
}
public class ThreadExam05 {
	public static void main(String[] args) {
		ThreadEx_05 r = new ThreadEx_05();
		
		// thread 3개
		Thread t1 = new Thread(r,"*"); // 두 번째 인자는 thread의 이름
		Thread t2 = new Thread(r,"**");
		Thread t3 = new Thread(r,"***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			t1.suspend(); // t1을 일시 중지
			Thread.sleep(2000);
			t2.suspend(); // t2를 일시 중지
			Thread.sleep(2000);
			t1.resume(); // t1이 다시 동작하도록 설정
			Thread.sleep(2000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
		} catch (Exception e) {
			
		}
	}
}


