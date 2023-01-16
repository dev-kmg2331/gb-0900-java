package castingTask;

import java.util.Random;

public class Bank {
	private String client, accountNumber, mobile, pw, bankId;
	private int balance;
	
	public Bank() {;}
	
	public Bank(String client, String mobile, String pw) {
		this.client = client;
		this.mobile = mobile;
		this.pw = pw;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}

	public int withDraw(int amount) {
		return checkWithDraw(amount) ? amount : 0;
	}
	
	public void createAccount() {
		int generatedAccountNumber = 100000 + new Random().nextInt(99999);
		String accountNumber = bankId + " " + generatedAccountNumber;
		
		while(checkAccountNumber(accountNumber)) {
			generatedAccountNumber = 100000 + new Random().nextInt(99999);
			accountNumber = bankId + " " + generatedAccountNumber;
		}
	}
	
	private boolean checkWithDraw(int amount) {
		return balance > amount ? true : false;
	}
	
	private boolean checkAccountNumber(String accountNumber) {
		return !this.accountNumber.equals(accountNumber);
	}
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
