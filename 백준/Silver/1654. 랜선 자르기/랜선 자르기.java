import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[K];

        for (int i = 0; i < K; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        long min = 1;
        long max = A[K - 1];

        while (min <= max) {
            long mid = min + (max - min) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += A[i] / mid;
            }

            if (count >= N) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }
}
