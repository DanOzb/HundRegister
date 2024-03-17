//Hund svans och namn jämförarklassen
//Av Danyal Enes Özbek
import java.util.Comparator;

public class DogTailNameComparator implements Comparator<Dog> {
	public int compare(Dog dogOne, Dog dogTwo) {
		DogTailComparator tail = new DogTailComparator();
		DogNameComparator name = new DogNameComparator();

		
		if(tail.compare(dogOne, dogTwo) == 1) {
			return 1;
		} else if(tail.compare(dogOne, dogTwo) == -1) {
			return -1;
		}
		return name.compare(dogOne, dogTwo);
	}

}
