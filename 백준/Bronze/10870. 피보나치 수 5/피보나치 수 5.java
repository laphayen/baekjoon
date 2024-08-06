import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(fib(n));
	}
	
	// bottom up을 해볼까?
	// 0부터 1, 이전 값을 통해서 더해서 올라가니깐
	
	private static long fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		
		return fib(n-1) + fib(n-2);
	}
}
