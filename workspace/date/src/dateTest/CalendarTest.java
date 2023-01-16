package dateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println(simpleDateFormat.format(calendar.getTime()));
		
		try {
			System.out.println(simpleDateFormat.parse("2023/01/23 13:08:52"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
