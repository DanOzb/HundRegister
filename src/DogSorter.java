//Hund sorterarklassen
//Av Danyal Enes Özbek
import java.util.ArrayList;
import java.util.Comparator;

public class DogSorter {
	
	public static int sortDogs(Comparator<Dog> comparison, ArrayList<Dog> list) {
		int swapReturn = 0;
		for(int i = 0; i < list.size(); i++) {
			int index = nextDog(comparison, list, i);
			if(index != i) {
				swapDogs(list, index, i);
				swapReturn++;
			}
		}
		return swapReturn;
	}
	
	private static void swapDogs(ArrayList<Dog> list, int indexOne, int indexTwo) {
		Dog elementOne = list.get(indexOne);
		Dog elementTwo = list.get(indexTwo);
		
		list.set(indexOne, elementTwo);
		list.set(indexTwo, elementOne);
		
	}
	
	private static int nextDog(Comparator<Dog> comparison, ArrayList<Dog> list, int indexSmaller) {
		int i = indexSmaller;
		for(i = indexSmaller; i < list.size(); i++) {
			if(comparison.compare(list.get(indexSmaller), list.get(i)) > 0) {
				indexSmaller = i;
			} 
		}
		
		return indexSmaller;
	}
}
