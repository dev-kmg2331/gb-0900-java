package controllStatement;

import java.util.Scanner;

public class ForTask {

	public static void main(String[] args) {
		
		int  result = 0, number = 0;
		Scanner sc = new Scanner(System.in);
//		for (int i = 0; i < 100 ; i++) {
//			System.out.println(i + 1);
//		}
//		
//		for (int i = 0; i < 100; i++) {
//			System.out.println(num1 - i);
//		}
//		
//		for (int i = 0; i < 100; i += 2) {
//			System.out.println(i+2);
//		}
//		
//		for (int i = 0; i < 10 ; i++) {
//			result += i + 1;
//		}
//		
//		System.out.println(result);
//		
//		System.out.println("n ют╥б.");
//		number = sc.nextInt();
//		result = 0;
//		for (int i = 0; i < number ; i++) {
//			result += i + 1;
//		}
//		
//		System.out.println(result);
		
		for (int i = 'A'; i < 'G'; i++) {
			System.out.println((char)(i));
		}
		
		for (int i = 'A'; i < 'G'; i++) {
			if(i == 'C') {
				i++;
			}
			System.out.println((char)(i));
		}
		
		for (int i = 0; i < 12; i++) {
			System.out.println(i % 4);
		}
		
		for (int i = 'a'; i < 'z' + 1; i++) {
//			if(i % 2 == 0) {
//				System.out.println((char)(i - 32));
//			}else System.out.println((char)i);
			
			int out = 0;
			out = i % 2 == 0 ? i - 32 : i;
			System.out.print((char)out);
		}
	}

}
