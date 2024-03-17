import java.util.ArrayList;

public class DogSorterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog dog1 = new Dog("xlvin", "mastiff", 12, 10);
		Dog dog2 = new Dog("novara", "tax", 4, 8);
		
		ArrayList<Dog> list = new ArrayList<Dog>();
		list.add(dog1);
		list.add(dog2);
		System.out.println(list.toString());

	
	}

}
