package stringTest;

public class StringTest {
	public static void main(String[] args) {
		String data = "ABC";
		String[] data2 = new String[3]; 
		
//		���ڿ��� ����
		System.out.println(data.length());
		System.out.println(data2.length);
		
//		���ϴ� �ε����� ���� ����
		System.out.println(data.charAt(1));
//		���ϴ� ���� ��ȸ
		System.out.println(data.indexOf('C'));
	}

}
