package lecture0714;

import javax.swing.JOptionPane;

class ThreadEx_04 extends Thread{
	@Override
	public void run() {
		int i = 10;
		while (i != 0 && !isInterrupted()) {
			System.out.println(--i);

//			for(long k=0; k<2500000000L; k++) { // 시간지연
//			}
			// 이 코드로 대체 가능
			try {
				Thread.sleep(4000);
				// 자고 있을 때 interrupt가 걸린다.
				// 일어나게 되면 자기의 intrrupted 상태를 false로 초기화시킨다.
				// 따라서 sleep을 사용하게 되면, 숫자가 중단되지 않고 계속 돌아간다.
			} catch( Exception e) {
				// 따라서 catch문에서 interrupt를 한 번 더 걸어줘야 된다.
				interrupt();
			}
		}
		System.out.println("카운트가 종료되었어요");
	}
}

public class ThreadExam04 {
	public static void main(String[] args) {
		Thread t = new ThreadEx_04();
		t.start();
		
		String input = JOptionPane.showInputDialog("값을 입력하세요!");
		System.out.println("입력값은 : "+input);
		
		t.interrupt();
		// Thread t의 interrupt 상태가 true가 된다.
		System.out.println("Thread 상태값은 : "+t.isInterrupted());
	} 
}

/*
9
8
7
6
5
4
3
입력값은 : 14
Thread 상태값은 : true
카운트가 종료되었어요
*/