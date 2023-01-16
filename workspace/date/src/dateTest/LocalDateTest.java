package dateTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDateTime time = LocalDateTime.now();

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		
		System.out.println(now);
		System.out.println(time.format(dateTimeFormatter));
	}
}
