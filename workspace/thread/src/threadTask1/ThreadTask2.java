package threadTask1;

public class ThreadTask2 implements Runnable {
	
	
	public ThreadTask2() {;}
	
	public void printFirst(Runnable first) {
		first.run();
	}
	
	public void printSecond(Runnable second) {
		second.run();
	}
	
	public void printThird(Runnable third) {
		third.run();
	}
	
	@Override
	public void run() {
		
	}
}
