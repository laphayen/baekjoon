import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;




public class Main {
	
	/*
	 * 각 행의 합을 구한 후, 그 합들의 최소값.
	 * 
	 * k번 회전 규칙에 따라서 배열을 회전시키는데
	 * 이 때 k번의 순서가 중요하다.
	 * 돌리는 순서에 따라서 결과가 달라진다.
	 * 조합을 짜보자.
	 */
	
	
	/*
	 * 
	 * 실패 지점
	 * 각 경우마다 복사된 배열을 돌렸어야 한다.
	 * 
	 */
	
	
	// 1. 순서를 정한다.
	// 2. 배열 돌린다.
	// 3. 각 행의 합을 구한 후 최소값을 비교한다.
	
	static int n;
	static int m;
	static int k;
	static int [][] map;
	static int [][] mapC;
	static int [][] orderK;
	static int result;
	static int mid; // 각 배열의 회전할 때마다의 최소값
	static int [][] sel;
	static boolean [] v;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		k = s.nextInt();
		
		// k개를 계산할 값들.
		orderK = new int [k][];
		sel = new int [k][];
		v = new boolean[k];
		result = Integer.MAX_VALUE;
		
		// 지도 입력
		map = new int[n][m];
		for(int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				map[r][c] = s.nextInt();
			}
		}
		
		// 배열을 돌릴 좌표 입력
		for (int kc = 0; kc < k; kc++) {
			int inputR = s.nextInt();
			int inputC = s.nextInt();
			int inputS = s.nextInt();
			orderK[kc] = new int [] {inputR, inputC, inputS};
		}
		
		// 각 재귀에서 할 것을 생각하자
		// 현재 k 번째를 선택하는 경우
		order(0);
		
		System.out.println(result);
		// 
	}

	private static void order(int ch) {
		if (ch == sel.length) {
			// 순서를 가지고 이제 배열을 돌린다.
			mapC = new int[n][m];
			// 실패 지점 - 배열 복사
			for(int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					mapC[r][c] = map[r][c];
				}
			}
			for (int j = 0; j < sel.length; j++) {	
				rotate(sel[j][0], sel[j][1], sel[j][2]);
//				printArr(mapC);
//				System.out.println("Hello " + sel[j][0] + " " + sel[j][1]+" "+ sel[j][2]);
				
			}
			// 배열을 돌렸으면 계산을 해.
			cal();
			

			return;
		}
		
		for (int i = 0; i < orderK.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[ch] = orderK[i];
				order(ch+1);
				v[i] = false;
			}
		}
	}
	
	/*
	 * 배열을 원들의 개수를 구해서
	 * 안쪽 원으로 갈 수 록 1식 상하좌우 감소.
	 */
	
	/*
	 * 0 			         m
	 * 	r-s, c-s	r-s, c+s
	 * 	sr sc		sr	ec	
	 * 
	 * 	r+s, c-s	 r+s, c+s
	 * 	er sc		er ec
	 * 
	 * n					n,m
	 * 
	 */
	
	// 배열을 회전하는 함수. rv, cv는 중심 원의 좌표
	private static void rotate(int rv, int cv, int sv) {
		int sr = rv-sv-1;
		int sc = cv-sv-1;
		int er = rv+sv-1;
		int ec = cv+sv-1;
		int rSize = (2 * sv) + 1;
		int cSize = (2 * sv) + 1;
		
		// 회전할 원의 개수
		int cnt = (Math.min(er-sr, ec-sc)) / 2;
		for (int cn = 0; cn < cnt; cn++) { // cn은 원의 개수 이따가 바꿔줘야 함. -> cnt로
			// 좌 - 하 - 우 - 상
			int temp = mapC[sr][sc];
			
			// 좌부터 한칸식 밀어보자.
			for (int i = 0; i < rSize-1; i++) {
				mapC[sr+i][sc] = mapC[sr+i+1][sc];
			}
			// 이제 하
			for (int i = 0; i <cSize-1; i++) {
				mapC[er][sc+i] = mapC[er][sc+i+1];
			}
			// 이제 우
			for (int i = 0; i < rSize-1; i++) {
				mapC[er-i][ec] = mapC[er-i-1][ec];
			}			
			// 마지막 상
			for (int i = 0; i < cSize-1; i++) {
				mapC[sr][ec-i] = mapC[sr][ec-i-1];
			}
			
			mapC[sr][sc+1] = temp;

			// 다 돌고 
			sr += 1;
			sc += 1;
			er -= 1;
			ec -= 1;
			rSize -= 2;
			cSize -= 2;
		}
	}

	// 배열의 각 행의 합의 최소값을 구하는 함수.
	private static void cal() {
		mid = Integer.MAX_VALUE;
		int sum = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				sum += mapC[r][c];
			}
			mid = Math.min(sum, mid);
			sum = 0;
		}
		result = Math.min(result, mid);
	}

	// 배열 출력하는 함수.
	private static void printArr(int arr[][]) {
			for (int r = 0; r < arr.length; r++) {
			System.out.println(Arrays.toString(arr[r]));
		}
		System.out.println("===========");
	}
}
