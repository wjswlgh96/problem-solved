import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        int[][] D = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                D[i][j] = line.charAt(j) - '0';

                if (D[i][j] == 1 && i > 0 && j > 0) {
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j], D[i][j - 1])) + 1;
                }

                if (max < D[i][j]) {
                    max = D[i][j];
                }
            }
        }

        bw.write(max * max + "");
        bw.close();
        br.close();
    }

}
