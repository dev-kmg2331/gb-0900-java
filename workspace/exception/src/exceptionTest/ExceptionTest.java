package exceptionTest;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			System.out.println(10 / 0);
			System.out.println("연산 성공!");
		} catch (ArithmeticException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("연산 완료.");
		}
		
	}
}
