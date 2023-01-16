package synchronizedTest;

public class ATM implements Runnable{
	
	public int money;
	private final int COUNT = 10;
	
	public ATM() {this(10000);}

	public ATM(int money) {
		this.money = money;
	}
	
	
	

	@Override
	public /* synchronized */ void run() {
//		synchronized (this) {
			for (int i = 0; i < COUNT; i++) {
				withdraw(500);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//		}
	}
	
	public  synchronized  void withdraw(int money) {
//		synchronized (this) {
			this.money -= money;
			System.out.println(Thread.currentThread().getName() + "출금");
			System.out.println("잔액 : " + this.money);
//		}
	}
}
