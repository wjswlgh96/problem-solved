import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;
        fibo(n);
        System.out.println(dp[n]);
    }

    public static int fibo(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibo(n - 2) + fibo(n - 1);
    }
}
