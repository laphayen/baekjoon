
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t<=test; t++) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int result = 0;
			
			int[][] arr = new int[n][n];
			
			for (int i = 0; i <n; i++) {
				for (int j = 0; j < n; j++ ) {
					int bit = sc.nextInt();
					arr[i][j] = bit;
				}
			}
			
			
			// 먼저 행 
			for (int i = 0; i < n; i++) {
				
				int cnt = 0;
				
				for (int j = 0; j <n ; j++ ) {
					if (arr[i][j] == 0) {
						if (cnt == k) {
							result += 1;
						}
						cnt = 0;
					}
					else {
						cnt += 1;
					}
				}
				
				if (cnt == k) {
					result += 1;
				}
			}
			
			for (int i = 0; i < n; i++) {
				
				int cnt = 0;
				
				for (int j = 0; j <n ; j++ ) {
					if (arr[j][i] == 0) {
						if (cnt == k) {
							result += 1;
						}
						cnt = 0;
					}
					else {
						cnt += 1;
					}
				}
				
				if (cnt == k) {
					result += 1;
				}
			}
			
			
			System.out.println("#" + t + " "+result);
		}
		
	}

}
