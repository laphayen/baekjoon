
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		
		for (int t = 1; t<=test; t++) {
			int s= 0;
			int d= 0;
			
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				switch (sc.nextInt()) {
				case 1:
					s += sc.nextInt();
					break;
				case 2:
					s -= sc.nextInt();
					if (s < 0)
						s = 0;
					break;
				}
				d += s;
			}

			System.out.printf("#%d %d\n", t, d);
		}
		
	}

}
