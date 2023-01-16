package anonymousTask;

public class Samsung {
	public void register(Form form) {
		for (int i = 0; i < form.getDevices().length; i++) {
			System.out.println(form.getDevices()[i]);
		}
		
		if(form instanceof FormAdapter) {
			System.out.println("무료 나눔 매장입니다.");
			return;
		}
		
		form.sell("아이폰12");
	}
}
