import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n + 2];
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            D[i + 1] = Math.max(D[i + 1], D[i]);

            if (i + T[i] <= n + 1) {
                D[i + T[i]] = Math.max(D[i + T[i]], D[i] + P[i]);
            }
        }

        System.out.println(D[n + 1]);
    }

}
