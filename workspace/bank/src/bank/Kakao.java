package bank;

public class Kakao extends Bank{
	@Override
	public int showBalance() {
		setMoney(getMoney() / 2);
		return super.showBalance();
	}
}
