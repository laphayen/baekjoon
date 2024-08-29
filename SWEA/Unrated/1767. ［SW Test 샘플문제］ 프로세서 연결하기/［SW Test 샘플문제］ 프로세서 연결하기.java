
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int n; // dfs든 bfs든 프로세스가 벽을 만나면 다음으로 넘김
	static int pc; // 프로세서 개수.
	static int result;
	static int [][] map;
	static ArrayList<Point> l;
	static boolean [] v;
	
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		
		/*
		 * 고려사항 - 한쪽 방향으로 가다가 1을 만나면 멈추는데.
		 * 완료되지 않았으면 다음으로 넘어갈 것.
		 * 
		 * 
		 * 
		 * 벽에 붙어 있으면 제외하고 나머지만 돌려 -> 좌표가 0,n-1일 경우 
		 * 나머지들의 좌표를 뽑아내.
		 * 
		 * 연결 리스트에 있는 좌표를 기준으로 
		 * 
		 * 
		 * 1번 프로세스를 뽑아서 방향을 나눠서 전진시켜 -> 1방향 돌리고 다음 프로세스 돌려봐야 함 n퀸 처럼. -> 4방향 다(dr,dc) for
		 * 		1일 아닐 때까지 전진해서 0이나 n-1 값이면
		 * 			다음 프로세서를 돌려
		 * 			
		 * 		1일 경우 탈출.
		 * 		
		 * dfs(n) -> 0, 1, 2, 3, 4-> pc-1 {
		 * 		// 4방향을 나눠서 돌
		 * 		for (int i = 0; i < 4; i++ ) {
		 * 			nr = p.x + dr[i];
		 * 			nc = p.y + dc[i];
		 * 		
		 * 			while(nr >= 0 && nr < n && nc >= 0 && nc < n &&
		 * 		}
		 * 
		 * 
		 * }
		 * 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            n = sc.nextInt();
            map = new int[n][n];
            l = new ArrayList<>();
            pc = 0;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    map[r][c] = sc.nextInt();
                    if (map[r][c] == 1) {
                        if (r == 0 || c == 0 || r == n - 1 || c == n - 1) { 
                            continue;
                            
                        }
                        l.add(new Point(r, c));
                    }
                }
            }
            
            result = Integer.MAX_VALUE;
            
            
            connect(0, 0, 0);

            System.out.println("#" + t + " " + result);
        }

    }
//	
//	// 조합
//    private static void comb(int cnt, int start, int sum) {
//        if (cnt == l.size()) {
//            connect(0, 0);
//            return;
//        }
//
//        for (int i = start; i < l.size(); i++) {
//            if (!v[i]) {
//                v[i] = true;
//                comb(cnt + 1, i + 1, r);
//                v[i] = false;
//            }
//        }
//    }

	private static void connect(int idx, int pcCnt, int sum) {
        if (idx == l.size()) {
        	if (pcCnt > pc) {
        		pc = pcCnt;
        		result = sum;
        	}
        	else if (pcCnt == pc) {
        		result = Math.min(result, sum);
        	}
            return;
        }
        
		
		Point np = l.get(idx); // 현재 꺼 좌표에서
		
		for (int i = 0; i < 4; i++) { // 4방 탐색을 하는데/
			// 현재꺼 좌표에서.
			int nr = np.x;
			int nc = np.y;

			// 벽을 만날 때까지 증가 시키면
//			// 0, 2);
//			System.out.println("np 값: " + np.x + " " + np.y);
//			System.out.println("dr, dc: " + dr[i] + " " + dc[i]);
//			
			int lineCnt = 0; // 현재 프로세서의 1을 놓은 개수.
			boolean chk = true; // 1을 연결했는지 여
			
			while (true) {
				nr += dr[i];
				nc += dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
	                break;
	            }
				// 다음 위치가. 0이 아니면. 
				// 만약 0이 아닌 숫자를 만나면 while문 탈출후 1값 만큼 0으로 복귀
				if (map[nr][nc] != 0) {
					chk = false;
					break;
				}
				
				lineCnt++;
			}
			
			if (chk) {
                nr = np.x;
                nc = np.y;

                for (int j = 0; j < lineCnt; j++) {
                    nr += dr[i];
                    nc += dc[i];
                    map[nr][nc] = 1;
                }

                connect(idx + 1, pcCnt + 1, sum + lineCnt);

                nr = np.x;
                nc = np.y;

                for (int j = 0; j < lineCnt; j++) {
                    nr += dr[i];
                    nc += dc[i];
                    map[nr][nc] = 0;
                }
            }
			
		}
		connect(idx+1, pcCnt, sum);
		
	}
	

}
