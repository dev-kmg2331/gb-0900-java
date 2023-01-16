package arrayTest;

public class ArTest1 {
	public static void main(String[] args) {
		int[] arData = {2, 4, 5, 6, 8};
		
//		[I@7637f22 [ : 배열 I : int타입
//		System.out.println(arData);
//		System.out.println(arData.length);
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		
//		5, 4, 3, 2, 1 을 넣고 출력
		for (int i = 0; i < arData.length; i++) {
			arData[i] = 5 - i;
			System.out.println(arData[i]);
		}
	}

}
