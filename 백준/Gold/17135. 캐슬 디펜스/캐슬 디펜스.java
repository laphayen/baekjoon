
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    /* 
     * 적이 없을 때까지 반복 - // 가장 작은 r값이 n까지 도달할 때까지 돌린다.
     *         1. 궁수 배치
     *         2. 공격
     *         3. 적을 내림
     * 
     */
    
    static int n;
    static int m;
    static int d;
    static int minR;
    
    static int [][] map;
    static int [][] mapC;
    static boolean flag;
    static boolean [] v;
    static boolean [][] kv;
    
    static int result;
    static int mid;
    
    static int [] dr = { -1, 0, 1};
    static int [] dc = { -1, -1, -1};
    
    public static void main(String[] args) {
        
        
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        
        result = Integer.MIN_VALUE;
        
        // 1초 공격 -> 1초 적 내림 -> 1초 공격 -> 1초 적 내림.
        v = new boolean [m];
        map = new int [n+1][m]; // 마지막 줄에 궁수 추가.
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                map[r][c] = sc.nextInt();
                if (map[r][c] ==  1) {
                    minR =  Math.min(minR, r);
                }
            }
        }
        // 궁수를 배치하는 경우
        order(0);
        
        System.out.println(result);
    }

    private static void order(int k) {
        if (k == 3) {
            mapC = new int[n+1][m];
            copy();
            
            // 궁수 배치 - true인 경우만
            for (int i  = 0; i < m; i++) {
                if (v[i] == true) {
                    mapC[n][i] = 2;
                }
            }
            
            // 반복 - flag 가 true일 때 까지        
            mid = 0;
            flag = false;
            while (!flag) { // flag가 true 때까지
                // 타켓 먼저 정하고 죽여
                target();
                kill();
//                printMap();
                move();
                find();
            }
            return;
        }
        
        for (int i = 0; i < m; i++) {
            if (!v[i]) {
                v[i] = true;
                order(k+1);
                v[i] = false;
            }
        }
    }

    // 타겟 설정
    private static void target() {
    	kv = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (mapC[n][i] == 2) {
                Point target = null;
                int minDist = Integer.MAX_VALUE;
                
                // 적이 범위 안에 있는지 계산
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < m; c++) {
                        if (mapC[r][c] == 1) {
                            int dist = cal(n, i, r, c);
                            if (dist <= d) {
                                if (dist < minDist || (dist == minDist && c < target.c)) {
                                    target = new Point(r, c);
                                    minDist = dist;
                                }
                            }
                        }
                    }
                }
                
                if (target != null) {
                    kv[target.r][target.c] = true;
                }
            }
        }
    }

    // 적 제거해.
    private static void kill() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (kv[r][c]) {
                    mapC[r][c] = 0;
                    mid++;
                }
            }
        }
        result = Math.max(result, mid);
    }
    
    // 거리 계산
    private static int cal(int r1, int c1, int r2, int c2) {
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }

    // 지도 복사.
    private static void copy() {
        for (int r = 0; r < n+1; r++) {
            for (int c = 0; c < m; c++) {
                mapC[r][c] = map[r][c];
            }
        }
    }

    // 맵에서 더 이상 적이 있는지 확인하는 함수
    // 적이 없을 경우 true 반환
    private static void find() {
        flag = true;
        L: for (int r = 0; r <n; r++) {
            for (int c = 0; c < m; c++) {
                if (mapC[r][c] == 1) {
                    flag = false;
                    break L;
                }
            }
        }
    }

    // 매초 적을 내리는 함수
    // r값을 1씩 감소 시킨다.
    private static void move() {
        for (int c = 0; c < m; c++) {
            for (int i = 0; i < n-1; i++) {
                mapC[n-i-1][c] = mapC[n-i-2][c];
            }
            mapC[0][c] = 0;
        }
    }
    
    // 맵을 출력하는 함수
    private static void printMap() {
        for (int r = 0; r < n+1; r++) {
            System.out.println(Arrays.toString(mapC[r]));
        }
        System.out.println("====================");
    }
    
    // 맵을 출력하는 함수
    private static void printMap1() {
        System.out.println("원본");
        for (int r = 0; r < n+1; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
        System.out.println("원본====================");
    }
    
    // 포인터 좌표
    private static class Point{
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
