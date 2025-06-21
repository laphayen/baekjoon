

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static int m;
	static int n;
	
	static int [][] map;
	static boolean [][] visited;
	static Queue<Point> q;
	
	static ArrayList<Point> startPoint;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		
		map = new int [n][m];
		visited = new boolean [n][m];

		
		q = new ArrayDeque<Point>();
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c <m; c++) {
				int num = sc.nextInt();
				map[r][c] = num;
				if (map[r][c] == 1) {
					q.add(new Point(r, c));
					visited[r][c] =  true;
				}
			}
		}
		
		
//		System.out.println(q.toString());
		
//		printMap();
		
		// 토마토가 있는 좌표 부터 매 번 1씩 증가.
		// 2차원 좌표에서 각각의 토마토가 매번 확산, 가중치x -> bfs
		// 입력 받을 때 1인 좌표들을 사전에 저장해 놀고 큐에 넣어 버리자
		
		bfs();
		
		boolean flag = false;
		int maxDay = 0;
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c< m; c++ ) {
				if (map[r][c] == 0) {
					flag = true;
					break;
				}
				if (maxDay < map[r][c]) {
					maxDay = map[r][c];
				}
			}
		}
		
		if (flag == true) {
			System.out.println(-1);
		}
		else {
			System.out.println(maxDay -1);
		}
		
		
		
	}
	
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	
	static int result;
	
	private static void bfs() {
		// 1. 큐를 만들고
		
		// 2. map을 탐색해서 1인 값들을 넣어준다.
		
		// 3. 블러드필 확신.
		
		// 1.
		while (!q.isEmpty()) {
//			printMap();
			Point nowPoint =  q.poll();
			for (int i = 0; i<4; i++) {
				int nowR = nowPoint.pr + dx[i];
				int nowC = nowPoint.pc + dy[i];
				
//				System.out.println(nowR);
//				System.out.println(nowC);
				if (nowR >= 0 && nowC >= 0 && nowR < n && nowC < m) {
					if (visited[nowR][nowC] == false && map[nowR][nowC] == 0) {
						map[nowR][nowC] = map[nowPoint.pr][nowPoint.pc] + 1;
						visited[nowR][nowC] = true;
						q.offer(new Point(nowR, nowC));
					}
				}
			}
		}
		
		
		// 2.
		
	}

	// 좌표를 저장할 클래스
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
		
		System.out.println(" ");
		
	}
	
	
	
}
