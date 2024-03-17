
public class DogCollectionsTest {

	public static void main(String[] args) {
		DogCollection collection = new DogCollection();
		Dog dog = new Dog("jeff", "mastiff", 5, 10);
		Dog dog1 = new Dog("jef", "tax", 3, 3);
		
		collection.addDog(dog);
		collection.addDog(dog1);
		System.out.println(collection.getArrayWithTailLength(4));
		

	}

}
