package methodTest;

public class MethodTask {
//   1~10 ���� println()���� ����ϴ� �޼ҵ�.
//   "ȫ�浿"�� n �� println()���� ����ϴ� �޼ҵ�
//   �̸��� n�� println()���� ����ϴ� �޼ҵ�
//   �� ������ ������ ���ִ� �޼ҵ�
   public static void main(String[] args) {
      MethodTask mt = new MethodTask();
      
//      mt.printNums();
//      mt.printName(10);
//      mt.printName(10, "���α�");
//      System.out.println(mt.subtract(10, 9, 8));
//      int[] result = mt.divide(10, 3);
//      if(result != null) {
//         System.out.printf("�� : %d, ������ : %d", result[0], result[1]);
//      } else System.out.println("0���� ���� �� �����ϴ�.");
      
      System.out.println(mt.sumOfN(100));
      System.out.println(mt.changeNum(2));
      System.out.println(mt.changeString("!@#abcDEF"));
      System.out.println(mt.valueOfindex(new int[]{1, 2, 5, 8}, 2));
      System.out.println("�ѱۿ��� ���ڷ� : " + mt.krToInt("�����̻�"));
      int[] arInt = mt.minAndMax(new int[] {3, 6, 11, 7, 99});
      System.out.printf("�ּҰ� : %d, �ִ밪 : %d\n", arInt[0], arInt[1]);
      int[] arInt2 = new int[] {3, 6, 11, 7, 99};
      int[] arResult = new int[2];
      mt.voidMinAndMax(arInt2, arResult);
      System.out.printf("�ּҰ� : %d, �ִ밪 : %d\n", arResult[0], arResult[1]);
      System.out.println(Integer.parseInt("0123"));
      
      System.out.println(mt.myIndexOf("ABC", 'D'));
   }
   
//   1~n������ ���� �����ִ� �޼ҵ�
   int sumOfN(int n) {
      int result = 0;
      for (int i = 0; i < n; i++) {
         result += i + 1;
      }
      return result;
   }
//   Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
   int changeNum(int num) {
      return num + 1;
   }
//   ���ڿ��� �Է¹ް� �ҹ��ڴ� �빮�ڷ�, �빮�ڴ� �ҹ��ڷ� �ٲ��ִ� �޼ҵ�
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
//   5���� ������ �Է¹��� �� ���ϴ� �ε����� ���� �����ִ� �޼ҵ�
   int valueOfindex(int[] ar, int index) {
      return ar[index];
   }
//   �ѱ��� ������ �ٲ��ִ� �޼ҵ�
   int krToInt(String kr) {
      String hangul = "�����̻�����ĥ�ȱ�";
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
   
//   5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�
   int[] minAndMax(int[] arNum) {
      int min = arNum[0], max = arNum[0];
      for (int i = 1; i < arNum.length; i++) {
         min = arNum[i] < min ? arNum[i] : min;
         max = arNum[i] > max ? arNum[i] : max;
      }
      
      return new int[] {min, max};
   }
   
//   5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�(void)
   void voidMinAndMax(int[] arNum, int[] arResult) {
      int min = arNum[0], max = arNum[0];
      
      for (int i = 1; i < arNum.length; i++) {
         min = arNum[i] < min ? arNum[i] : min;
         max = arNum[i] > max ? arNum[i] : max;
         arResult[0] = min;
         arResult[1] = max;
      }
      
   }
   
//   indexOf() �����
//   ���ڿ��� ���ڸ� ���ڸ� �Է¹��� �� �ش� ���ڰ� �� ���� �ε����� �ִ� �� �˻��ϰ�
//   ���� �ش� ���ڰ� ������ -1�� �����Ѵ�.
   
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
         System.out.println("ȫ�浿");
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
//   �� ������ ������ �� ��� ������ �� ���� ���ϴ� �޼ҵ�
   int[] divide(int num1, int num2) {
      int[] result = null;
      
      return num2 == 0 ? result : new int[]{num1 / num2, num1 % num2};
   }
   
}