import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static char [][] map;
    static int n;
    static int m;
    
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, -1, 0, 1};
    
    static boolean [][] v;
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            
            n = sc.nextInt();
            m = sc.nextInt();
            
            map = new char[n][m];
            v = new boolean[n][m];
            
            Queue<Point> q = new ArrayDeque<>();
            for (int r = 0; r < n; r++ ) {
                char [] input = sc.next().toCharArray();
                for (int c = 0; c < m; c++) {
                    map[r][c] = input[c];
                    if (map[r][c] == 'W') {
                        q.offer(new Point(r, c, 0)); // 모든 'W' 셀을 큐에 추가
                        v[r][c] = true;
                    }
                }
            }
            
            int result = 0;
            while(!q.isEmpty()) {
                Point p = q.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];
                    
                    if (0 <= nr && nr < n && 0 <= nc && nc < m && !v[nr][nc] && map[nr][nc] == 'L') {
                        v[nr][nc] = true;
                        q.offer(new Point(nr, nc, p.cnt + 1));
                        result += p.cnt + 1;
                    }
                }
            }
            
            System.out.println("#" + tc + " " + result);
        }
    }
    
    private static class Point {
        int r, c, cnt;
        
        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}