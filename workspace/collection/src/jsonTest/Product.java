package jsonTest;

public class Product {
	private int number, price, quantity;
	private String name;
	
	public Product() {;}
	
	public Product(int number, int price, int quantity, String name) {
		this.number = number;
		this.price = price;
		this.quantity = quantity;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", price=" + price + ", quantity=" + quantity + ", name=" + name + "]";
	}
	
}
