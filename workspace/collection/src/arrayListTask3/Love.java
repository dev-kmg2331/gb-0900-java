package arrayListTask3;

public class Love {
	private static int index;
	private int number;
	private String name;
	private int age;
	
	public Love() {;}

	{
		Love.index++;
		number = Love.index;
	}
	
	public int getNumber() {
		return this.number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Love [number=" + number + ", name=" + name + ", age=" + age + "]";
	}

}
