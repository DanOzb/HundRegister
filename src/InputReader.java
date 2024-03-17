//Inmatningsklassen
//Av Danyal Enes Özbek
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
	private static ArrayList<InputStream> list = new ArrayList<InputStream>();
	private Scanner input;

	public InputReader(){
		this(System.in);
	}

	public InputReader(InputStream stream){
		if(list.contains(stream)) {
			throw new IllegalStateException("Felmeddelande");
		}
		InputReader.list.add(stream);
		input = new Scanner(stream);
	}
	
	public int readInt(String str) {
		System.out.print(str+"?> ");
		int number = input.nextInt();
		input.nextLine();
		return number;
	}
	
	public double readDouble(String str) {
		System.out.print(str+"?> ");
		double number = input.nextDouble();
		input.nextLine();
		return number;
	}
	
	public String readNextLine(String str) {
		String noText = "";
		String testText = "";
		System.out.print(str+"?> ");
		while(input.hasNextLine()) {
			testText = input.nextLine();
			if(testText.isEmpty()) {
				break;
			}
			else if(testText.matches(".*\\d.*")) {
				continue;
			}
			return testText;
		}
		return noText;
	}
	
}
