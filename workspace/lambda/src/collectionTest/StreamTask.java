package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamTask {
	public static void main(String[] args) {
		ArrayList<Integer> datas = new ArrayList<Integer>();
		
		IntStream.rangeClosed(1, 10).forEach(v -> datas.add(11 - v));
		
		System.out.println(datas);
		
		datas.removeAll(datas);
		
		IntStream.rangeClosed(1, 10).forEach(datas::add);
		
		System.out.println(datas);
		
//		ABCDEF를 각 문자별로 출력
		"ABCDEF".chars().forEach(v -> System.out.println((char)v));
		IntStream.rangeClosed('A', 'F').forEach(c -> System.out.println((char)c));
		
//		1~100 까지 중 홀수만 ArrayList에 담고 출력
		datas.removeAll(datas);
		
		IntStream.rangeClosed(1, 50).map(v -> v * 2 - 1).forEach(datas::add);
		
		System.out.println(datas);
		
//		A~F까지 중 D 제외하고 ArrayList에 담고 출력
		datas.removeAll(datas);
		ArrayList<Character> charData = new ArrayList<Character>();
		
		IntStream.rangeClosed('A', 'E').map(c -> c  > 'C' ? c + 1 : c).forEach(c -> charData.add((char)c));
		
		System.out.println(charData);
		
//		5개의 문자열을 모두 소문자로 변경(Black, WHITE, reD, yeLLow, PINk), toLowerCase()
		ArrayList<String> stringData = new ArrayList<String>(Arrays.asList("Black", "WHITE", "reD", "yeLLow", "PINk"));
		stringData.stream().map(String::toLowerCase).forEach(System.out::println);
		
//		1~100 까지 중 홀수만 ArrayList에 담고 출력(filter)
		datas.removeAll(datas);
		
		IntStream.rangeClosed(1, 100).filter(n -> n % 2 != 0).forEach(datas::add);
		
		System.out.println(datas);
		
//		Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력
		ArrayList<String> stringData2 = new ArrayList<String>(Arrays.asList("Apple", "banana", "Melon"));		
		stringData2.stream().filter(s -> s.charAt(0) < 'a').forEach(System.out::println);
		
//		한글을 정수로 변경
		String hangul = "공일이삼사오육칠팔구";
		"일오육삼".chars().map(hangul::indexOf).forEach(System.out::println);
		
//		정수를 한글로 변경
		int numData = 1567990;
		String.valueOf(numData).chars().map(Character::getNumericValue).forEach(c -> System.out.println(hangul.charAt(c)));
		
//		String.valueOf(numData).chars().map(c -> hangul.charAt(c - '0')).forEach(c -> System.out.print((char)c));
	
	}
}
