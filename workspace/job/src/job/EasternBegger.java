package job;

import java.util.Random;
import java.util.Scanner;

public class EasternBegger{
//	���ɿ� �����ϸ� ���� �⵿ Ȯ���� �����ϰ� �ִ��� ���� �ݾ��� ��°� ��ǥ�̴�.
	public static void main(String[] args) {
		
//		�ȳ� �޽�����
		String[] introMsg = {
			"�ߵ����� ���ӿ� ���� ���� ȯ���մϴ�!",
			"������ �̸��� �Է��ϼ���.",
			"������ ���̸� �Է��ϼ���.",
			"������ ������ �Է��ϼ���.",
			"=======================\n"
		};
		String[] eventMsg = {
				"���ο� ���� �ƶ����� ��Ÿ�����ϴ�!",
				"��� �Ͻðڽ��ϱ�? ���� ���Ḧ ���Ͻø� N�� �Է��ϼ���.\n������ ���Ͻø� �ƹ� Ű�� �Է��ϼ���.",
				"������ �⵿�߽��ϴ�! ������ �����մϴ�.",
				"������ �����մϴ�."
		};
		
		String[] arGender = {"����", "����", "�� ��"};
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
			
//			���� �������� �Է�.
			while(gender == null) {
				int genderNum = 0;
				System.out.println(introMsg[3]);
				for (int i = 0; i < arGender.length; i++) {
					System.out.println(i + 1 + ". " + arGender[i]);
				}
				
				genderNum = sc.nextInt();
				
				if(genderNum < 0 || genderNum > 3) {
					System.out.println("���� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
					System.out.println();
					continue;
				}
				
				gender = arGender[genderNum - 1];
			}
			
//			���� ������ ���.
			begger = new Begger(age, name, gender);
			System.out.printf("�̸� : %s\n���� : %d\n���� : %s\n", begger.name, begger.age, begger.gender);
			
//			������ �⵿�ϰų� ������ ������ ��� ������ �ݺ����̴�.
			while(!begger.policeChanceCal() || exit) {
				arab = new Arab();
				System.out.println(eventMsg[0]);
				System.out.println("�ƶ����� �̸� : " + arab.name);
				
//				���� ���� / ���� ���� ����
				if(begger.moneyChanceCal()) {
					begger.doBegging(arab.wallet);
					System.out.println("���ɿ� �����߽��ϴ�!");
				} else System.out.println("����! ���ɿ� �����߽��ϴ�!");
				
				System.out.println("���� " + begger.name + "�� ���ڻ��� $" + begger.balance + " �Դϴ�.\n");
				System.out.println("���� ���� �⵿ Ȯ���� " + begger.policeChance + "% �Դϴ�.");
				
				System.out.println(eventMsg[1]);
				yesOrNo = sc.next();
				
				
				if(yesOrNo.equals("N")) {
					exit = true;
				}
			}
			
//			���� ���� �ݾ��� ������ش�.
			System.out.println(yesOrNo.equals("N") ? eventMsg[3] : eventMsg[2]);
			System.out.println(introMsg[4]);
			System.out.printf("����� ���� �ݾ��� : $%d �Դϴ�.\n", begger.balance);
			
			if(exit) {break;}
		}
		
//		Chance c = new Chance();
//		Begger b = new Begger(1, "1", "����");
//		
//		System.out.println(c.getSuccess(b.moneyChance));
	}
}

// ������ �ݾ��� ��� �ִ� �ƶ���, �̸� ���� �����̴�.
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

// ���� Ŭ����, ���ɿ� ������ Ȯ���� ���� �⵿ Ȯ��, �� �ڻ�, �󸶴� �Ⱓ ���� ���� ������.
class Begger {
	int ranking, balance, exp;
	String[] arRanking = new String[5];
	
	int age;
	String name, gender;
	
//	�󸶴� �Ⱓ���� ���� Ȯ���� ���� �����Ѵ�.
	static boolean isRamadan;
	
	int moneyChance;
	int policeChance;
	
//	���� Ȯ���� �ʱⰪ�� 80�̴�. ���� �⵿�� �ʱⰪ�� 0�̴�.
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
	
//	���� Ȯ�� ����. �����ϸ� ���� Ȯ���� 10�ۼ�Ʈ��ŭ �����Ѵ�.
	public boolean moneyChanceCal() {
		Chance chance = new Chance();
		boolean result = chance.getSuccess(this.moneyChance);
		
		if(result) {
			this.moneyChance -= 10;
			return result;
		}
		
		return result;
	}
	
//	���� �⵿���� ����. ������ �⵿���� ���� ��� �⵿ Ȯ���� 10 �����Ѵ�.
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

//	Ȯ�� Ŭ����. ���� / ���� ���θ� �����Ѵ�.
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
