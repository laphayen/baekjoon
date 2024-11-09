// package date1109;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	
	static int [][] map;
	static boolean [][] v; // 바깥 부분을 계산할 방문.
	static ArrayList<Point> al;
	
	
	static int result;
	
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		
		//System.setIn(b2638.class.getResourceAsStream("b2638.txt"));
		
		Scanner s = new Scanner(System.in);
		
		
		n = s.nextInt();
		m = s.nextInt();
		
		map = new int[n][m];
		v = new boolean[n][m];
		al = new ArrayList<>();
		result = 0;
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				map[r][c] = s.nextInt();
				if (map[r][c] == 1) {
					al.add(new Point(r, c));
				}
			}
		}
		
//		print();
//		System.out.println(al);
		
		// 바깥 부분을 2로 칠한다.
		// 치즈가 없어질 때까지 죽인다.
		while(!al.isEmpty()) {
		
//		    print();
		    v = new boolean[n][m];
		    Point sp = new Point(0, 0);
			bfs(sp);
//			System.out.println("바깥표시. ");
//			print();
			
			
			cut();
//			System.out.println(al);
//			System.out.println("cut");
//			print();
			
			 
			// 자르고 남은 좌표들을 다시 al에 넣는다.
			// 2인 부분은 다시 0으로 만들어 준다.
			find();
//			System.out.println(al);
//			System.out.println("find ");
//			print();
			result += 1;
		}
		
		
//		print();
		
		
		System.out.println(result);
		
	}
	
	private static void find() {
		al = new ArrayList<>();
		for (int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if (map[r][c] == 2) {
					map[r][c] = 0;
				}
				if (map[r][c] == 1) {
					al.add(new Point(r, c));
				}
			}
		}
		
	}

	// al 에서 좌표들을 순서대로 돌아서
	// 각좌표별로 4방 탐색을 한 후에
	// 2곳 이상이 2인 경우만. 제거.
	private static void cut() {
		for (int i = 0; i < al.size(); i++) {
			Point target = al.get(i);
			
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = target.r + dr[d];
				int nc = target.c + dc[d];
				
				// 범위를 벗어나면 건너뛰어.
				if (nr < 0 || nc < 0 || nr > n-1 || nc > m-1) {
					continue;
				}
				
				// 만약 2인 경우 카운트
				if (map[nr][nc] == 2) {
					cnt += 1;
				}
			}
			
			if (cnt >= 2) {
				map[target.r][target.c] = 0;
			}
		}
	}


	// 바깥 부분을 칠한다.
	private static void bfs(Point sp) {
		
		v[sp.r][sp.c] = true;
		map[sp.r][sp.c] = 2;
		
		Queue<Point> q = new ArrayDeque<>();
		q.offer(sp);
		
//		System.out.println(q);
		
		while (!q.isEmpty()) {
			Point now = q.poll();
			
			for (int i = 0; i < 4; i ++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				// map의 범위를 벗어나면 다음 방향으로 이동.
				if (nr < 0 || nc < 0 || nr > n-1 || nc > m-1) {
					continue;
				}
				
				// 이동한 좌표가 방문하지 않고 0일 경우만 이동.
				if (!v[nr][nc] && map[nr][nc] == 0) {
					// 현재 위치를 2로 칠한다.
					// 방문 처리를 한다.
					// 큐에 넣는다.
//					System.out.println(nr + " " + nc);
					v[nr][nc] = true;
					map[nr][nc] = 2;
					Point next = new Point(nr, nc);
					q.offer(next);
				}
			}
		}
		
	}


	// 출력부 ------------------------------------------------------------
	private static void print() {
		for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		System.out.println(" ");
		
	}

	static class Point {
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
}
