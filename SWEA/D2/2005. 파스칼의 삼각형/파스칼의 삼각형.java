
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t <= test; t++) {
			int N = sc.nextInt();
            int[][] map = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j) {
                        map[i][j] = 1;
                    } else if (j == 0) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
                    }
                }
            }
            
            System.out.println("#" + t);
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) 
                    System.out.print(map[i][j] + " ");          
                System.out.println();
		}
	}
    }
}
