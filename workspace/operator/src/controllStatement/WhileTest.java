package controllStatement;

public class WhileTest {

	public static void main(String[] args) {
//		이름 10번 출력
		int index = 0;
		while(index < 10) {
			index++;
			if(index == 3) index++;
			System.out.println(index + "강민구");
		}
	}

}
