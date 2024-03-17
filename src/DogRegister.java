//Hund registreringsklassen
//Av Danyal Enes Özbek
public class DogRegister {

	private static final String OWNER_REGISTER_COMMAND = "register new owner";
	private static final String OWNER_REMOVE_COMMAND = "remove owner";
	private static final String DOG_REGISTER_COMMAND = "register new dog";
	private static final String DOG_REMOVE_COMMAND = "remove dog";
	private static final String GIVE_DOG_TO_OWNER_COMMAND = "give dog to owner";
	private static final String REMOVE_DOG_FROM_OWNER_COMMAND = "remove dog from owner";
	private static final String LIST_DOGS_COMMAND = "list dogs";
	private static final String INCREASE_AGE_COMMAND = "increase age";
	private static final String LIST_OWNERS_COMMAND = "list owners";
	private static final String EXIT_COMMAND = "exit";
	
	private OwnerCollection owners = new OwnerCollection();
	private DogCollection dogs = new DogCollection();
	private InputReader input = new InputReader();

	private void start() {
		runCommandLoop();
		shutDown();
	}

	private void shutDown() {
		System.out.println("shutting down");
	}

	private void runCommandLoop() {
		String command;
		do {
			command = readCommand();
			handleCommand(command);
		} while (!command.equals(EXIT_COMMAND));

	}

	private void handleCommand(String command) {
		switch (command.toLowerCase()) {
		case OWNER_REGISTER_COMMAND:
			registerOwner();
			break;
		case OWNER_REMOVE_COMMAND:
			removeOwner();
			break;
		case DOG_REGISTER_COMMAND:
			registerDog();
			break;
		case DOG_REMOVE_COMMAND:
			removeDog();
			break;
		case LIST_DOGS_COMMAND:
			listDogs();
			break;
		case GIVE_DOG_TO_OWNER_COMMAND:
			giveDogToOwner();
			break;
		case REMOVE_DOG_FROM_OWNER_COMMAND:
			removeDogFromOwner();
			break;
		case INCREASE_AGE_COMMAND:
			increaseAge();
			break;
		case LIST_OWNERS_COMMAND:
			listOwners();
			break;
		case EXIT_COMMAND:
			break;
		default:
			System.out.println("error, wrong command!");
		}

	}

	private String readCommand() {
		return input.readNextLine("Enter command").toLowerCase().trim();
	}

	private void registerOwner() {
		String ownerName = input.readNextLine("Enter owner name");
		if (stringIsBlank(ownerName)) {
			registerOwner();
			return;
		}
		ownerName = formatName(ownerName);

		if (owners.containsOwner(ownerName)) {
			printError(ownerName, "owner", "exists");
		} else {
			printError(ownerName, "owner", "added");
			Owner owner = new Owner(ownerName);
			owners.addOwner(owner);
		}
	}

	private void removeOwner() {
		if (noOwners()) {
			return;
		}
		String ownerName = input.readNextLine("Enter owner name");
		if (stringIsBlank(ownerName)) {
			return;
		}
		ownerName = formatName(ownerName);
		if (owners.getOwner(ownerName) == null) {
			printError(ownerName, "owner", "not exists");
			return;
		} else if (owners.containsOwner(owners.getOwner(ownerName))) {
			removeOwnerLoop(ownerName);
			return;
		}
	}

	private void registerDog() {
		String dogName = "";
		dogName = input.readNextLine("Enter dog name");
		if (stringIsBlank(dogName)) {
			registerDog();
			return;
		}
		dogName = formatName(dogName);

		if (dogs.containsDog(dogName)) {
			printError(dogName, "dog", "exists");
		} else {
			registerDogLoop(dogName);
		}
	}

	private void removeDog() {
		if (noDogs()) {
			return;
		}
		String dogName = input.readNextLine("Enter dog name");
		if (stringIsBlank(dogName)) {
			return;
		}
		dogName = formatName(dogName);
		if (dogs.containsDog(dogs.getDog(dogName))) {
			dogs.getDog(dogName).setOwner(null);
			dogs.removeDog(dogs.getDog(dogName));
			printError(dogName, "dog", "removed");
		} else {
			printError(dogName, "dog", "not exists");
		}
	}

