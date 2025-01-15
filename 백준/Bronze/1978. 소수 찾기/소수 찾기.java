import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int LENGTH = 1001;
        boolean[] primes = new boolean[LENGTH];
        for (int i = 2; i < LENGTH; i++) {
            primes[i] = true;
        }

        for (int i = 0; i < Math.sqrt(LENGTH); i++) {
            if (!primes[i]) {
                continue;
            }

            for (int j = i + i; j < LENGTH; j = i + j) {
                primes[j] = false;
            }
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (primes[num]) {
                count++;
            }
        }
        System.out.println(count);
    }
}