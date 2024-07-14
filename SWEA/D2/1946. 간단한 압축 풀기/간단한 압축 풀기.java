
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t<=test; t++) {
			
			int N = sc.nextInt();
			
            StringBuilder result = new StringBuilder();
 
            for (int i = 0; i < N; i++) {
                String c = sc.next();
                int num = sc.nextInt();
 
                for (int j = 0; j < num; j++) {
                    result.append(c);
                }
            }
 
            System.out.println("#" + t);
            for (int i = 0; i < result.length(); i += 10) {
            	
                if (i + 10 <= result.length()) {
                	
                    System.out.println(result.substring(i, i + 10));
                } 
                else {
                    System.out.println(result.substring(i));
                }
                
            }
			
		}
		
	}

}
