package exitTest;

import java.util.Scanner;

public class ExitTest {
	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		Thread thread = new Thread(threadTest);
		Scanner sc = new Scanner(System.in);
		
		thread.start();
		
		if(sc.nextInt() == 0) {
//			ThreadTest.isExit = true;
			thread.interrupt();
		}
	}
}
