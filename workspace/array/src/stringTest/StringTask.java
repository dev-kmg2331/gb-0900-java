package stringTest;

import java.util.Iterator;
import java.util.Scanner;

public class StringTask {
	public static void main(String[] args) {
//		사용자에게 입력받은 문자열 중 소문자는 모두 대문자로,
//		대문자는 모두 소문자로 변경한다.
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요.\n 예) abCDEF");
		String data = sc.nextLine();
//		char[] arChar = data.toCharArray();

		char[] arChar = new char[data.length()];
		
		for (int i = 0; i < arChar.length; i++) {
			arChar[i] = data.charAt(i);
		}
		
		data = "";
		
		for (int i = 0; i < arChar.length; i++) {
			arChar[i] = (char) (arChar[i] > 90 ? arChar[i] - 32 : arChar[i] + 32);
			data += arChar[i];
		}
		
		System.out.println(data);
		
//		정수를 한글로 변경
//		에) 1024 -> 일공이사
		int[] nums = new int[10];
		String hangul = "공일이삼사오육칠팔구";
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		
		System.out.println("숫자를 입력하세요.\n예)1024");
		data = sc.next();
//		arChar = data.toCharArray();
//		data = "";
		String result = "";
		for (int i = 0; i < data.length(); i++) {
//			int charAt = Integer.parseInt(String.valueOf(arChar[i]));
//			arChar[i] = hangul.charAt(charAt);
//			data += arChar[i];
			result += hangul.charAt(data.charAt(i) - 48);
		}
		System.out.println(result);
	}
}
