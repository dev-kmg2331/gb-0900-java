package anonymous;

public class Computer {
	public static void main(String[] args) {
//		부모 추상클래스에 구현 안된걸 구현하는데 목적이 있다.
//		업캐스팅되어 짤리기 때문에 익명클래스에 새로 선언해도 의미없음.
		
		Game game = new Game() {
			
			@Override
			public void play() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
