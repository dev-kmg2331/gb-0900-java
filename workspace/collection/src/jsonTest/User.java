package jsonTest;

public class User {
	private int number, age;
	private String id, password, name;
	
	public User() {;}
	
	public User(int number, int age, String id, String password, String name) {
		this.number = number;
		this.age = age;
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [number=" + number + ", age=" + age + ", id=" + id + ", password=" + password + ", name=" + name
				+ "]";
	}
	
}
