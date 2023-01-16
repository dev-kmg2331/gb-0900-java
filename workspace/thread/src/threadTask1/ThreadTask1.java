package threadTask1;

import java.util.ArrayList;

public class ThreadTask1 {
	
	public static void main(String[] args) throws InterruptedException {
		int roarNum = 10;
		
		ArrayList<Thread> list = new ArrayList<Thread>();
		
		Runnable target = () -> {
			for (int i = 0; i < roarNum; i++) {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread tiger = new Thread("어흥");
		Thread cat = new Thread("야옹");
		Thread dog = new Thread(target, "멍멍");
		
		list.add(tiger);
		list.add(cat);
		
		MyThread thread = new MyThread(list);
		
		thread.start();
		
		thread.join();
		
		dog.start();
		
		
	}
}
