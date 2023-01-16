package collectionTask;

public class Page {
	public static void main(String[] args) {
		UserField field = new UserField();
		User user1 = new User();
		user1.setUserId("kmg2331");
		user1.setUserPw("1234");
		user1.setUserName("강민구");
		user1.setUserPhoneNumber("01034442331");
		
//		회원가입
		field.join(user1);
		
//		전체 DB 출력
		System.out.println(DBConnecter.userDB);
//		로그인 성공 시 User 객체 리턴. 실패 시 null 리턴.
		System.out.println(field.login(user1));
		
////		인증키 전송
//		String verify = field.sendVerify("01034442331");
//		System.out.println(verify);
//		
////		인증키 일치 확인
////		일치함
//		if(field.checkVerify(verify, verify)) {
//			field.changePw("kmg2331", "abc123");
//		}
////		불일치함
//		else System.out.println("인증번호 다름.");
		
		System.out.println(DBConnecter.userDB);
	}
}
