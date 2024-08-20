
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 테스트 수 만큼 반복하라.
		int T = sc.nextInt();
		for (int t = 1; t<=T; t++) {
			
			// 산 개수 n입력
			int n = sc.nextInt();
			int [] arr = new int [n];
			
			// 이거 입력 받으면서 현재 지점부터 다음 지점의 값이 커지면
			// 봉우리로 카운터 하면서 진행할 수 있겠다.
			// 어차피 입력 받고 for문 돌리거 아닌가?
			
			// 가장 작은 봉우리 값.
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int up = 0;
            int down =0;
            int result = 0;
            for(int i=1; i < n; i++) {
                if(arr[i-1]<arr[i]) {
                    if(down>0) {
                        result += down*up;
                        up=0;
                        down=0;
                    }
                    up++;
                }
                else {
                    down++;
                }
            }
            result += up*down;
            System.out.println("#"+ t + " " + result);
            
        }
    }
}
