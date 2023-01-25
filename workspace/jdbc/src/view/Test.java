package view;

import dao.UserDAO;
import domain.UserVO;

public class Test {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
//		System.out.println(dao.select(1L));
		
//		System.out.println(dao.checkId("kmg2331"));
		
//		pr.setString(2, vo.getUserIdentification());
//		pr.setString(3, vo.getUserName());
//		pr.setString(4, vo.getUserPassword());
//		pr.setString(5, vo.getUserPhone());
//		pr.setString(6, vo.getUserNickname());
//		pr.setString(7, vo.getUserEmail());
//		pr.setString(8, vo.getUserAddress());
//		pr.setString(9, vo.getUserBirth());
//		pr.setString(10, vo.getUserGender());
//		pr.setString(11, vo.getUserRecommenderId());
		
//		vo.setUserIdentification("kmg2331");
//		vo.setUserName("강민구");
//		vo.setUserPassword("1234");
//		vo.setUserPhone("01012341234");
//		vo.setUserNickname("민구1234");
//		vo.setUserEmail("kmg2331@gmail.com");
//		vo.setUserAddress("경기 의왕시");
//		vo.setUserBirth("1998-01-30");
//		vo.setUserGender("M");
//		
//		for(int i = 0; i < 100; i++) {
//			String identification = "test" + i;
//			String userName = "테스트" + i;
//			String email = "test" + i + "@gmail.com";
//			vo.setUserIdentification(identification);
//			vo.setUserName(userName);
//			vo.setUserEmail(email);
//			vo.setUserRecommenderId("kmg2331");
//			
//			dao.join(vo);
//		}
		
//		vo.setUserId(2L);
//		dao.updateUser(vo);
		
//		System.out.println(dao.login("kmg2331", "1234"));
		dao.quitUser(34L);
		System.out.println(dao.select(34L));
//		System.out.println(dao.findIdentification("kmg2331@gmail.com", "01012341234"));
//		System.out.println(dao.countReccommends("kmg2331"));
//		System.out.println(dao.getReccommendList("kmg2331"));
//		System.out.println(dao.getReccommendedUser("kmg2331"));
	}

}
