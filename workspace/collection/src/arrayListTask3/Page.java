package arrayListTask3;

public class Page {
	public static void main(String[] args) {
		
		Love lv1 = new Love();
		Love lv2 = new Love();
		Love lv3 = new Love();
		Love lv4 = new Love();
		
		DateApp app = new DateApp();
		
		lv4.setAge(27);
		lv4.setName("강민구4");
		app.insert(lv4);
		
		lv2.setAge(21);
		lv2.setName("강민구2");
		app.insert(lv2);
		
		lv1.setAge(21);
		lv1.setName("강민구1");
		app.insert(lv1);
		
		lv3.setAge(25);
		lv3.setName("강민구3");
		app.insert(lv3);
		
		
		System.out.println(app.arLove);
		
		lv4.setAge(29);
		app.updateAge(lv4);
		
		System.out.println(app.arLove);
		
		System.out.println(app.orderAscendingByAge());
		
		System.out.println(app.arLove);
	}
	
	
}
