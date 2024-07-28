import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = n-i; j > 0; j--) {
				System.out.print("*");
			}
			
			System.out.println("");
		}
	}
}