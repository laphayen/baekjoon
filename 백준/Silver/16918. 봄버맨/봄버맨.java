import java.util.Scanner;

public class Main {
    
    // map
    static char[][] map;
    
    // 말 그대로 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int R = sc.nextInt();
        int C = sc.nextInt();
        int N = sc.nextInt();
        
        // 맵 크기 설정
        map = new char[R][C];
        
        // 폭탄 위치를 미리 알고 있으면 초마다 반복되는 곳의 4방을
        // 쉽게 설정할 수 있을 거 같은데
        int[][] next = new int[R][C];
        
        // 행부터 입력 받자!
        for (int r = 0; r < R; r++) {
            // 배열의 배열을 입력 받자!
            String str = sc.next();
            for(int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                
                // 만약 해당 위치가 폭탄이면 미리 위치 저장
                if (map[r][c] == 'O') {
                    next[r][c] = 3;
                }
            }
        }
        
        // 시간 경과
        for (int time = 1; time <= N; time++) {
            if (time % 2 == 0) {
                // 비어있는 모든 칸에 폭탄을 설치
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            next[i][j] = time + 3;
                        }
                    }
                }
            } else {
                // 시간이 다 된 폭탄 터트림
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (next[i][j] == time) {
                            map[i][j] = '.';
                            for (int d = 0; d < 4; d++) {
                                int ni = i + dx[d];
                                int nj = j + dy[d];

                                if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;

                                // 이번에 터트려야 할 폭탄을 연쇄반응으로 미리 터트리게 되면 
                                // 미리 터트린 폭탄의 주변 폭탄을 연쇄시킬 수 없다. 그래서 next를 확인!
                                if (map[ni][nj] == 'O' && next[ni][nj] != time) {
                                    map[ni][nj] = '.';
                                    next[ni][nj] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        // 최종 맵 출력
        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }

        sc.close();  // Scanner 객체 닫기
    }
}
