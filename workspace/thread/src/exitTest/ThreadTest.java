package exitTest;

public class ThreadTest implements Runnable{

	public static boolean isExit;
	
	@Override
	public void run() {
		while(true) {
			System.out.println("...진행중");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException 으로 쓰레드 종료.");
				break;
			}
			if(isExit) {
				System.out.println("쓰레드 종료.");
				break;
			}
		}
	}
	
}
