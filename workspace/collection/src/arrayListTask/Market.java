package arrayListTask;

import java.util.ArrayList;

public class Market {
	
	ArrayList<Fruit> arFruit = DBConnecter.fruitDB;
	
	private Fruit checkFruit(String name) {
		
		for(Fruit temp : arFruit) {
			if(temp.getName().equals(name)) {
				return temp;
			}
		}
		
		return null;
	}
	
	public ArrayList<Fruit> selectAll() {
		return arFruit;
	}
	
	public Fruit selectByName(String name) {
		return checkFruit(name);
	}
	
	public void insert(Fruit fruit) {
		if(checkFruit(fruit.getName()) != null) {
			return;
		}
		
		arFruit.add(fruit);
	}
	
	public void delete(Fruit fruit) {
		arFruit.remove(checkFruit(fruit.getName()));
	}
	
	public int selectPriceByName(String name) {
		Fruit temp = checkFruit(name);
		
		if(temp != null) {
			return temp.getPrice();
		}
		
		return -1;
	}
	
	public boolean checkAvgPrice(Fruit fruit) {
		return fruit.getPrice() < getAvgPrice();
	}
	
	private double getAvgPrice() {
		int count = arFruit.size();
		int sum = 0;
		double result = 0.0;
		
		for(Fruit temp : arFruit) {
			sum += temp.getPrice();
		}
		
		result = (double) sum / count;
		
		return result;
	}
}
