package view;

import dao.BoardDAO;
import dao.ReplyDAO;
import dao.UserDAO;
import domain.BoardVO;
import domain.ReplyVO;
import domain.UserVO;

public class Test {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		BoardDAO bDao = new BoardDAO();
		ReplyDAO replyDAO = new ReplyDAO();
		UserVO vo = new UserVO();
		BoardVO bVO = new BoardVO();
		ReplyVO replyVO = new ReplyVO();
//		System.out.println(dao.select(1L));
		
//		System.out.println(dao.checkId("kmg2331"));
		
//		
//		vo.setUserIdentification("kmg2331");
//		if(dao.checkId(vo.getUserIdentification())) {
//			System.out.println("회원가입 성공.");
//			dao.join(vo);
//		} else System.out.println("회원가입 실패");
		
//		vo.setUserId(2L);
//		dao.updateUser(vo);
		
//		vo.setUserIdentification("dlwnstkd1234");
//		vo.setUserName("이준상");
//		vo.setUserPassword("1234");
//		vo.setUserPhone("01034442331");
//		vo.setUserNickname("재현1234");
//		vo.setUserEmail("dlwnstkd1234@naver.com");
//		vo.setUserAddress("경기 의왕시");
//		vo.setUserBirth("1998-01-30");
//		vo.setUserGender("M");
//		vo.setUserRecommenderId("kmg2331");
//		
////		---- 회원가입 테스트
//		if(dao.checkId(vo.getUserIdentification())) {
//			System.out.println("회원가입 성공");
//			dao.join(vo);
//		} else System.out.println("중복 아이디.");
		
		
//		---- 로그인 테스트
//		UserVO temp = null;
//		if((temp = dao.login("jjw1111", "1234")) != null) {
//			vo = temp;
//			System.out.println("로그인 성공");
//			UserDAO.httpRequestSession.put("userId", temp.getUserId());
//		} else System.out.println("로그인 실패.");
		
////		---- 회원정보 조회 테스트
//		System.out.println(dao.select());
//		
////		---- 회원정보 수정 테스트
//		vo.setUserNickname("CodingMachine");
//		dao.updateUser(vo);
		
//		---- 비밀번호 수정
//		dao.updatePassword("2331");
		
//		---- 추천수 테스트
		System.out.println(dao.countReccommends(3L));
		
//		bVO.setBoardTitle("강민구의 하루");
//		bVO.setBoardContent("알찬 하루였다!");
//		
//		bDao.insert(bVO);
		
//		bDao.selectUserBoards().stream().map(BoardVO::toString).forEach(System.out::println);
//		bVO = bDao.selectUserBoards().get(0);
//		System.out.println(bVO.getBoardId());
		
//		bVO.setBoardTitle("오태양 화이팅!");
//		bDao.update(bVO);
//		System.out.println(bDao.selectBoardDetail(bVO.getBoardId()));
		
//		bDao.selectAllBoards().stream().map(BoardDTO::toString).forEach(System.out::println);
//		bDao.delete(3L);
//		bDao.selectAllBoards().stream().map(BoardDTO::toString).forEach(System.out::println);
		
//		replyVO.setReplyId(7L);
//		replyVO.setReplyContent("수정된 테스트용 댓글입니다.");
//		replyVO.setBoardId(5L);
//		replyDAO.insert(replyVO);
//		replyDAO.insert(replyVO, 6L);
		
//		replyDAO.selectReplyAll().stream().map(ReplyDTO::toString).forEach(System.out::println);
//		replyDAO.selectNestedReplyAll(1L).stream().map(ReplyDTO::toString).forEach(System.out::println);
		
//		replyVO.setReplyId(8L);
//		replyDAO.update(replyVO);
//		replyDAO.delete(10L);
		
//		replyDAO.update(replyVO);
	}

}
