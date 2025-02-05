import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[202][202];

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

                    if (dp[i][j] > 1_000_000_000) {     // K 범위가 넘어가면 범위의 최댓값 저장
                        dp[i][j] = 1_000_000_000;
                    }
                }
            }
        }

        if (dp[N + M][M] < K) {
            System.out.println("-1");
        } else {
            while (N != 0 || M != 0) {
                if (dp[N - 1 + M][M] >= K) {
                    System.out.print("a");
                    N--;
                } else {
                    System.out.print("z");
                    K -= dp[N - 1 + M][M];
                    M--;
                }
            }
        }
    }
}
