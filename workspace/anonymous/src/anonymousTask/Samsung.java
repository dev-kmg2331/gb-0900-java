package anonymousTask;

public class Samsung {
	public void register(Form form) {
		for (int i = 0; i < form.getDevices().length; i++) {
			System.out.println(form.getDevices()[i]);
		}
		
		if(form instanceof FormAdapter) {
			System.out.println("���� ���� �����Դϴ�.");
			return;
		}
		
		form.sell("������12");
	}
}
