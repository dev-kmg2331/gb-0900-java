package interfaceTask;

public class Building {
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		Starbucks jamsil = new Starbucks();
		gangnam.register(new Form() {
			
			@Override
			public void sell(String menu) {
				System.out.println("판매 완료.");
			}
			
			@Override
			public String[] getMenu() {
				String[] menu = {"아메리카노", "라떼", "밀크티"};
				return menu;
			}
		});
		
		jamsil.register(new FormAdapter() {
			@Override
			public void sell(String menu) {
				System.out.println("무료 나눔 행사중.");
			}
		});
	}
}
