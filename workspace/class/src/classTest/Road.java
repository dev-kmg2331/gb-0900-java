package classTest;

class Car{
//	�귣��
//	����
//	����
	
	String brand, color;
	int price;
	
	Car(String brand, String color, int price)	{
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	public Car(String color, int price) {
			this.color = color;
			this.price = price;
	}

//	�õ��ѱ�(�귣�� �õ� �ѱ�)
	public void engineON() {
		System.out.println(brand + " �õ� �ѱ�.");
	}
//	�õ�����(�귣�� �õ� ����)
	public void engineOFF() {
		System.out.println(brand + " �õ� ����.");
	}
}

public class Road {
	public static void main(String[] args) {
		Car car1 = new Car("BMW", "�Ķ���", 8000);
		Car car2 = new Car("�׷���", "������", 6000);
		Car car3 = new Car("������", 6000);
		
		car1.engineON();
		car1.engineOFF();
		car2.engineON();
		car2.engineOFF();
		car3.engineON();
		car3.engineOFF();
	}
}
