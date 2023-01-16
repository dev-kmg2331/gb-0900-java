package exceptionTest;

// Exception 상속 : 컴파일러가 체크
// RuntimeException : 
public class BadWordException extends RuntimeException {
	public BadWordException(String message) {
		super(message);
	}
}
