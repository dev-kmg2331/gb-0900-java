package exceptionTest;

import java.util.Scanner;

public class Chatting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = null;
		
		System.out.println("메시지 : ");
		message = sc.nextLine();
		
		if(message.contains("바보")) {
			throw new BadWordException("욕설 감지.");
		}
	}
}
