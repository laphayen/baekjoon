
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t <= test; t++ ) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int sum = 0;
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// + 형태
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, 1, -1 };
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int tmp = arr[r][c];
					for (int m = 1; m < M; m++) {
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d] * m;
							int nc = c + dc[d] * m;
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								tmp += arr[nr][nc];
							}
						}

					}
					if (tmp > sum) {
						sum = tmp;
					}
				}
			}

			// x 형태
			int[] drx = { -1, 1, -1, 1 };
			int[] dcx = { -1, 1, 1, -1 };
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int tmp = arr[r][c];
					for (int m = 1; m < M; m++) {
						for (int d = 0; d < 4; d++) {
							int nr = r + drx[d] * m;
							int nc = c + dcx[d] * m;
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								tmp += arr[nr][nc];
							}
						}

					}
					if (tmp > sum) {
						sum = tmp;
					}
				}
			}

			System.out.printf("#%d %d\n", t, sum);
		}
	}

}
