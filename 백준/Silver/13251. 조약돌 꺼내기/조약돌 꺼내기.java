import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int[] rocks = new int[M];
        int total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            rocks[i] = value;
            total += value;
        }

        int K = Integer.parseInt(br.readLine());
        if (M == 1 || K == 1) {
            System.out.println(1.0);
            return;
        }

        double result = 0.0;
        for (int i = 0; i < M; i++) {
            double sum = 1.0;
            int tTotal = total;
            int curr = rocks[i];

            for (int j = 0; j < K; j++) {
                sum *= curr / (tTotal * 1.0);
                curr--;
                tTotal--;
            }

            result += sum;
        }

        bw.write(result + "");
        bw.close();
        br.close();
    }
}
