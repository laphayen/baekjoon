import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;

    static int[][] map;

    static ArrayList<Vertex>[] adj;

    static class Vertex implements Comparable<Vertex> {
        int e;
        int w;

        public Vertex(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        // 넘버링 시작
        int num = 2;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == 1) {
                    numbering(r, c, num++);
                }
            }
        }

        // 노드 개수
        int V = num - 2;
        adj = new ArrayList[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] > 1) {
                    makeAdj(r, c);
                }
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] v = new boolean[V];
        PriorityQueue<Vertex> q = new PriorityQueue<>();
        q.add(new Vertex(0, 0));

        int mstSum = 0;
        int visitedCount = 0;

        while (!q.isEmpty()) {
            Vertex p = q.poll();
            if (v[p.e]) continue;
            v[p.e] = true;
            mstSum += p.w;
            visitedCount++;

            for (Vertex next : adj[p.e]) {
                if (!v[next.e] && dist[next.e] > next.w) {
                    dist[next.e] = next.w;
                    q.add(new Vertex(next.e, next.w));
                }
            }
        }

        if (visitedCount != V) {
            System.out.println(-1);
        } else {
            System.out.println(mstSum);
        }
    }

    private static void makeAdj(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            int dist = 0;
            while (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (map[nr][nc] == map[r][c]) break;
                if (map[nr][nc] != 0 && map[nr][nc] != map[r][c] && dist >= 2) {
                    int start = map[r][c] - 2;
                    int end = map[nr][nc] - 2;
                    adj[start].add(new Vertex(end, dist));
                    adj[end].add(new Vertex(start, dist));
                    break;
                }
                if (map[nr][nc] != 0) break;
                nr += dr[i];
                nc += dc[i];
                dist++;
            }
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    private static void numbering(int r, int c, int num) {
        map[r][c] = num;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 1) {
                numbering(nr, nc, num);
            }
        }
    }
}
