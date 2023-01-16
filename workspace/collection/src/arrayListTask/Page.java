package arrayListTask;

public class Page {
	public static void main(String[] args) {
		Fruit apple = new Fruit();
		Fruit banana = new Fruit();
		Fruit cherry = new Fruit();
		Market mk = new Market();
		
		apple.setName("apple");
		apple.setPrice(1000);
		banana.setName("banana");
		banana.setPrice(1500);
		cherry.setName("cherry");
		cherry.setPrice(2000);
		
		mk.insert(apple);
		mk.insert(banana);
		mk.insert(cherry);
		mk.insert(apple);
		
		System.out.println(mk.selectAll());
		
		System.out.println(mk.checkAvgPrice(cherry));

		mk.delete(cherry);
		
		System.out.println(mk.selectAll());
		
		System.out.println(mk.selectPriceByName("apple"));
		System.out.println(mk.selectPriceByName("pineapple"));
	}
}
