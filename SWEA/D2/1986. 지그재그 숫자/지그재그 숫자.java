
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t<=test; t++) {
			int n = sc.nextInt();
			
			int sum = 0;
			
			for (int i = 1; i<=n; i++) {
				if (i % 2 == 0) {
					sum -= i;
				}
				else {
					sum += i;
				}
			}
			
			System.out.println("#"+t +" "+sum);
		}
		
	}

}
