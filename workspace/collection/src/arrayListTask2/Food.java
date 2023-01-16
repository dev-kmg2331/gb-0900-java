package arrayListTask2;

public class Food {
	private String name, kind;
	private int price;
	
	public Food() {;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", kind=" + kind + ", price=" + price + "]";
	}

}
