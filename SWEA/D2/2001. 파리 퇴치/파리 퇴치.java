
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t <= test; t++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int max = 0;
			
			int[][] mat = new int[n][n];
			
			for (int i= 0; i<n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
			// 인덱스 범위를 넘기는 경
			for (int i = 0; i<n-m+1; i++) {
				for (int j = 0; j <n-m+1; j++) {
					int sum = 0;
					
					for(int k = 0; k <m; k++) {
						for(int l = 0; l <m; l++) {
							sum += mat[i+k][j+l];
						}
					}
					
					if (max < sum) {
						max = sum;
					}
				}
			}
			
			System.out.println("#" + t+ " "+max);
		}
	}

}
