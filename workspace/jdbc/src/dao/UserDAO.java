package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.UserVO;

public class UserDAO {

	public Connection con; // 연결 객체
	public PreparedStatement pr; // 쿼리 관리 객체
	public ResultSet rs; // 결과 테이블 객체
	
	private static final int KEY = 3;
	
	String[] sqlErrorMsgs = {
			"checkId() ",
			"join() "
	};
	String[] errorMsgTypes = {
			"SQL문 오류"
	};
	
//	아이디 중복검사
//	중복이 없을 떄 true 있을 떄 false
	public boolean checkId(String userIdentification) {
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER "
				+ "WHERE USER_IDENTIFICATION = ?";
		boolean result = false;
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, userIdentification);
			rs = pr.executeQuery();

			rs.next();
			result = rs.getInt(1) == 0;
			
		} catch (SQLException e) {
			System.out.println(sqlErrorMsgs[0] + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return result;
	}
	
//	회원가입
	public void join(UserVO vo) {
		String query = "INSERT INTO TBL_USER (USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID) "
				+ "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int success = 0;
		
		if(!checkId(vo.getUserIdentification())) {
			System.out.println(success == 0 ? "회원가입 실패!" : "회원가입 성공!");
			return;
		}
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			
			pr.setString(1, vo.getUserIdentification());
			pr.setString(2, vo.getUserName());
			pr.setString(3, encryptPassword(vo.getUserPassword()));
			pr.setString(4, vo.getUserPhone());
			pr.setString(5, vo.getUserNickname());
			pr.setString(6, vo.getUserEmail());
			pr.setString(7, vo.getUserAddress());
			pr.setString(8, vo.getUserBirth());
			pr.setString(9, vo.getUserGender());
			pr.setString(10, vo.getUserRecommenderId());
			
			success = pr.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("select() " + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println(success == 0 ? "회원가입 실패!" : "회원가입 성공!");
	}

//	로그인
	public UserVO login(String userIdentification, String password) {
		UserVO vo = null;
		String query = "SELECT USER_ID "
				+ "FROM TBL_USER "
				+ "WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		
		if(checkId(userIdentification)) {
			return vo;
		}
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, userIdentification);
			pr.setString(2, encryptPassword(password));
			rs = pr.executeQuery();
			
			if(rs.next()) {
				vo = select(rs.getLong(1));
			}
			
		} catch (SQLException e) {
			System.out.println("select() " + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return vo;
	}
	
//	암호화
	public String encryptPassword(String pw) {
		String result = "";
		for(char c : pw.toCharArray()) {
			result += (char)(c * KEY);
		}
		
		return result;
	}

//	복호화
	public String decryptPassword(String pw) {
		String result = "";
		for(char c : pw.toCharArray()) {
			result += (char)(c / KEY);
		}
		
		return result;	
	}
	
//	회원탈퇴
	public void quitUser(Long userId) {
		UserVO vo = null;
		
		vo = select(userId);
		
		if(vo != null) {
			Long deletedUserId = vo.getUserId();
			vo.setUserIdentification("DELETED_IDENTIFICATION" + deletedUserId);
			System.out.println(vo);
		}
		
		updateUser(vo);
	}
	
//	아이디 찾기
	public String findIdentification(String email, String phone) {
		UserVO vo = null;
		String query = "SELECT USER_ID "
				+ "FROM TBL_USER "
				+ "WHERE USER_EMAIL = ? AND USER_PHONE = ?";
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, email);
			pr.setString(2, phone);
			rs = pr.executeQuery();
			
			if(rs.next()) {
				vo = select(rs.getLong(1));
			}
			
		} catch (SQLException e) {
			System.out.println("select() " + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return vo == null ? null : vo.getUserIdentification();
	}
	
//	비밀번호 변경
	public void updatePassword(UserVO vo) {
		updateUser(vo);
	}
	
//	회원정보 수정
	public void updateUser(UserVO vo) {
		String query = "UPDATE TBL_USER "
				+ "SET USER_IDENTIFICATION=?, USER_NAME=?, USER_PASSWORD=?, USER_PHONE=?, USER_NICKNAME=?, USER_EMAIL=?, "
				+ "USER_ADDRESS=?, USER_BIRTH=?, USER_GENDER=? , USER_RECOMMENDER_ID=? "
				+ "WHERE USER_ID= ?";
		int success = 0;
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			
			pr.setString(1, vo.getUserIdentification());
			pr.setString(2, vo.getUserName());
			pr.setString(3, encryptPassword(vo.getUserPassword()));
			pr.setString(4, vo.getUserPhone());
			pr.setString(5, vo.getUserNickname());
			pr.setString(6, vo.getUserEmail());
			pr.setString(7, vo.getUserAddress());
			pr.setString(8, vo.getUserBirth());
			pr.setString(9, vo.getUserGender());
			pr.setString(10, vo.getUserRecommenderId());
			pr.setLong(11, vo.getUserId());
			
			success = pr.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("select() " + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println(success == 0 ? "회원 수정 실패!" : "회원 수정 성공!");
	}
	
//	회원정보 조회
	public UserVO select(Long userId) {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER WHERE USER_ID = ?";
		UserVO vo = new UserVO();
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			rs = pr.executeQuery();
			
			if(rs.next()) {
				vo.setUserId(rs.getLong(1));
				vo.setUserIdentification(rs.getString(2));
				vo.setUserName(rs.getString(3));
				vo.setUserPassword(decryptPassword(rs.getString(4)));
				vo.setUserPhone(rs.getString(5));
				vo.setUserNickname(rs.getString(6));
				vo.setUserEmail(rs.getString(7));
				vo.setUserAddress(rs.getString(8));
				vo.setUserBirth(matchDateFormat(rs.getString(9)));
				vo.setUserGender(rs.getString(10));
				vo.setUserRecommenderId(rs.getString(11));
			}
			
		} catch (SQLException e) {
			System.out.println("select() " + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return vo;
	}

//	추천수
	public int countReccommends(String identification) {
		String query = "SELECT COUNT(USER_ID) "
				+ "FROM TBL_USER "
				+ "WHERE USER_RECOMMENDER_ID = ?";

		int result = 0;
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, identification);
			rs = pr.executeQuery();
			
			result = rs.next() ? rs.getInt(1) : 0;
			
		} catch (SQLException e) {
			System.out.println("select() " + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return result;
	}
	
//	나를 추천한 사람
	public ArrayList<UserVO> getReccommendList(String identification){
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER WHERE USER_RECOMMENDER_ID = ? "
				+ "ORDER BY USER_ID DESC";
		
		UserVO vo = new UserVO();
		ArrayList<UserVO> result = new ArrayList<UserVO>();
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, identification);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				vo.setUserId(rs.getLong(1));
				vo.setUserIdentification(rs.getString(2));
				vo.setUserName(rs.getString(3));
				vo.setUserPassword(rs.getString(4));
				vo.setUserPhone(rs.getString(5));
				vo.setUserNickname(rs.getString(6));
				vo.setUserEmail(rs.getString(7));
				vo.setUserAddress(rs.getString(8));
				vo.setUserBirth(rs.getString(9));
				vo.setUserGender(rs.getString(10));
				vo.setUserRecommenderId(rs.getString(11));
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("select() " + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return result;
	}
	
//	내가 추천한 사람
	public UserVO getReccommendedUser(String identification) {
		UserVO vo = null;
		String query = "SELECT USER_ID "
				+ "FROM TBL_USER "
				+ "WHERE USER_IDENTIFICATION = ?";
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, identification);
			rs = pr.executeQuery();
			
			if(rs.next()) {
				vo = select(rs.getLong(1));
			}
			
		} catch (SQLException e) {
			System.out.println("select() " + errorMsgTypes[0]);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return vo;
	}
	
	private String matchDateFormat(String s) {
		String[] temp = s.split(" ");
		return temp[0];
	}
}
