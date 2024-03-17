
public class DogTestProgram {

	public static void main(String[] args) {
		Dog dog = new Dog("pASDpy", "    Tax ", 10, 5);
		
		System.out.println(dog.getBreed());
		System.out.println(dog.getName());
		System.out.println(dog.getAge());
		System.out.println(dog.getWeight());
		System.out.println(dog.getTailLength());
		System.out.println(dog.toString());
	}

}
