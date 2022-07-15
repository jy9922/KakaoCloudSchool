package lecture0715;

class ThreadEx_08_1 extends Thread{
	
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10000); // 10초 동안 자요!
			} catch (Exception e) {
				System.out.println("interrupt에 의해서 깨어났어요!");
			}
			gc();
			System.out.println("메모리 청소 완료! 현재 사용 가능한 메모리량은:"
					+ freeMemory());
		} 
	}
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) {
			usedMemory = 0;
		}
	}
	public int totalMemory() {
		return MAX_MEMORY;
	}
	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}
}
public class ThreadExam08 {
	public static void main(String[] args) {
		ThreadEx_08_1 t1 = new ThreadEx_08_1();
		t1.setDaemon(true);
		t1.start();
		
		int requiredMemory = 0;
		
		for(int i=0; i<20; i++) {
			requiredMemory = ((int)(Math.random() * 10)) * 20;
							 // 0.0보다 같거나 크고 200보다 작은 정수
			
			// 필요한 memory가 사용할 수 있는 양보다 크거나 
			// 현재 전체 메모리양의 60%이상을 사용하고 있을 때 gc를 실행
			if ((t1.freeMemory() < requiredMemory) ||
					(t1.freeMemory() < t1.totalMemory() * 0.4)) {
				t1.interrupt(); // 여기서 gc() 실행이 끝날때까지 기다리지 않아요..!
				try {
					t1.join(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			// 청소가 되었으니 메모리양을 사용할 수 있음
			t1.usedMemory += requiredMemory;
			System.out.println("사용된 메모리량 :" +t1.usedMemory);
		}
	
	}
}
