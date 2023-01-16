package markerInterfaceTest;

public class Lab {
	
	public void checkKinds(Animal[] arAnimal) {
		for (int i = 0; i < arAnimal.length; i++) {
			if(arAnimal[i] instanceof CarnivoreMarker) {
				System.out.println("���ĵ���");
			} else if(arAnimal[i] instanceof HerbivoreMarker) {
				System.out.println("�ʽĵ���");
			} else System.out.println("��ĵ���");
		}
	}
	
	public static void main(String[] args) {
		Animal[] animals = {
				new Bear(),
				new Tiger(),
				new Cow(),
				new Dog()
		};
		
		new Lab().checkKinds(animals);
	}
}