	private void giveDogToOwner() {

		if (noDogs()) {
			return;
		} else if (noOwners()) {
			return;
		}
		String dogName = input.readNextLine("Enter dog name");
		dogName = formatName(dogName);
		if (dogs.getDog(dogName) == null) {
			printError(dogName, "dog", "not exists");
			return;
		} else if (dogs.getDog(dogName).getOwner() != null) {
			printError(dogName, "", "has owner");
			return;
		}
		String ownerName = input.readNextLine("Enter owner name");
		ownerName = formatName(ownerName);
		if (owners.getOwner(ownerName) == null) {
			printError(ownerName, "owner", "not exists");
			return;
		}
		dogs.getDog(dogName).setOwner(owners.getOwner(ownerName));
		System.out.println("The dog " + dogName + " is now owned by " + ownerName + "\n");
	}

	private void removeDogFromOwner() {
		if (noDogs()) {
			return;
		} else if (noOwners()) {
			return;
		}
		String dogName = input.readNextLine("Enter dog name");
		dogName = formatName(dogName);
		if (dogs.getDog(dogName) == null) {
			printError(dogName, "dog", "not exists");
			return;
		} else if (dogs.getDog(dogName).getOwner() == null) {
			System.out.println("Error: The dog " + dogName + " doesn't have an owner.\n");
			return;
		}
		dogs.getDog(dogName).setOwner(null);
		System.out.println("The dog " + dogName + " now has no owner.\n");
	}

	private void increaseAge() {
		if (noDogs()) {
			return;
		}
		String dogName = input.readNextLine("Enter dog name");
		System.out.println();
		dogName = formatName(dogName);
		if (dogs.getDog(dogName) == null) {
			printError(dogName, "dog", "not exists");
			return;
		}
		dogs.getDog(dogName).updateDogAge(1);
		System.out.println("The dog " + dogName + " is one year older now.\n");
	}

	private void listDogs() {
		if (noDogs()) {
			return;
		}
		double tail = input.readDouble("Enter tail length");
		System.out.println();
		System.out.println("DOG LIST");
		for (Dog dog : dogs.getArrayWithTailLength(tail)) {
			System.out.printf(dog.toString() + "\n");
			
		}
			System.out.println();
	}

	private void listOwners() {
		if (owners.getOwners().isEmpty()) {
			printError("", "owners", "empty register");
			return;
		}
		for (Owner owner : owners.getOwners()) {
			System.out.println(owner.toString());
		}
		System.out.println();
	}

	// Egna metoder:

	private boolean stringIsBlank(String str) {
		if (str.isBlank()) {
			printError("", "", "blank string");
			return true;
		}
		return false;
	}

	private String formatName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	private boolean noDogs() {
		if (dogs.getDogs().isEmpty()) {
			printError("", "dogs", "empty register");
			return true;
		}
		return false;
	}

	private boolean noOwners() {
		if (owners.getOwners().isEmpty()) {
			printError("", "owners", "empty register");
			return true;
		}
		return false;
	}

	private void printError(String name, String dogOrOwner, String command) {
		switch (command) {
		case "blank string":
			System.out.println("Error: A blank string is not allowed, try again.\n");
			break;
		case "added":
			System.out.println("The " + dogOrOwner + " " + name + " has been added to the register.\n");
			break;
		case "removed":
			System.out.println("The " + dogOrOwner + " " + name + " has been removed from the register. \n");
			break;
		case "exists":
			System.out.println("Error: The " + dogOrOwner + " " + name + " already exists.");
			break;
		case "not exists":
			System.out.println("Error: The " + dogOrOwner + " " + name + " doesn't exist.\n");
			break;
		case "empty register":
			System.out.println("Error: No " + dogOrOwner + " in the register.\n");
			break;
		case "has owner":
			System.out.println("Error: The dog " + name + " already have an owner.\n");
			break;
		default:
			System.out.println("");
		}
	}

	private void registerDogLoop(String dogName) {
		String breed = input.readNextLine("Enter breed");
		if (stringIsBlank(breed)) {
			registerDogLoop(dogName);
		} else {
			int age = input.readInt("Enter age");
			int weight = input.readInt("Enter weight");
			Dog dog = new Dog(dogName, breed, age, weight);
			dogs.addDog(dog);
			System.out.println("The dog " + dogName + " has been added to the register.\n");
		}
	}

	private void removeOwnerLoop(String ownerName) {
		printError(ownerName, "owner", "removed");
		for (Dog dog : owners.getOwner(ownerName).getDogs()) {
			dog.setOwner(null);
			owners.getOwner(ownerName).removeDog(dog);
			dogs.removeDog(dog);
		}
		owners.removeOwner(owners.getOwner(ownerName));
	}

	public static void main(String[] args) {
		new DogRegister().start();
	}
}
