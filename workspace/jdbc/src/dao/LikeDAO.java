package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BoardDTO;
import domain.UserVO;

public class LikeDAO {
	
	public Connection con; // 연결 객체
	public PreparedStatement pr; // 쿼리 관리 객체
	public ResultSet rs;
	
//	신규 좋아요
	public void insertLike(Long boardId) {
		String query = "INSERT INTO TBL_BOARD_LIKE "
				+ "(LIKE_ID, USER_ID, BOARD_ID) "
				+ "VALUES(SEQ_FOLLOW.NEXTVAL, ?, ?) ";	

		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		
		con = DBConnector.getConnection();
		
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			pr.setLong(2, boardId);
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
	
//	좋아요 중복검사
	public boolean checkDuplicateLike(Long boardId) {
		String checkQuery = "SELECT BOARD_ID "
				+ "FROM TBL_BOARD_LIKE "
				+ "WHERE USER_ID = ? AND BOARD_ID = ? ";
		
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		
		boolean check = true;
		
		con = DBConnector.getConnection();
		
		try {
			pr = con.prepareStatement(checkQuery);
			pr.setLong(1, userId);
			pr.setLong(2, boardId);
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
	
//	좋아요 취소
	public void deleteLike(Long boardId) {
		String query = "DELETE FROM TBL_BOARD_LIKE "
				+ "WHERE BOARD_ID = ? ";	

		try {
			
			pr = con.prepareStatement(query);
			pr.setLong(1, boardId);
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
	public ArrayList<BoardDTO> selectLikeBoardAll() {
		String query = "SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, BOARD_UPDATE_DATE, "
				+ "D1.USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, "
				+ "USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM "
				+ "( "
				+ "	SELECT D2.BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, BOARD_UPDATE_DATE, USER_ID, BOARD_LIKE_COUNT "
				+ "	FROM "
				+ "	( "
				+ "		SELECT BOARD_ID "
				+ "		FROM TBL_BOARD_LIKE "
				+ "		WHERE USER_ID = ? "
				+ "	) D2 JOIN TBL_BOARD B "
				+ "	ON B.BOARD_ID = D2.BOARD_ID "
				+ ") D1 JOIN TBL_USER U "
				+ "ON D1.USER_ID = U.USER_ID ";
		
		BoardDTO dto = null;
		UserDAO userDAO = new UserDAO();
		
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		
		int index = 0;
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				dto = new BoardDTO();
//				BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, BOARD_UPDATE_DATE , 
//				D1.USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, 
//				USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID
				
				dto.setBoardId(rs.getLong(++index));
				dto.setBoardTitle(rs.getString(++index));
				dto.setBoardContent(rs.getString(++index));
				dto.setBoardRegisterDate(rs.getString(++index));
				dto.setBoardUpdateDate(rs.getString(++index));
				dto.setUserId(rs.getLong(++index));
				dto.setUserIdentification(rs.getString(++index));
				dto.setUserName(rs.getString(++index));
				dto.setUserPassword(rs.getString(++index));
				dto.setUserPhone(rs.getString(++index));
				dto.setUserNickname(rs.getString(++index));
				dto.setUserEmail(rs.getString(++index));
				dto.setUserAddress(rs.getString(++index));
				dto.setUserBirth(rs.getString(++index));
				dto.setUserGender(rs.getString(++index));
				dto.setUserRecommenderId(rs.getString(++index));
				
				result.add(dto);
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
