package interfaceTask;

public class Building {
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		Starbucks jamsil = new Starbucks();
		gangnam.register(new Form() {
			
			@Override
			public void sell(String menu) {
				System.out.println("�Ǹ� �Ϸ�.");
			}
			
			@Override
			public String[] getMenu() {
				String[] menu = {"�Ƹ޸�ī��", "��", "��ũƼ"};
				return menu;
			}
		});
		
		jamsil.register(new FormAdapter() {
			@Override
			public void sell(String menu) {
				System.out.println("���� ���� �����.");
			}
		});
	}
}
