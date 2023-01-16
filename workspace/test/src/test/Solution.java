package test;

class Solution {
    public int[] solution(String s) {
    	String temp = "";
    	int[] answer = new int[s.length()];
    	
        for (int i = 0; i < s.length(); i++) {
			temp += s.charAt(i);
			
			if(temp.length() < 2) {
				answer[i] = -1;
				continue;
			}
			
		}
    	
        return answer;
    }
}
