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
////		���������� ���ο� �ּ� new�� ������ �޸𸮿��� �����ȴ�.
//		obj = new StorageClassTest1();
//		obj.increaseData();
//		obj.increaseData();
//		obj.increaseData();
	}
}
