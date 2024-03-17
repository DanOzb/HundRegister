//enoz7518 Enes Özbek
import java.util.Comparator;

public class DogNameComparator implements Comparator<Dog> {
	public int compare(Dog nameOne, Dog nameTwo) {
		
		return nameOne.getName().compareTo(nameTwo.getName());
	}

}
