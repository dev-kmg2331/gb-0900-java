package stringTest;

import java.util.Iterator;
import java.util.Scanner;

public class StringTask {
	public static void main(String[] args) {
//		����ڿ��� �Է¹��� ���ڿ� �� �ҹ��ڴ� ��� �빮�ڷ�,
//		�빮�ڴ� ��� �ҹ��ڷ� �����Ѵ�.
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڿ��� �Է��ϼ���.\n ��) abCDEF");
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
		
//		������ �ѱ۷� ����
//		��) 1024 -> �ϰ��̻�
		int[] nums = new int[10];
		String hangul = "�����̻�����ĥ�ȱ�";
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		
		System.out.println("���ڸ� �Է��ϼ���.\n��)1024");
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
