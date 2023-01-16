package classTest;

class Company {
	static Long sequence;
	static int total;
	
	Long id;
	String name;
	Long salary;
	int income;
	
	static {
		sequence = 0L;
	}
	
//	초기화 블럭
//	생성자 호출될 때마다 실행
	{
		id = ++sequence;
	}
	
	public Company(String name, Long salary) {
		this.name = name;
		this.salary = salary;
	}

	void printMyData() {
		System.out.println(id + ", " + name + ", " + "연 " + salary + "만원");
	}
}

public class Market {
	public static void main(String[] args) {
		Company kmg = new Company("강민구", 8500L);
		Company hds = new Company("한동석", 1000L);
		Company oty = new Company("오태양", 8500L);
		Company jyc = new Company("정유찬", 8500L);
		
		kmg.printMyData();
		hds.printMyData();
		oty.printMyData();
		jyc.printMyData();
		
		Company.total += kmg.income = 1000;
		Company.total += hds.income = 1000;
		Company.total += oty.income = -3000;
		Company.total += jyc.income = -5000;
		
		System.out.println(Company.total);
	}
}
