
import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    static int [][] map;
    static int [][] mapC;
    static int n;
    static int m;
    static boolean [][] v;
    static int result;
    
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, -1, 0, 1};
    
    public static void main(String[] args) {
        
        /*
         * 설계
         * 
         * 벽을 3 개씩 새워본다.
         * 2를 기준으로 바이러스 확산 시킨다.
         * 0을 카운트 한다.
         * 
         * 벽을 세운다. -> dfs
         * 2초에 512MB가 이니깐
         * 3 <= n, m <=8 중복 있어도
         * 
         * 
         * 바이러스 2는 퍼진다 -> 1을 만나는 경우를 제외하고
         *                     -> 0을 2로 변경
         * 퍼져 나간다 -> BFS
         * 상하좌우 -> dx dy 
         * 
         * 
         * 입력 시 2의 자표를 저장
         * for문을 통해서 
         *         bfs로 2를 확산
         * 
         * 출력 - 맵에서 남은 0인 부분을 카운트
         * 
         * 
         * 함수로 만들 것들.
         * 1. 벽을 세울 함수 -> dfs
         * 2. 바이러스 확산 함수 -> bfs
         * 3. 0의 계수를 셀 함수. -> 결과값보다 크면 교환.
         * 
         *
         */
            
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        map = new int[n][m];
        result = Integer.MIN_VALUE;
        
        for (int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                map[r][c] = sc.nextInt();
                /*
                 * 좌표를 저장해야 겠다. - 2를 시작점으로 bfs를 돌아야
                 */
            }
        }
        
        // 벽을 세워 보자
        dfs(0);
        System.out.println(result);
        
    }

    // 벽 세우는 모든 경우의 수.
	private static void dfs(int cnt) {
		if (cnt == 3) {
//			print();
//			System.out.println("-------");
			
			// 벽을 만들었으니 여기서 바이러스 확산시켜.
			bfs();
			
			return;
		}
		
		/* 
		 * 한 차례에 뭘 할 건가?
		 * 한 개의 벽만 세워
		 * 
		 * 벽 세우기 전에 조건을 검사했는데 3이면 돌아가.
		 */
		// map을 돌면서 1을 넣고.
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (map[r][c] == 0) {
					// 0이면 벽을 하나 세우
					map[r][c] = 1;
					// 다음 벽 세우기로 넘어가는데
					// 1개 선택 했으니 선택 개수 증가.
					
					dfs(cnt+1);
					// 돌아왔을 때 현재 벽을 지워.
					map[r][c] = 0;
				}
			}
		}
		
	}
	
	// 바이러스 확산 시키는 함수.
	private static void bfs() {
		mapC = new int[n][m];
		Queue<Point> q = new LinkedList<>();
		for (int r = 0; r<n; r++) {
			for (int c = 0; c < m; c++) {
				mapC[r][c] = map[r][c];
				if (mapC[r][c] == 2) {
					q.offer(new Point(r, c));
					
				}
			}
		}
		
		while (!q.isEmpty()) {
			Point np = q.poll();
			for (int i = 0; i<4; i++) {
//				print2();
				int nr = np.x + dr[i];
				int nc = np.y + dc[i];
				if (nr >= 0 && nr <n && nc >= 0 && nc < m && mapC[nr][nc] == 0) {
					mapC[nr][nc] = 2;
					q.offer(new Point(nr, nc));
				}
			}
		}
		
		cal();
		
	}

	// 입력된 배열 상태 확인하는 함수.
	private static void print() {
		for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(map[r]));	
		}
		System.out.println("0000000");
	}
	
	private static void print2() {
		for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(mapC[r]));	
		}
		System.out.println("0000000");
	}
	
	// 0의 개수를 세고 결과를 저장하는 함수.
	private static void cal() {
		int cnt = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (mapC[r][c] == 0) {
					cnt += 1;
				}
			}
		}
		result = Math.max(result, cnt);
	}
}