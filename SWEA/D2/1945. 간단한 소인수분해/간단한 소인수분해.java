
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for (int t = 1; t<=test; t++) {
			int n = sc.nextInt();
			
            int[] div = {2, 3, 5, 7, 11};
            int[] cnt = new int[div.length];
 
            for (int i = 0; i < div.length; i++) {
                while (n % div[i] == 0) {
                    cnt[i]++;
                    
                    n /= div[i];
                }
            }
 
            System.out.print("#" + t + " ");
            
            for (int count : cnt) {
                System.out.print(count + " ");
            }
            
            System.out.println();
			
		}
		
	}

}
