package test;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class HallOfFameSolution {
	public static void main(String[] args) {
		new HallOfFameSolution().solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
	}
	
	public int[] solution(int k, int[] score) {
		
		ArrayList<Integer> arrScore = new ArrayList<Integer>();
		ArrayList<Integer> arrAnswer = new ArrayList<Integer>();
		int[] answer = {};
		
		for(int i : score) {
			arrScore.add(i);
		}
		
		System.out.println(arrScore.subList(0, 2));
		
        
        for (int i = 1; i < arrScore.size() + 1; i++) {
        	
        	int startIndex = i > 3 ? i - 3 : 0;
        	int endIndex = i;
        	
        	int low = arrScore.subList(startIndex, endIndex).stream().sorted().collect(Collectors.toList()).get(0);
        	arrAnswer.add(low);
		}
        
        System.out.println(arrAnswer);
        
        return answer;
    }
}
