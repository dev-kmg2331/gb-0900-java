package classTest;

class Car{
//	브랜드
//	색상
//	가격
	
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

//	시동켜기(브랜드 시동 켜기)
	public void engineON() {
		System.out.println(brand + " 시동 켜기.");
	}
//	시동끄기(브랜드 시동 끄기)
	public void engineOFF() {
		System.out.println(brand + " 시동 끄기.");
	}
}

public class Road {
	public static void main(String[] args) {
		Car car1 = new Car("BMW", "파란색", 8000);
		Car car2 = new Car("그랜져", "검은색", 6000);
		Car car3 = new Car("빨간색", 6000);
		
		car1.engineON();
		car1.engineOFF();
		car2.engineON();
		car2.engineOFF();
		car3.engineON();
		car3.engineOFF();
	}
}
