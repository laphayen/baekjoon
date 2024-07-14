
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t <= test; t++) {
			
			String s = sc.next();
			String r = "";
			
			for (int i = s.length()-1; i >= 0; i--) {
				r = r + s.charAt(i);
			}
			
			if (s.equals(r)) {
				System.out.println("#"+t+" 1");
			}
			else {
				System.out.println("#"+t+" 0");
			}
		}
	}

}
