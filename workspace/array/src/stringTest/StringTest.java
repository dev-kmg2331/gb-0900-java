package stringTest;

public class StringTest {
	public static void main(String[] args) {
		String data = "ABC";
		String[] data2 = new String[3]; 
		
//		문자열의 길이
		System.out.println(data.length());
		System.out.println(data2.length);
		
//		원하는 인덱스의 문자 추출
		System.out.println(data.charAt(1));
//		원하는 문자 조회
		System.out.println(data.indexOf('C'));
	}

}
