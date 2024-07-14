
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t<=test; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			int w = sc.nextInt();
			
			int a = p * w;
			int b;
			if(w <= r)
				b = q;
			else
				b = q + s * (w - r);
			System.out.println("#" + t + " " + Math.min(a, b));
		}
		
	}

}
