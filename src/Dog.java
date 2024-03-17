//Hund klassen
//Av Danyal Enes Özbek
public class Dog {
	private static final double DACHSHUND_TAIL_LENGTH = 3.7;
	private String name; 
	private String breed; 
	private int age;
	private int weight; 
	private Owner owner;
	public Dog(String name, String breed, int age, int weight) {
		
		this.name = name.trim(); 
		this.breed = breed.trim(); 
		this.age = age; 
		this.weight = weight; 
	} 
	
	public void updateDogAge(int year) {
		if(year > 0) {
			if(year == Integer.MAX_VALUE || this.age == Integer.MAX_VALUE) {
				this.age = Integer.MAX_VALUE;
			} else {
				this.age += year;
			} 
		}
	}
	
	public String getName() {
		return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
	}
	
	public String getBreed() {
		return breed.substring(0,1).toUpperCase() + breed.substring(1).toLowerCase();
	}
	
	public int getAge() {
		return this.age; 
	}
	
	public int getWeight() {
		return this.weight; 
	}
	
	public double getTailLength() {
		if(getBreed().equals("Tax") || getBreed().equals("Dachshund")) {
			return DACHSHUND_TAIL_LENGTH;
		}
		return Double.valueOf(getAge()) * getWeight()/10;
	}
	
	public String toString() {
		if(owner == null) {
			return "Name: " + getName().toString() + " | Breed: " +  getBreed().toString() + " | Age: "
					+ getAge() + " | Weight: " + getWeight() + " | Tail Length: " + getTailLength();
		}
		return "Name: " + getName().toString() + " | Breed: " +  getBreed().toString() + " | Age: "
				+ getAge() + " | Weight: " + getWeight() + " | Tail Length: " + getTailLength() 
				+ " Owner : " + owner.getName();
	}
	
	public boolean setOwner(Owner owner) {
		if(owner == null) {
			if(this.owner != null) {
				this.owner.removeDog(this);
			}
			this.owner = null;
			return false;
		} 
		if(getOwner() != null) {
			return false;
		}
		if(!owner.getDogs().contains(this)) {
			owner.addDog(this);
		}
		this.owner = owner;
		return true;
	}
	
	public Owner getOwner() {
		return owner;
	}
}
