import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String line;
        for (int i = 1; i <= n; i++) {
            line = String.format("%" + n + "s", "*".repeat(i));
            System.out.println(line);
        }
    }
}