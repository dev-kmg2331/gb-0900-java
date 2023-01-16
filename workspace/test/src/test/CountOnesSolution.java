package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountOnesSolution {
	public static void main(String[] args) {
		System.out.println(new CountOnesSolution().solution("0111101111110111111111"));
	}
	
	public int solution(String s) {
		
		
//		int count = 0;
//		int max = 0;
//		
//		for (int i = 0; i < s.length(); i++) {
//			if(s.charAt(i) == '1') {
//				++count;
//			}
//			
//			max = count > max ? count : max;
//			
//			if(s.charAt(i) == '0') {
//				count = 0;
//			}
//		}
//		
//		return max;
		
		ArrayList<String> arString = new ArrayList<String>(Arrays.asList(s.split("0")));
		
		List<Integer> results = arString.stream().map(String::length).sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		
		return results.size() == 0 ? 0 : results.get(0);
	}
}
