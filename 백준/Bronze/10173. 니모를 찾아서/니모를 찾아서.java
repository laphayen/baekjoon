import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			
			if (str.equals("EOI")) {
				break;
			}
			
			String upStr = str.toUpperCase();
			
			if (upStr.contains("NEMO")) {
				System.out.println("Found");
			}
			else {
				System.out.println("Missing");
			}
		}
	}
}