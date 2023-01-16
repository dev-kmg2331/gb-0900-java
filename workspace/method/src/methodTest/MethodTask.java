package methodTest;

public class MethodTask {
//   1~10 까지 println()으로 출력하는 메소드.
//   "홍길동"을 n 번 println()으로 출력하는 메소드
//   이름을 n번 println()으로 출력하는 메소드
//   세 정수의 뺄셈을 해주는 메소드
   public static void main(String[] args) {
      MethodTask mt = new MethodTask();
      
//      mt.printNums();
//      mt.printName(10);
//      mt.printName(10, "강민구");
//      System.out.println(mt.subtract(10, 9, 8));
//      int[] result = mt.divide(10, 3);
//      if(result != null) {
//         System.out.printf("몫 : %d, 나머지 : %d", result[0], result[1]);
//      } else System.out.println("0으로 나눌 수 없습니다.");
      
      System.out.println(mt.sumOfN(100));
      System.out.println(mt.changeNum(2));
      System.out.println(mt.changeString("!@#abcDEF"));
      System.out.println(mt.valueOfindex(new int[]{1, 2, 5, 8}, 2));
      System.out.println("한글에서 숫자로 : " + mt.krToInt("공일이삼"));
      int[] arInt = mt.minAndMax(new int[] {3, 6, 11, 7, 99});
      System.out.printf("최소값 : %d, 최대값 : %d\n", arInt[0], arInt[1]);
      int[] arInt2 = new int[] {3, 6, 11, 7, 99};
      int[] arResult = new int[2];
      mt.voidMinAndMax(arInt2, arResult);
      System.out.printf("최소값 : %d, 최대값 : %d\n", arResult[0], arResult[1]);
      System.out.println(Integer.parseInt("0123"));
      
      System.out.println(mt.myIndexOf("ABC", 'D'));
   }
   
//   1~n까지의 합을 구해주는 메소드
   int sumOfN(int n) {
      int result = 0;
      for (int i = 0; i < n; i++) {
         result += i + 1;
      }
      return result;
   }
//   홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
   int changeNum(int num) {
      return num + 1;
   }
//   문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
   String changeString(String data) {
      String result = "";
      for (int i = 0; i < data.length(); i++) {
         char c = data.charAt(i);
         boolean cap =  c > 'A' - 1 && c < 'Z' + 1;
         boolean sml = c > 'a' - 1 && c < 'z' + 1;
         
         if(!cap && !sml) {
            result += c;
            continue;
         }
         
         result += cap ? (char)(c + 32) : (char)(c - 32);
      }
      
      return result;
   }
//   5개의 정수를 입력받은 후 원하는 인덱스의 값을 구해주는 메소드
   int valueOfindex(int[] ar, int index) {
      return ar[index];
   }
//   한글을 정수로 바꿔주는 메소드
   int krToInt(String kr) {
      String hangul = "공일이삼사오육칠팔구";
      String temp = "";
      int result = 0;
      
      for (int i = 0; i < kr.length(); i++) {
         int index = hangul.indexOf(kr.charAt(i));
         
         if(index == -1) {
            result = -1;
            break;
         }
         
         temp += "" + index;
      }
      
      return result != -1 ? Integer.parseInt(temp) : result;
   }
   
//   5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
   int[] minAndMax(int[] arNum) {
      int min = arNum[0], max = arNum[0];
      for (int i = 1; i < arNum.length; i++) {
         min = arNum[i] < min ? arNum[i] : min;
         max = arNum[i] > max ? arNum[i] : max;
      }
      
      return new int[] {min, max};
   }
   
//   5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void)
   void voidMinAndMax(int[] arNum, int[] arResult) {
      int min = arNum[0], max = arNum[0];
      
      for (int i = 1; i < arNum.length; i++) {
         min = arNum[i] < min ? arNum[i] : min;
         max = arNum[i] > max ? arNum[i] : max;
         arResult[0] = min;
         arResult[1] = max;
      }
      
   }
   
//   indexOf() 만들기
//   문자열과 문자를 문자를 입력받은 뒤 해당 문자가 몇 번쨰 인덱스에 있는 지 검사하고
//   만약 해당 문자가 없으면 -1을 리턴한다.
   
   int myIndexOf(String str, char c) {
	   for (int i = 0; i < str.length(); i++) {
		   if(str.charAt(i) == c) {
			   return i;
		   }
	   }
	   return -1;
   }
   
//   ---------------------------------------------------------------------------
   
   void printNums() {
      for (int i = 0; i < 10; i++) {
         System.out.println(i + 1);
      }
   }
   
   void printName(int count) {
      for (int i = 0; i < count; i++) {
         System.out.println("홍길동");
      }
   }
   
   void printName(int count, String name) {
      for (int i = 0; i < count; i++) {
         System.out.println(name);
      }
   }
   
   int subtract(int num1, int num2, int num3) {
      return num1 - num2 - num3;
   }
//   두 정수의 나눗셈 후 몫과 나머지 두 개를 구하는 메소드
   int[] divide(int num1, int num2) {
      int[] result = null;
      
      return num2 == 0 ? result : new int[]{num1 / num2, num1 % num2};
   }
   
}