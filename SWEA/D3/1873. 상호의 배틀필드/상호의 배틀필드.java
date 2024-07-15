/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
class Tank {
	int dir, y, x;
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		char[] dir = {'^', '>', 'v', '<'};
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		for(int t = 1; t <= tc; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			Tank tank = new Tank();
			char[][] map = new char[H][W];
			for(int i = 0; i < H; i++) {
				String str = sc.next();
				for(int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					for(int d = 0; d < 4; d++) {
						if(tank.dir != 0) break;
						if(map[i][j] == dir[d]) {
							map[i][j] = '.';
							tank.dir = d; tank.y = i; tank.x = j;
							break;
						}
					}
				}
			}
			sc.nextInt();
			char[] input = sc.next().toCharArray();
			for(int i = 0; i < input.length; i++) {
				switch(input[i]) {
				case 'U' :
					tank.dir = 0;
					if(tank.y - 1 >= 0 && map[tank.y - 1][tank.x] == '.')
						tank.y--;
					break;
				case 'D' :
					tank.dir = 2;
					if(tank.y + 1 < H && map[tank.y + 1][tank.x] == '.')
						tank.y++;
					break;
				case 'L' :
					tank.dir = 3;
					if(tank.x - 1 >= 0 && map[tank.y][tank.x - 1] == '.')
						tank.x--;
					break;
				case 'R' :
					tank.dir = 1;
					if(tank.x + 1 < W && map[tank.y][tank.x + 1] == '.')
						tank.x++;
					break;
				case 'S' :
					int shoot_y = tank.y, shoot_x = tank.x;
					while(true) {
						if(shoot_y >= H || shoot_x >= W || shoot_y < 0 || shoot_x < 0)
							break;
						else if(map[shoot_y][shoot_x] == '*') {
							map[shoot_y][shoot_x] = '.';
							break;
						}
						else if(map[shoot_y][shoot_x] == '#')
							break;
						shoot_y += dy[tank.dir];
						shoot_x += dx[tank.dir];
					}
					break;
				}
			}
			map[tank.y][tank.x] = dir[tank.dir];
			System.out.print("#" + t + " ");
			for(char[] a : map) {
				for(char b : a)
					System.out.print(b);
				System.out.println();
			}
		}
		sc.close();
	}
}