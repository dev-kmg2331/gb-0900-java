package controllStatement;

import java.util.Scanner;

public class IfTask {

	public static void main(String[] args) {
//		사용자에게 아래의 메뉴를 출력하고
//		번호를 입력받는다.
		/*
		 * 1.빨간색
		 * 2.검은색
		 * 3.노란색
		 * 4.흰색
		*/
		
//		사용자가 입력한 번호의 색상을 영어로 출력한다.
		
		Scanner sc = new Scanner(System.in);
		String color1 = "red", color2 = "black", color3 = "yellow", color4 = "while", msg = "1~4까지 색상번호를 입력하세요.",
				menu = "1.빨간색\n2.검은색\n3.노란색\n4.흰색\n", result = "";
		int number = 0;
		
		System.out.println("------메뉴------\n" + menu);
		System.out.println(msg);
		number = sc.nextInt();
		
		if(number == 1) {
			result = color1;
		} else if(number == 2) {
			result = color2;
		} else if(number == 3) {
			result = color3;
		} else if(number == 4) {
			result = color4;
		} else result = "잘못된 번호입니다.";
		
		System.out.println(result);
	}

}
