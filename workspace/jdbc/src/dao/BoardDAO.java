package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import domain.BoardDTO;
import domain.BoardVO;

public class BoardDAO {

	public Connection con; // 연결 객체
	public PreparedStatement pr; // 쿼리 관리 객체
	public ResultSet rs; // 결과 테이블 객체
	
//	게시글 추가
	public void insert(BoardVO vo) {
		String query = "INSERT INTO TBL_BOARD (BOARD_ID, BOARD_TITLE, BOARD_CONTENT, USER_ID) "
				+ "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?)";
		
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		con = DBConnector.getConnection();
		
		try {
			pr = con.prepareStatement(query);
			pr.setString(1, vo.getBoardTitle());
			pr.setString(2, vo.getBoardContent());
			pr.setLong(3, userId);
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
	
//	게시글 조회 (마이페이지)
	public ArrayList<BoardVO> selectUserBoards() {
		String query = "SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, "
				+ "BOARD_UPDATE_DATE, USER_ID "
				+ "FROM TBL_BOARD "
				+ "WHERE USER_ID = ? ";
		
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, userId);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setBoardId(rs.getLong(1));
				vo.setBoardTitle(rs.getString(2));
				vo.setBoardContent(rs.getString(3));
				vo.setBoardRegisterDate(rs.getString(4));
				vo.setBoardUpdateDate(rs.getString(5));
				vo.setUserId(userId);
				
				result.add(vo);
			}
			
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
		
		return result;
	}
	
//	게시글 상세조회 DTO
	public BoardDTO selectBoardDetail(Long boardId) {
		String query = "SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, "
	            + "BOARD_UPDATE_DATE, U.USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
	            + "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, "
	            + "USER_RECOMMENDER_ID "
	            + "FROM TBL_USER U JOIN TBL_BOARD B "
	            + "ON U.USER_ID = B.USER_ID AND BOARD_ID = ?";
		
		BoardDTO dto = null;
		int index = 0;
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, boardId);
			rs = pr.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
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
		
		return dto;
	}
	
//	게시글 수정
	public void update(BoardVO vo) {
		String query = "UPDATE TBL_BOARD "
				+ "SET BOARD_TITLE = ?, BOARD_CONTENT = ?, BOARD_UPDATE_DATE = SYSDATE "
				+ "WHERE BOARD_ID = ? ";
		
		LocalDateTime now = LocalDateTime.now();
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			
			pr.setString(1, vo.getBoardTitle());
			pr.setString(2, vo.getBoardContent());
			pr.setLong(3, vo.getBoardId());
			
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
	
//	게시글 삭제
	public void delete(Long boardId) {
		String query = "DELETE FROM TBL_BOARD "
				+ "WHERE BOARD_ID = ? ";
		
		con = DBConnector.getConnection();
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
				if(con != null) {
					con.close();
				}
				
				if(pr != null) {
					pr.close();
				}
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
//	게시글 전체 조회
	public ArrayList<BoardDTO> selectAllBoards() {
		String query = "SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, "
	            + "BOARD_UPDATE_DATE, U.USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
	            + "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, "
	            + "USER_RECOMMENDER_ID "
	            + "FROM TBL_USER U JOIN TBL_BOARD B "
	            + "ON U.USER_ID = B.USER_ID ";
		
		BoardDTO dto = null;
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		
		int index = 0;
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				index = 0;
				
				dto = new BoardDTO();
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
}
