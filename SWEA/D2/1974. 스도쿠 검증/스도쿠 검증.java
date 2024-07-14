
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		int arr[][] = new int[9][9];
		
		for (int t = 1; t<=test; t++) {
			
			int result = 1;
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 9; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 9; j++) {
					rowSum += arr[i][j];
					colSum += arr[j][i];
				}

				if (rowSum != 45 || colSum != 45) {
					result = 0;
					break;
				}
			}
			
			if (result == 0) {
				System.out.println("#" + t + " " + result);
				continue;
			}
			
			for (int i = 1; i <= 3; i++) {
				int squareSum = 0;
				for (int j = (i - 1) * 3; j < i * 3; j++) {
					for (int k = (i - 1) * 3; k < i * 3; k++) {
							squareSum += arr[j][k];
						}
					}
					if (squareSum != 45) {
						result = 0;
						break;
					}
				if (result == 0) {
					break;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
		
	}

}
