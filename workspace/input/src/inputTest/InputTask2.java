package inputTest;

import java.util.Scanner;

public class InputTask2 {

	public static void main(String[] args) {
//		3���� ������ �� ���� �Է¹��� ��
//		�� ������ ���� ���
//		next()�� �翵
		
		Scanner sc = new Scanner(System.in);
		String firstNum = "", secondNum = "", thirdNum = "";
		int result = 0;
		
		System.out.println("�� ������ �Է��ϼ���.");
		
		firstNum = sc.next();
		secondNum = sc.next();
		thirdNum = sc.next();
		
		result = Integer.parseInt(firstNum) * Integer.parseInt(secondNum) * Integer.parseInt(thirdNum);
		
		System.out.println(result);
	}
}
