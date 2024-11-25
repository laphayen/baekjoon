
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int [][] map;
	static boolean [][] v;
	static int [][] dist;
	static int result;
	
	public static void main(String[] args) {
		
		//System.setIn(b4485.class.getResourceAsStream("b4485.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		n = 1;
		int cnt = 1;
		while (true) {
			
			result = 0;
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			
			map = new int [n][n];
			dist = new int [n][n];
			v = new boolean[n][n];
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					map[r][c] = sc.nextInt();
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
			
			dijk();
			
			System.out.println("Problem " + cnt + ": " + result);
			cnt++;
		}
	}
	
	private static void dijk() {
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0, map[0][0]));
		v[0][0] = true;
		
		while (!pq.isEmpty()) {
			Point nowP = pq.poll();
			
			if (nowP.pr == n-1 && nowP.pc == n-1) {
				result = nowP.pw;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = nowP.pr + dr[i];
				int nc = nowP.pc + dc[i];
				
				if (nr < 0 || nc < 0 || nc > n-1 || nr > n-1) {
					continue;
				}
				
				if (!v[nr][nc]) {
					pq.add(new Point(nr, nc, nowP.pw+ map[nr][nc]));
					v[nr][nc] = true;
				}
			}
		}
	}
	
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, 1, -1};

	static class Point implements Comparable<Point> {
		int pr;
		int pc;
		int pw;
		public Point(int pr, int pc, int pw) {
			super();
			this.pr = pr;
			this.pc = pc;
			this.pw = pw;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.pw, o.pw);
		}
		
	}
}
