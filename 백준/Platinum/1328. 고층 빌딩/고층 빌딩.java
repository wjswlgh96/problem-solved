import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long mod = 1000000007;

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[101][101][101];
        dp[1][1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + (dp[i - 1][j][k] * (i - 2))) % mod;
                }
            }
        }

        bw.write(dp[N][L][R] + "");
        bw.close();
        br.close();
    }

}
