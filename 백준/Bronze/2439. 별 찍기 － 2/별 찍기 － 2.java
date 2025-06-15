import java.util.Scanner;

public class Main {
	static int space;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int cnt = 1;
		sc.close();
        
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N-cnt; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < cnt; j++) {
				System.out.print("*");
			}
			System.out.println();
			cnt++;
		}
		System.out.print("");
	}
}