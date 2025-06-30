
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	
	static int [][] map;
	
	static boolean [][] v;
	
	// 각각의 단지 수를 저장할 배열
	static LinkedList<Integer> li;
	
	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int [n][n];
		v = new boolean [n][n];
		check = 1;
		
		li = new LinkedList<Integer>();
		
		
		sc.nextLine();
		
		for (int r = 0; r <  n; r ++) {
			
			String str = sc.nextLine();
			
			for (int c = 0; c < n; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		for (int r = 0; r  < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] == 1 && v[r][c] == false) {
					// 먼저 현재 위치를 체크표시한다.
					map[r][c] = check;
					cnt = 1; // 1부터 시작해서 bfs 돌 때 시작점 포함.
					bfs(r, c);
					
					check += 1;
					li.add(cnt);
				}
			}
		}
		
		System.out.println(check-1); // 체크는 1부터 시작 단지 수 -1
		
		Collections.sort(li);
		
		// 두 번 for를 도는 것 보다 각각 bfs 돌면서 단지 수를 저장하자.
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
		
	
		
	}

	static int check;

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(r, c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			
			Point nowPoint = q.poll();
			for (int i = 0; i < 4; i++) {
				
				int nr = nowPoint.r + dr[i];
				int nc = nowPoint.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
					if (v[nr][nc] == false && map[nr][nc] == 1) {
						map[nr][nc] = check;
						q.offer(new Point(nr, nc));
						cnt += 1;
						v[nr][nc] = true;
//						System.out.println("nr, nc : " + nr + " " + nc);
					}
				}
				
				
//				printMap();
			}
		}
	}
	
	private static void printMap() {
		for (int r= 0; r < n; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		System.out.println("");
		
	}

	static int [] dr = {-1, 1, 0, 0 };
	static int [] dc = {0, 0, -1, 1};
	
	public static class Point {
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
