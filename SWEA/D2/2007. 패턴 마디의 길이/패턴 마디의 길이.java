
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		// 패턴이 반복되는지 확인 -> 1번이랑 2번이랑 같은지 확인하고
		// 다르면 비교 문자열을 추가 
		// 탐색ㅇ은 2번째 문자부터 한다. 1번과 1번이 같으면 종료되니깐
		
		for (int t = 1; t <= test; t++) {
			
			String s = sc.next();
			
			for (int i=1; i<s.length(); i++) {
				// korea 에서 k를 가져온
				String cmp1 = s.substring(0,i);
				String cmp2 = s.substring(i, i+i);
				
				if (cmp1.equals(cmp2)) {
					System.out.println("#"+ t + " " +cmp1.length());
					break;
				}
			}
		
		}
	}

}
