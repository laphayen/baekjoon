
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			String num = Integer.toString(i);
			String result = "";
			for (int j=0; j<num.length(); j++) {
				if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
					result += "-";
				} 
			}
			if (result.length() >= 1) {
				System.out.print(result + " ");
			} else {
				System.out.print(num + " ");
			}
		}
	}

}
