
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		int[] dayend = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		for (int t = 1; t<=test; t++) {
			
			int days = 0;
            
			int sm = sc.nextInt();
            int sd = sc.nextInt();
            int em = sc.nextInt();
            int ed = sc.nextInt();
            
            for(int m = sm; m <em; m++) {
                days += dayend[m];
            }
            
            days += (ed-sd+1);
            
            System.out.println("#" + t + " " + days);

		}
		
	}

}
