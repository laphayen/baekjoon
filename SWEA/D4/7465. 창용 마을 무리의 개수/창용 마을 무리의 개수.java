// package date1125;

import java.util.Scanner;

public class Solution {
	
	static int n;
	static int m;
	static int [] parents;
	
	static int result;
	
	public static void main(String[] args) {
		
		// System.setIn(s7465.class.getResourceAsStream("s7465.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			result = 0;
			
			parents = new int[n+1];
			
			for (int i = 1; i < parents.length; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				
				union(s, e);
			}
			
			for (int i = 1; i < parents.length; i++) {
				if (parents[i] == i) {
					result++;
				}
			}
			
			System.out.println("#" + tc + " " + result);
			
		}
	}

	private static void union(int s, int e) {
		int ps = find(s);
		int pe = find(e);
		
		if (ps != pe) {
			parents[ps] = pe;
		}
		
	}

	private static int find(int s) {
		if (parents[s] == s) {
			return s;
		}
		else {
			return parents[s] = find(parents[s]);
		}
		
	}
}
