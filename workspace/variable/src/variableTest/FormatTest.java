package variableTest;

public class FormatTest {

	public static void main(String[] args) {
		String name = "���α�";
		int age = 20;
		double height = 172.536;
		
		System.out.printf("�̸� : %s\n", name);
		System.out.printf("���� : %n", age);
		System.out.printf("���� : %.2f\n", height); // �ݿø�
	}

}
