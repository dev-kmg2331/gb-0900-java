package variableTest;

public class FormatTest {

	public static void main(String[] args) {
		String name = "강민구";
		int age = 20;
		double height = 172.536;
		
		System.out.printf("이름 : %s\n", name);
		System.out.printf("나이 : %n", age);
		System.out.printf("나이 : %.2f\n", height); // 반올림
	}

}
