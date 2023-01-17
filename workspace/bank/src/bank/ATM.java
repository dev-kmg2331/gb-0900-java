package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
   public static void main(String[] args) {
      Bank[][] arrBank = new Bank[3][100]; // 은행 3개 고객100명을 담을 2차원 배열 생성
      int[] arCount = new int[3]; // 은행별 고객수
      Bank[] arBank = null; // 은행을 담을 Bank타입의 arBank 배열

      final int ACCOUNT_LENGTH = 6; // 계좌번호의 길이는 6자리 고정이므로 상수

      String message = "1. 신한은행\n2. 국민은행\n3. 카카오뱅크\n4.나가기";
//      계좌개설, 입금하기, 출금하기, 잔액조회, 계좌번호 찾기(새로운 계좌발급, 핸드폰 번호로 서비스 이용가능), 나가기
      String menu = "0. 주식시장\n1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행 다시 선택";
      Scanner sc = new Scanner(System.in);
      int index = 0, choice = 0, money = 0;
      // 계좌 번호는 번호를 담아야 하므로 빈문자열, 폰번호 비밀번호는 널로 초기화
      String account = "", phoneNumber = null, password = null;
      Random random = new Random();
      // Bank타입의 user와 userCheck를 null로 초기화
      // user는 유저, userCheck는 유저 확인 객체
      Bank user = null, userCheck = null;

      while (true) {
//         은행을 선택한다.
         System.out.println(message);
         index = sc.nextInt();
         if (index == 4) {
            break;
         } // 나가기 눌렀을 때에는 while문 즉시 탈출!
         index--; // 인덱스로 쓸 거라서 1을 빼준다.

         while (true) { // 반복문을 돌린다
//            System.out.println(account);
            System.out.println(menu);
            choice = sc.nextInt();
            if (choice == 6) {
               break;
            } // 은행 다시 선택 누르면 현재 while문 탈출

            if (choice == 1) { // 계좌 개설
               // 3개의 객체를 만든다, 사용자가 어떤 은행 선택할지 모름
               // 규칙성을 만들려고 담아놓음
               arBank = new Bank[] { new Shinhan(), new Kookmin(), new Kakao() };

               while (true) { // 반복문 또 돌려
                  for (int i = 0; i < ACCOUNT_LENGTH; i++) { // 계좌번호의길이(6)만큼 반복돌려서
                     // 계좌번호 랜덤으로 생성
                     account += random.nextInt(10);
                  }
                  //
                  userCheck = Bank.checkAccount(arrBank, arCount, account);
                  if (userCheck == null) {
                     break;
                  } // null이라면 계좌 중복이 없다는 뜻
               }
               user = arBank[index]; // arBank index번째 은행에 고객의 계좌를 담는다
               account = index + account;
               user.setAccount(account);
               account = "";

               System.out.print("예금주: ");
               user.setName(sc.next());

               while (true) {
                  System.out.print("핸드폰 번호['-' 제외]: ");
                  phoneNumber = sc.next();

                  phoneNumber = phoneNumber.replaceAll("-", "");
                  if (phoneNumber.length() == 11) {
                     if (phoneNumber.startsWith("010")) {
                        userCheck = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);
                        if (userCheck == null) {
                           break;
                        }
                     }
                  }
                  System.out.println("잘못된 핸드폰 번호입니다.");
               }
               user.setPhoneNumber(phoneNumber);

               while (true) {
                  System.out.print("비밀번호[4자리]: ");
                  password = sc.next();
                  if (password.length() == 4) {
                     break;
                  }
                  System.out.println("비밀번호는 4자리로 설정해주세요.");
               }
               user.setPassword(password);

               arrBank[index][arCount[index]] = user;
               // arCount[index] 은행별 고객수 에 user를 넣는다
               arCount[index]++; // 추가했으니 1 더해주기
               System.out.println("환영합니다 " + user.getName() + " 고객님, 계좌개설이 완료되었습니다.");
               System.out.println("계좌번호: " + user.getAccount());
               System.out.println(arBank[index].getName());
               continue;

            } else if (choice == 5) { // 계좌번호 찾기
               System.out.print("핸드폰 번호: ");
               phoneNumber = sc.next();

               user = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);

               if (user != null) {
                  System.out.print("비밀번호: ");
                  password = sc.next();

                  if (user.getPassword().equals(password)) {
                     while (true) {
                        for (int i = 0; i < ACCOUNT_LENGTH; i++) {
                           account += random.nextInt(10);
                        }
                        userCheck = Bank.checkAccount(arrBank, arCount, account);
                        if (userCheck == null) {
                           break;
                        }
                     }
                     System.out.println("새로운 계좌번호로 변경되었습니다.");
                     System.out.println("계좌번호: " + account);
                     account = user.getAccount().charAt(0) + account;
                     user.setAccount(account);
                  }
               } else {
                  System.out.println("없는 핸드폰 번호입니다.");
               }
               continue;
            }

            System.out.print("계좌번호: ");
            account = sc.next();

            System.out.print("비밀번호: ");
            password = sc.next();

            user = Bank.login(arrBank, arCount, account, password);

            switch (choice) {
            case 0:
            	if(!(user instanceof Kakao)) {
            		System.out.println("주식 서비스는 카카오뱅크에서만 이용 가능합니다. (●'◡'●)/");
            		break;
            	}
            	Kakao kakaoUser = (Kakao)user;
            	System.out.println("투자액 : ");
//            	kakaoUser. sc.nextInt();
            	Thread stockThread = new Thread();
            	break;
            case 2: // 입금하기

               if (user != null) {
                  if (!user.getAccount().startsWith(index + "")) {
                     System.out.println("계좌 개설한 은행만 입금 가능");
                     break;
                  }

                  System.out.print("입금액: ");
                  money = sc.nextInt();
                  if (money > 0) {
                     user.deposit(money);
                     System.out.println(money + "원 입금 완료");
                  } else {
                     System.out.println("입금액을 다시 확인해주세요.");
                  }
               } else {
                  System.out.println("로그인 실패");
               }
               break;

            case 3: // 출금하기
               if (user != null) {
                  System.out.print("출금액: ");
                  money = sc.nextInt();
                  if (money > 0) {
                     if (user.getMoney() >= (user instanceof Kookmin ? money * 1.5 : money)) {
                        user.withdraw(money);
                     } else {
                        System.out.println("출금액을 다시 확인해주세요.");
                     }
                  }
               } else {
                  System.out.println("로그인 실패");
               }
               break;
            case 4: // 잔액 조회
               if (user != null) {
                  System.out.println("현재 잔액: " + user.showBalance());
               } else {
                  System.out.println("로그인 실패");
               }
               break;
            }
         }
      }
   }
}