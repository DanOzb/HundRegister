//Hund samlingsklassen
//Av Danyal Enes Özbek
import java.util.ArrayList;

public class DogCollection {
	
	private ArrayList<Dog> list = new ArrayList<>();
	
	public boolean addDog(Dog dog) {
		if(dog == null) {
			return false;
		}
		if(containsDog(dog.getName())) {
				return false;
		}
		list.add(dog);
		return true;
	}
	
	public boolean removeDog(Dog dog) {
		if(dog == null) {
			return false;
		}
		if(containsDog(dog.getName())) {
			if(dog.getOwner() != null) {
				return false;
			}
			list.remove(dog);
			return true;
		}
		return false;
	}
	
	public boolean removeDog(String dogName) {
		if(getDog(dogName) == null) {
			return false;
		}
		if(getDog(dogName).getOwner() != null) {
			return false;
		}
		removeDog(getDog(dogName));
		return true;
	}
	
	public boolean containsDog(String dogName) {
		for(Dog dog : list) {
			if(dog.getName().equals(dogName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsDog(Dog dog) {
		if(list.contains(dog)) {
			return true;
		}
		return false;
	}
	
	public Dog getDog(String dogName) {
		for(Dog dog : list) {
			if(dog.getName().equals(dogName)) {
				return dog;
			}
		}
		return null;
	}
	
	public ArrayList<Dog> getDogs(){
		DogNameComparator comparator = new DogNameComparator();
		ArrayList<Dog> referenceList = new ArrayList<Dog>(list);
		DogSorter.sortDogs(comparator, referenceList);
		return referenceList;
	}
	
	public ArrayList<Dog> getArrayWithTailLength(double tail){
		ArrayList<Dog> referenceList = new ArrayList<Dog>(list);
		referenceList.removeIf(dog -> dog.getTailLength() < tail);
		DogTailNameComparator comparator = new DogTailNameComparator();
		DogSorter.sortDogs(comparator, referenceList);
		return referenceList;
	}
	
}
