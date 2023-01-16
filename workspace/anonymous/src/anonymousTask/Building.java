package anonymousTask;

public class Building {
	public static void main(String[] args) {
		Samsung gangnam = new Samsung();
		gangnam.register(new Form() {
			
			@Override
			public void sell(String menu) {
				System.out.println(menu);
			}
			
			@Override
			public String[] getDevices() {
				return new String[]{"아이폰12", "폴더3", "Z플립"};
			}
		});
		
		Samsung yeoksam = new Samsung();
		yeoksam.register(new FormAdapter() {
			
			@Override
			public String[] getDevices() {
				return new String[]{"아이폰12", "폴더3", "Z플립"};
			}
		});
	}
}
