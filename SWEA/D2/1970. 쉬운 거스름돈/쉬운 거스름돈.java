
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t<=test; t++) {
			
			int num = sc.nextInt();
			
			int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] result = new int[8];
			
			for (int i = 0; i< 8 ; i++) {
				result[i] = num / coin[i];
				num %= coin[i];
			}
			
			System.out.println("#" + t);
			
			for (int i = 0; i < 8; i++) {
				System.out.print(result[i] + " ");
			}
			
			System.out.println();
		}
		
	}

}
