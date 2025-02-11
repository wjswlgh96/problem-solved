import java.io.*;
import java.util.*;

public class Main {

    private static char[] A;
    private static char[] B;
    private static long[][] DP;
    private static List<Character> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        int aLen = A.length;
        int bLen = B.length;

        DP = new long[aLen + 1][bLen + 1];
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A[i - 1] == B[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }

        bw.write(DP[aLen][bLen] + "\n");
        getText(aLen, bLen);
        for (int i = path.size() - 1; i >= 0; i--) {
            bw.write(path.get(i));
        }

        bw.close();
        br.close();
    }

    private static void getText(int a, int b) {
        if(a == 0 || b == 0) return;

        if (A[a - 1] == B[b - 1]) {
            path.add(A[a - 1]);
            getText(a - 1, b - 1);
        } else {
            if (DP[a - 1][b] > DP[a][b - 1]) {
                getText(a - 1, b);
            } else {
                getText(a, b - 1);
            }
        }
    }

}
