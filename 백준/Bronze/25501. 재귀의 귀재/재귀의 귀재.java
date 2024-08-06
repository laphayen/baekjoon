

import java.util.Scanner;

public class Main {
	
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 0; t < T; t++) {
			String s = sc.nextLine();
			
			System.out.println(isPalindrome(s)+ " "+cnt);
			cnt = 0;
		}
	}

	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
		
	}

	public static int recursion(String s, int l, int r) {
		cnt += 1;
		// AAA인 경우
		if (l >= r) {
			return 1;
		}
		// ABCA
		else if (s.charAt(l) != s.charAt(r)) {
			return 0;
		}
		else {
			return recursion(s, l+1, r-1);
		}
	}
	
}
