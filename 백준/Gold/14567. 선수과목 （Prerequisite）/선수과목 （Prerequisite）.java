

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	
	static int m;
	
	// 간선 리스트
	static List<Integer>[] li;
	
	// 결과 배열
	static int [] result;
	
	static int [] parentCnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		li = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			li[i] = new ArrayList<>();
		}
		
		// 1부터 시작.
		result = new int [n+1];
		parentCnt = new int [n+1];
		
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			li[from].add(to);
			parentCnt[to]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			if (parentCnt[i] == 0) {
				q.add(i);
			}
		}
		
		int hak = 1;
		while (!q.isEmpty()) {
			
			int size = q.size();
			while (size-- != 0) {
				int now = q.poll();
				result[now] = hak;
				for (int child: li[now]) {
					if (--parentCnt[child] == 0) {
						q.add(child);
					}
				}
			}
			
			hak++;
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	
	static class Node {
		int w;

		public Node(int w) {
			this.w = w;
		}
		
	}

}
