import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int blank = n * 2;
        for (int i = 1; i < n; i++) {
            blank -= 2;
            sb.append("*".repeat(i) + " ".repeat(blank) + "*".repeat(i));
            sb.append("\n");
        }
        sb.append("*".repeat(n * 2) + "\n");
        for (int i = n - 1; i > 0; i--) {
            sb.append("*".repeat(i) + " ".repeat(blank) + "*".repeat(i));
            sb.append("\n");
            blank += 2;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}