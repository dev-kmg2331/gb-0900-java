package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import domain.ReplyDTO;
import domain.ReplyVO;

public class ReplyDAO {
	
	public Connection con;
	public PreparedStatement pr;
	public ResultSet rs;
	
//	댓글 추가
	public void insert(ReplyVO vo) {
		String insertQuery = "INSERT INTO TBL_REPLY (REPLY_ID, REPLY_CONTENT, REPLY_GROUP, "
				+ "REPLY_DEPTH, USER_ID, BOARD_ID) "
				+ "VALUES(SEQ_BOARD.NEXTVAL, ?, SEQ_BOARD.CURRVAL, 0, ?, ?)";
		
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		con = DBConnector.getConnection();
		
		int index = 0;
		
		try {
			pr = con.prepareStatement(insertQuery);
			pr.setString(++index, vo.getReplyContent());
//			댓글인지 대댓글인지 판단
			pr.setLong(++index, userId);
			pr.setLong(++index, vo.getBoardId());
			
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
	
//	대댓글 추가
	public void insert(ReplyVO vo, Long targetId) {
		String insertQuery = "INSERT INTO TBL_REPLY (REPLY_ID, REPLY_CONTENT, REPLY_GROUP, "
				+ "REPLY_DEPTH, USER_ID, BOARD_ID) "
				+ "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, (SELECT REPLY_DEPTH + 1 FROM TBL_REPLY WHERE REPLY_ID = ?), ?, ?)";
		
		Long userId = (Long) UserDAO.httpRequestSession.get("userId");
		con = DBConnector.getConnection();
		
		int index = 0;
		try {
			pr = con.prepareStatement(insertQuery);
			pr.setString(++index, vo.getReplyContent());
//			댓글인지 대댓글인지 판단
			pr.setLong(++index, targetId);
			pr.setLong(++index, targetId);
			pr.setLong(++index, userId);
			pr.setLong(++index, vo.getBoardId());
			
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
//	댓글 전체 조회
	public ArrayList<ReplyDTO> selectReplyAll(){
		String query = "SELECT r.REPLY_ID, r.REPLY_CONTENT, r.REPLY_REGISTER_DATE, r.REPLY_UPDATE_DATE, r.REPLY_GROUP, r.REPLY_DEPTH, r.USER_ID, r.BOARD_ID, "
				+ "u.USER_IDENTIFICATION, u.USER_NAME, u.USER_NICKNAME, u.USER_EMAIL "
				+ "FROM TBL_USER u JOIN TBL_REPLY r "
				+ "ON u.USER_ID = r.USER_ID ";
		
		ReplyDTO dto = null;
		ArrayList<ReplyDTO> result = new ArrayList<ReplyDTO>();
		
		int index = 0;
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				index = 0;
				dto = new ReplyDTO();
				
				dto.setReplyId(rs.getLong(++index));
				dto.setReplyContent(rs.getString(++index));
				dto.setReplyRegisterDate(rs.getString(++index));
				dto.setReplyUpdateDate(rs.getString(++index));
				dto.setReplyGroup(rs.getLong(++index));
				dto.setReplyDepth(rs.getInt(++index));
				dto.setUserId(rs.getLong(++index));
				dto.setBoardId(rs.getLong(++index));
				dto.setUserIdentification(rs.getString(++index));
				dto.setUserName(rs.getString(++index));
				dto.setUserNickname(rs.getString(++index));
				dto.setUserEmail(rs.getString(++index));
	            
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
//	대댓글 전체 조회
	public ArrayList<ReplyDTO> selectNestedReplyAll(Long replyGroup){
		String query = "SELECT r.REPLY_ID, r.REPLY_CONTENT, r.REPLY_REGISTER_DATE, r.REPLY_UPDATE_DATE, r.REPLY_GROUP, r.REPLY_DEPTH, r.USER_ID, r.BOARD_ID, "
				+ "u.USER_IDENTIFICATION, u.USER_NAME, u.USER_NICKNAME, u.USER_EMAIL "
				+ "FROM TBL_USER u JOIN TBL_REPLY r "
				+ "ON u.USER_ID = r.USER_ID AND r.REPLY_DEPTH > 0 "
				+ "WHERE r.REPLY_GROUP = ? ";
		
		ReplyDTO dto = null;
		ArrayList<ReplyDTO> result = new ArrayList<ReplyDTO>();
		
		int index = 0;
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, replyGroup);
			rs = pr.executeQuery();
			
			while(rs.next()) {
				index = 0;
				dto = new ReplyDTO();
				
				dto.setReplyId(rs.getLong(++index));
				dto.setReplyContent(rs.getString(++index));
				dto.setReplyRegisterDate(rs.getString(++index));
				dto.setReplyUpdateDate(rs.getString(++index));
				dto.setReplyGroup(rs.getLong(++index));
				dto.setReplyDepth(rs.getInt(++index));
				dto.setUserId(rs.getLong(++index));
				dto.setBoardId(rs.getLong(++index));
				dto.setUserIdentification(rs.getString(++index));
				dto.setUserName(rs.getString(++index));
				dto.setUserNickname(rs.getString(++index));
				dto.setUserEmail(rs.getString(++index));
	            
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
	
//	댓글 수정
	public void update(ReplyVO vo) {
		String query = "UPDATE TBL_REPLY "
				+ "SET REPLY_CONTENT= ?, REPLY_UPDATE_DATE = SYSDATE "
				+ "WHERE REPLY_ID = ? ";
		
//		LocalDateTime now = LocalDateTime.now();
//		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		int index = 0;
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			
			pr.setString(++index, vo.getReplyContent());
//			pr.setString(++index, formatedNow);
			pr.setLong(++index, vo.getReplyId());
			
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
	
//	댓글 삭제
	public void deleteReply(Long replyGroup) {
		String query = "DELETE FROM TBL_REPLY "
				+ "WHERE GROUP_ID = ? ";
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, replyGroup);
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
	
	public void deleteNestedReply(Long replyId) {
		String query = "DELETE FROM TBL_REPLY "
				+ "WHERE REPLY_ID = ? ";
		
		con = DBConnector.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setLong(1, replyId);
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
	
}
