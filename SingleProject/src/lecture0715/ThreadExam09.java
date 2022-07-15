package lecture0715;

// Thread에 의해서 공유되는 공유객체를 생성하기 위한 class
class Account{
	private int balance = 1000; //계좌 잔액
	public int getBalance() {
		return balance;
	}
	// 출금하는 method => 동기화 처리
	public void withdraw(int money) {
		// 동기화 블록
		synchronized(this) { // 인자에는 어떤 객체에 대해 동기화 할지
			if (balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				balance -= money;
			}
		}
	}
}
class ThreadEx_09 implements Runnable{
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance()>0) {
			int money = ((int)(Math.random() * 3 + 1)*100);
			acc.withdraw(money);
			System.out.println("남은 잔액 :" + Thread.currentThread().getName() + " "+ acc.getBalance());
		}	
	}
}
public class ThreadExam09 {
	public static void main(String[] args) {
		ThreadEx_09 r = new ThreadEx_09(); // runnable 객체
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
	
}
