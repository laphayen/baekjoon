
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int cnt;
	static int [][] map;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0);
		
		System.out.println(cnt);
	}

	private static void dfs(int r, int c, int d) {
		if (r == n-1 && c == n-1) {
			cnt++;
			return;
		}
		
		if (d == 0) {
			if (c + 1 < n && map[r][c+1] == 0) {
				dfs(r, c+1, 0);
			}
		}
		else if (d == 1) {
			if (r + 1 < n && map[r+1][c] == 0) {
				dfs(r+1, c, 1);
			}
		}
		else if (d== 2) { // 방향이 대각선인 경우.
			if (c+1 < n && map[r][c+1] == 0) {
				dfs(r, c+1, 0);
			}
			if (r+1 < n && map[r+1][c] == 0) {
				dfs(r+1, c, 1);
			}
		}
		
		if (r+1 < n && c+1 < n && map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0) {
			dfs(r+1, c+1, 2);
		}
		
		
	}
}
