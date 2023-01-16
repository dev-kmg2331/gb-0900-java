package inputTest;

import java.util.Scanner;

public class InputTask1 {
	
	public static void main(String[] args) {
//		두 정수를 입력한 뒤 덧겜 결과 출력
//		단, next()만 사용한다.
		
		Scanner sc = new Scanner(System.in);
		String firstNum = "", secondNum = "";
		int result = 0;
		
		System.out.println("두 정수를 입력하세요.");
		
		firstNum = sc.next();
		secondNum = sc.next();
		
		result = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
		
		System.out.println(result);
	}
}
