package classTest;

import java.util.Scanner;

class SuperCar {
//	�귣��, ����, ����, ��й�ȣ
	String brand, color, pw;
	int price, count;
//	���� ����
	boolean engine;

	{
		this.engine = false;
		this.pw = "2331";
		this.count = 0;
	}

//	������
	public SuperCar(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	public SuperCar() {}

//	�õ� �ѱ�
//	���� ���¸� Ȯ���ϰ�
//	�õ��� �����ִٸ�, "�õ� �ѱ�." ���
//	�̹� �õ��� �����ִٸ�, "�õ��� �̹� �����ֽ��ϴ�." ���
	boolean engineON() {
		this.engine = engine ? this.engine : true;
		return engine ? true : false;
	}

//	�õ� ����
//	���� ���¸� Ȯ���ϰ�
//	�õ��� �����ִٸ�, "�õ� ����." ���
//	�̹� �õ��� �����ִٸ�, "�õ��� �̹� �����ֽ��ϴ�." ���
	boolean engineOFF() {
		this.engine = engine ? false : this.engine;
		return engine ? false : true;
	}

//	�õ��� �ѱ� ���ؼ� ��й�ȣ 4�ڸ��� �Է¹޾ƾ� �Ѵ�.
//	3�� ���� �߸� �Է����� �� "���� �⵿" ���
//	* ���ڿ� �񱳴� ==�� �ƴ� equals()�� ���Ѵ�.
	boolean check(String pw) {
		if (this.pw.equals(pw)) {
			engineON();
			return true;
		} else
			this.count++;

		return false;
	}
}

public class ClassTask {
	public static void main(String[] args) {
		SuperCar car = new SuperCar();
		Scanner sc = new Scanner(System.in);

		while (car.count < 3) {
			System.out.println("���� ��й�ȣ�� �Է��ϼ���.");
			if (car.check(sc.next())) {
				System.out.println("������ ŵ�ϴ�.");
				break;
			}
		}

		if (car.count > 1)
			System.out.println("���� �⵿.");
	}
}
