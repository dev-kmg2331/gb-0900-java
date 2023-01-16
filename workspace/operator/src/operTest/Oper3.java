package operTest;

import java.util.Scanner;

public class Oper3 {

	public static void main(String[] args) {
//		사용자에게 키를 입력받고
//		정수라면 정수로 출력
//		실수라면 실수로 출력
//		예) 183 -> 183 출력
//			183.5 -> 183.5 출력
//		삼항 연산자를 사용!
		
		double num = 0;
	      String result = null, intPartofNum = null, msg = "정수 또는 실수를 입력하세요.";
	      int length = 0, decimalIndex = 0;
	      boolean check = false;
	      Scanner sc = new Scanner(System.in);
	      
	      System.out.println(msg);
	      num = sc.nextDouble();
	      
	      check = num - (int)num == 0;
	      decimalIndex =  Double.toString(num).indexOf('.');
	      // substring : extends to the character at index endIndex - 1
	      intPartofNum = Double.toString(num).substring(0, decimalIndex + 1);
	      
	      length = Double.toString(num).length() - intPartofNum.length();
//	      length = Double.toString(num - (int)num).length() - 2;
	      
//	      실수가 메모리에 저장되는 방식
//	      가수부 마지막에는 항상 반올림하여 저장하기 때문에 원래 값보다 크거나 작을 수 있다. 
	      System.out.println("소숫점 위치 : " + length);
	      
	      result = check ? "결괏값(정수) : %.0f" : "결괏값(실수) : " + "%." + length + "f";
	      System.out.printf(result, num - (int)num == 0 ? (int)num : num);
	}

}
