import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int blank = n - 1;
        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(blank--) + "*".repeat(2 * i + 1));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}