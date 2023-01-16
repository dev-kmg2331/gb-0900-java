package collectionTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	public static void main(String[] args) {
//		<?> : 제네릭
//		객체화 시 타입을 지정하는 기법
//		설계할 때에는 타입을 지정할 수 없기 때문에 임시로 타입을 선언할 때 사용된다.
//		따로 다운 캐스팅을 할 필요가 없으며, 지정할 타입에 제한을 줄 수 있다.
		
//		<A extends Number> 도 가능
		
		final int SIZE = 9;
		
		ArrayList<Integer> datas = new ArrayList<Integer>();
//		System.out.println(datas.size());
		
		for (int i = 0; i < SIZE; i++) {
			if(i > 4) {
				datas.add(i + 1);
				continue;
			}
			datas.add((i + 1) * 10);
		}
		
		System.out.println(datas);
		
//		Collections.sort(datas);

//		추가(삽입)
//		50 뒤에 500 삽입
		
		if(datas.indexOf(50) != -1) {
			datas.add(datas.indexOf(50) + 1, 500);
		}
		
		System.out.println(datas);
		
//		수정
//		90을 9로 수정
		
		if(datas.contains(9)) {
			datas.replaceAll(n -> n == 9 ? n * 10 : n);
		}

		System.out.println(datas);
		
//		삭제
//		80 삭제
		
		datas.add(80);
		datas.add(80);
		
//		1. 인덱스로 삭제
		if(datas.indexOf(80) != -1) {
			datas.remove(datas.indexOf(80));
		}
		
		System.out.println(datas);
		
//		2. 값으로 삭제
		
		datas.remove(Integer.valueOf(80));
		
		System.out.println(datas);
		
	}
}
