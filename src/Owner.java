//Enes Özbek enoz7518
import java.util.ArrayList;

public class Owner implements Comparable<Owner> {
	private ArrayList<Dog> dogs = new ArrayList<Dog>();
	
	
	private String name;
	public Owner(String name) {
		this.name = name.substring(0,1).toUpperCase() + name.substring(1,name.length()).toLowerCase();
		this.dogs = new ArrayList<Dog>();
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		String text = getName() + " : ";
		for(Dog dog : dogs) {
			text += dog.getName() + ", ";
		}
		text  = text.substring(0, text.length() - 2);
		return text;
	}
	
	public int compareTo(Owner other) {
		return this.getName().compareTo(other.getName());
	}
	
	public boolean addDog(Dog dog) {
		if(dog == null) {
			return false;
		}
		if(dogs.contains(dog)) {
			return false;
		} 
		if(dog.getOwner() == null) {
			dogs.add(dog);
			dog.setOwner(this);
			return true;
		}
		return false;
		
	}
	
	public boolean removeDog(Dog dog) {
		if(dog == null) {
			return false;
		}
		if(dogs.contains(dog)) {
			dogs.remove(dog);
			return true;
		}
		return false;
	}
	
	public ArrayList<Dog> getDogs(){
		ArrayList<Dog> referenceList = new ArrayList<Dog>(dogs);
		DogNameComparator comparator = new DogNameComparator();
		DogSorter.sortDogs(comparator, referenceList);
		return referenceList;
	}

	
}
