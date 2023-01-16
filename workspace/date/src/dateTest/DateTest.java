package dateTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(simpleDateFormat.format(now));
		
		Date date1 = new Date();
		System.out.println("앙!");
		System.out.println("앙!");
		System.out.println("앙!");
		System.out.println("앙!");
		Date date2 = new Date();
		
//		getTime() : 두 날짜의 차이를 구할 떄 사용, 밀리초 리턴
		System.out.println(date1.getTime() - date2.getTime());
	}
}
