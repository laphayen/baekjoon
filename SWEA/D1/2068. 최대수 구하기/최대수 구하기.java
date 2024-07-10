
import java.util.Scanner;
import java.io.FileInputStream;


public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int Test = sc.nextInt();
		
		for (int t = 1; t <= Test; t++) {
			
			int[] arr = new int[10];
			
			int result = 0;
			
			for (int i = 0; i < 10; i++) {
				
				arr[i] = sc.nextInt();
				
				if (result < arr[i]) {
					result =  arr[i];
				}
				
			}
			
			System.out.println("#"+t+" "+result);
			
		}
		
	}

}
