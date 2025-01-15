import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        final int LENGTH = E + 1;
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

        for (int i = S; i <= E; i++) {
            if (primes[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}