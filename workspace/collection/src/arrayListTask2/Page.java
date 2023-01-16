package arrayListTask2;

public class Page {
	public static void main(String[] args) {
		
		Food kr = new Food();
		Food kr2 = new Food();
		Food ch = new Food();
		Food jp = new Food();
		Food en = new Food();
		String[] kinds = {"한식", "중식", "일식", "양식"};
		Restaurant rs = new Restaurant();
		
		kr.setName("김치찌개");
		kr.setKind(kinds[0]);
		kr.setPrice(6000);
		rs.insert(kr);
		
		kr2.setName("된장찌개");
		kr2.setKind(kinds[0]);
		kr2.setPrice(7000);
		rs.insert(kr2);
		
		ch.setName("유산슬");
		ch.setKind(kinds[1]);
		ch.setPrice(12000);
		rs.insert(ch);
		
		jp.setName("라멘");
		jp.setKind(kinds[2]);
		rs.insert(jp);
		
		en.setName("파스타");
		en.setKind(kinds[3]);
		rs.insert(en);
		
		System.out.println(rs.arFood);
		
		System.out.println(rs.selectByName("유산슬"));
		
		System.out.println(rs.selectByKind(kinds[0]));
		
		ch.setKind(kinds[2]);
		rs.updateKindAndPrice(ch);
		
		System.out.println(rs.arFood);
		
		System.out.println(rs.selectCountOfKind(kinds[0]));
	}
}
