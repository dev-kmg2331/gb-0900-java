package operTest;

import java.util.Scanner;

public class Oper3 {

	public static void main(String[] args) {
//		����ڿ��� Ű�� �Է¹ް�
//		������� ������ ���
//		�Ǽ���� �Ǽ��� ���
//		��) 183 -> 183 ���
//			183.5 -> 183.5 ���
//		���� �����ڸ� ���!
		
		double num = 0;
	      String result = null, intPartofNum = null, msg = "���� �Ǵ� �Ǽ��� �Է��ϼ���.";
	      int length = 0, decimalIndex = 0;
	      boolean check = false;
	      Scanner sc = new Scanner(System.in);
	      
	      System.out.println(msg);
	      num = sc.nextDouble();
	      
	      check = num - (int)num == 0;
	      decimalIndex =  Double.toString(num).indexOf('.');
	      // substring : extends to the character at index endIndex - 1
	      intPartofNum = Double.toString(num).substring(0, decimalIndex + 1);
	      
	      length = Double.toString(num).length() - intPartofNum.length();
//	      length = Double.toString(num - (int)num).length() - 2;
	      
//	      �Ǽ��� �޸𸮿� ����Ǵ� ���
//	      ������ ���������� �׻� �ݿø��Ͽ� �����ϱ� ������ ���� ������ ũ�ų� ���� �� �ִ�. 
	      System.out.println("�Ҽ��� ��ġ : " + length);
	      
	      result = check ? "�ᱣ��(����) : %.0f" : "�ᱣ��(�Ǽ�) : " + "%." + length + "f";
	      System.out.printf(result, num - (int)num == 0 ? (int)num : num);
	}

}
