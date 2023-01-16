package classTest;

import java.util.Scanner;

class SuperCar {
//	브랜드, 색상, 가격, 비밀번호
	String brand, color, pw;
	int price, count;
//	엔진 상태
	boolean engine;

	{
		this.engine = false;
		this.pw = "2331";
		this.count = 0;
	}

//	생성자
	public SuperCar(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	public SuperCar() {}

//	시동 켜기
//	엔진 상태를 확인하고
//	시동이 꺼져있다면, "시동 켜기." 출력
//	이미 시동이 켜져있다면, "시동이 이미 켜져있습니다." 출력
	boolean engineON() {
		this.engine = engine ? this.engine : true;
		return engine ? true : false;
	}

//	시동 끄기
//	엔진 상태를 확인하고
//	시동이 켜져있다면, "시동 끄기." 출력
//	이미 시동이 켜져있다면, "시동이 이미 꺼져있습니다." 출력
	boolean engineOFF() {
		this.engine = engine ? false : this.engine;
		return engine ? false : true;
	}

//	시동을 켜기 위해서 비밀번호 4자리를 입력받아야 한다.
//	3번 연속 잘못 입력했을 시 "경찰 출동" 출력
//	* 문자열 비교는 ==이 아닌 equals()로 비교한다.
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
			System.out.println("차의 비밀번호를 입력하세요.");
			if (car.check(sc.next())) {
				System.out.println("엔진을 킵니다.");
				break;
			}
		}

		if (car.count > 1)
			System.out.println("경찰 출동.");
	}
}
