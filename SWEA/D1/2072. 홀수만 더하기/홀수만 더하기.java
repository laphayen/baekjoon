import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int Test = sc.nextInt();
        
        int[] nums = new int[10];
        
        for (int t = 1; t <= Test; t++) {
            int result = 0;
            
            for (int i = 0; i < 10; i++) {
                nums[i] = sc.nextInt();
                
                if (nums[i] % 2 != 0) {
                    result += nums[i];
                }
            }
            
            System.out.println("#"+ t + " "+ result);
        }
	}
}