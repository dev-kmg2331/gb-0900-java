package arrayTest;

import java.util.Scanner;

public class ArTask {
	public static void main(String[] args) {
		int[] arData = new int[10];
		int[] arData2 = new int[5];
		int[] arData3 = new int[100];
		int[] arData4 = new int[6];
		
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//			System.out.println(arData[i]);
//		}
//		
//		for (int i = 0; i < arData2.length; i++) {
//			arData2[i] = 10 - i*2;
//			System.out.println(arData2[i]);
//		}
//		
//		for (int i = 0; i < arData3.length; i++) {
//			arData3[i] = i + 1;
//			if(arData3[i] % 2 != 0) {
//				System.out.println(arData3[i]);
//			}
//			if(arData3[i] % 2 != 0) continue;
//			System.out.println(arData3[i]);
//		}
//		
		int result = 0;
		
		for (int i = 0; i < arData3.length; i++) {
			arData3[i] = i + 1;
//			if(arData3[i] % 2 == 0) {
//				result += arData3[i];
//			} 
			if(arData3[i] % 2 != 0) continue;
			result += arData3[i];
		}
		
		System.out.println(result);
		
		for (int i = 0; i < arData4.length; i++) {
			arData4[i] = i + 'A';
			System.out.println((char)arData4[i]);
		}
		
		for (int i = 0; i < arData4.length; i++) {
			if(i == 2) {
				continue;
			}
			arData4[i] = i + 'A';
			System.out.println((char)arData4[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		int min = 0, max = 0;
		for (int i = 0; i < arData2.length; i++) {
			System.out.println(i + 1 + "번 쨰 정수를 입력하세요.");
			arData2[i] = sc.nextInt();
			
			if(i == 0) {
				min = arData2[i];
			} else if(arData2[i] < min) {
				min = arData2[i];
			}
			
			if(i == 0) {
				max = arData2[i];
			} else if(arData2[i] > max) {
				max = arData2[i];
			}
		}
		
		
		System.out.println("최소값 : " + min +"\n" + "최대값 : " + max);
		
		System.out.println("배열의 길이를 입력하세요.");
		int[] arData5 = new int[sc.nextInt()];
		int total = 0;
		for (int i = 0; i < arData5.length; i++) {
			System.out.println(i + 1 + "번 쨰 정수를 입력하세요.");
			arData5[i] = sc.nextInt();
			total += arData5[i];
		}
		
		System.out.printf("평균 : %.2f", (double)total / arData5.length);
	}
}
