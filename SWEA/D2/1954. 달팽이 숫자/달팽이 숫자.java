
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class Solution {
	
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t<=test; t++) {
			
			int N = sc.nextInt();
			int[][] ans = new int[N][N];
			int x = 0;
			int y = 0;
			int d = 0;
			int cnt = 1; 
			
			
			while(cnt<=N*N) {
				
				ans[x][y] = cnt++;
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx<0 || nx >=N || ny <0 || ny>=N || ans[nx][ny] !=0) {

					d = (d+1)%4;
					nx = x + dx[d];
					ny = y + dy[d];
				}
				
				x = nx;
				y = ny;
			}
			
			System.out.printf("#%d\n",t);
			
			for(int[] arr:ans) {
				for(int i : arr) {
					System.out.printf("%d ",i);
				}
				
				System.out.println();
			}
			
		}
		
	}

}
