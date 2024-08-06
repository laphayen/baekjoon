
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int [] arr;
	static int [] sel;
	static boolean [] v;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		// 1부터 n까지 초기
		arr = new int [n];
		v = new boolean [n];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		// 조합 시작 - 0부터 시작해서 0개 선
		com(arr, new int[m], 0, v);
	}

	// 인덱스와 선택 개
	public static void com(int[] arr, int[] sel, int k, boolean[] v) {
		
		/*
		 * 종료 조건
		 * 선택한 개수와 선택 배열의 크기가 같은 경우 해당 요소들을 출력
		 */
		// 방문했으면 돌아가
		// sel을 다 채운것이 선택 개수랑 같으면 다 채웠기 때문
		if (sel.length == k) {
			// 현재 채운 배열을 출력하고
			for (int i : sel) {
				System.out.print(i + " ");
			}
			System.out.println("");
			// 돌아가.
			return;
		}
		
		for (int i = 0; i<arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				com(arr, sel, k+1, v);
				v[i] = false;
			}
		}
		
	}
	
}