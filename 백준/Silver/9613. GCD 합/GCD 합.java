import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long result = 0;
            String[] str = br.readLine().split(" ");

            for (int j = 1; j < str.length; j++) {
                int curr = Integer.parseInt(str[j]);
                for (int k = j + 1; k < str.length; k++) {
                    int next = Integer.parseInt(str[k]);
                    result += gcd(curr, next);
                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
