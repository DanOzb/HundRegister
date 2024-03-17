
public class OwnerOfDogsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog dog = new Dog("jeff", "tax", 12, 10);
		Dog dog2 = new Dog("jeremy", "mastiff", 3, 10);
		Owner owner = new Owner("Sam");
		Owner owner2 = new Owner("david");
		dog.setOwner(owner);
		owner.addDog(dog);
		dog.setOwner(null);
		owner.addDog(dog2);
		System.out.println(dog.getOwner());
		System.out.println(owner.getDogs());
	}

}
