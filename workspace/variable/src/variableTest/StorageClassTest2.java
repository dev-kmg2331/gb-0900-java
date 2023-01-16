package variableTest;

public class StorageClassTest2 {
	public static void main(String[] args) {
		StorageClassTest1 obj = new StorageClassTest1();
		
		StorageClassTest1.increaseData_s();
		StorageClassTest1.increaseData_s();
		StorageClassTest1.increaseData_s();
		obj = new StorageClassTest1();
		StorageClassTest1.increaseData_s();
		StorageClassTest1.increaseData_s();
		StorageClassTest1.increaseData_s();
		
//		obj.increaseData();
//		obj.increaseData();
//		obj.increaseData();
////		전역변수는 새로운 주소 new를 만나면 메모리에서 해제된다.
//		obj = new StorageClassTest1();
//		obj.increaseData();
//		obj.increaseData();
//		obj.increaseData();
	}
}
