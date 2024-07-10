
import java.util.Scanner;
import java.io.FileInputStream;


public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		
		int Test = sc.nextInt();
		
		for (int t = 1; t<= Test; t++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if (A < B) {
				System.out.println("#"+t+ " <");
				
			}
			else if (A > B) {
				System.out.println("#"+t+ " >");
			}
			else {
				System.out.println("#"+t+ " =");
			}
			
		}
		
	}

}
