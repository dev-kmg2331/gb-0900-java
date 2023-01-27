package domain;

public class ReplyVO {
//	REPLY_ID NUMBER CONSTRAINT PK_REPLY PRIMARY KEY,
//	REPLY_CONTENT VARCHAR2(1000) NOT NULL,
//	REPLY_REGISTER_DATE DATE DEFAULT SYSDATE,
//	REPLY_UPDATE_DATE DATE DEFAULT SYSDATE,
//	REPLY_GROUP NUMBER NOT NULL,
//	REPLY_DEPTH NUMBER NOT NULL,
//	USER_ID NUMBER NOT NULL,
//	BOARD_ID NUMBER NOT NULL,
	
	private Long replyId;
	private String replyContent;
	private String replyRegisterDate;
	private String replyUpdateDate;
	private Long replyGroup;
	private int replyDepth;
	private Long userId;
	private Long boardId;
	
	public ReplyVO()	{;}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyRegisterDate() {
		return replyRegisterDate;
	}

	public void setReplyRegisterDate(String replyRegisterDate) {
		this.replyRegisterDate = replyRegisterDate;
	}

	public String getReplyUpdateDate() {
		return replyUpdateDate;
	}

	public void setReplyUpdateDate(String replyUpdateDate) {
		this.replyUpdateDate = replyUpdateDate;
	}

	public Long getReplyGroup() {
		return replyGroup;
	}

	public void setReplyGroup(Long replyGroup) {
		this.replyGroup = replyGroup;
	}

	public int getReplyDepth() {
		return replyDepth;
	}

	public void setReplyDepth(int replyDepth) {
		this.replyDepth = replyDepth;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", replyContent=" + replyContent + ", replyRegisterDate="
				+ replyRegisterDate + ", replyUpdateDate=" + replyUpdateDate + ", replyGroup=" + replyGroup
				+ ", replyDepth=" + replyDepth + ", userId=" + userId + ", boardId=" + boardId + "]";
	}
}
