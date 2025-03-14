import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] parts = st.nextToken().split(",");
            int A = Integer.parseInt(parts[0]);
            int B = Integer.parseInt(parts[1]);

            bw.write(String.valueOf(A + B) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}