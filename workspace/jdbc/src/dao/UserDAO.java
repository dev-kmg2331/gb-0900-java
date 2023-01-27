package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import domain.UserVO;

public class UserDAO {

	public Connection con; // 연결 객체
	public PreparedStatement pr; // 쿼리 관리 객체
	public ResultSet rs; // 결과 테이블 객체
	
	public static HashMap<String, Object> httpRequestSession = new HashMap<String, Object>();
	
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
		String tbl_userQuery = "INSERT INTO TBL_USER (USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID) "
				+ "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";
		
		String userIdentification = null;
		Long selectedUserId = 0L;
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(tbl_userQuery);
			
			pr.setString(1, vo.getUserIdentification());
			pr.setString(2, vo.getUserName());
			pr.setString(3, getBase64EncodedPassword(vo.getUserPassword()));
			pr.setString(4, vo.getUserPhone());
			pr.setString(5, vo.getUserNickname());
			pr.setString(6, vo.getUserEmail());
			pr.setString(7, vo.getUserAddress());
			pr.setString(8, vo.getUserBirth());
			pr.setString(9, vo.getUserGender());
			pr.setString(10, vo.getUserRecommenderId());
			
			pr.executeUpdate();
			
			userIdentification = vo.getUserRecommenderId();
			
			if(userIdentification != null) {
				selectedUserId = getUserIdByIdentification(userIdentification);
				increseUserRecommendCount(selectedUserId);
			}
			
		} catch (SQLException e) {
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
	}

	private String getBase64EncodedPassword(String s) {
		return new String(Base64.getEncoder().encode(s.getBytes()));
	}

