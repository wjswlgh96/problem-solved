import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        while (K > 0) {
            if (N > M * 2) {
                N--;
            } else {
                M--;
            }
            K--;
        }

        int count = 0;
        while (N > 1 && M > 0) {
            N -= 2;
            M -= 1;
            count++;
        }

        bw.write(count + "");
        bw.close();
        br.close();
    }
}
