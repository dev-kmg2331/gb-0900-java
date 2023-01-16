package lambdaTask;

public class Calc {
//	[심화 실습]
//			여러 개의 정수를 입력받아서 알맞는 덧셈, 뺄셈 결과를 확인하는 애플리케이션 제작
//
//			입력 예1) 7 + 35 - 9
//			출력 예1) 33
//
//			입력 예2) -9 + 8 + 10
//			출력 예2) 9
//
//			* "ABC".split("")은 [A][B][C] 3칸 문자열 배열로 리턴된다.
//			   "A,B,C".split(",")은 [A][B][C] 3칸 문자열 배열로 리턴된다.
//			   split("구분점")을 전달하면 문자열에서 동일한 구분점을 기준으로 문자열 값을 잘라낸 후 문자열 배열로 리턴한다.
//			   구분점을 여러 개 사용할 때에는 split("구분점|구분점")으로 사용하며, "+", "-"를 구분점으로 사용할 때에는 "+", "-"로 표현한다.
//			   예)"4 + 9".split("+")은 [4][9] 2칸 문자열 배열로 리턴
//
//			* 사용자가 정상적으로만 입력한다는 가정 하에 구현하도록 한다.
//			* 두 정수를 전달받은 후 int로 리턴하는 calc 추상메소드 선언(함수형 인터페이스 제작)
//			* 두 정수의 덧셈, 뺄셈을 구해주는 함수형 인터페이스를 리턴하는 static 메소드 선언(람다식 리턴)
//			* 전체 식을 전달받은 후 String[]로 리턴하는 getOpers 추상메소드 선언(함수형 인터페이스 제작)
//			* main메소드에 getOper를 람다식으로 구현
//			* 첫번째 정수가 음수일 경우 오류 해결
	
	public static CalcInter calcTwo(boolean isSum) {
		
		if(isSum) {
			return (a, b) -> a + b;
		}
		
		return (a, b) -> a - b;
	}
	
	public static void main(String[] args) {
		String input = "9+3-4-2";
		String[] a = input.split("+");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
