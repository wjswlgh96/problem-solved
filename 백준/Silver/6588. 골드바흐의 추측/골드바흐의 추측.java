import java.io.*;
import java.util.*;

public class Main {

    static final int LENGTH = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] primes = new int[LENGTH];
        for (int i = 2; i < LENGTH; i++) {
            primes[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(LENGTH); i++) {
            if (primes[i] == 0) {
                continue;
            }
            for (int j = i + i; j < LENGTH; j += i) {
                primes[j] = 0;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                break;
            }

            int i = 2;
            int j = num;

            while (i <= j) {
                if (primes[j] == 0) {
                    j--;
                    continue;
                }
                if (primes[i] == 0) {
                    i++;
                    continue;
                }

                int sum = primes[i] + primes[j];
                if (sum == num) {
                    bw.write(num + " = " + primes[i] + " + " + primes[j] + "\n");
                    break;
                } else if (sum >= num) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}