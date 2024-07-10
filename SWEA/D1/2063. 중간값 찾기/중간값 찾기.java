
import java.util.Scanner;
import java.io.FileInputStream;


public class Solution {
	
	public static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	public static void bubble(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j <arr.length - 1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			int value = sc.nextInt();
			
			arr[i] = value;
		}
		
		
		bubble(arr);
		
		System.out.println(arr[arr.length /2]);
	}

}
