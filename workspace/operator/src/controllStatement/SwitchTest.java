package controllStatement;

import java.util.Scanner;

public class SwitchTest {

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
		
		switch (number) {
		case 1: {
			result = "red";
			break;
		}
		case 2: {
			result = "black";
			break;
		}
		case 3: {
			result = "yellow";
			break;
		}
		case 4: {
			result = "white";
			break;
		}
		default:
			result = "올바른 번호가 아닙니다.";
		}
		
		System.out.println(result);
	}

}
