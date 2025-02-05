import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long mod = 1_000_000_000;
        long[] dp = new long[1_000_001];
        
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % mod;
        }

        System.out.println(dp[N]);
    }
}
