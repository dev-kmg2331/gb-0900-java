package bank;

import java.util.Random;

public class Kakao extends Bank implements Runnable{
	
	public boolean isExit;
	public int principal;
	public int stockMoney;
	
	@Override
	public int showBalance() {
		setMoney(getMoney() / 2);
		return super.showBalance();
	}
	
//	주가
	public void stock() {
		Random random = new Random();
		int rating = random.nextInt(31);
		
		final boolean isDecrease = random.nextBoolean();
		
		rating = isDecrease ? rating : rating * -1;
		
		stockMoney *= (100 + rating) * 0.01;
	}
	
//	매도
	public void sell() {
		setMoney(stockMoney);
		stockMoney = 0;
	}

	@Override
	public void run() {
		double rating = 0;
		int earningRate = 0;
		
		while(true) {
			rating = (double)stockMoney / principal;
			earningRate = (int) (rating < 1.0 ? rating * -100 : (rating - 1.0) * 100); 
			synchronized (this) {
				System.out.print("▶평가액 : " + stockMoney + "원\t\t");
				System.out.printf("▶수익률 : %1f", earningRate);
				if(isExit) {
					try {this.wait();} catch (Exception e) {;}
				}
			}
			try {
				Thread.sleep(3000);
//				매도
			} catch (InterruptedException e) {break;}
		}
	}
	
//	매수
}
