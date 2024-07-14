
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int n, k, a, b, c;
		double[] scores;
		String[] credit = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"}; 
		
		int test = sc.nextInt();
		
		for (int t = 1; t<=test; t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			scores = new double[n];
			for (int i = 0; i < n; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				scores[i] = 0.35*a + 0.45*b + 0.2*c;
			}
			
			String ans = "";
			double goal = scores[k-1];
			Arrays.sort(scores);
			for (int i = 0; i < n; i++) {
				if (goal == scores[i]) {
                    ans = credit[i/(n/10)];
                    break;
				}
			}
			System.out.println("#" + t+ " " + ans);
		}
		
	}

}
