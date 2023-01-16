package arrayListTask3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DateApp {
	ArrayList<Love> arLove = DBConnecter.loveDB;
	
	public void insert(Love love) {
		arLove.add(love);
	}
	
	public ArrayList<Love> selectByAge(int age){
		ArrayList<Love> result = new ArrayList<Love>();
		
		for(Love temp : arLove) {
			if(temp.getAge() == age) {
				result.add(temp);
			}
		}
		
		return result;
	}
	
	public void updateAge(Love love) {
		arLove.replaceAll(l -> l.getNumber() == love.getNumber() ? love : l);
		
	}
	
	public ArrayList<Love> orderAscendingByAge() {
//		Collections.sort(arLove, ageComp);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Love> result = new ArrayList<Love>();
		Love love = null;
		
		for(Love lv : arLove) {
			temp.add(lv.getAge());
		}
		
		Collections.sort(temp);
		
		for(int age : temp) {
			for(Love lv : arLove) {
				if(lv.getAge() == age) {
					result.add(lv);
					love = lv;
				}
			}
			arLove.remove(love);
		}
		
		return result;
	}
	
//	4132
	
//	Comparator<Love> ageComp = new Comparator<Love>() {
//		
//		@Override
//		public int compare(Love o1, Love o2) {
//			if(o1.getAge() > o2.getAge()) {
//				return 1;
//			} else if(o1.getAge() < o2.getAge()) {
//				return -1;
//			} else return 0;
//		}
//	};
//	
}
