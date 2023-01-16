package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
		HashMap<String, Integer> chinaTown = new HashMap<String, Integer>();
		ArrayList<Integer> datas= new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50));
		
		chinaTown.put("짜장면", 4500);
		chinaTown.put("짬뽕", 5500);
		chinaTown.put("탕수육", 12500);
		
//		forEach()
//		여러 값을 가지고 있는 컬렉션 객체에서 forEach메소드를 사용할 수 있다.
//		forEach() 메소드에는 Consumer 인터페이스 타입의 값을 전달해야 한다.
//		Consumer는 함수형 인터페이스이기 때문에 람다식을 사용할 수 있다.
//		매개변수에는 컬렉션 객체 안에 들어있는 값들이 순서대로 담기고,
//		화살표 뒤에서는 실행하고 싶은 문장을 작성한다.
		
//		chinaTown.values().stream().forEach(v -> System.out.println(v));
//		Collection 에서 forEach()는 따로 만들어놓음
//		chinaTown.values().forEach(v -> System.out.println(v));
		chinaTown.values().forEach(System.out::println);
		
		datas.forEach(System.out::println);
		
		IntStream.range(0, 10).forEach(datas::add);
		
		System.out.println(datas);
		
//		chars() : 문자열을 IntStream으로 변경
		String charData = "ABC";
		charData.chars().forEach(v -> System.out.print((char)v));
		
//		map() : 기존 값을 원하는 값으로 변경
		"ABC".chars().map(c -> c + 3).forEach(c -> System.out.print((char)c));
		
		ArrayList<User> users = new ArrayList<User>(Arrays.asList(
				new User(1, "강민구", 20),
				new User(2, "강민구", 22),
				new User(3, "강민구", 24)));
		
//		filter() : 조건식이 true일 경우만 추출
		IntStream.rangeClosed(1, 10).filter(n -> n % 2 == 0).forEach(System.out::print);
		
		System.out.println();
		
//		sorted()
		Integer[] arData = {10, 40, 23, 32, 50};
		ArrayList<Integer> integerArray = new ArrayList<Integer>(Arrays.asList(arData));
		
		integerArray.stream().sorted().forEach(System.out::print);
		integerArray.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);
		
//		collect() : 결과를 다양한 타입으로 리턴해준다.
		
		ArrayList<Integer> result = null;
		result = (ArrayList<Integer>) integerArray.stream().sorted().collect(Collectors.toList());
		
	}
}
