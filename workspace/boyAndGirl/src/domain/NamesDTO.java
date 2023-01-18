package domain;

public class NamesDTO {
	
	private String name;
	private int rank;
	private int amount;
	private String gender;
	
	public NamesDTO() {;}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return gender + "\t" + name + "\t" + rank + "\t" + amount;
	}

	
}
