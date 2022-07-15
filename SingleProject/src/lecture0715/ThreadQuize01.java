package lecture0715;

class Shared{
	public synchronized void printNums() {
		for (int i=0; i<20; i++) {
			notify();
			System.out.println("실행중인 thread :" + " "+ Thread.currentThread().getName());
	
		}
	}
}
class ThreadEx_10 implements Runnable{
	private Shared shared;
	
	@Override
	public void run() {
		shared.printNums();
		
	}
}
public class ThreadQuize01 {
	public static void main(String[] args) {
		ThreadEx_10 r = new ThreadEx_10(); // runnable 객체..
		
		Thread t1 = new Thread(r, "첫번째 스레드");
		Thread t2 = new Thread(r, "두번째 스레드");
		
		t1.start();
		t2.start();
	}
	
}
