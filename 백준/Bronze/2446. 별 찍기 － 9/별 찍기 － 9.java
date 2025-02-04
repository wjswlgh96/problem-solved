import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int blank = 0;

        for (int i = n; i > 0; i--) {
            System.out.printf("%s" + "%s\n", " ".repeat(blank++), "*".repeat(i * 2 - 1));
        }
        blank = n - 2;
        for (int i = 2; i <= n; i++) {
            System.out.printf("%s" + "%s\n", " ".repeat(blank--), "*".repeat(i * 2 - 1));
        }

    }
}