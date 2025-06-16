

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 줄바꿈 제거

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine(); // 한 줄 전체 입력
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0); // 시작점
        System.out.println(map[n - 1][m - 1]); // 최단 거리 출력
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[cx][cy] + 1; // 거리 누적
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}