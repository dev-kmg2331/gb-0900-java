package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int index = 0;
		String msg = " 번 째 정수를 입력하세요.", num = "";
		int[] nums = new int[5];
		try {
			while(true) {
				System.out.println(index + 1 + msg);
				num = sc.next();
				
				if(num.equals("q")) {
					throw new Exception();
				}
				
				try{
					nums[index] = Integer.parseInt(num);
				} catch (Exception e) {
					continue;
				}
				
				index++;
				
				if(index > 4) break;
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("프로그램 종료.");
		} finally {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i + 1]);
			}
		}
	}
}
