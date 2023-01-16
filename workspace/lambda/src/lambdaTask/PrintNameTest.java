package lambdaTask;

public class PrintNameTest {
	public static void main(String[] args) {
		PrintName printName = (first, last) -> first + " " + last;
		new PrintNameTest().printFullName(printName, "강", "민구");
	}
	
	public void printFullName(PrintName printName, String firstName, String lastName){
		System.out.println(printName.getFullName(firstName, lastName));
	}
}
