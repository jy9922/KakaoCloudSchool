package lecture0714;

// Daemon Thread에 대해서 알아보아요!
public class ThreadExam02 implements Runnable {
	
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadExam02());
		
		t.setDaemon(true); // 데몬 스레드로 바꾸어주기
		
		t.start();
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(1000); // 현재 실행하고 있는 스레드를 재움
			}catch(Exception e) {
				;
			}
			System.out.println(i);
			
			if (i==5) {
				autoSave = true;
			}
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000); // 메서드 자체가 
			} catch(InterruptedException e) {
				
			}
			
			if(autoSave) {
				System.out.println("자동저장되었어요!");
			}
		}
	}
}
