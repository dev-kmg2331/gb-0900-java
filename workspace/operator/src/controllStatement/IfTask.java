package controllStatement;

import java.util.Scanner;

public class IfTask {

	public static void main(String[] args) {
//		����ڿ��� �Ʒ��� �޴��� ����ϰ�
//		��ȣ�� �Է¹޴´�.
		/*
		 * 1.������
		 * 2.������
		 * 3.�����
		 * 4.���
		*/
		
//		����ڰ� �Է��� ��ȣ�� ������ ����� ����Ѵ�.
		
		Scanner sc = new Scanner(System.in);
		String color1 = "red", color2 = "black", color3 = "yellow", color4 = "while", msg = "1~4���� �����ȣ�� �Է��ϼ���.",
				menu = "1.������\n2.������\n3.�����\n4.���\n", result = "";
		int number = 0;
		
		System.out.println("------�޴�------\n" + menu);
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
		} else result = "�߸��� ��ȣ�Դϴ�.";
		
		System.out.println(result);
	}

}
