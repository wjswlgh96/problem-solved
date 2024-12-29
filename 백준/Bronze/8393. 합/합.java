import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Double sum = (N + 1.0) / 2.0 * N;

        bw.write(String.valueOf(sum.intValue()));

        bw.flush();
        bw.close();
        br.close();
    }
}