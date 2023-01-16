package classTest;

class A {
//	ÇÊµå
	int data;
	
	A(int data) {
		this.data = data;
	}
	
	void printData() {
		System.out.println(data);
	}
}

public class ClassTest {
	public static void main(String[] args) {
		A a = new A(20);
		A a2 = new A(35);
		System.out.println(a);
		System.out.println(a.data);
		System.out.println(a2.data);
	}
}
