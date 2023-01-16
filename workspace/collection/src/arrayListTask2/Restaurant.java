package arrayListTask2;

import java.util.ArrayList;

public class Restaurant {
	public ArrayList<Food> arFood = DBConnecter.foodDB;
	
	public Food checkName(String name) {
		for(Food temp : arFood) {
			if(temp.getName().equals(name)) {
				return temp;
			}
		}
		
		return null;
	}
	
	public void insert(Food food) {
		if(checkName(food.getName()) != null) {
			return;
		}
		
		arFood.add(food);
	}
	
	public String selectByName(String name) {
		Food temp = checkName(name);
		return temp == null ? null : temp.getKind();
	}
	
	public ArrayList<Food> selectByKind(String kind) {
		ArrayList<Food> result = new ArrayList<Food>();
		
		for(Food temp : arFood) {
			if(temp.getKind().equals(kind)) {
				result.add(temp);
			}
		}
		
		return result;
	}
	
	public void updateKindAndPrice(Food food) {
		int changedPrice = 0;
		
		changedPrice =  (int) (food.getPrice() * 1.1);
		
		food.setPrice(changedPrice);
		
		arFood.replaceAll(f -> f.getName().equals(food.getName()) ? food : f);
	}
	
	public int selectCountOfKind(String kind) {
		return selectByKind(kind).size();
	}
}
