
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			
			long diff = 0;
			
			int m = 0;
			
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = n-1; i >= 0; i--) {
				if(arr[i] > m) {
					m = arr[i];
				}
				diff += m - arr[i];
			}
			
			System.out.printf("#%d %d\n",t,diff);
		}
	}

}
