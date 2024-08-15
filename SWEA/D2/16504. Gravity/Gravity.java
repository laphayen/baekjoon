import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 수
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());  // 방의 가로 길이
            String[] heightStrings = br.readLine().split(" ");
            int[] heights = new int[N];
            
            // 상자 높이 입력 받기
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(heightStrings[i]);
            }
            
            int maxFall = 0;
            
            // 각 위치에서 낙차 계산
            for (int i = 0; i < N; i++) {
                int currentHeight = heights[i];
                int fallDistance = 0;
                
                // 오른쪽에 있는 열들 중 현재 열보다 낮은 열의 개수를 세서 낙차 계산
                for (int j = i + 1; j < N; j++) {
                    if (heights[j] < currentHeight) {
                        fallDistance++;
                    }
                }
                
                // 최대 낙차 갱신
                if (fallDistance > maxFall) {
                    maxFall = fallDistance;
                }
            }
            
            // 결과 출력
            System.out.println("#" + t + " " + maxFall);
        }
    }
}
