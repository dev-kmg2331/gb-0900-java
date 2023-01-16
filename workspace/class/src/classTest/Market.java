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
	
//	�ʱ�ȭ ��
//	������ ȣ��� ������ ����
	{
		id = ++sequence;
	}
	
	public Company(String name, Long salary) {
		this.name = name;
		this.salary = salary;
	}

	void printMyData() {
		System.out.println(id + ", " + name + ", " + "�� " + salary + "����");
	}
}

public class Market {
	public static void main(String[] args) {
		Company kmg = new Company("���α�", 8500L);
		Company hds = new Company("�ѵ���", 1000L);
		Company oty = new Company("���¾�", 8500L);
		Company jyc = new Company("������", 8500L);
		
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
