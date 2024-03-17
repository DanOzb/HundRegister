//enoz7518 Enes Özbek
import java.util.Comparator;

public class DogTailComparator implements Comparator<Dog>{
	public int compare(Dog tailOne, Dog tailTwo) {
		if(tailOne.getTailLength()> tailTwo.getTailLength()) {
			return 1;
		} else if(tailOne.getTailLength() < tailTwo.getTailLength()){
			return -1;
		}
		return 0;
	}
}
