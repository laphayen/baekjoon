// package date0623;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	
	// 노드와 간선으로 구현되어 있다.
	
	// 노드 개수.
	static int N;
	
	// 간선 개수.
	static int M;
	
	// 노드의 입접 리스트.
	static List<Integer> [] graph;
	
	// 방문 배열
	static boolean [] v;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 인접 리스트 초기화.
		graph = new ArrayList[N+1];
		v = new boolean[N+1];
		
		for (int nCnt = 1; nCnt <= N; nCnt++) {
			graph[nCnt] = new ArrayList<>();
		}
		
		for (int mCnt = 0; mCnt < M; mCnt++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			graph[u].add(v);
			graph[v].add(u);
			
		}
		
		// 인접해 있는 것을 돌아야 한다.
		// 가중치가 없다 -> bfs.
		
		bfs(1);
		
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(i + " : " + graph[i]);
//		}
		
		// 나중에 방문한 노드의 개수만 카운트.
		// 방문한 노드는 1부터 체크 0은 없다.
		
		int result = 0;
		
		for (int nCnt = 1; nCnt <= N; nCnt++) {
			if (v[nCnt] == true) {
				result += 1;
			}
		}
		
		// 1번 컴퓨터 제외.
		System.out.println(result-1);
//		System.out.println(Arrays.toString(v));
	}

	private static void bfs(int nodeNum) {
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(nodeNum);
		v[nodeNum] = true;
		
		while(!q.isEmpty()) {
			int nowNode = q.poll();
			
			// 큐에서 꺼낸 현재 노드의 연결리스트에서 for 문을 돌아서 방문하지 않았으면 큐에 넣는다.
			for (int targetCnt = 0; targetCnt < graph[nowNode].size(); targetCnt++) {
				int target = graph[nowNode].get(targetCnt);
//				System.out.println(target);
				if (!v[target]) {
					v[target] = true;
					q.add(target);
					
				}
			}
		}
		
		
	}
	
		
	
}
