package controllStatement;

public class WhileTest {

	public static void main(String[] args) {
//		�̸� 10�� ���
		int index = 0;
		while(index < 10) {
			index++;
			if(index == 3) index++;
			System.out.println(index + "���α�");
		}
	}

}
