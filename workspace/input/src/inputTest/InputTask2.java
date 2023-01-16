package inputTest;

import java.util.Scanner;

public class InputTask2 {

	public static void main(String[] args) {
//		3개의 정수를 한 번에 입력받은 후
//		세 정수의 곱셈 출력
//		next()만 사영
		
		Scanner sc = new Scanner(System.in);
		String firstNum = "", secondNum = "", thirdNum = "";
		int result = 0;
		
		System.out.println("세 정수를 입력하세요.");
		
		firstNum = sc.next();
		secondNum = sc.next();
		thirdNum = sc.next();
		
		result = Integer.parseInt(firstNum) * Integer.parseInt(secondNum) * Integer.parseInt(thirdNum);
		
		System.out.println(result);
	}
}