//	로그인
	public UserVO login(String userIdentification, String password) {
		UserVO vo = null;
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER "
				+ "WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, userIdentification);
			pr.setString(2, getBase64EncodedPassword(password));
			rs = pr.executeQuery();
			
			if(rs.next()) {
				vo = setUserVO(rs);
			}
			
		} catch (SQLException e) {
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
//	private String encryptPassword(String pw) {
//		String result = "";
//		for(char c : pw.toCharArray()) {
//			result += (char)(c * KEY);
//		}
//		
//		return result;
//	}

//	복호화
//	private String decryptPassword(String pw) {
//		String result = "";
//		for(char c : pw.toCharArray()) {
//			result += (char)(c / KEY);
//		}
//		
//		return result;
//	}
	
//	회원탈퇴
	public void quitUser() {
		UserVO vo = null;
		
		vo = select();
		
		if(vo != null) {
			Long deletedUserId = vo.getUserId();
			vo.setUserIdentification("DELETED_IDENTIFICATION" + deletedUserId);
			updateUser(vo);
		}
		
	}
	
//	아이디 찾기
	public String findIdentification(String email, String phone) {
		String result = null;
		String query = "SELECT USER_IDENTIFICATION "
				+ "FROM TBL_USER "
				+ "WHERE USER_EMAIL = ? AND USER_PHONE = ?";
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setString(1, email);
			pr.setString(2, phone);
			rs = pr.executeQuery();
			
			if(rs.next()) {
				result = rs.getString(1);
			}
			
		} catch (SQLException e) {
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
	
//	비밀번호 변경
	public void updatePassword(String pw) {
		String query = "UPDATE TBL_USER "
				+ "SET USER_PASSWORD = ? "
				+ "WHERE USER_ID= ?";
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			
			pr.setString(1, getBase64EncodedPassword(pw));
			pr.setLong(2, (Long)httpRequestSession.get("userId"));
			
			pr.executeUpdate();
			
		} catch (SQLException e) {
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
	}
	
//	회원정보 수정
	public void updateUser(UserVO vo) {
		String query = "UPDATE TBL_USER "
				+ "SET USER_IDENTIFICATION=?, USER_NAME=?, USER_PASSWORD=?, USER_PHONE=?, USER_NICKNAME=?, USER_EMAIL=?, "
				+ "USER_ADDRESS=?, USER_BIRTH=TO_DATE(?, 'YYYY-MM-DD'), USER_GENDER=? , USER_RECOMMENDER_ID=? "
				+ "WHERE USER_ID= ?";
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			
			pr.setString(1, vo.getUserIdentification());
			pr.setString(2, vo.getUserName());
			pr.setString(3, getBase64EncodedPassword(vo.getUserPassword()));
			pr.setString(4, vo.getUserPhone());
			pr.setString(5, vo.getUserNickname());
			pr.setString(6, vo.getUserEmail());
			pr.setString(7, vo.getUserAddress());
			pr.setString(8, vo.getUserBirth());
			pr.setString(9, vo.getUserGender());
			pr.setString(10, vo.getUserRecommenderId());
			pr.setLong(11, (Long)httpRequestSession.get("userId"));
			
			pr.executeUpdate();
			
		} catch (SQLException e) {
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
	}
	
//	회원정보 조회 (회원용)
	public UserVO select() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER WHERE USER_ID = ?";
		UserVO vo = null;
		Long userId = (Long)httpRequestSession.get("userId");
		
		if(userId == null) return vo;
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			rs = pr.executeQuery();
			
			if(rs.next()) {
				vo = setUserVO(rs);
			}
			
		} catch (SQLException e) {
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
	public int countReccommends(Long userId) {
		String query = "SELECT RECOMMEND_COUNT "
				+ "FROM TBL_RECOMMEND "
				+ "WHERE USER_ID = ?";

		int result = 0;
		
		con = DBConnector.getConnection();
		
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			rs = pr.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
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
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setString(1, identification);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				
				vo = setUserVO(rs);
				
				result.add(vo);
			}      
			
		} catch (SQLException e) {
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
	public UserVO getReccommendedUser(Long userId) {
		UserVO vo = null;
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER "
				+ "WHERE USER_IDENTIFICATION = "
				+ "	("
				+ "		SELECT USER_RECOMMENDER_ID "
				+ "		FROM TBL_USER u "
				+ "		WHERE u.USER_ID = ? "
				+ "	)";
		
		try {
			con = DBConnector.getConnection();
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			rs = pr.executeQuery();
			
			if(rs.next()) {
				vo = setUserVO(rs);
			}
			
		} catch (SQLException e) {
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
	
	
	private Long getUserIdByIdentification(String userIdentification) {
		
		String getUserIdQuery = "SELECT USER_ID "
				+ "FROM TBL_USER "
				+ "WHERE USER_IDENTIFICATION = ? ";
		
		Long userId = 0L;
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(getUserIdQuery);
			pr.setString(1, userIdentification);
			rs = pr.executeQuery();
			
			if(rs.next()) userId = rs.getLong(1);
			
		} catch (SQLException e) {
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
		
		return userId;
	}
	
	public void increseUserRecommendCount(Long userId) {
		String tbl_RecommendQuery = "UPDATE TBL_RECOMMEND SET RECOMMEND_COUNT = RECOMMEND_COUNT + 1 WHERE USER_ID = ? ";
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(tbl_RecommendQuery);
			pr.setLong(1, userId);
			pr.executeUpdate();
			
			System.out.println("추천수 증가.");
			
		} catch (SQLException e) {
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
	}
	
	private UserVO setUserVO(ResultSet rs) throws SQLException {
		UserVO vo = new UserVO();
		
		vo.setUserId(rs.getLong(1));
		vo.setUserIdentification(rs.getString(2));
		vo.setUserName(rs.getString(3));
		vo.setUserPassword(rs.getString(4));
		vo.setUserPhone(rs.getString(5));
		vo.setUserNickname(rs.getString(6));
		vo.setUserEmail(rs.getString(7));
		vo.setUserAddress(rs.getString(8));
		vo.setUserBirth(matchDateFormat(rs.getString(9)));
		vo.setUserGender(rs.getString(10));
		vo.setUserRecommenderId(rs.getString(11));
		
		return vo;
	}
	
	private String matchDateFormat(String s) {
		return s.split(" ")[0];
	}
	
}
