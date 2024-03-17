//Ägar samlingsklassen
//Av Danyal Enes Özbek
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OwnerCollection {
	private Owner[] ownerArray = new Owner[0];
	
	public boolean addOwner(Owner owner) {
		if(containsOwner(owner)) {
			return false;
		}		
		Owner[] newOwnerArray = new Owner[ownerArray.length + 1];
		for(int i = 0; i < ownerArray.length; i++) {
			newOwnerArray[i] = ownerArray[i];
		}
		newOwnerArray[ownerArray.length] = owner;
		ownerArray = newOwnerArray;
		return true;
	}
	
	public boolean removeOwner(Owner owner) {
		return removeOwner(owner.getName());
	}
	
	public boolean removeOwner(String ownerName) {
		if(containsOwner(ownerName)) {
			if(!(getOwner(ownerName).getDogs().isEmpty())) {
				return false;
			}
			Owner[] newOwnerArray = new Owner[ownerArray.length - 1];
			int deleteElementIndex = ownerLoop(ownerName);
			int j = 0;
			
			for(int i = 0; i < ownerArray.length; i++) {
				if(i == deleteElementIndex || ownerArray[i] == null) {
					continue;
				} 
				newOwnerArray[j] = ownerArray[i];
				j++;
			}
			ownerArray = newOwnerArray;
			return true;
		}
		return false;
	}
	
	public boolean containsOwner(String ownerName) {
			if(ownerLoop(ownerName) >= 0) {
				return true;
			}
		return false;
	}
	
	public boolean containsOwner(Owner owner) {
		return containsOwner(owner.getName());
	}
	
	public Owner getOwner(String ownerName) {
		int ownerIndex = ownerLoop(ownerName);
		if(ownerIndex >= 0) {
			return ownerArray[ownerIndex];
		}
		return null;
	}
	
	public ArrayList<Owner> getOwners(){
		ArrayList<Owner> referenceList =  new ArrayList<Owner>(Arrays.asList(ownerArray));
		Collections.sort(referenceList);
		return referenceList;
		
	}
	
	private int ownerLoop(String ownerName) {
		int length = ownerArray.length;
		for(int i = 0; i < length; i++) {
			if(ownerArray[i] != null) {
				if(ownerName.equals(ownerArray[i].getName())) {
					return i;
				}
			}
		}
		return -1;
	}
}
