import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 컴퓨터는 인접해 있는지 모른다.
	// 섬의 개수를 세는 것 처럼 카운트 해줘야 한다.
	
	// 0,0 부터 n, m까지 1이고 방문배열에서 true일 경우 같은 넘버링으로 채워 버린다.
	// 그러면 111, 22222, 33333 섬의 개수가 카운트 되고 마지막의 카운트 값을 출력한다.
	
	static int testcnt;
	
	static int m;
	static int n;
	static int baechucnt;
	static int mappingnumber;
	
	static int [][] map;
	static boolean [][] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		testcnt = sc.nextInt();
		
		for (int tc = 1; tc <= testcnt; tc++) {
			m = sc.nextInt();
			n = sc.nextInt();
			baechucnt = sc.nextInt();
			mappingnumber = 1;
			
			map = new int [n][m];
			visited = new boolean [n][m];
			
			
			for (int i = 0; i < baechucnt; i++ ) {
				int c = sc.nextInt(); 
				int r = sc.nextInt();
				
				map[r][c] = 1;
			}
			
			
//			printMap();
			
			// 인접해 있는 것을 모두 넣어야 하기 때문에 bfs() 인것같다.
			
			
			// 각각의 좌표를 돌아서 0이 아니고 방문하지 않았으면 돌아버린다.
			// 방문했으면 이미 탐색한 섬이라서 갈 필요가 없다.
			for (int r = 0 ; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (map[r][c] != 0 && visited[r][c] == false) {
						bfs(r, c);
						mappingnumber += 1;
//						printMap();
					}
				}
				
			}
			
			System.out.println(mappingnumber-1);
		}
		
		
		
		
	}
	
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	
	private static void bfs(int tr, int tc) {
		// 종료 조건.이 없지 큐 넣고 돌리는 것이라서
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(tr, tc));
		visited[tr][tc] = true;
		map[tr][tc] = mappingnumber;
		
		while(!q.isEmpty()) {
			Point nowPoint = q.poll();
			for (int i = 0; i<4; i++) {
				int nr = nowPoint.pr + dx[i];
				int nc = nowPoint.pc + dy[i];
				
				if (nr >= 0 && nc >=0 && nr < n && nc < m) {
					if (map[nr][nc] != 0 && visited[nr][nc] == false) {
						map[nr][nc] = mappingnumber;
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
		
		
		
	}
	
	private static class Point {
		int pr;
		int pc;
		public Point(int pr, int pc) {
			super();
			this.pr = pr;
			this.pc = pc;
		}
		@Override
		public String toString() {
			return "Point [pr=" + pr + ", pc=" + pc + "]";
		}
	}

	private static void printMap() {
		
		for (int r = 0; r<n; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		System.out.println();
		
	}

	
}
