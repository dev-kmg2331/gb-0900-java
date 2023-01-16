package objectTest;

class Student {
   private int number;
   private String name;
   
   public Student() {;}
   
   public Student(int number, String name) {
	super();
	this.number = number;
	this.name = name;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

//	1562557367
	
	@Override
	   public String toString() {
	      return "Student [number=" + number + ", name=" + name + "]";
	}
}

public class ToStringTest {
   public static void main(String[] args) {
      Student 한동석 = new Student();
      
      한동석.setNumber(1);
      한동석.setName("한동석");
      
      System.out.println(한동석);
   }
}



















