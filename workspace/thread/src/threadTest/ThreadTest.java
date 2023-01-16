package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1("★");
		Thread1 t2 = new Thread1("♥");
		
		Thread2 thread = new Thread2();
		Runnable target = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t3 = new Thread(thread, "★");
		Thread t4 = new Thread(target, "♥");
		
//		t1.start();
//		t2.start();
		
//		t1.run();
//		t2.run();
		
		t3.start();
		
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t4.start();
	}
}
