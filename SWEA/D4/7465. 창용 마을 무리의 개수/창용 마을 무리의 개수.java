

import java.util.Arrays;
import java.util.Scanner;


/*
 * 실패 지점 - 노드는 있는데 타켓이 입력이 없을 경우
 * 연결되지 않는 노드도 집합으로 구해야 한다.
 * 1, 2, 3, 4, 5
 * 1 -2 번 연결되어 있는 정보가 있으면
 * 1-2, 3, 4, 5, -> 4개
 * 
 */

public class Solution {

	static int [][] map;
	static int n;
	static int m;
	static boolean [] v;
	
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int [n+1][n+1];
			v = new boolean[n+1];
			int cnt = 0;
			int result = n;
			
			for (int mc = 0; mc <m; mc++) {
				int node =sc.nextInt();
				int target = sc.nextInt();
				map [node][target] = 1;
				map[target][node] = 1;
			}
			
			/*
			 * 맵을 돌아서 1일 경우 dfs를 돈다.
			 * 돌면서 맵의 1을 true로 해준다.
			 * 무방향이므로 node] [target]의 반대도 해준다.
			 * dfs를 도는 만큼을 카운트해서 출력한다.
			 */
			
			for (int r = 0; r < n+1; r++) {
				for (int c = 0; c < n+1; c++) {
					if (!v[r] && map[r][c] == 1) {
						dfs(r);
						cnt +=1;
					}
				}
			}
			
			int falseCnt = 0;
			for (int i = 1; i < v.length; i++) {
				if (v[i] == false) {
					falseCnt += 1;
				}
			}
			
			System.out.println("#"+tc + " " + (cnt+falseCnt));
		}
		
	}
	
	private static void dfs(int r) {

		// 1. 해당 위치를 방문처리를 하고
		v[r] = true;
//		System.out.println(r);
		
		// 2. 인접된 각 행의 노드 부분을 dfs를 돌아 버리면서 0으로 바꿔준다. 
		for (int target = 0; target <n+1; target++) {
			// 타겟의 번호를 방문하지 않고
			if (!v[target] && map[r][target] == 1) {
				// 방문 처리를 한 다음에 다음 연결된 좌표를 돈다.
				v[target] = true;
				dfs(target);
			}
		}
		
	}

}
