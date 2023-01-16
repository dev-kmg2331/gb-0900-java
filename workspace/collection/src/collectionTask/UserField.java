package collectionTask;

import java.util.ArrayList;
import java.util.Random;

public class UserField {
	public ArrayList<User> arUser = DBConnecter.userDB;
	private final int ENCRYPTION_KEY = 3;
	
//	아이디 중복검사
	public User checkId(String userId) {
		User result = null;
		for(User user : arUser) {
			if(user.getUserId().equals(userId)) {
				return user;
			}
		}
		return result;
	}
	
//	회원가입
	public void join(User user) {
		User result = new User();
		
		if(checkId(user.getUserId()) != null) {
			return;
		}
		
		result.setUserId(user.getUserId());
		result.setUserPw(encryptPw(user.getUserPw()));
		result.setUserName(user.getUserName());
		result.setUserPhoneNumber(user.getUserPhoneNumber());
		
		arUser.add(result);
	}
	
//	로그인
	public User login(User user) {
		for(User result : arUser) {
			if(result.getUserId().equals(user.getUserId()) && result.getUserPw().equals(encryptPw(user.getUserPw()))) {
				return result;
			}
		}
		return null;
	}
	
//	인증키 전송.
	public String sendVerify(String userPhoneNumber) {
		String verifyNumber = null;
		
		Random rd = new Random();
		SmsApi api = new SmsApi();
		
//		5자리의 랜덤한 숫자 인증번호 생성
		verifyNumber = "" + rd.nextInt(10) + rd.nextInt(10000);
		api.sendSMS(verifyNumber, userPhoneNumber);
		
		return verifyNumber;
	}
	 
//	인증키 일치 확인
	public boolean checkVerify(String validVerifyNumber, String userVerifyNumber) {
		return validVerifyNumber.equals(userVerifyNumber);
	}
	
//	비밀번호 변경
	public void changePw(String userId, String newUserPw) {
		User user = checkId(userId);
		user.setUserPw(encryptPw(newUserPw));
	}
	
//	비밀번호 암호화
	private String encryptPw(String userPw) {
		String encryptedPw = "";
		for(char c : userPw.toCharArray()) {
			encryptedPw += (char)(c - ENCRYPTION_KEY);
		}
		
		return encryptedPw;
	}
}
