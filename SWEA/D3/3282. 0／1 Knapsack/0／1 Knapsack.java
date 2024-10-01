

import java.util.Scanner;

public class Solution {

    static int[] v;
    static int[] c;

    public static void main(String[] args) {

        //System.setIn(s3282.class.getResourceAsStream("s3282.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            v = new int[n + 1];
            c = new int[n + 1];

            int[][] dp = new int[n + 1][k + 1];

            for (int i = 1; i <= n; i++) {
                v[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (v[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - v[i]] + c[i], dp[i - 1][j]);
                    }
                }
            }
            System.out.println("#" + tc + " " + dp[n][k]);
        }
    }
}
