package controllStatement;

import java.util.Scanner;

public class SwitchTest {

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
			result = "�ùٸ� ��ȣ�� �ƴմϴ�.";
		}
		
		System.out.println(result);
	}

}
