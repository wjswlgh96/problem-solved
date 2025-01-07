import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] strArr = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            strArr[i] = input.substring(i);
        }

        Arrays.sort(strArr, (a, b) -> {
            return a.compareTo(b);
        });

        for (String s : strArr) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}