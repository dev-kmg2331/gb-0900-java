package inputTest;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		초기값 : 아직 어떤 값을 넣을 지 모를 때 넣는 ㄱ밧
//		정수 : 0
//		실수 : 0.0
//		문자 : ' ' (공백문자)
//		문자열 : null 또는 ""(빈 문자열)
		
		String firstName = "", lastName = "";
		System.out.print("이름 : ");
		firstName = sc.next();
		lastName = sc.next();
		sc.close();
		System.out.println(firstName + lastName);
	}
}
