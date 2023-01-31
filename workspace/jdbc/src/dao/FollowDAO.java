package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.UserVO;

public class FollowDAO {
	
	public Connection con; // 연결 객체
	public PreparedStatement pr; // 쿼리 관리 객체
	public ResultSet rs;
	
//	신규 팔로우
	public void insertFollow(Long followerId) {
		String query = "INSERT INTO TBL_USER_FOLLOW "
				+ "(FOLLOW_ID, USER_ID, FOLLOWER_ID) "
				+ "VALUES(SEQ_FOLLOW.NEXTVAL, ?, ?) ";	

		String checkQuery = "SELECT FOLLOWER_ID "
				+ "FROM TBL_USER_FOLLOW "
				+ "WHERE USER_ID = ? ";
		
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		
		UserDAO userDAO = new UserDAO();
		
		if(followerId == null) {
			return;
		}
		
		con = DBConnector.getConnection();
		
		try {
			
			pr = con.prepareStatement(checkQuery);
			pr.setLong(1, userId);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				if(rs.getLong(1) == followerId) return;
			}
			
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			pr.setLong(2, followerId);
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
	
//	팔로우 중복검사
	public boolean checkDuplicateFollow(Long followerId) {
		String checkQuery = "SELECT FOLLOWER_ID "
				+ "FROM TBL_USER_FOLLOW "
				+ "WHERE USER_ID = ? AND FOLLOWER_ID = ? ";
		
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		
		boolean check = true;
		
		con = DBConnector.getConnection();
		
		try {
			
			pr = con.prepareStatement(checkQuery);
			pr.setLong(1, userId);
			pr.setLong(2, followerId);
			rs = pr.executeQuery();
			
			check = rs.next() ? false : check;

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

		return check;
	}
	
//	팔로우 취소
	public void deleteFollow(Long followerId) {
		String query = "DELETE FROM TBL_USER_FOLLOW "
				+ "WHERE FOLLOWER_ID = ? ";	

		
		try {
			
			pr = con.prepareStatement(query);
			pr.setLong(1, followerId);
			pr.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	
//	내 팔로우 목록 UserVO
	public ArrayList<UserVO> selectFollowerAll() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER WHERE USER_ID IN "
				+ "("
				+ "	SELECT FOLLOWER_ID "
				+ "	FROM TBL_USER_FOLLOW "
				+ "	WHERE USER_ID = ? "
				+ ")";
		
		UserVO vo = null;
		UserDAO userDAO = new UserDAO();
		
		ArrayList<UserVO> result = new ArrayList<UserVO>();
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				vo = new UserVO();
				vo = userDAO.setUserVO(rs);
				
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
	
//	나를 팔로우하는 사람들 UserVO
	public ArrayList<UserVO> selectFollowingAll() {

		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER WHERE USER_ID IN "
				+ "("
				+ "	SELECT USER_ID "
				+ "	FROM TBL_USER_FOLLOW "
				+ "	WHERE FOLLOWER_ID = ? "
				+ ")";
		
		UserVO vo = null;
		UserDAO userDAO = new UserDAO();
		
		ArrayList<UserVO> result = new ArrayList<UserVO>();
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, 56L);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				vo = new UserVO();
				vo = userDAO.setUserVO(rs);
				
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
	
//	회원의 팔로워 수
	public int selectFollowerCount(Long userId) {
		String query = "SELECT COUNT(FOLLOWER_ID) "
				+ "FROM TBL_USER_FOLLOW "
				+ "WHERE USER_ID = ? ";
		
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
	
//	회원을 팔로우하는 수
	public int selectFollowingCount(Long userId) {
		String query = "SELECT COUNT(USER_ID) "
				+ "FROM TBL_USER_FOLLOW "
				+ "WHERE FOLLOWER_ID = ? ";
		
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
	
	
	
	
	
	
	
	
	
	
	
	
}
