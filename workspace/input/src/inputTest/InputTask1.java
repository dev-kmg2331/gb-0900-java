package inputTest;

import java.util.Scanner;

public class InputTask1 {
	
	public static void main(String[] args) {
//		�� ������ �Է��� �� ���� ��� ���
//		��, next()�� ����Ѵ�.
		
		Scanner sc = new Scanner(System.in);
		String firstNum = "", secondNum = "";
		int result = 0;
		
		System.out.println("�� ������ �Է��ϼ���.");
		
		firstNum = sc.next();
		secondNum = sc.next();
		
		result = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
		
		System.out.println(result);
	}
}
