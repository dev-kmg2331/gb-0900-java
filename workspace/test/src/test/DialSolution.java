package test;

public class DialSolution {
   
   public static int index = 0;
   public static int result2 = 0;
   
   public static void main(String[] args) {
      int data = new DialSolution().solution("82195", "64723");
      int data2 = 0;
      System.out.println(data);
      data = new DialSolution().solution("00000000000000000000", "91919191919191919191");
      data2 = new DialSolution().solution("82195", "64723");
      System.out.println(data);
      System.out.println(data2);
   }
   /*
    * 잠겨 있는 자물쇠
    * 눈금쇠에 맞추면 풀린다. 눈금선 방향 : 정방향 or 역방향
    * 자물쇠를 풀기 위해 회전시키는 횟수의 최솟값을 구할 수 있다.
    * 
    * 현재 눈금선에 있는 숫자 p, 비밀번호 s 가 매개변수로 주어질 때,
    * 최소 회전 횟수를 리턴하는 solution 함수를 작성하여라
    * 
    */
   
   public int solution(String p, String s) {
      
      if(p.length() != s.length()) {
         return -1;
      }
      
      /*
       *  두 정수의 차이는 항상 p - s 의 절대값이다.
       *  2 -> 5 3
       *  3 -> 9 6
       *  8 -> 4 4
       *  근데, 0에서부터 거리를 더하면? ex) 2와 5를 더해준다. | ※ 0 과의 거리는 0에서의 거리 또는 10에서의 거리이다.
      */

//      ******========두 버전 모두 로직은 같음========******
//      ******==========for문 버전==========******
      
      int data = 0, target = 0, zeroDistanceOfP = 0, zeroDistanceOfS = 0, prime = 0;
      int result = 0;
      
      for (int i = 0; i < p.length(); i++) {
         data = Character.getNumericValue(p.charAt(i));
         target = Character.getNumericValue(s.charAt(i));
         
         zeroDistanceOfP = data < 10 - data ? data : 10 - data;
//         System.out.println("0부터 거리 : " + zeroDistanceOfP);
         zeroDistanceOfS = target < 10 - target ? target : 10 - target;
//         System.out.println("0부터 거리 : " + zeroDistanceOfS);
         prime = target - data > 0 ? target - data : data - target;
//         System.out.println("두 수의 거리 : " + prime);
         
         result += zeroDistanceOfP + zeroDistanceOfS < prime ? zeroDistanceOfP + zeroDistanceOfS : prime;
        }
      
//      ******======stream() 버전 (※많이더러움)======******
      
//      index = 0;
//      result2 = 0;
//      
//      p.chars().map(Character::getNumericValue).forEach(i -> {
//         int data = 0, target = 0, zeroP = 0, zeroS = 0, prime = 0;
//         
//         data = i;
//         target = Character.getNumericValue(s.charAt(index));
//         
//         zeroP = data < 10 - data ? data : 10 - data;
////         System.out.println("0부터 거리 : " + zeroP);
//         zeroS = target < 10 - target ? target : 10 - target;
////         System.out.println("0부터 거리 : " + zeroS);
//         prime = target - data > 0 ? target - data : data - target;
////         System.out.println("두 수의 거리 : " + prime);
//         
//         result2 += zeroP + zeroS < prime ? zeroP + zeroS : prime;
//         
//         ++index;
//      });
      
      return result;
//      return result2;
   }
   
   public int solution2(String p, String s) {
	      int answer = 0;
	      
	      for (int i = 0; i < s.length(); i++) {
	         int number = p.charAt(i), target = s.charAt(i), result = target - number;
	         answer += Math.abs(result) > 4 ? 10 - result : Math.abs(result);
	      }
	      return answer;
	   }
}