import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        if (!num.contains("0")) {
            System.out.println("-1");
            return;
        }

        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += c - '0';
        }

        if (sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        char[] digits = num.toCharArray();
        Arrays.sort(digits);

        StringBuilder sb = new StringBuilder(new String(digits));
        bw.write(sb.reverse().toString());
        bw.close();
        br.close();
    }
}
