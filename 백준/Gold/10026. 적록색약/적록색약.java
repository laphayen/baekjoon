// package date0623;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	static char [][] map;

	static boolean [][] v1; // 일반.
	static int r1;
	static boolean [][] v2;	// 색약.
	static int r2;
	
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new char [n][n];
		v1 = new boolean [n][n];
		v2 = new boolean [n][n];
		
		r1 = 0;
		r2 = 0;
		
		sc.nextLine();
		for (int r = 0; r < n; r++) {
			String str = sc.nextLine();
			for (int c = 0; c < n; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		
//		printMap();
		
		// 2차원 행렬에서 가중치가 없고 인접한 좌표의 값을 탐색 -> BFS
		
		// 일반과 색약 -> 총 2번 돌아야 한다.
		// 일반과 색약의 방문 배열이 2개 필요하다.
		
		
		// 일반은 각각의 한 색깔 마다 돌아서 방문 배열을 체크.
		// 색약은 큐에서 뽑아낸 값이 R과 G 일 경우 동일하게 처리.
		
		
		// 일반.
		for(int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (v1[r][c] == false) {
					bfs1(r, c);
					r1 += 1;
				}
			}
		}
		
		// 색약.
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (v2[r][c] == false) {
					bfs2(r, c);
					r2 += 1;
				}
			}
		}
		
		
		System.out.println(r1 + " " + r2);
		
	}

	private static void bfs2(int sr, int sc) {
		Queue<Point> q2 = new LinkedList<Point>();
		q2.offer(new Point(sr, sc));
		v2[sr][sc] = true;
		
		while(!q2.isEmpty()) {
			Point nowPoint = q2.poll();
			for(int i = 0; i < 4; i++) {
				int nr = nowPoint.pr + dr[i];
				int nc = nowPoint.pc + dc[i];
				
				if (nr >= 0 &&  nc >= 0 && nr < n && nc < n && v2[nr][nc] == false) {
					// 맵 범위 안에 있고 현재 값과 옆에 있는 값이 같으면 같은 영역
					// 예외 조건 들어감 R인 때는 G도 가능 
					// now r -> nr nc g
					// now g -> nr nc r
					if (map[nowPoint.pr][nowPoint.pc] == map[nr][nc] || (map[nowPoint.pr][nowPoint.pc] == 'R' && map[nr][nc] == 'G') || (map[nowPoint.pr][nowPoint.pc] == 'G' && map[nr][nc] == 'R') ) {
						q2.offer(new Point(nr, nc));
						v2[nr][nc] = true;
					}
				}
			}
		}
		
	}

	// 일반.
	private static void bfs1(int sr, int sc) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sr, sc));
		v1[sr][sc] = true;
		
		while(!q.isEmpty()) {
			Point nowPoint = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = nowPoint.pr + dr[i];
				int nc = nowPoint.pc + dc[i];
				
				if (nr >= 0 &&  nc >= 0 && nr < n && nc < n) {
					// 맵 범위 안에 있고 현재 값과 옆에 있는 값이 같으면 같은 영역
					if (v1[nr][nc] == false && map[nowPoint.pr][nowPoint.pc] == map[nr][nc]) {
						q.offer(new Point(nr, nc));
						v1[nr][nc] = true;
					}
				}
			}
		}
	}
	
	public static class Point {
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
		
		for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(map[r]));
			
		}
		System.out.println();
	}

}
