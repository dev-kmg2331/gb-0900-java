package hashSetTest;

import java.util.HashSet;

public class School {
	
	public static void main(String[] args) {
		HashSet<Student> stdSet = new HashSet<Student>();
		
		stdSet.add(new Student(1, "강민구"));
		
		System.out.println(stdSet.contains(new Student(1, "강민구")));
		
		System.out.println(stdSet);
	}
}
