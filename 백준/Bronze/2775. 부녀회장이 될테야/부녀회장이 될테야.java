import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];

        for (int i = 1; i < 15; i++) {
            dp[0][i] = i;
            dp[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int k = 0; k < N; k++) {
            int i = Integer.parseInt(br.readLine());
            int j = Integer.parseInt(br.readLine());

            bw.write(dp[i][j] + "\n");
        }

        bw.close();
        br.close();
    }
}
