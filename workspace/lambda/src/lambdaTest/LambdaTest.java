package lambdaTest;

public class LambdaTest {
	public static void main(String[] args) {
//		LambdaInter lambdaInter = (number) -> number % 10 == 0;
//		System.out.println(lambdaInter.check10(10));
//		System.out.println(lambdaInter.check10(3));
		
		LambdaInter lambdaInter = (n) -> {
			System.out.println(n + " �� 10�� ��� �˻�.");
			return n % 10 == 0;
		};
		System.out.println(lambdaInter.check10(10));
	}
}
