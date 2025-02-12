import java.io.*;
import java.util.*;

public class Main {

    static final int LENGTH = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][][] dp = new int[LENGTH][5][5];
        int[][] mp = {
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}
        };

        int n = 0, s = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < LENGTH; k++) {
                    dp[k][i][j] = LENGTH * 4;
                }
            }
        }
        dp[0][0][0] = 0;
        while (true) {
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            for (int i = 0; i < 5; i++) {
                if (n == i) {
                    continue;
                }

                for (int j = 0; j < 5; j++) {
                    dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]);
                }
            }

            for (int j = 0; j < 5; j++) {
                if (n == j) {
                    continue;
                }

                for (int i = 0; i < 5; i++) {
                    dp[s][n][j] = Math.min(dp[s - 1][i][j] + mp[i][n], dp[s][n][j]);
                }
            }

            s++;
        }

        s--;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[s][i][j]);
            }
        }

        bw.write(min + "");
        bw.close();
        br.close();
    }

}
