package view;

import dao.BoardDAO;
import dao.UserDAO;
import domain.BoardDTO;
import domain.BoardVO;
import domain.UserVO;

public class Test {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		BoardDAO bDao = new BoardDAO();
		UserVO vo = new UserVO();
		BoardVO bVO = new BoardVO();
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
		
//		vo.setUserIdentification("jjw1111");
//		vo.setUserName("정지욱");
//		vo.setUserPassword("1234");
//		vo.setUserPhone("01012341234");
//		vo.setUserNickname("재현1234");
//		vo.setUserEmail("jjw1111@gmail.com");
//		vo.setUserAddress("경기 수원시");
//		vo.setUserBirth("1997-01-30");
//		vo.setUserGender("M");
//		vo.setUserRecommenderId("kmg2331");
//		
////		---- 회원가입 테스트
//		if(dao.checkId(vo.getUserIdentification())) {
//			System.out.println("회원가입 성공");
//			dao.join(vo);
//		} else System.out.println("중복 아이디.");
		
		
//		---- 로그인 테스트
		UserVO temp = null;
		if((temp = dao.login("jjw1111", "1234")) != null) {
			vo = temp;
			System.out.println("로그인 성공");
			UserDAO.httpRequestSession.put("userId", temp.getUserId());
		} else System.out.println("로그인 실패.");
		
////		---- 회원정보 조회 테스트
//		System.out.println(dao.select());
//		
////		---- 회원정보 수정 테스트
//		vo.setUserNickname("CodingMachine");
//		dao.updateUser(vo);
		
//		---- 비밀번호 수정
//		dao.updatePassword("2331");
		
//		bVO.setBoardTitle("강민구의 하루");
//		bVO.setBoardContent("알찬 하루였다!");
//		
//		bDao.insert(bVO);
		
//		bDao.selectUserBoards().stream().map(BoardVO::toString).forEach(System.out::println);
//		bVO = bDao.selectUserBoards().get(0);
//		System.out.println(bVO.getBoardId());
		
//		bVO.setBoardTitle("정지욱 화이팅!");
//		bDao.update(bVO);
//		System.out.println(bDao.selectBoardDetail(bVO.getBoardId()));
		
		bDao.selectAllBoards().stream().map(BoardDTO::toString).forEach(System.out::println);
		bDao.delete(3L);
		bDao.selectAllBoards().stream().map(BoardDTO::toString).forEach(System.out::println);
	}

}
