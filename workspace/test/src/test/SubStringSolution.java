package test;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SubStringSolution {
	private static int pSum;
	
	public int Solution(String t, String p) {
		int answer = 0;
		int pLength = 0;
		ArrayList<String> arr = new ArrayList<String>();
		
		pLength = p.length();
		
		int digit = (int) Math.pow(10, pLength - 1);
		
		pSum = stringCharSum(p, digit);
		
		for (int i = 0; i < t.length(); i++) {
			String temp = "";
			
			if(i + pLength > t.length()) {
				break;
			}
			
			temp = t.substring(i, i + pLength);
			
			arr.add(temp);
		}
		
		System.out.println(arr);
		
		arr.stream().filter(s -> pSum > stringCharSum(s, digit)).forEach(System.out::println);
		
		answer = arr.stream().filter(s -> pSum > stringCharSum(s, digit)).collect(Collectors.toList()).size();
		
		return answer;
	}

	/**
     * 주어진 숫자 문자열의 각 자릿수 * 해당 자리의 아스키코드 값을 차례로 더해준다.
     *
     * @author 강민구
     * @return int
     * @version 1.0
     * 
     * @param t : 주어진 숫자 문자열
     * @param digit : 해당 숫자의 자릿수 ex) 3자리면 100
     */
	private int stringCharSum(String t, int digit) {
		int sum = 0;
		
		for(char c : t.toCharArray()) {
			sum += c*digit;
			digit = digit / 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		SubStringSolution ss = new SubStringSolution();
		System.out.println(ss.stringCharSum("271", 100));
		
		System.out.println(ss.Solution("12458012355", "271"));
	}
}
