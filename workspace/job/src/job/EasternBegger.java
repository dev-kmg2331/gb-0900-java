package job;

import java.util.Random;
import java.util.Scanner;

public class EasternBegger{
//	구걸에 성공하면 경찰 출동 확률이 증가하고 최대한 많은 금액을 얻는게 목표이다.
	public static void main(String[] args) {
		
//		안내 메시지들
		String[] introMsg = {
			"중동거지 게임에 오신 것을 환영합니다!",
			"거지의 이름을 입력하세요.",
			"거지의 나이를 입력하세요.",
			"거지의 성별을 입력하세요.",
			"=======================\n"
		};
		String[] eventMsg = {
				"새로운 부자 아랍인이 나타났습니다!",
				"계속 하시겠습니까? 게임 종료를 원하시면 N을 입력하세요.\n진행을 원하시면 아무 키나 입력하세요.",
				"경찰이 출동했습니다! 게임을 종료합니다.",
				"게임을 종료합니다."
		};
		
		String[] arGender = {"남자", "여자", "그 외"};
		String name = "", gender = null;
		int age = 0;
		
		Begger begger = null;
		Arab arab = null;
		
		boolean exit = false;
		String yesOrNo = "";
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(introMsg[0]);
			
			System.out.println(introMsg[1]);
			name = sc.next();
			
			System.out.println(introMsg[2]);
			age = sc.nextInt();
			
//			거지 개인정보 입력.
			while(gender == null) {
				int genderNum = 0;
				System.out.println(introMsg[3]);
				for (int i = 0; i < arGender.length; i++) {
					System.out.println(i + 1 + ". " + arGender[i]);
				}
				
				genderNum = sc.nextInt();
				
				if(genderNum < 0 || genderNum > 3) {
					System.out.println("없는 번호입니다. 다시 입력해주세요.");
					System.out.println();
					continue;
				}
				
				gender = arGender[genderNum - 1];
			}
			
//			거지 프로필 출력.
			begger = new Begger(age, name, gender);
			System.out.printf("이름 : %s\n나이 : %d\n성별 : %s\n", begger.name, begger.age, begger.gender);
			
//			경찰이 출동하거나 게임을 종료할 경우 끝나는 반복문이다.
			while(!begger.policeChanceCal() || exit) {
				arab = new Arab();
				System.out.println(eventMsg[0]);
				System.out.println("아랍인의 이름 : " + arab.name);
				
//				구걸 성공 / 실패 여부 리턴
				if(begger.moneyChanceCal()) {
					begger.doBegging(arab.wallet);
					System.out.println("구걸에 성공했습니다!");
				} else System.out.println("저런! 구걸에 실패했습니다!");
				
				System.out.println("현재 " + begger.name + "의 총자산은 $" + begger.balance + " 입니다.\n");
				System.out.println("현재 경찰 출동 확률은 " + begger.policeChance + "% 입니다.");
				
				System.out.println(eventMsg[1]);
				yesOrNo = sc.next();
				
				
				if(yesOrNo.equals("N")) {
					exit = true;
				}
			}
			
//			최종 얻은 금액을 출력해준다.
			System.out.println(yesOrNo.equals("N") ? eventMsg[3] : eventMsg[2]);
			System.out.println(introMsg[4]);
			System.out.printf("당신의 최종 금액은 : $%d 입니다.\n", begger.balance);
			
			if(exit) {break;}
		}
		
//		Chance c = new Chance();
//		Begger b = new Begger(1, "1", "남자");
//		
//		System.out.println(c.getSuccess(b.moneyChance));
	}
}

// 랜덤한 금액을 들고 있는 아랍인, 이름 또한 랜덤이다.
class Arab{
	Random random = new Random();
	
	String name;
	int wallet;
	
	Arab(){
		this.wallet = random.nextInt(100) * 100;
		this.name = "Muhamad " + randomNameGenerator() + " Alah";
	}
	
	private String randomNameGenerator() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1)
		        .limit(targetStringLength)
		        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		        .toString();
		
		return generatedString;
	}
}

// 거지 클래스, 구걸에 성공할 확률과 경찰 출동 확률, 총 자산, 라마단 기간 여부 등을 가진다.
class Begger {
	int ranking, balance, exp;
	String[] arRanking = new String[5];
	
	int age;
	String name, gender;
	
//	라마단 기간에는 구걸 확률이 대폭 증가한다.
	static boolean isRamadan;
	
	int moneyChance;
	int policeChance;
	
//	구걸 확률의 초기값은 80이다. 경찰 출동의 초기값은 0이다.
	{
		balance = 1000;
		exp = 0;
		ranking = 1;
		moneyChance = 80;
		policeChance = 0;
	}

	public Begger(int age, String name, String gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	
	public void doBegging(int wallet) {
		balance += wallet;
	}
	
//	구걸 확률 계산기. 성공하면 구걸 확률이 10퍼센트만큼 감소한다.
	public boolean moneyChanceCal() {
		Chance chance = new Chance();
		boolean result = chance.getSuccess(this.moneyChance);
		
		if(result) {
			this.moneyChance -= 10;
			return result;
		}
		
		return result;
	}
	
//	경찰 출동여부 계산기. 경찰이 출동하지 않을 경우 출동 확률이 10 증가한다.
	public boolean policeChanceCal() {
		Chance chance = new Chance();
		boolean result = chance.getSuccess(this.policeChance);
		
		if(result) {
			return result;
		}
		
		this.policeChance += 5;
		return result;
	}
}

//	확률 클래스. 성공 / 실패 여부를 리턴한다.
class Chance{
	public boolean getSuccess(int chance) {
		Random random = new Random();
		int[] rating = new int[100];
		int data = chance;
		
		for (int i = 0; i < data; i++) {
			rating[i] = 1;
		}
		
		return rating[random.nextInt(100)] == 1;
	}
}
