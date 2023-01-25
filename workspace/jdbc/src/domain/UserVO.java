package domain;

public class UserVO {
//	CREATE TABLE TBL_USER(
//			USER_ID NUMBER CONSTRAINT PK_USER PRIMARY KEY,
//			USER_IDENTIFICATION VARCHAR2(500) CONSTRAINT UK_USER_IDENTIFICATION UNIQUE NOT NULL,
//			USER_NAME VARCHAR2(500) NOT NULL,
//			USER_PASSWORD VARCHAR2(500) NOT NULL,
//			USER_PHONE VARCHAR2(100) NOT NULL,
//			USER_NICKNAME VARCHAR2(500),
//			USER_EMAIL VARCHAR2(100) CONSTRAINT UK_USER_EMAIL UNIQUE NOT NULL,
//			USER_ADDRESS VARCHAR2(500) NOT NULL,
//			USER_BIRTH DATE,
//			USER_GENDER CHAR(1) DEFAULT 'N' CONSTRAINT CHECK_USER_GENDER CHECK(USER_GENDER IN('M', 'W', 'N')),
//			USER_RECOMMENDER_ID VARCHAR2(500)
//		);
	
//	null 검사를 위해 Long 클래스 타입 사용
	private Long userId;
	private String userIdentification;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userNickname;
	private String userEmail;
	private String userAddress;
	private String userBirth;
	private String userGender;
	private String userRecommenderId;
	
	public UserVO() {;}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserIdentification() {
		return userIdentification;
	}
	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserRecommenderId() {
		return userRecommenderId;
	}
	public void setUserRecommenderId(String userRecommenderId) {
		this.userRecommenderId = userRecommenderId;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userIdentification=" + userIdentification + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userPhone=" + userPhone + ", userNickname=" + userNickname
				+ ", userEmail=" + userEmail + ", userAddress=" + userAddress + ", userBirth=" + userBirth
				+ ", userGender=" + userGender + ", userRecommenderId=" + userRecommenderId + "]";
	}
	
}
